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

	private Napakalaki() {
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
			result = rn.nextInt(players.size());
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
			result = rn.nextInt(players.size()) + 1;
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
	/*
	public CombatResult developCombat() {

	}

	public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
		for (int i = 0; i < treasures.size() ; i++) {
			Treasure treasure = next();
			currentPlayer.discardVisibleTreasure(treasure);
			
		}
	}
	
	public void discardHiddenTreasures(ArrayList<Treasure> treasures) {

	}
	
	public void makeTreasureVisible(ArrayList<Treasure> treasures) {

	}
	*/
	public void initGame(ArrayList<String> players) {
		initPlayers(players);
		setEnemies();
		CardDealer dealer = CardDealer.getInstance();
		dealer.initTreasureCardDeck();
		dealer.initMonsterCardDeck();
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
			currentMonster = dealer.nextMonster();
			currentPlayer = nextPlayer();
			dead = currentPlayer.isDead();
			if (dead) {
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
