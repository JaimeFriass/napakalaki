package Napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jesusjimsa & jaimefriass
*/

public class CultistPlayer extends Player {
	private static int totalCultistPlayers = 0;
	private Cultist myCultistCard;
	
	public CultistPlayer(Player p, Cultist c) {
		super(p);
		myCultistCard = c;
		totalCultistPlayers++;
	}
	
	@Override
	protected int getCombatLevel(){
		int combatLevel = super.getCombatLevel();
		
		//Se pone (int) para que al hacer la multilicación por 0.7 no deje decimales, ya que se convierte en un double
		combatLevel = (int) (combatLevel + (combatLevel * 0.7) + myCultistCard.getGainedLevels());
		
		return combatLevel;
	}
	
	@Override
	protected int getOponentLevel(Monster m){
		return m.getCombatLevelAgainstCultistPlayer();
	}
	
	@Override
	protected boolean shouldConvert(){		
		return false;	//Nunca se pasa de cultist a normal
	}
	
	public int getTotalCultistPlayers(){
		return totalCultistPlayers;
	}
	
	private Treasure giveMeATreasure(){
		Random rn = new Random();
		ArrayList<Treasure> visibles = super.getVisibleTreasures();
		
		if (visibles.isEmpty())
		    return null;
		else
		    return visibles.get(rn.nextInt(visibles.size() - 1));
	}
	
	private boolean canYouGiveMeATreasure(){
		Player enemigo = super.getEnemy();
		
		return !enemigo.getVisibleTreasures().isEmpty();	//Si no está vacío devuelve true
	}
}
