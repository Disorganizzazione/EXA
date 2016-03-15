package exa;

public class Hex {
    Xel origin;
    int range;
    
    public Hex(int range){ //costruttore che crea nuove celle
        origin= new Xel();
        this.range= range;
        //...
    }
    public Hex(Xel origin, int range){ //cella già esistente come centro
        this.origin= origin;
        this.range= range;
        //controlli sul range
    }
}
