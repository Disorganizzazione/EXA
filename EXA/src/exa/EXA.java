package exa;
import java.util.*;

public class EXA {

    public static void main(String[] args) {
        Hex agon= new Hex(100);
        Xel io= agon.origin;
        Xel center= io;
        Scanner input= new Scanner(System.in);
        String line;
        char in;
        while(true){
            System.out.print(
                    "Location: "+io.s.getE()+" "+io.s.getX()+" "+io.s.getA()+" "+(io.getLife()==true?"[alive]":"[dead]")+
                    " Distance: "+io.s.diff(center.s).module()+
                    "\nInput: ");
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
                case '\0': agon.act(); break;
                case 'q': return;
                default: System.out.println("< w,e,d,x,z,a to move, s to switch, c to center, q to quit >");
            }
            System.out.println();
        }
    }
    
}
