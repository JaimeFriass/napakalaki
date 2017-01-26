package Napakalaki;

import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();

	public SpecificBadConsequence(String name, int lvls, ArrayList<TreasureKind> specificVisible, ArrayList<TreasureKind> specificHidden) {
		super(name, lvls, false);
		this.specificVisibleTreasures = new ArrayList();
		this.specificHiddenTreasures = new ArrayList();
		this.specificVisibleTreasures = specificVisible;
		this.specificHiddenTreasures = specificHidden;
	}

	@Override
	public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
		ArrayList<TreasureKind> visible_adjust = specificVisibleTreasures;
		ArrayList<TreasureKind> hidden_adjust = specificHiddenTreasures;
		
		SpecificBadConsequence devuelve = new SpecificBadConsequence(text, levels, new ArrayList(), new ArrayList()  );
		
		for (int i = 0; i < v.size(); i++) {
		    if ( visible_adjust.contains(v.get(i).getType() ) ) {
			devuelve.specificVisibleTreasures.add(v.get(i).getType());
			visible_adjust.remove(v.get(i).getType() );
		    }
		}
		for (int i = 0; i < h.size(); i++) {
		    if ( hidden_adjust.contains (h.get(i).getType() ) ) {
			devuelve.specificHiddenTreasures.add(h.get(i).getType());
			hidden_adjust.remove(h.get(i).getType() );
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

	@Override
	public void substractVisibleTreasure(Treasure t) {
		if (specificVisibleTreasures != null) {
			specificVisibleTreasures.remove(t.getType());
		}
	}

	@Override
	public void substractHiddenTreasure(Treasure t) {
		if (specificHiddenTreasures != null) {
			specificHiddenTreasures.remove(t.getType());
		}
	}
	
	@Override
	public boolean isEmpty() {
	    return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
	}

	@Override
	public String toString() {
                String devolver = "";
		if (levels != 0) {
			devolver += "Pérdida de niveles: " + levels + "\n";
		}

		if (specificVisibleTreasures != null) {
			devolver += "Lista tesoros visibles: " + specificVisibleTreasures.toString() + "\n";
		}
		if (specificHiddenTreasures != null) {
			devolver += "Lista tesoros ocultos: " + specificHiddenTreasures.toString() + "\n";
		}

		return devolver;
	}
}
