/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Napakalaki;

/**
 *
 * @author jaimefrias
 */
public class Monster {

	private String name;
	private int combatLevel;
	private BadConsequence bc;
	private Prize prize;
	private int levelChangeAgainstCultistPlayer = 0;
	private int icon;

	//Constructor normal
	Monster(String name, int level, BadConsequence bc, Prize prize) {
		this.name = name;
		combatLevel = level;
		this.bc = bc;
		this.prize = prize;
	}
	
	// Constructor de copia
	public Monster(Monster monstruo) {
		this.name = monstruo.name;
		this.combatLevel = monstruo.combatLevel;
		this.bc = monstruo.bc;
		this.prize = monstruo.prize;
	}
	
	//Constructor para Cultist
	public Monster(String name, int combatLevel, BadConsequence badConsequence, Prize prize, int IC){
		this.name = name;
		this.combatLevel = combatLevel;
		bc = badConsequence;
		this.prize = prize;
		levelChangeAgainstCultistPlayer = IC;
	}

	public String getName() {
		return name;
	}

	public int getCombatLevel() {
		return combatLevel;
	}

	public BadConsequence getBadConsequence() {
		return bc;
	}

	public Prize getPrize() {
		return prize;
	}
	
	int getCombatLevelAgainstCultistPlayer(){
		return levelChangeAgainstCultistPlayer + combatLevel;
	}

//	boolean onlyLoseLevels() {
//		return bc.onlyLoseLevels();
//	}

	boolean winLevelsFrom(int lvl) {
		return prize.winLevelsFrom(lvl);
	}

//	boolean loseTreasure(Treasure treasure, boolean visible) {
//		return bc.loseTreasure(treasure, visible);
//	}
	
	int getLevelsGained(){
		return bc.getLevels();
	}
	
	int getTreasuresGained(){
		return this.prize.getTreasures();
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}
	
	public int getIcon(){
		return icon;
	}

	@Override
	public String toString() {
		return name + "(" + Integer.toString(combatLevel) + ")";
	}
}