package exa;

public class Exa {
    
    int E;
    int X;
    int A;
    
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
    public Exa(Xel mother){
        E= mother.s.E;
        X= mother.s.X;
        A= mother.s.A;
    }
    
    public void redux(){ //riduce le cordinate alla forma minima
        int redx = 0;
        //trovo la coordinata con valore intermedio
        if(E<=A && E>=X || E<=X && E>=A)
            redx= E;
        else if(X<=E && X>=A || X<=A && X>=E)
            redx= X;
        else if(A<=X && A>=E || A<=E && A>=X)
            redx= A;
        //la porto a zero
        while(redx!=0){
            if(redx>0)
                {E--;X--;A--;redx--;}
            else
                {E++;X++;A++;redx++;}
        }
    }
    public int distance(){ //distanza dall'origine
        return Math.abs(E) + Math.abs(X) + Math.abs(A);
    }
    public int distance(Xel to){ //numero minimo di celle tra questa e quella in input
        return Math.abs(E-to.s.E) + Math.abs(X-to.s.X) + Math.abs(A-to.s.A);
    }
    public void access(int E, int X, int A){
        //da discutere
    }
}
