
public class Plateau {
    int[] alu ={1,3,5,7};



    public void afficheTab(int[] t){
        int x = 0;
        for(int i=0;i<4;i++){
            System.out.print(x+" ");
            x++;
            for(int y=0;y<t[i];y++){
                System.out.print("| ");
            }
            System.out.println();
        }
    }
    public int nbAllumette(int[] t){
        int x = 0;
        for(int i=0;i<t.length;i++){
            x+=t[i];
        }
        return x;
    }
}
