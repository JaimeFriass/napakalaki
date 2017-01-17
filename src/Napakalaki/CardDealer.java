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

		badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.HELMET)),
				new ArrayList());
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize));

		badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
				new ArrayList(Arrays.asList(TreasureKind.SHOES)),
				new ArrayList());
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

		badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
				+ "Descarta 1 mano visible y 1 mano oculta", 0,
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
				new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
		prize = new Prize(4, 2);
		unusedMonsters.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));

		badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, NumericBadConsequence.MAXTREASURES, 0);
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));

		badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0,
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

		badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2,
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
		
		//Monstruos de los cultist
		badConsequence = new BadConsequence("Pierdes 1 mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 0);
		prize = new Prize(3, 1);
		unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize));
		
		badConsequence = new BadConsequence("TPierdes tus tesoros visibles. Jajaja", 0, Integer.MAX_VALUE, 0);
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize));
		
		badConsequence = new BadConsequence("Hoy no es tu día de suerte. Mueres", true);
		prize = new Prize(2, 5);
		unusedMonsters.add(new Monster("El gran Cthulhu", 20, badConsequence, prize));
		
		badConsequence = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
		prize = new Prize(2, 1);
		unusedMonsters.add(new Monster("Serpiente Politico", 8, badConsequence, prize));
		
		badConsequence = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, 
				new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
				new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize));
		
		badConsequence = new BadConsequence("Pierdes 2 niveles", 2, 0, 0);
		prize = new Prize(4, 2);
		unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize));
		
		badConsequence = new BadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
		prize = new Prize(1, 1);
		unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize));
	}
	
	private void initCultistCardDeck(){
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
	
	private void shuffleCultist(){
		Collections.shuffle(unusedCultist);
	}

	public Treasure nextTreasure() {
		Treasure siguiente;
		
		if(unusedTreasures.isEmpty() ){
		    unusedTreasures = usedTreasures;
		    shuffleTreasures();
		    
		    siguiente = unusedTreasures.get(unusedTreasures.size() - 1);
		}
		else{
		    siguiente = unusedTreasures.get(unusedTreasures.size() - 1);
		    unusedTreasures.remove(unusedTreasures.size() - 1);
		}
		
		return siguiente;
	}

	public Monster nextMonster() {
		Monster siguiente;
		
		if(!unusedMonsters.isEmpty()){
			siguiente = unusedMonsters.get(unusedMonsters.size() - 1);
			unusedMonsters.remove(unusedMonsters.size() - 1);
		}
		else{
			unusedMonsters = usedMonsters;
			shuffleMonsters();
			
			siguiente = unusedMonsters.get(unusedMonsters.size() - 1);
		}
		
		return siguiente;
	}

	public Cultist nextCultist(){
		Cultist siguiente;
		
		if(unusedCultist.isEmpty()){
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
