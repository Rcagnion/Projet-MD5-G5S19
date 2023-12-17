
import java.util.Scanner;
public class Joueur {
	private String nom;
	private int num;
	
	public Joueur(String s,int n){
		this.nom=s;
		this.num=n;
	}
	
	public Joueur(int n){
		Scanner s=new Scanner(System.in);
		this.nom=s.nextLine();
		this.num=n;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public int getNum(){
		return this.num;
	}
}
