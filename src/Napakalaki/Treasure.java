package Napakalaki;

public class Treasure {

	public String name;
	public int bonus;
	TreasureKind type;

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
