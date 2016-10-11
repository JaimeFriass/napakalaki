/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jaimefrias
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

	@Override
	public String toString() {
		return "Text = " + text + " levels = " + Integer.toString(levels)
				+ " Visible Treasures = " + Integer.toString(nVisibleTreasures)
				+ " Hidden Treasures = " + Integer.toString(nHiddenTreasures)
				+ " death = " + Boolean.toString(death);
	}

}