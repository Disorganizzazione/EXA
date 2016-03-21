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
    
    public void act(){
        Xel temp= origin;
        temp.law();
        for(int r=0; r<range-1; r++){
            if(r>0){
                temp= temp.move(6);
                temp.law();
                for(int l=0; l<r-1; l++){
                    temp= temp.move(1);
                    temp.law();
                }
            }
            for(int v= 1; v<=4; v++){ 
                if(r==0 && v==1){
                    temp= temp.move(0);
                    temp.law();
                }
                else{
                    temp= temp.move(v);
                    temp.law();
                }
                for(int l=0; l<r; l++){
                    temp= temp.move(v+1);
                    temp.law();
                }
            }
            temp= temp.move(5);
            temp.law();
            for(int l=0; l<r+1; l++){
                temp= temp.move(6);
                temp.law();
            }
        }
        temp= origin;
        temp.time();
                for(int r=0; r<range-1; r++){
            if(r>0){
                temp= temp.move(6);
                temp.time();
                for(int l=0; l<r-1; l++){
                    temp= temp.move(1);
                    temp.time();
                }
            }
            for(int v= 1; v<=4; v++){ 
                if(r==0 && v==1){
                    temp= temp.move(0);
                    temp.time();
                }
                else{
                    temp= temp.move(v);
                    temp.time();
                }
                for(int l=0; l<r; l++){
                    temp= temp.move(v+1);
                    temp.time();
                }
            }
            temp= temp.move(5);
            temp.time();
            for(int l=0; l<r+1; l++){
                temp= temp.move(6);
                temp.time();
            }
        }
    }
    public void reset(){
        Xel temp= origin;
        temp.kill();
        for(int r=0; r<range-1; r++){
            if(r>0){
                temp= temp.move(6);
                temp.kill();
                for(int l=0; l<r-1; l++){
                    temp= temp.move(1);
                    temp.kill();
                }
            }
            for(int v= 1; v<=4; v++){ 
                if(r==0 && v==1){
                    temp= temp.move(0);
                    temp.kill();
                }
                else{
                    temp= temp.move(v);
                    temp.kill();
                }
                for(int l=0; l<r; l++){
                    temp= temp.move(v+1);
                    temp.kill();
                }
            }
            temp= temp.move(5);
            temp.kill();
            for(int l=0; l<r+1; l++){
                temp= temp.move(6);
                temp.kill();
            }
        }
    }
}
