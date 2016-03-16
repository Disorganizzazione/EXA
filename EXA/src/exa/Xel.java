package exa;

public class Xel {
    boolean life;
    int E;
    int X;
    int A;
    
    Xel w;
    Xel e;
    Xel d;
    Xel x;
    Xel z;
    Xel a;
    
    public Xel(){ //cella origin
        life= false;
        E=0;
        X=0;
        A=0;
    }
    public Xel(Xel mother){ //cella clone
        this.life= mother.life;
        this.E= mother.E;
        this.X= mother.X;
        this.A= mother.A;
    }
    
    public void is(){
        if(life)
            life= false;
        else
            life= true;
    }
    public void kill(){
        life= false;
    }

    public Xel link(int axe){
        switch(axe){
            case 0:
                w= new Xel(this); w.x= this; w.X--; w.redux(); return w; //primo passo
            case 4: 
                a= new Xel(this); a.d= this; a.A++; a.redux(); //collegamento principale
                a.e= w; w.z= a; return a; //collegamento secondario(magico)
            case 2:
                x= new Xel(this); x.w= this; x.X++; x.redux(); //collegamento principale
                x.a= z; z.d= x; return x; //collegamento secondario(magico)
            case -1:
                e= new Xel(this); e.z= this; e.E++; e.redux(); //collegamento principale
                e.x= d; d.w= e; return e; //collegamento secondario(magico)            
            case 1:
                d= new Xel(this); d.a= this; d.A--; d.redux(); //collegamento principale
                d.z= x; x.e= d; return d; //collegamento secondario(magico)
            case -2:
                w= new Xel(this); w.x= this; w.X--; w.redux(); //collegamento principale
                w.d= e; e.a= w; return w;//collegamento secondario(magico)            
            case 3:
                z= new Xel(this); z.e= this; z.E--; z.redux(); //collegamento principale
                z.w= a; a.x= z; return z; //collegamento secondario(magico)
            case 5:
                w= new Xel(this); w.x= this; w.X--; w.redux(); //collegamento principale
                w.d= e; e.a= w; //collegamento secondario(magico)   
                w.e= e.w; e.w.z= w; return w;
            default: System.out.println("Nope"); return null;
        }
    }
    public void redux(){
        int redx = 0;
        if(A<=X && A>=E || A<=E && A>=X)
            redx= A;
        else if(X<=E && X>=A || X<=A && X>=E)
            redx= X;
        else if(E<=A && E>=X || E<=X && E>=A)
            redx= E;
        while(redx!=0){
            if(redx>0){
                A--;X--;E--;redx--;
            }
            else{
                A++;X++;E++;redx++;
            }
        }
    }
}
