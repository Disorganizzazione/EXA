package exa;
import java.util.*;

public class EXA {

    public static void main(String[] args) {
        Hex agonal= new Hex(10);
        Xel io= agonal.origin;
        Xel center= io;
        Scanner input= new Scanner(System.in);
        String line;
        char in;
        while(true){
            System.out.print("Location: "+io.E+" "+io.X+" "+io.A+" "+(io.life==true?"[alive]":"[dead]")+" Distance: "+io.distance(center)+"\nInput: ");
            line= input.nextLine();
            in= line.equals("")?'\0':line.charAt(0);
            switch(in){
                case 'w': if(io.w!=null)io= io.w;else System.out.println("< Out of range >"); break;
                case 'e': if(io.e!=null)io= io.e;else System.out.println("< Out of range >"); break;
                case 'd': if(io.d!=null)io= io.d;else System.out.println("< Out of range >"); break;
                case 'x': if(io.x!=null)io= io.x;else System.out.println("< Out of range >"); break;
                case 'z': if(io.z!=null)io= io.z;else System.out.println("< Out of range >"); break;
                case 'a': if(io.a!=null)io= io.a;else System.out.println("< Out of range >"); break;
                case 's': io.es(); break;
                case 'c': center= io; break;
                case 'q': return;
                default: System.out.println("< w,e,d,x,z,a to move, c to center, q to quit >");
            }
            System.out.println();
            io.redux();
        }
    }
    
}
