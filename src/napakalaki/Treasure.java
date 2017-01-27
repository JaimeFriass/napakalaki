package Napakalaki;

public class Treasure {

	private String name;
	private int bonus;
	private TreasureKind type;

	public Treasure() {
		this.name = "";
		this.bonus = 0;
		type = TreasureKind.ONEHAND;
	}

	public String toString() {
		return name;
	}

	public Treasure(String name, int bonus, TreasureKind t) {
		this.name = name;
		this.bonus = bonus;
		type = t;
	}

	public String getName() {
		return name;
	}

	public int getBonus() {
		return bonus;
	}

	public TreasureKind getType() {
		return type;
	}
}
