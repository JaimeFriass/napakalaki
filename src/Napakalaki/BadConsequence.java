
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
	
	BadConsequence(String text, int levels) {
		this.text = text;
		this.levels = levels;
	}

	BadConsequence(String text, boolean death) {
		this.text = text;
		this.death = death;
	}
	
	BadConsequence(String text, int levels, boolean death){
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

	public abstract String toString();
}
