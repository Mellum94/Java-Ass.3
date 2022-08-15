import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Labyrint{
	public Rute rutenett[][];
	private Liste<String> utveier = new Lenkeliste<String>();
	private static int matrise;


	private Labyrint(Rute rutenett[][], int matrise){
		//Konstruktoor
		this.rutenett = rutenett;
		this.matrise = matrise; //Dimensjon paa rader og kolonner er den samme -kvadratisk. Trenger bare én som du kan kalle matrise.
	}


	public static void lesFraFil(File fil) throws FileNotFoundException {
		Scanner scan = new Scanner(fil);
		String [] tall = scan.nextLine().split(" ");
		int antRader = Integer.parseInt(tall[0]);
		int antKolonner = Integer.parseInt(tall[1]);

		Rute rutenett[][] = new Rute[antKolonner][antRader];
		//Labyrint labyrint = new Labyrint(antKolonner, antRader);
	

			for(int rad = 0; rad < antRader; rad++){
				String tegn = scan.nextLine();
				System.out.println(tegn);
				char[] charArray = tegn.toCharArray();
				

				for(int kolonne = 0; kolonne < antKolonner; kolonne++){
					char tegnet = charArray[kolonne];
					if(tegnet == '.'){
						if(kolonne == 0 || rad == 0 || kolonne == (antKolonner -1) || rad == (antRader-1)){
							Aapning aapningen = new Aapning(kolonne, rad);
							rutenett[kolonne][rad] = aapningen;
						}
						else{
						HvitRute hvit = new HvitRute(kolonne, rad);
						rutenett[kolonne][rad] = hvit;
						}
					}

					if(tegnet == '#'){
						SortRute sort = new SortRute(kolonne,rad);
						rutenett[kolonne][rad] = sort;
					}
				}
			}

			Labyrint labyrint = new Labyrint(rutenett, matrise);
			for(int rad = 0; rad < matrise; rad++){
				for(int kolonne = 0; kolonne < matrise; kolonne++){
					rutenett[kolonne][rad].setLabyrint(labyrint);
					rutenett[kolonne][rad].settNaboSor(rutenett);
					rutenett[kolonne][rad].settNaboNord(rutenett);
					rutenett[kolonne][rad].settNaboOst(rutenett);
					rutenett[kolonne][rad].settNaboVest(rutenett);
				}
			}
			//Finner utvei
			labyrint.rutenett[2][3].finnUtvei();
	}
//--------------------------------------------- Metoder til Labyrint ---------------------------
	

	public void leggTilUtveier(String utveien){
		utveier.leggTil(utveien);
	}

	public Liste<String> finnUtveiFra(int kolonne, int rad){
		if(rutenett[kolonne][rad] instanceof SortRute){
			System.out.println("Sort rute, ingen utvei");
			return null;
		}
		rutenett[kolonne][rad].finnUtvei();
		return utveier;
	}

	public void skrivLabyrint(){
		for(int rad = 0; rad < matrise; rad++){
			for(int kol = 0; kol < matrise; kol++){
				System.out.print(rutenett[kol][rad].tilTegn());
			}
			System.out.println();
		}
	}
	//Eventuelt lage en toString() fremfor skrivLabyrint()

	@Override
	public String toString(){
		this.matrise = matrise
		String utskrift = "";
		for(int rad = 0; rad < matrise; rad++){
			for(int kol = 0; kol < matrise; kol++){
				System.out.print(rutenett[kol][rad].tilTegn());
			}
			System.out.println();
		}
	}
	@Override
	public String toString(){
		return null;

	}

	public int hentMatrise(){
		return this.matrise;  //Samme matrise på kolonne og rad -kvadratisk.
	}
	





//--------------------------------------- Main -------------------------------------------------


	public static void main(String[] args) {
		try{
			lesFraFil(new File("test.txt"));			

			
			
		}
		catch(FileNotFoundException e){
			System.out.println("u fck up");
		}
		

	}
}