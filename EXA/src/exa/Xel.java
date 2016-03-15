package exa;

/**
 *
 * @author claudio
 */

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
    
    
    public Xel(){
        life= false;
        E=0;
        X=0;
        A=0;
    }
    public Xel(Xel w, Xel e, Xel d, Xel x, Xel z, Xel a){
        life= false;
        this.w= w;
        this.e= e;
        this.d= d;
        this.x= x;
        this.z= z;
        this.a= a;
    }
    
    public void is(){
        if(life)
            life= false;
        else
            life= true;
    }
}
