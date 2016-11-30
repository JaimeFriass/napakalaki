/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jaimefrias and jesusjimsa
 */
public class BadConsequence {

	private String text;
	private int levels;
	private int nVisibleTreasures;
	private int nHiddenTreasures;
	private boolean death;
	private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
	private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();

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

	BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
		this.text = text;
		this.levels = levels;
		this.specificHiddenTreasures = tHidden;
		this.specificVisibleTreasures = tVisible;
	}

	BadConsequence(String text, int levels, int nVisible, ArrayList<TreasureKind> tHidden) {
		this.text = text;
		this.levels = levels;
		this.specificHiddenTreasures = tHidden;
		nVisibleTreasures = nVisible;
	}

	BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, int nHidden) {
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

	ArrayList<TreasureKind> getSpecificHiddenTreasures() {
		return specificHiddenTreasures;
	}

	ArrayList<TreasureKind> getSpecificVisibleTreasures() {
		return specificVisibleTreasures;
	}

	boolean onlyLoseLevels() {
		boolean correcto;

		correcto = levels > 0 && nVisibleTreasures == 0 && nHiddenTreasures == 0;

		return correcto;
	}

	boolean loseTreasure(TreasureKind treasure, boolean visible) {
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
			if(specificVisibleTreasures.get(i) == t.getType()){
				nVisibleTreasures--;
				specificVisibleTreasures.remove(t.getType());
			}
		}
	}
	
	void substractHiddenTreasure(Treasure t){
		for(int i = 0; i < nHiddenTreasures; i++){
			if(specificHiddenTreasures.get(i) == t.getType()){
				nHiddenTreasures--;
				specificHiddenTreasures.remove(t.getType());
			}
		}
	}

	BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v; ArrayList<Treasure> h) {
		// Devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador.
		BadConsequence bc = new BadConsequence();
		// aqui falta tela, me he rallao, luego lo termino xddd
	}
}
