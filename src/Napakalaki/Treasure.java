package Napakalaki;

public class Treasure {

	private String name;
	private int bonus;
	private TreasureKind type;
	
	public Treasure() {
	    this.name = null;
	    this.bonus = 0;
	    type = null;
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
