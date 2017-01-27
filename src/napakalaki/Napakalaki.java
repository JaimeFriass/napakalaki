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
		} else {
			for (int i = 0; i < players.size(); i++) {
				if (currentPlayer == players.get(i)) {
					if (i != players.size()) {
						result = i + 1;
					} else {
						result = 0;
					}
				}
			}
		}
		if (result >= players.size()) {
			result -= 1;
		}

		return players.get(result);
	}

	public boolean nextTurnAllowed() {
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

			while (i == result) {
				result = rn.nextInt(players.size());
			}

			players.get(i).setEnemy(players.get(result));
		}
	}

	public static Napakalaki getInstance() {
		return instance;
	}

	public CombatResult developCombat() {
		CombatResult combatResult = currentPlayer.combat(currentMonster);

		CD.giveMonsterBack(currentMonster);

		if (combatResult == CombatResult.LOSEANDCONVERT) {
			CardDealer dealer = CardDealer.getInstance();
			Cultist sectario = dealer.nextCultist();

			CultistPlayer jugador_sect = new CultistPlayer(currentPlayer, sectario);

			int actual = players.indexOf(currentPlayer);

			currentPlayer = jugador_sect;
			players.set(actual, jugador_sect);

			for (Player a_player : players) {
				if (a_player != jugador_sect) {
					if (a_player.getEnemy() == currentPlayer) {
						a_player.setEnemy(jugador_sect);
					}
				}
			}

			currentPlayer = jugador_sect;
		}

		CD.giveMonsterBack(currentMonster);

		return combatResult;
	}

	public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
		Treasure treasure;
		for (int i = 0; i < treasures.size(); i++) {
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

	public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
		for (Treasure treasure : treasures) {
			currentPlayer.makeTreasureVisible(treasure);
		}
	}

	public void initGame(ArrayList<String> players) {
		initPlayers(players);
		setEnemies();
		CD.initCards();
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

			if (currentPlayer.isDead()) {
				currentPlayer.initTreasures();
			}
		}
		else {
			this.currentMonster = this.CD.nextMonster(); //1.2
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
