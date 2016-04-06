
public class coordonnee {
	private int ord;
	private int abs;
	
	public coordonnee(int x, int y){
		abs=x;
		ord=y;
	}
	
	public int getAbs(){
		return this.abs;
	}
	
	public int getOrd(){
		return this.ord;
	}
	
	public void setAbs(int x){
		abs=x;
	}
	
	public void setOrd(int y){
		ord=y;
	}
}
