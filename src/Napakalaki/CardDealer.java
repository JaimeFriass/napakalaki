package Napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CardDealer {
    public static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    
    
    private CardDealer() { }
    
    public CardDealer getInstance() {
        return instance;
    }
    
    // Inicializa el mazo de cartas de Tesoros (unusuedTreasures) con todas
    // las cartas de tesoros proporcionadas.
    private void initTreasureCardDeck() {
        
    }
    
    // Inicializa el mazo de cartas de Monstruos (unusedMonsters) con todas
    // las cartas de unusedMonsters proporcionadas.
    private void initMonsterCardDeck() {
        BadConsequence badConsequence;
		badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
	Prize prize = new Prize(1, 1);
	unusedMonsters.add(new Monster("Byakhees de bonanza", 8, badConsequence, prize));

	badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
			new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				0);
	prize = new Prize(1, 1);
	unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize));

	badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
			new ArrayList(Arrays.asList(TreasureKind.SHOES)),
				0);
	prize = new Prize(1, 1);
	unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

	badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
			+ "Descarta 1 mano visible y 1 mano oculta", 0,
			new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
			new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
	prize = new Prize(4, 2);
	unusedMonsters.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));

	badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, Integer.MAX_VALUE, 0);
	prize = new Prize(3, 1);
	unusedMonsters.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));

	badConsequence = new BadConsequence("Pierdes la armadura visible", 0,
			new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
			0);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));

	badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
			new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
			0);
	prize = new Prize(1, 1);
	unusedMonsters.add(new Monster("Necrófago", 13, badConsequence, prize));

	badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5,
			3,
			0);
	prize = new Prize(3, 2);
	unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence, prize));

	badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
	prize = new Prize(1, 1);
	unusedMonsters.add(new Monster("Flecher", 2, badConsequence, prize));

	badConsequence = new BadConsequence("Estos unusedMonsters resultan bastante superficiales y te aburren mortalmente. Estás muerto", 0, 0, 0);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

	badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2,
			0,
			2);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("Semillas Cthulu", 4, badConsequence, prize));

	badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0,
			new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
			0);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

	badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
	prize = new Prize(3, 1);
	unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

	badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", 0, 0, 0);
	prize = new Prize(3, 1);
	unusedMonsters.add(new Monster("Y skhtihyssg-Goth", 14, badConsequence, prize));

	badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", 0, 0, 0);
	prize = new Prize(3, 1);
	unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));

	badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un te soro 2 manos visible", 2,
			new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
			0);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

	badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
			new ArrayList(Arrays.asList(TreasureKind.HELMET)),
			0);
	prize = new Prize(1, 1);
	unusedMonsters.add(new Monster("El espía sordo", 5, badConsequence, prize));

	badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 2 tesoros visibles", 2, 2, 0);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("Tongue", 19, badConsequence, prize));

	badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
			Integer.MAX_VALUE,
			Integer.MAX_VALUE);
	prize = new Prize(2, 1);
	unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence, prize));
    }
    
    // Baraja el mazo de cartas de tesoros unusedTreasures
    private void shuffleTreasures() {
        Random rnd = new Random();
        for (int i = unusedTreasures.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Treasure a = unusedTreasures.get(index);
            unusedTreasures.set(index, unusedTreasures.get(i));
            unusedTreasures.set(i, a);
            // Incompleto
        }
    }
    /*
    // Baraja el mazo de cartas de monstruos unusedMonsters
    private void shuffleMonsters() {
        
    }
    
    public Treasure nextTreasure(){
        // P3
    }
    
    public Monster nextMonster() {
        // P3
    }
    */
    public void giveTreasureBack(Treasure t) {
        usedMonsters.add(t);
    }
    
    public void giveMonsterBack(Monster m) {
        usedTreasures.add(m);
    }
    /*
    public void initCards() {
        
    }
    */
}