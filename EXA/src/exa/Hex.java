package exa;

public class Hex {
    Xel origin;
    int range;
    
    public Hex(int range){ //costruttore che crea nuove celle
        origin= new Xel();
        this.range= range;
        
        Xel temp= origin;
        for(int r=0; r<range; r++){ //come facciamo il bordo?
            
            //primo (small)
            if(r>0){
                temp= temp.link(6); 
            for(int l=0; l<r-1; l++)
                temp= temp.link(16);
            }
            
            //quattro spicchi
            for(int v= 1; v<=4; v++){ 
                if(r==0 && v==1)
                    temp= temp.link(0);
                else
                    temp= temp.link(v);
                for(int l=0; l<r; l++)
                    temp= temp.link(10+v);
            }
            //ultimo (big)
            temp= temp.link(5); 
            for(int l=0; l<r+1; l++)
                temp= temp.link(15);
        }
    }
    public Hex(Xel origin, int range){ //cella già esistente come centro
        this.origin= origin;
        this.range= range;
        //controlli sul range...
    }
}
