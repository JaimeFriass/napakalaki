
package napakalaki;

import static java.lang.Integer.min;
import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence {
    
    protected ArrayList<TreasureKind> specificHiddenTreasures = null;
    protected ArrayList<TreasureKind> specificVisibleTreasures = null;
    
    public SpecificBadConsequence(String name, int lvls, ArrayList<TreasureKind> specificVisible, ArrayList<TreasureKind> specificHidden) {
        super(name, lvls);
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = specificVisible;
        this.specificHiddenTreasures = specificHidden;
    }
    
    public BadConsequence adjustToFitTreasureList( ArrayList<Treasure> tvisibles, ArrayList<Treasure> thidden) {
        BadConsequence bc;
        ArrayList<TreasureKind> visible_adjust;
        ArrayList<TreasureKind> hidden_adjust;
        visible_adjust = new ArrayList();
        hidden_adjust = new ArrayList();
        
        for (TreasureKind tKind : TreasureKind.values() ) {
            int jugador = 0;
            int badCons = 0;
            
            
            if (specificVisibleTreasures != null) {
                for (TreasureKind t : specificVisibleTreasures) {
                    if ( t == tKind)
                        badCons++;
                }
                
                for (Treasure t : tvisibles) {
                    if (t.getType() == tKind)
                        jugador++;
                }
                
                for (int i = 0; i < min(jugador, badCons); i++)
                    visible_adjust.add(tKind);
            }
            
            jugador = 0; badCons = 0;
            
            if (specificHiddenTreasures != null) {
                for (TreasureKind t : specificHiddenTreasures) {
                    if ( t == tKind)
                        badCons++;
                }
                
                for (Treasure t : thidden) {
                    if (t.getType() == tKind)
                        jugador++;
                }
                
                for (int i = 0; i < min(jugador, badCons); i++) {
                    hidden_adjust.add(tKind);
                }
            }
        }
        bc = new SpecificBadConsequence (text, 0, visible_adjust, hidden_adjust);
        return bc;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public void substractVisibleTreasure(Treasure t) {
        if (specificVisibleTreasures != null) {
            specificVisibleTreasures.remove(t.getType());
        }
    }

    public void substractHiddenTreasure(Treasure t) {
        if (specificHiddenTreasures != null) {
            specificHiddenTreasures.remove(t.getType());
        }
    }

    public String toString(){
        String description = "--- Mal Rollo Específico --- \n" + "Texto: " + text + "\n";
        
        if (levels != 0)
            description += "Pérdida de niveles: " + levels + "\n";
        
        if(specificVisibleTreasures != null)
            description += "Lista tesoros visibles: " + specificVisibleTreasures.toString() + "\n";
        if( specificHiddenTreasures != null)
            description += "Lista tesoros ocultos: " + specificHiddenTreasures.toString() + "\n";
                
        return description;
    } 
}
