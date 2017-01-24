package Napakalaki;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {

	public static final Napakalaki instance = new Napakalaki();
	private Monster currentMonster;
	private Player currentPlayer;
	private final ArrayList<Player> players = new ArrayList();
	private static final CardDealer CD = CardDealer.getInstance();
	private Boolean primera_jugada = true;
	

	public Napakalaki() {
		
	}

	private void initPlayers(ArrayList<String> names) {
		for (int i = 0; i < names.size(); i++) {
			players.add(new Player(names.get(i)));
		}
	}

	private Player nextPlayer() {
		Random rn = new Random();
		int result = 0;
		
		if (primera_jugada) {
			primera_jugada = false;
			result = rn.nextInt(players.size() - 1);
		}
		else{
			for(int i = 0; i < players.size(); i++){
				if(currentPlayer == players.get(i)){
					if(i != players.size()){
						result = i + 1;
					}
					else{
						result = 0;
					}
				}
			}
		}
		if (result >= players.size())
		    result -= 1;
		
		return players.get(result);
	}

	private boolean nextTurnAllowed() {
		if (currentPlayer == null) {
			return true;
		} else {
			return currentPlayer.validState();
		}
	}

	private void setEnemies() {
		Random rn = new Random();
		int result;

		for (int i = 0; i < players.size(); i++) {
			result = rn.nextInt(players.size());
			if (result != i) {
				players.get(i).setEnemy(players.get(result));
			} else {
				i--;
			}
		}
	}

	public static Napakalaki getInstance() {
		return instance;	
	}
	
	public CombatResult developCombat() {
		CombatResult combatResult;
		combatResult = currentPlayer.combat(currentMonster);
		CD.giveMonsterBack(currentMonster);
		
		if(combatResult == CombatResult.LOSEANDCONVERT){
			CardDealer dealer = CardDealer.getInstance();
			Cultist sectario = dealer.nextCultist();
			
			CultistPlayer jugador_sect = new CultistPlayer(currentPlayer, sectario);
			
			int actual = players.indexOf(currentPlayer);
			
			currentPlayer = jugador_sect;
			players.set(actual, jugador_sect);
		}
		
		return combatResult;

	}
	public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
		Treasure treasure;
		for (int i = 0; i < treasures.size() ; i++) {
			treasure = treasures.get(i);
			currentPlayer.discardVisibleTreasure(treasure);
			CD.giveTreasureBack(treasure);
		}
	}
	public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
		Treasure treasure;
		for (int i = 0; i < treasures.size(); i++) {
			treasure = treasures.get(i);
			currentPlayer.discardHiddenTreasure(treasure);
			CD.giveTreasureBack(treasure);
		}
	}
	/*
	public void makeTreasureVisible(ArrayList<Treasure> treasures) {

	}
	*/
	public void initGame(ArrayList<String> players) {
		initPlayers(players);
		setEnemies();
		CD.initTreasureCardDeck();
		CD.initMonsterCardDeck();
		nextTurn();
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Monster getCurrentMonster() {
		return currentMonster;
	}

   	public boolean nextTurn() {
		boolean stateOK = nextTurnAllowed();
		if (stateOK) {
			currentMonster = CD.nextMonster();
			currentPlayer = nextPlayer();
			if ( currentPlayer.isDead()) {
				currentPlayer.initTreasures();
			}
		}
		
		return stateOK;
			
    	}
	public boolean endOfGame(CombatResult result) {
		return (CombatResult.WINGAME == result);
	}

	public static void main(String[] args) {
		// TODO code application logic here
	}

}
