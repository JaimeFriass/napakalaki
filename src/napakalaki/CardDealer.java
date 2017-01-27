package Napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardDealer {

	public static final CardDealer instance = new CardDealer();
	private ArrayList<Monster> unusedMonsters = new ArrayList();
	private ArrayList<Monster> usedMonsters = new ArrayList();
	private ArrayList<Treasure> unusedTreasures = new ArrayList();
	private ArrayList<Treasure> usedTreasures = new ArrayList();
	private ArrayList<Cultist> unusedCultist = new ArrayList();

	private CardDealer() {
	}

	public static CardDealer getInstance() {
		return instance;
	}

	// Inicializa el mazo de cartas de Tesoros (unusuedTreasures) con todas
	// las cartas de tesoros proporcionadas.
	public void initTreasureCardDeck() {
		unusedTreasures.add(new Treasure("Si,mi amo!", 4, TreasureKind.HELMET));
		unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
		unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
		unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
		unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
		unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
		unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
		unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
		unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Escopeta de 3 caniones", 4, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
		unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
		unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("NecroPlayboycon", 3, TreasureKind.ONEHAND));	//¿Va con segundas lo de una mano con Playboy? Jajaja
		unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
		unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
		unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
		unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
	}

	// Inicializa el mazo de cartas de Monstruos (unusedMonsters) con todas
	// las cartas de unusedMonsters proporcionadas.
	public void initMonsterCardDeck() {
		BadConsequence badConsequence;
		badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
		Prize prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Byakhees de bonanza", 8, badConsequence, prize));
		unusedMonsters.get(0).setIcon(1);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				new ArrayList());
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
		unusedMonsters.get(1).setIcon(2);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.SHOES)),
				new ArrayList());
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
		unusedMonsters.get(2).setIcon(3);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
				+ "Descarta 1 mano visible y 1 mano oculta", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
		prize = new Prize(4, 2);
		unusedMonsters.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));
		unusedMonsters.get(3).setIcon(4);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, NumericBadConsequence.MAXTREASURES, 0);
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
		unusedMonsters.get(4).setIcon(5);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList());
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
		unusedMonsters.get(5).setIcon(6);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
				new ArrayList());
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Necrófago", 13, badConsequence, prize));
		unusedMonsters.get(6).setIcon(7);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
		prize = new Prize(3, 2);
		unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence, prize));
		unusedMonsters.get(7).setIcon(8);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Flecher", 2, badConsequence, prize));
		unusedMonsters.get(8).setIcon(9);	//Icono para la interfaz

		badConsequence = new DeathBadConsequence("Estos unusedMonsters resultan bastante superficiales y te aburren mortalmente. Estás muerto");
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
		unusedMonsters.get(9).setIcon(10);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Semillas Cthulu", 4, badConsequence, prize));
		unusedMonsters.get(10).setIcon(11);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList());
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
		unusedMonsters.get(11).setIcon(12);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
		unusedMonsters.get(12).setIcon(13);	//Icono para la interfaz

		badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("Y skhtihyssg-Goth", 14, badConsequence, prize));
		unusedMonsters.get(13).setIcon(14);	//Icono para la interfaz

		badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto");
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
		unusedMonsters.get(14).setIcon(15);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2,
				new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
				new ArrayList());
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
		unusedMonsters.get(15).setIcon(16);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				new ArrayList());
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("El espía sordo", 5, badConsequence, prize));
		unusedMonsters.get(16).setIcon(17);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 2 tesoros visibles", 2, 2, 0);
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Tongue", 19, badConsequence, prize));
		unusedMonsters.get(17).setIcon(18);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
				new ArrayList());
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence, prize));
		unusedMonsters.get(18).setIcon(19);	//Icono para la interfaz

		//Monstruos de los cultist
		badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList());
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize));
		unusedMonsters.get(19).setIcon(20);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja", 0, 10, 0);
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize));
		unusedMonsters.get(20).setIcon(21);	//Icono para la interfaz

		badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres");
		prize = new Prize(2, 5);
		unusedMonsters.add(new Monster("El gran Cthulhu", 20, badConsequence, prize));
		unusedMonsters.get(21).setIcon(22);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Serpiente Politico", 8, badConsequence, prize));
		unusedMonsters.get(22).setIcon(23);	//Icono para la interfaz

		badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize));
		unusedMonsters.get(23).setIcon(24);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
		prize = new Prize(4, 2);
		unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize));
		unusedMonsters.get(24).setIcon(25);	//Icono para la interfaz

		badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize));
		unusedMonsters.get(25).setIcon(26);	//Icono para la interfaz
	}

	private void initCultistCardDeck() {
		unusedCultist.add(new Cultist("Sectario 1", 1));
		unusedCultist.add(new Cultist("Sectario 2", 2));
		unusedCultist.add(new Cultist("Sectario 3", 1));
		unusedCultist.add(new Cultist("Sectario 4", 2));
		unusedCultist.add(new Cultist("Sectario 5", 1));
		unusedCultist.add(new Cultist("Sectario 6", 1));
	}

	// Baraja el mazo de cartas de tesoros unusedTreasures
	private void shuffleTreasures() {
		Collections.shuffle(unusedTreasures);
	}

	// Baraja el mazo de cartas de monstruos unusedMonsters
	private void shuffleMonsters() {
		Collections.shuffle(unusedMonsters);
	}

	private void shuffleCultist() {
		Collections.shuffle(unusedCultist);
	}

	public Treasure nextTreasure() {
		if(unusedTreasures.isEmpty()){
			unusedTreasures = usedTreasures;
			usedTreasures = new ArrayList();
			shuffleTreasures();
		}
		
		Treasure trs = unusedTreasures.get(0);
		unusedTreasures.remove(trs);
		usedTreasures.add(trs);
		
		return trs; 
	}

	public Monster nextMonster() {
		Monster siguiente;

		shuffleMonsters();

		if (!unusedMonsters.isEmpty()) {
			siguiente = unusedMonsters.get(unusedMonsters.size() - 1);
			unusedMonsters.remove(unusedMonsters.size() - 1);
		} else {
			unusedMonsters = usedMonsters;
			shuffleMonsters();

			siguiente = unusedMonsters.get(unusedMonsters.size() - 1);
		}

		return siguiente;
	}

	public Cultist nextCultist() {
		Cultist siguiente;

		if (unusedCultist.isEmpty()) {
			initCultistCardDeck();
			shuffleCultist();
		}

		siguiente = unusedCultist.get(0);

		unusedCultist.remove(siguiente);

		return siguiente;
	}

	public void giveTreasureBack(Treasure t) {
		usedTreasures.add(t);
	}

	public void giveMonsterBack(Monster m) {
		usedMonsters.add(m);
	}

	public void initCards() {
		initMonsterCardDeck();
		shuffleMonsters();

		initTreasureCardDeck();
		shuffleTreasures();

		initCultistCardDeck();
		shuffleCultist();
	}
}
