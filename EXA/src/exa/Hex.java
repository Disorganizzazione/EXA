package exa;

public class Hex {
    Xel origin;
    int range;
    
    public Hex(int range){ //costruttore che crea nuove celle
        origin= new Xel();
        this.range= range;
        
        Xel temp= origin;
        for(int i=0; i<(range-1)*6; i++) //palesemente da rivedere
            temp= temp.link(i);
    }
    public Hex(Xel origin, int range){ //cella già esistente come centro
        this.origin= origin;
        this.range= range;
        //controlli sul range
    }

    public void test(){
        Xel temp= origin;
        for(int i= 0; i<range ;i++){
            System.out.println(temp.E+" "+temp.X+" "+temp.A);
            temp= temp.w;
        }
    }
}
