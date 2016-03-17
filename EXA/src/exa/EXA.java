package exa;
import java.util.*;

public class EXA {

    public static void main(String[] args) {
        Hex agonal= new Hex(1);
        agonal.test();
        Xel io= agonal.origin;
        Scanner input= new Scanner(System.in);
        char in;
        while(true){
            System.out.print("Move: ");
            in= input.nextLine().charAt(0);
            switch(in){
                case 'w': io= io.w; break;
                case 'e': io= io.e; break;
                case 'd': io= io.d; break;
                case 'x': io= io.x; break;
                case 'z': io= io.z; break;
                case 'a': io= io.a; break;
                default: System.out.println("Press w,e,d,x,z,a");
            }
            System.out.println(io.E+" "+io.X+" "+io.A);
        }
    }
    
}
