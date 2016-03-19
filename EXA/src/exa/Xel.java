package exa;

public class Xel {
    
    //data
    boolean life;
    
    //coordinate
    Exa s;
    
    //legami
    Xel w;
    Xel e;
    Xel d;
    Xel x;
    Xel z;
    Xel a;
    
    public Xel(){ //cella origin
        life= false;
        s= new Exa();
    }
    public Xel(Xel mother){ //cella clone
        this.life= mother.life;
        s= new Exa(mother);
    }
    
    public void es(){ //on-off
        life = !life;
    }
    public void kill(){ //off
        life= false;
    }

    public Xel link(int phase){ //tutti le diverse azioni necessarie alla creazione della rete
        switch(phase){
            
            //primo passo
            case 0:
                e= new Xel(this); e.z= this; e.s.E++; return e;
            
            //due legami
            case 1:
                d= new Xel(this); d.a= this; d.s.A--;
                d.z= x; x.e= d; return d;
            case 2:
                x= new Xel(this); x.w= this; x.s.X++;
                x.a= z; z.d= x; return x;
            case 3:
                z= new Xel(this); z.e= this; z.s.E--;
                z.w= a; a.x= z; return z;
            case 4: 
                a= new Xel(this); a.d= this; a.s.A++;
                a.e= w; w.z= a; return a;
            case 5:
                w= new Xel(this); w.x= this; w.s.X--;
                w.d= e; e.a= w; return w;           
            case 6:
                e= new Xel(this); e.z= this; e.s.E++;
                e.x= d; d.w= e; return e;
            
            //tre legami
            case 11:
                x= new Xel(this); x.w= this; x.s.X++;
                x.a= z; z.d= x;
                x.z= z.x; z.x.e= x; return x;
            case 12:
                z= new Xel(this); z.e= this; z.s.E--;
                z.w= a; a.x= z; 
                z.a= a.z; a.z.d= z; return z;
            case 13: 
                a= new Xel(this); a.d= this; a.s.A++;
                a.e= w; w.z= a; 
                a.w= w.a; w.a.x= a; return a;
            case 14:
                w= new Xel(this); w.x= this; w.s.X--;
                w.d= e; e.a= w; 
                w.e= e.w; e.w.z= w; return w;           
            case 15:
                e= new Xel(this); e.z= this; e.s.E++;
                e.x= d; d.w= e;
                e.d= d.e; d.e.a= e; return e;
            case 16:
                d= new Xel(this); d.a= this; d.s.A--;
                d.z= x; x.e= d; 
                d.x= x.d; x.d.w=d; return d;
            default: return null;
        }
    }

}
