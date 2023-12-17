

public class Ia extends Joueur{
    
    public Ia(String s,int n){
        super(s+String.valueOf(n),n);
    }

    public int[] tourIa(int[] t){
        int x,y;
        int[] resVar =new int[2];
        boolean stratGagnante = false;
        int[] tmp = new int[4];


        x = 0;
        y = 1;
        if(nbAllumette(t)!= 1 && nbAllumette(t)!=0){
            while(!stratGagnante && x<t.length){
                for(int i =0;i<t.length;i++){
                    tmp[i] = t[i];
                }
                while(!stratGagnante && y<=t.length){
                    for(int i =0;i<t.length;i++){
                        tmp[i] = t[i];
                    }
                    tmp[x] -= y;
                    stratGagnante=convBinairePair(tmp);
                    if(stratGagnante){
                        resVar[0]=x;
                        resVar[1]=y;
                    }
                    y++;
                }
                x++;
                y=1;
            }
       
        }else if(nbAllumette(t)==1){
            for(int i=0;i<4;i++){
                if(t[i]==1){
                    resVar[0] = i;
                    resVar[1] = 1;
                }
            }

        }
        return resVar;
    }

    public int nbAllumette(int[] t){
        int x = 0;
        for(int i=0;i<t.length;i++){
            x+=t[i];
        }
        return x;
    }

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
        for(int k=0;k<t2.length;k++){
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

