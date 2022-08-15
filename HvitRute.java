public class HvitRute extends Rute{
	

	public HvitRute(int rad, int kolonne){
		super(rad, kolonne);
	}

	@Override
	public char tilTegn(){
		char tegnet = '.';
		return tegnet;

	}

	public void gaa(Rute gammelRute, String veienHit){
		

		veienHit += this.koordinater() + " --> ";
		if(naboNord != null && naboNord !=gammelRute){
			naboNord.gaa(this, veienHit);
		}
		if(naboSor != null && naboSor != gammelRute){
			naboSor.gaa(this, veienHit);
		}
		if(naboOst != null && naboOst != gammelRute){
			naboOst.gaa(this, veienHit);
		}
		if(naboVest != null && naboVest != gammelRute){
			naboVest.gaa(this, veienHit);
		}

	}

	public void finnUtvei(){
		gaa(null, "");
	}
}
