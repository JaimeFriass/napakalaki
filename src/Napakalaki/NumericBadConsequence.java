
package napakalaki;

import java.util.ArrayList;

public class NumericBadConsequence extends BadConsequence{
    
    int nVisibleTreasures;
    int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int level, int nVisible, int nHidden) {
        super(text, level);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }
    
    public int getHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isEmpty() {
        return (nVisibleTreasures == 0 && nHiddenTreasures == 0);
    }
    
    public void substractVisibleTreasure(Treasure t) {
        if (this.nVisibleTreasures > 0)
            this.nVisibleTreasures -= 1;
    }

    public void substractHiddenTreasure(Treasure t) {
        if (this.nHiddenTreasures > 0)
            this.nHiddenTreasures -= 1;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Napakalaki.Treasure> v, ArrayList<Napakalaki.Treasure> h) {
	// Devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador.
	int nVisible = nVisibleTreasures;
	int nHidden = nHiddenTreasures;
		
	if (v.size() < nVisibleTreasures)
	    nVisible = v.size();
		
	if (h.size() < nHiddenTreasures)
	    nHidden = h.size();
        
        BadConsequence bc = new NumericBadConsequence(text, 0, nVisible, nHidden);
        
        return bc;
    }
    
    public String to_s() {
        return text + "\nTesoros visibles: " + nVisibleTreasures + "\nTesoros ocultos" + nHiddenTreasures;
    }
}
