
import java.util.ArrayList;
import java.util.Random;
import Napakalaki.*;
public class Napakalaki {

    public static final Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private Player currentPlayer;
    private final ArrayList<Player> players = new ArrayList();
    private static final CardDealer CD = CardDealer.getInstance();

    private Napakalaki() {
    }

    private void initPlayers(ArrayList<String> names) {
	for (int i = 0; i < names.size(); i++) {
	    players.add(new Player(names.get(i)));
	}
    }

    private Player nextPlayer() {
	Random rn = new Random();
	int result;
	if (PRIMERA 
	    JUGADA
	
	    ) {
            result = rn.nextInt(players.size());
	}else {
            // El jugador siguiente al que se encuentra en la pos actual
        }
	result = rn.nextInt(6);

	return players.get(result);
    }

    private boolean nextTurnAllowed() {
	if (currentPlayer = null) {
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

    public CombatResult developCombat() {

    }

    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {

    }

    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {

    }

    public void makeTreasureVisible(ArrayList<Treasure> treasures) {

    }

    public void initGame(ArrayList<String> players) {

    }

    public Player getCurrentPlayer() {
	return currentPlayer;
    }

    public Monster getCurrentMonster() {
	return currentMonster;
    }

    public boolean nextTurn() {

    }

    public boolean endOfGame(CombatResult result) {
	return (CombatResultWINGAME == result);
    }

    public static void main(String[] args) {
	// TODO code application logic here
    }

}
