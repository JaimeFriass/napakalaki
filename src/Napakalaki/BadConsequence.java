
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jaimefrias and jesusjimsa
 */
public class BadConsequence {

	protected String text;
	protected int levels;
	private int nVisibleTreasures;
	private int nHiddenTreasures;
	public static final int MAXTREASURES = 4;
	private boolean death;
	protected ArrayList<Treasure> specificHiddenTreasures = new ArrayList();
	protected ArrayList<Treasure> specificVisibleTreasures = new ArrayList();

	BadConsequence(String text, int levels, int nVisible, int nHidden) {
		this.text = text;
		this.levels = levels;
		nVisibleTreasures = nVisible;
		nHiddenTreasures = nHidden;
	}

	BadConsequence(String text, boolean death) {
		this.text = text;
		this.death = death;
	}
	
	BadConsequence(String text, int levels){
		this.text = text;
		this.levels = levels;
	}

	BadConsequence(String text, int levels, ArrayList<Treasure> tVisible, ArrayList<Treasure> tHidden) {
		this.text = text;
		this.levels = levels;
		this.specificHiddenTreasures = tHidden;
		this.specificVisibleTreasures = tVisible;
	}

	BadConsequence(String text, int levels, int nVisible, ArrayList<Treasure> tHidden) {
		this.text = text;
		this.levels = levels;
		this.specificHiddenTreasures = tHidden;
		nVisibleTreasures = nVisible;
	}

	BadConsequence(String text, int levels, ArrayList<Treasure> tVisible, int nHidden) {
		this.text = text;
		this.levels = levels;
		nHiddenTreasures = nHidden;
		this.specificVisibleTreasures = tVisible;
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

	int getTVisible() {
		return nVisibleTreasures;
	}

	int getTHidden() {
		return nHiddenTreasures;
	}

	boolean getDeath() {
		return death;
	}

	void setDeath(boolean death) {
		this.death = death;
	}

	ArrayList<Treasure> getSpecificHiddenTreasures() {
		return specificHiddenTreasures;
	}

	ArrayList<Treasure> getSpecificVisibleTreasures() {
		return specificVisibleTreasures;
	}

	boolean onlyLoseLevels() {
		boolean correcto;

		correcto = levels > 0 && nVisibleTreasures == 0 && nHiddenTreasures == 0;

		return correcto;
	}

	boolean loseTreasure(Treasure treasure, boolean visible) {
		boolean lose = false;
		if (visible) {
			for (int i = 0; specificVisibleTreasures.size() > i; i++) {
				if (specificVisibleTreasures.get(i) == treasure) {
					lose = true;
				}
			}
		} else {
			for (int i = 0; specificHiddenTreasures.size() > i; i++) {
				if (specificHiddenTreasures.get(i) == treasure) {
					lose = true;
				}
			}
		}
		return lose;
	}
	
        // Devuelve true cuando no se pierden tesoros
	boolean isEmpty(){
            return (nVisibleTreasures == 0 && nHiddenTreasures == 0);
	}

	@Override
	public String toString() {
		return "Text = " + text + " levels = " + Integer.toString(levels)
				+ " Visible Treasures = " + Integer.toString(nVisibleTreasures)
				+ " Hidden Treasures = " + Integer.toString(nHiddenTreasures)
				+ " death = " + Boolean.toString(death);
	}
	
	void substractVisibleTreasure(Treasure t){
		for(int i = 0; i < nVisibleTreasures; i++){
			if(specificVisibleTreasures.get(i).getType() == t.getType()){
				nVisibleTreasures--;
				specificVisibleTreasures.remove(t);
			}
		}
	}
	
	void substractHiddenTreasure(Treasure t){
		for(int i = 0; i < nHiddenTreasures; i++){
			if(specificHiddenTreasures.get(i).getType() == t.getType()){
				nHiddenTreasures--;
				specificHiddenTreasures.remove(t);
			}
		}
	}

	BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
		// Devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador.
		int visibleTreasures;
		int hiddenTreasures;
		visibleTreasures = nVisibleTreasures;
		hiddenTreasures = nHiddenTreasures;
		ArrayList<Treasure> specificVisible = specificVisibleTreasures;
		ArrayList<Treasure> specificHidden = specificHiddenTreasures;
		
		if (v.size() < nVisibleTreasures)
		    nVisibleTreasures = v.size();
		
		if (h.size() < nHiddenTreasures)
		    nHiddenTreasures = h.size();
		
		for (int i = 0; i < specificVisibleTreasures.size(); i++) {
			if (specificVisible.get(i) != v.get(i)) {
				specificVisible.remove(i);
				i--;
			}
		}
		
		BadConsequence bc = new BadConsequence(text, 0, specificVisible, specificHidden);
		
		return bc;
	}
}
