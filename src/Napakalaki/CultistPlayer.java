package Napakalaki;

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
	
}
