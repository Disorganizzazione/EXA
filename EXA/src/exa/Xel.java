package exa;

public class Xel {
    
    //data
    boolean life;
    
    //coordinate
    int E;
    int X;
    int A;
    
    //legami
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
    
    public void es(){ //on-off
        if(life)
            life= false;
        else
            life= true;
    }
    public void kill(){ //off
        life= false;
    }

    public Xel link(int phase){ //tutti le diverse azioni necessarie alla creazione della rete
        switch(phase){
            
            //primo passo
            case 0:
                e= new Xel(this); e.z= this; e.E++; return e;
            
            //due legami
            case 1:
                d= new Xel(this); d.a= this; d.A--;
                d.z= x; x.e= d; return d;
            case 2:
                x= new Xel(this); x.w= this; x.X++;
                x.a= z; z.d= x; return x;
            case 3:
                z= new Xel(this); z.e= this; z.E--;
                z.w= a; a.x= z; return z;
            case 4: 
                a= new Xel(this); a.d= this; a.A++;
                a.e= w; w.z= a; return a;
            case 5:
                w= new Xel(this); w.x= this; w.X--;
                w.d= e; e.a= w; return w;           
            case 6:
                e= new Xel(this); e.z= this; e.E++;
                e.x= d; d.w= e; return e;
            
            //tre legami
            case 11:
                x= new Xel(this); x.w= this; x.X++;
                x.a= z; z.d= x;
                x.z= z.x; z.x.e= x; return x;
            case 12:
                z= new Xel(this); z.e= this; z.E--;
                z.w= a; a.x= z; 
                z.a= a.z; a.z.x= z; return z;
            case 13: 
                a= new Xel(this); a.d= this; a.A++;
                a.e= w; w.z= a; 
                a.w= w.a; w.a.z= a; return a;
            case 14:
                w= new Xel(this); w.x= this; w.X--;
                w.d= e; e.a= w; 
                w.e= e.w; e.w.a= w; return w;           
            case 15:
                e= new Xel(this); e.z= this; e.E++;
                e.x= d; d.w= e;
                e.d= d.e; d.e.w= e; return e;
            case 16:
                d= new Xel(this); d.a= this; d.A--;
                d.z= x; x.e= d; 
                d.x= x.d; x.d.e=d; return d;
            default: return null;
        }
    }
    public void redux(){ //riduce le cordinate alla forma minima
        int redx = 0;
        //trovo il valore medio tra le coordinate
        if(A<=X && A>=E || A<=E && A>=X)
            redx= A;
        else if(X<=E && X>=A || X<=A && X>=E)
            redx= X;
        else if(E<=A && E>=X || E<=X && E>=A)
            redx= E;
        //lo porto a zero
        while(redx!=0){
            if(redx>0)
                {A--;X--;E--;redx--;}
            else
                {A++;X++;E++;redx++;}
        }
    }
    public int distance(){ //distanza dall'origine
        return Math.abs(E) + Math.abs(X) + Math.abs(A);
    }
    public int distance(Xel to){ //numero minimo di celle tra questa e quella in input
        return Math.abs(E-to.E) + Math.abs(X-to.X) + Math.abs(A-to.A);
    }
}
