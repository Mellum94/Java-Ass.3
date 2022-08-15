abstract class Rute{
	protected int kolonne;
	protected int rad;
	protected Labyrint labyrinten;
	protected Rute naboNord;
	protected Rute naboSor;
	protected Rute naboVest;
	protected Rute naboOst;

	public Rute(int rad, int kolonne){
		this.kolonne = kolonne;
		this.rad = rad;		
	}

	public void setLabyrint(Labyrint setLabyrint){
		labyrinten = setLabyrint;
	}

	public String koordinater(){
		return "(" + kolonne + ", " + rad +")";
	}
	
	public void settNaboSor(Rute nabo[][]){
		int dimLabyrint = labyrinten.hentMatrise();
		if(rad +1 >= dimLabyrint-1){
			naboSor = nabo[kolonne][rad+1]; //Ett element opp i matrisen.
		}
	}
	public void settNaboNord(Rute nabo[][]){
		int dimLabyrint = labyrinten.hentMatrise();
		if(rad -1 >= 0){
			naboNord = nabo[kolonne][rad-1]; //Ett element ned i matrisen.	
		}
	}
	public void settNaboOst(Rute nabo[][]){
		int dimLabyrint = labyrinten.hentMatrise();
		if(kolonne +1 <= dimLabyrint -1){
			naboOst = nabo[kolonne+1][rad]; //Ett element til høyre i matrisen. 
		}
	}
	public void settNaboVest(Rute nabo[][]){
		int dimLabyrint = labyrinten.hentMatrise();
		if(kolonne -1 >= 0){
			naboVest = nabo[kolonne-1][rad]; //Ett element til venstr i matrisen.
		}
	}

	public abstract void gaa(Rute gammelRute, String veienHit);
	
	public abstract void finnUtvei();

	public abstract char tilTegn();	


}