

import java.util.Scanner;

public class Marienbad {
    private Plateau plateau;
	private Joueur[] joueurs;
	private Scanner sc;
    static int nba;

    //constructeur
    public Marienbad(){
		sc=new Scanner(System.in);
		plateau=new Plateau();
        joueurs =new Joueur[2];
        nba = 16;
		System.out.println("Quel est le nom du joueur ?");
        String nom=sc.next();
        joueurs[0]=new Joueur(nom, 0);
        joueurs[1]=new Ia("Ia",1);
        
	} 

    public void tourDeJeu(Joueur j,int nbal) {
        //On affiche le plateau
        this.plateau.afficheTab(plateau.alu);
        boolean b=false;
        // Tour de l'ia
            if(j instanceof Ia){
                int x,y;
                int[] resVar =new int[2];
                boolean stratGagnante = false;
                int[] tmp = new int[4];
                 x = 0;
                 y = 1;
                
                while((!stratGagnante && x<plateau.alu.length)){
                    for(int i =0;i<plateau.alu.length;i++){
                        tmp[i] = plateau.alu[i];
                    }
                    while((!stratGagnante && y<=plateau.alu[x])){
                        for(int i =0;i<plateau.alu.length;i++){
                            tmp[i] = plateau.alu[i];
                        }
                        tmp[x] -= y;
                        stratGagnante=convBinairePair(tmp);
                        if(stratGagnante==true){
                            resVar[0]=x;
                            resVar[1] =y;
                        }
                        y++;
                    }
                    x++;
                    y=1;
            }
            if (resVar[1] == 0){
            resVar[1]=1;
            for (int i=0; x<plateau.alu.length;i++){
                if (plateau.alu[i]!=0){
                    resVar[0]=i;
                }
            }
        }
                retirerAlu(resVar[0], resVar[1]);
                nbal = nbal-resVar[1];
                if(nbal != 0){
                    tourDeJeu(joueurs[0],nbal);
                }else{
                    System.out.println("L'ia gagne la partie");
                     System.exit(0);
                }
        

        }else{
            //tour du joueur
            while(b!=true){
                int input;
                System.out.println(j.getNom());
                System.out.println("Que voulez vous faire?\n"
                + "1: selectionner un nombre d'allumette | 2: Quitter le jeu");
                String rawInput=sc.next(); 
                if(rawInput.length()!=1 || !Character.isDigit(rawInput.charAt(0))) input=-1;
                else input=Integer.parseInt(rawInput);
            
                switch(input) {
                    case 1:
                        System.out.println("Entrer un numero de ligne:");
                        int x=sc.nextInt();
                        System.out.println("Entrer un nombre d'allumette:");
                        int y=sc.nextInt();
                        
                        if(!verifAlu(x,y)){
                            System.out.println("Erreur nombre rentré incorrect");
                            break;
                        }else{
                            retirerAlu(x,y);
                            nbal = nbal-y;
                            if(nbal != 0){
                                    tourDeJeu(joueurs[1],nbal);
                            }else{
                                System.out.println("Le joueur gagne la partie");
                                
                             }
                            break;
                    }
                case 2:
                    System.exit(0);
                default: System.out.println("Le numéro rentré est incorrect");
                }
            }
        }
    
    }

    //lance la partie avec le joueur qui joue en premier
    public void partieNormaleJdeb() {
            while(nba != 0) {
                 this.tourDeJeu(joueurs[1],plateau.nbAllumette(plateau.alu));
            //A la fin du tour, on passe au joueur suivant :)
            
             }
        }
        //lance la partie avec l'ia qui joue en premier
                public void partieNormaleIAdeb() {
            while(nba != 0) {
                 this.tourDeJeu(joueurs[0],plateau.nbAllumette(plateau.alu));
            }
        }
    
        //verifie si n peut retirer b allumettes sur la ligne a
    public boolean verifAlu(int a, int b){
        if(a>3){
            return false;
        }
        int cpt=plateau.alu[a];
        if(cpt<b || a>3){
            return false;
        }else{
            return true;
        }
    }

    public void retirerAlu(int x,int y){
        plateau.alu[x] -= y;
    }

    
    //crée un tableau de binaire a partir de t et verifie si on est dans une position gagnante
    public boolean convBinairePair(int[] t){
        int[] b = new int[t.length];
        for(int i=0;i<t.length;i++){
            b[i] = Integer.valueOf(Integer.toBinaryString(t[i]));
        }

        int[] t2 = new int[3];
        //premiere colonne
        t2[0]= (b[2]/100)+(b[3]/100);

        //deuxieme colonne
        int x=b[1]/10;
        for (int i=2; i<b.length; i++){
            int tmp=b[i]/10;
            if (tmp>=10){
                tmp -= 10;
            }
            x += tmp;
        }
        t2[1]=x;

        //troisieme colonne
        int y=0;
        for(int k=0;k<b.length;k++){
            y += b[k]%2;
        }
        t2[2]=y;

        int cpt = 0;
        for(int k=0;k<t2.length;k++){
            if(t2[k]%2==0){
                cpt++;
            }
        }
        if(cpt==3){
            return true;
        }else{
            return false;
        }
    }
}
