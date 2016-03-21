package exa;

public class Exa {
    
    private int E;
    private int X;
    private int A;
    
    public Exa(){
        E=0;
        X=0;
        A=0;
    }
    public Exa(Exa as){
        E= as.E;
        X= as.X;
        A= as.A;
    }
    public Exa(int E, int X, int A){
        this.E= E;
        this.X= X;
        this.A= A;
        redux();
    }

    static Exa vector(int E, int X, int A){
        return new Exa(E,X,A);
    }
    
    private void redux(){ //riduce le cordinate alla forma minima
        int redx = 0;
        //trovo la coordinata con valore intermedio
        if(E<=A && E>=X || E<=X && E>=A)
            redx= E;
        else if(X<=E && X>=A || X<=A && X>=E)
            redx= X;
        else if(A<=X && A>=E || A<=E && A>=X)
            redx= A;
        //la porto a zero
        E-= redx; X-= redx; A-= redx;
    }
    
    public int module(){
        return Math.abs(E)+ Math.abs(X)+ Math.abs(A);
    }
    public Exa add(Exa s){
        return new Exa(E+s.E, X+s.X, A+s.A);
    }
    public Exa inv(){
        return new Exa(-E,-X,-A);
    }
    public Exa diff(Exa s){
        return inv().add(s).inv();
    }
    public void w() {X--; redux();}
    public void e() {E++; redux();}
    public void d() {A--; redux();}
    public void x() {X++; redux();}
    public void z() {E--; redux();}
    public void a() {A++; redux();}
    public int getE() {return E;}
    public int getX() {return X;}
    public int getA() {return A;}
}
