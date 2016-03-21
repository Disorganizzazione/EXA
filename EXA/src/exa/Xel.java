package exa;

public class Xel {
    
    //data
    private boolean after;
    private boolean life;
    
    //coordinate
    final Exa s;
    
    //legami
    Xel w;
    Xel e;
    Xel d;
    Xel x;
    Xel z;
    Xel a;
    
    public Xel(){ //cella origin
        s= new Exa();
    }
    public Xel(Xel mother){ //cella clone
        s= new Exa(mother.s);
    }
    
    public void es(){ //on-off
        life = !life;
    }
    public void kill(){ //off
        life= false;
    }
    public void law(){ //propagazione semplice
        if(w.life || e.life || d.life || x.life || z.life || a.life)
            after= true;
    }
    public void time(){
        life= after;
        after= false;
    }
    public Xel link(int phase){ //tutti le diverse azioni necessarie alla creazione della rete
        switch(phase){
            
            //primo passo
            case 0:
                e= new Xel(); e.z= this; e.s.e(); return e;
            
            //due legami
            case 1:
                d= new Xel(this); d.a= this; d.s.d();
                d.z= x; x.e= d; return d;
            case 2:
                x= new Xel(this); x.w= this; x.s.x();
                x.a= z; z.d= x; return x;
            case 3:
                z= new Xel(this); z.e= this; z.s.z();
                z.w= a; a.x= z; return z;
            case 4: 
                a= new Xel(this); a.d= this; a.s.a();
                a.e= w; w.z= a; return a;
            case 5:
                w= new Xel(this); w.x= this; w.s.w();
                w.d= e; e.a= w; return w;           
            case 6:
                e= new Xel(this); e.z= this; e.s.e();
                e.x= d; d.w= e; return e;
            
            //tre legami
            case 11:
                x= new Xel(this); x.w= this; x.s.x();
                x.a= z; z.d= x;
                x.z= z.x; z.x.e= x; return x;
            case 12:
                z= new Xel(this); z.e= this; z.s.z();
                z.w= a; a.x= z; 
                z.a= a.z; a.z.d= z; return z;
            case 13: 
                a= new Xel(this); a.d= this; a.s.a();
                a.e= w; w.z= a; 
                a.w= w.a; w.a.x= a; return a;
            case 14:
                w= new Xel(this); w.x= this; w.s.w();
                w.d= e; e.a= w; 
                w.e= e.w; e.w.z= w; return w;           
            case 15:
                e= new Xel(this); e.z= this; e.s.e();
                e.x= d; d.w= e;
                e.d= d.e; d.e.a= e; return e;
            case 16:
                d= new Xel(this); d.a= this; d.s.d();
                d.z= x; x.e= d; 
                d.x= x.d; x.d.w=d; return d;
            default: return null;
        }
    }
    public Xel move(int phase){
        switch(phase){
            case 1: return d;
            case 2: return x;
            case 3: return z;
            case 4: return a;
            case 5: return w;           
            case 6: case 0: return e;
            default: return null;
        }
    }
    public Xel accessOrigin(){
        return access(s.inv());
    }
    public Xel access(int E, int X, int A){
        return access(Exa.vector(E,X,A).diff(s));
    }
    public Xel access(Exa vector){
        Xel temp= this;
        while(vector.getE()!=0)
            if(vector.getE()>0)
                {vector.z(); temp= temp.z;}
            else
                {vector.e(); temp= temp.e;}
        while(vector.getX()!=0)
            if(vector.getX()>0)
                {vector.w(); temp= temp.w;}
            else
                {vector.x(); temp= temp.x;}
        while(vector.getA()!=0)
            if(vector.getA()>0)
                {vector.d(); temp= temp.d;}
            else
                {vector.a(); temp= temp.a;}
        return temp;
    }
    public boolean getLife(){
        return life;
    }
    
}
