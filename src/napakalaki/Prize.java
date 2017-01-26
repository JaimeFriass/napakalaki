
package Napakalaki;

public class Prize {

	private int levels;
	private int treasures;

	Prize(int treasures, int levels) {
		this.levels = levels;
		this.treasures = treasures;
	}

	public int getTreasures() {
		return treasures;
	}

	void setTreasures(int treasures) {
		this.treasures = treasures;
	}

	public int getLevel() {
		return this.levels;
	}

	void setLevel(int levels) {
		this.levels = levels;
	}

	boolean winLevelsFrom(int lvl) {
		return levels > lvl;
	}

	@Override
	public String toString() {
		return "Niveles -> " + Integer.toString(levels) + "\nTesoros -> " + Integer.toString(treasures);
	}

}
