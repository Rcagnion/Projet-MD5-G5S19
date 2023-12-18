//ID G5S19
import java.util.*;
public class Main {
	
Scanner sc=new Scanner(System.in);
	
	//Gère le paramétrage du jeu
	public void parametrage() throws Exception {
		
		System.out.println("Bonjour! Désirez vous jouer (1) ou voir les regles (2) ?)");
		String input=sc.next();
		while(!input.equals("1") && !input.equals("2")) {
			System.out.println("Entrée non reconnue, réessayez");
			input=sc.next();
		}
		String t = input;
		
		System.out.println("Désirez vous jouer en premier(y/n) ?)");
		String input1=sc.next();
		while(!input1.equals("y") && !input1.equals("n")) {
			System.out.println("Entrée non reconnue, réessayez");
			input1=sc.next();
		}
		String s = input1;
		if(t =="2"){
			
				System.out.println("Chacun leurs tours, les joueurs prennent entre autant d’allumettes qu’ils veulent dans la pyramide\n"
			+"mais il ne peuvent prendre que des allumettes se trouvant sur la même ligne.\n"
			+"Pour gagner, il faut prendre la dernière allumette.");
			System.out.println();
			if (s == "y") {
				Marienbad jeu=new Marienbad();
		    	jeu.partieNormaleJdeb();
			}else{
				Marienbad jeu=new Marienbad();
		    	jeu.partieNormaleJdeb();
			}
		}else{
			if (s == "n") {
				Marienbad jeu=new Marienbad();
		    	jeu.partieNormaleIAdeb();
			}else{
				Marienbad jeu=new Marienbad();
		    	jeu.partieNormaleIAdeb();
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Main a1=new Main();
		a1.parametrage();
		
	}
}

