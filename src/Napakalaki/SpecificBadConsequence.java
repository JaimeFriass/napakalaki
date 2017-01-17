package Napakalaki;

import static java.lang.Integer.min;
import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();

	public SpecificBadConsequence(String name, int lvls, ArrayList<TreasureKind> specificVisible, ArrayList<TreasureKind> specificHidden) {
		super(name, lvls);
		this.specificVisibleTreasures = new ArrayList();
		this.specificHiddenTreasures = new ArrayList();
		this.specificVisibleTreasures = specificVisible;
		this.specificHiddenTreasures = specificHidden;
	}

	public SpecificBadConsequence adjustToFitTreasureList(ArrayList<Treasure> tvisibles, ArrayList<Treasure> thidden) {
		ArrayList<TreasureKind> visible_adjust = specificVisibleTreasures;
		ArrayList<TreasureKind> hidden_adjust = specificHiddenTreasures;
		
		SpecificBadConsequence devuelve = new SpecificBadConsequence(text, levels, new ArrayList(), new ArrayList()  );
		
		for (int i = 0; i < tvisibles.size(); i++) {
		    if ( visible_adjust.contains( tvisibles.get(i).getType() ) ) {
			devuelve.specificVisibleTreasures.add(tvisibles.get(i).getType());
			visible_adjust.remove(tvisibles.get(i).getType() );
		    }
		}
		for (int i = 0; i < thidden.size(); i++) {
		    if ( hidden_adjust.contains ( thidden.get(i).getType() ) ) {
			devuelve.specificHiddenTreasures.add(thidden.get(i).getType());
			hidden_adjust.remove(thidden.get(i).getType() );
		    }
		}
		return devuelve;
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
	
	public boolean isEmpty() {
	    return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
	}

	public String toString() {
		String description = "--- Mal Rollo Específico --- \n" + "Texto: " + text + "\n";

		if (levels != 0) {
			description += "Pérdida de niveles: " + levels + "\n";
		}

		if (specificVisibleTreasures != null) {
			description += "Lista tesoros visibles: " + specificVisibleTreasures.toString() + "\n";
		}
		if (specificHiddenTreasures != null) {
			description += "Lista tesoros ocultos: " + specificHiddenTreasures.toString() + "\n";
		}

		return description;
	}
}
