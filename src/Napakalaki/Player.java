package Napakalaki;

import java.util.ArrayList;

public class Player { 
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private BadConsequence pendingBadConsequence;
    private Player enemy;
    private Treasure hiddenTreasures;
    private Treasure visibleTreasures;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        dead = false;
    }
    
    private int getCombatLevel() {
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
    /*
    private void applyPrize(Monster m) {
        
    }
    
    private void applyBadConsequence(Monster m) {
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        
    }
    */
    // Devuelve el número de tesoros visibles de tipo tKind del jugador
    private int howManyVisibleTreasures(TreasureKind tKind) {
        int number_visible = 0;
		
		if(pendingBadConsequence.getTVisible() != 0){
			ArrayList<TreasureKind> tesoros;
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
    /*
    public Treasure[] getHiddenTreasures() {
        
    }
    
    public Treasure[] getVisibleTreasures() {
        
    }
    
    public CombatResult combat(Monster m) {
        
    }
    
    public void makeTreasureVisible(Treasure t) {
        
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
    }
    
    public void discardHiddenTreasure(Treasure t) {
        
    }
    */
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
    /*
    public void initTreasures() {
        
    }
    */
    public int getLevels() {
        return level;
    }
    /*
    public Treasure stealTreasure() {
        
    }
    */
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    /*
    private Treasure giveMeATreasure() {
        
    }
    */
    // Devuelve variable canISteal
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
    /*
    public void discardAllTreasures() {
        
    }
	*/
}