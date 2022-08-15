public class SortRute extends Rute{
	
	public SortRute(int rad, int kolonne){
		super(rad, kolonne);
	}

    @Override
	public char tilTegn(){
		char tegnet = '#';
		return tegnet;
		}

	public void gaa(Rute kilde, String veienHit){
		return; //Blindvei
	}


	public void finnUtvei(){
		System.out.println("Sorry Sam, dette er en no go");
	}

}