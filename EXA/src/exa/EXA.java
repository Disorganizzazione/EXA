package exa;
import java.util.*;

public class EXA {

    public static void main(String[] args) {
        Hex agonal= new Hex(2);
        Xel io= agonal.origin;
        Scanner input= new Scanner(System.in);
        char in;
        while(true){
            System.out.print("Location: "+io.E+" "+io.X+" "+io.A+"\nMove: ");
            in= input.nextLine().charAt(0);
            switch(in){
                case 'w': if(io.w!=null)io= io.w;else System.out.println("Out of range"); break;
                case 'e': if(io.e!=null)io= io.e;else System.out.println("Out of range"); break;
                case 'd': if(io.d!=null)io= io.d;else System.out.println("Out of range"); break;
                case 'x': if(io.x!=null)io= io.x;else System.out.println("Out of range"); break;
                case 'z': if(io.z!=null)io= io.z;else System.out.println("Out of range"); break;
                case 'a': if(io.a!=null)io= io.a;else System.out.println("Out of range"); break;
                case 's': return;
                default: System.out.println("Press w,e,d,x,z,a");
            }
        }
    }
    
}
