public class Aapning extends HvitRute{
	
	public Aapning(int rad, int kolonne){
		super(rad, kolonne);
	}

  	//Arver fra Hvit, trenger ikke char da dette er det samme tegnet '.'.

	@Override
	public void gaa(Rute gammelRute, String veienHit){
		System.out.println(veienHit + this.koordinater());
		labyrinten.leggTilUtveier(veienHit + this.koordinater());
	}

	
}