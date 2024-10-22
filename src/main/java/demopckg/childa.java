package demopckg;

public class childa extends parenta {
	String global = "I am Child";
	
	public void jj() {
		System.out.println(super.global);

	}
	
	public static void main(String[] args) {
		childa ch = new childa(); 
		ch.jj();
	}
}
