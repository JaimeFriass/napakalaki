package Napakalaki;

import java.util.ArrayList;
import java.util.Random;

public class Player { 
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private BadConsequence pendingBadConsequence;
    private Player enemy;
    private final int MAXLEVEL = 10;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    
	@Override
    public String toString() {
		return name;
    }
	
	protected int getOponentLevel(Monster m){
		return m.getCombatLevel();
	}
	
	protected boolean shouldConvert(){
		
	}
    
    public Player(String name) {
        this.name = name;
    }
	
	public Player (Player p){
		name = p.getName();
	}
    
    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        dead = false;
    }
    
	protected int getCombatLevel() {
        return level;
    }
    
    private void incrementLevels(int lvls) {
        for(int i = 0; i < lvls; i++){
			level++;
		}
    }
    
    private void decrementLevels(int lvls) {
        if (lvls < level)
            level = level - lvls;
        else
            level = 0;
    }
    
    private void setPendingBadConsequence(BadConsequence bc) {
        pendingBadConsequence = bc;
    }

    private void applyPrize(Monster m) {
       int nLevels = m.getLevelsGained();
       incrementLevels(nLevels);
       int nTreasures = m.getTreasuresGained();
       Treasure treasure;
       if (nTreasures > 0) {
       		CardDealer dealer = CardDealer.getInstance();
       		for (int i = 0; i < nTreasures; i++) {
       			treasure = dealer.nextTreasure();
       			hiddenTreasures.add(treasure);
       		}
       } 
    }

    private void applyBadConsequence(Monster m) {
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }

    private boolean canMakeTreasureVisible(Treasure t) {
        Boolean can_make_it = true;
		int i = 0;
		
		if(t.getType() == TreasureKind.BOTHHANDS){
			while(i < visibleTreasures.size() && can_make_it){
				can_make_it = (visibleTreasures.get(i).getType() != TreasureKind.BOTHHANDS);
				i++;
			}
		}
		else{
			if(t.getType() == TreasureKind.ONEHAND){
				int total_one_hand = 0;
				
				while(i < visibleTreasures.size() && can_make_it){
					if(visibleTreasures.get(i).getType() == TreasureKind.ONEHAND){
						total_one_hand++;
					}
					
					can_make_it = (visibleTreasures.get(i).getType() != TreasureKind.BOTHHANDS && total_one_hand < 2);
					i++;
				}
			}
			else{
				while(i < visibleTreasures.size() && can_make_it){
					can_make_it = (visibleTreasures.get(i).getType() != t.getType());
					i++;
				}
			}
		}
		
		return can_make_it;
    }
    
    // Devuelve el número de tesoros visibles de tipo tKind del jugador
    private int howManyVisibleTreasures(Treasure tKind) {
        int number_visible = 0;
		
		if(pendingBadConsequence.getTVisible() != 0){
			ArrayList<Treasure> tesoros;
			tesoros = pendingBadConsequence.getSpecificHiddenTreasures();
			
			for(int i = 0; i < tesoros.size(); i++){
				if(tesoros.get(i) == tKind){
					number_visible++;
				}
			}
		}
		
		return number_visible;
    }
    
    private void dieIfNoTreasures() {
        if(pendingBadConsequence.getTHidden() == 0 && pendingBadConsequence.getTVisible() == 0)
			dead = true;
		else
			dead = false;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    public CombatResult combat(Monster m) {
    	CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
	int enemyLevel;
        int number;
        if (!canISteal()) {
        	Dice dice = Dice.getInstance();
        	number = dice.nextNumber();
        	if (number < 3)
        		enemyLevel = enemy.getCombatLevel();
        }

        if (myLevel > monsterLevel) {
        	applyPrize(m);
        	if (level >= MAXLEVEL)
        		combatResult = CombatResult.WINGAME;
        	else
        		combatResult = CombatResult.WIN;
        }
        else {
        	applyBadConsequence(m);
        	combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }

    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        if (canI) {
        	visibleTreasures.add(t);
        	hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty())
        	pendingBadConsequence.substractVisibleTreasure(t);
        dieIfNoTreasures();
    }
   
    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty())
        	pendingBadConsequence.substractHiddenTreasure(t);
        dieIfNoTreasures();
    }

    // Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir
    // y no tiene más de 4 tesoros ocultos, y false en caso contrario
    public boolean validState() {
		boolean valid = false;
		
        if (pendingBadConsequence != null) {
            if(pendingBadConsequence.isEmpty() && pendingBadConsequence.getTHidden() <= 4){
				valid = true;
            }
		}
		
		return valid;
    }

    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        Treasure treasure = dealer.nextTreasure();
        int number = dice.nextNumber();

        bringToLife();
        hiddenTreasures.add(treasure);

        if (number > 1) {
        	treasure = dealer.nextTreasure();
        	hiddenTreasures.add(treasure);
        }
        if (number == 6) {
        	treasure = dealer.nextTreasure();
        	hiddenTreasures.add(treasure);
        }
    }

    public int getLevels() {
        return level;
    }
    public Treasure stealTreasure() {
    	Treasure treasure = new Treasure();
        boolean canI = enemy.canISteal();
        if (canI) {
        	boolean canYou = enemy.canYouGiveMeATreasure();
        	if (canYou) {
        		treasure = enemy.giveMeATreasure();
        		hiddenTreasures.add(treasure);
        		haveStolen();
        	}
        }
        if (canI)
        	return treasure;
        else
        	return null; // Devuelve null si no se ha podido robar
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure() {
		Random rn = new Random();
		
		if (hiddenTreasures.isEmpty())
		    return null;
		else
		    return hiddenTreasures.get(rn.nextInt(hiddenTreasures.size() - 1));
    }
    
    // decrementLevelsuelve variable canISteal
    public boolean canISteal() {
        return canISteal;
    }
    
    // Devuelve true si el jugador tiene tesoros para ser robados por otro jugador
    private boolean canYouGiveMeATreasure() {
        return !(visibleTreasures == null && hiddenTreasures == null);
    }
    
    // Si el jugador roba un tesoro
    private void haveStolen() {
        canISteal = false;
    }

    public void discardAllTreasures() {
    	Treasure treasure = new Treasure();
	
        for (int i = 0; i < visibleTreasures.size(); i++) {
        	treasure = visibleTreasures.get(i);
        	discardAllTreasures();
        }
        for (int i = 0; i < hiddenTreasures.size(); i++) {
        	treasure = hiddenTreasures.get(i);
        	discardHiddenTreasure(treasure);
        }
    }
}