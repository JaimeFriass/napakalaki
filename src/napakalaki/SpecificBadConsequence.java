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
	public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
		BadConsequence speBadCon;
		
		// FOR VISIBLE TREASURES
		ArrayList<Treasure> copiaV = new ArrayList(v);
		ArrayList<TreasureKind> newSpecificVisible = new ArrayList();

		for (TreasureKind tk : specificVisibleTreasures){
			int i = 0;
			boolean found = false;

			while ((i < copiaV.size()) && !(found)){
				if (copiaV.get(i).getType() == tk){
					found = true;
					newSpecificVisible.add(tk);
					copiaV.remove(i);
				}

				i++;
			}
		}

		// FOR HIDDEN TREASURES
		ArrayList<Treasure> copiaH = new ArrayList(h);
		ArrayList<TreasureKind> newSpecificHidden = new ArrayList();

		for (TreasureKind tk : specificHiddenTreasures){
			int i = 0;
			boolean found = false;

			while ((i < copiaH.size()) && !(found)){
				if (copiaH.get(i).getType() == tk){
					found = true;
					newSpecificHidden.add(tk);
					copiaH.remove(i);
				}

				i++;
			}
		}

		speBadCon = new SpecificBadConsequence(this.text, this.levels, newSpecificVisible,newSpecificHidden);
		
		return speBadCon;
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
