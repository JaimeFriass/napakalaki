package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jaimefrias and jesusjimsa
 */
public abstract class BadConsequence {

	protected String text;
	protected int levels;
	private boolean death;

	BadConsequence(String text, int levels, boolean death) {
		this.text = text;
		this.levels = levels;
		this.death = death;
	}

	String getText() {
		return text;
	}

	void setText(String text) {
		this.text = text;
	}

	int getLevels() {
		return levels;
	}

	void setLevels(int levels) {
		this.levels = levels;
	}

	boolean getDeath() {
		return death;
	}

	void setDeath(boolean death) {
		this.death = death;
	}

	// Devuelve true cuando no se pierden tesoros
	abstract boolean isEmpty();

	public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
	
	public abstract void substractHiddenTreasure(Treasure t);
	
	public abstract void substractVisibleTreasure(Treasure t);
	
	@Override
	public abstract String toString();
}
