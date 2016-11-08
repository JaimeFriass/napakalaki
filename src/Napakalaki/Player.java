
public class Player { 
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        dead = false;
    }
    
    private int getCombatLevel() {
        return level;
    }
    
    private void incrementLevels(int lvls) {
        level++;
    }
    
    private void decrementLevels(int lvls) {
        level--;
    }
    
    private void setPendingBadConsequence(BadConsequence bc) {
        
    }
    
    private void applyPrize(Monster m) {
        
    }
    
    private void applyBadConsequence(Monster m) {
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind) {
        
    }
    
    private void dieIfNoTreasures() {
        
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public Treasure[] getHiddenTreasures() {
        
    }
    
    public Treasure[] getVisibleTreasures() {
        
    }
    
    public CombatResult combat(Monster m) {
        
    }
    
    public void makeTreasureVisible(Treasure t) {
        
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
    }
    
    public void discardHiddenTreasure(Treasure t) {
        
    }
    
    public boolean validState() {
        
    }
    
    public void initTreasures() {
        
    }
    
    public int getLevels() {
        return level;
    }
    
    public Treasure stealTreasure() {
        
    }
    
    public void setEnemy(Player enemy) {
        
    }
    
    private Treasure giveMeATreasure() {
        
    }
    
    public boolean canISteal() {
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure() {
        
    }
    
    private void haveStolen() {
        
    }
    
    public void discardAllTreasures() {
        
    }
    
     
    
}
