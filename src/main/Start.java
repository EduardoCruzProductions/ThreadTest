
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    
    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);

        System.out.println("Informe um grupo de caracteres");
        String caracteres = e.nextLine();

        System.out.println("Número de threads");
        int nThread = e.nextInt();

        int interv = caracteres.length() / nThread;
        List<Codigo> codigos = new ArrayList<>();
        int indexCount = 0;
        
        for (int i = 0; i < caracteres.length(); i += interv) {

            Codigo c = new Codigo();
            c.setGroupIndex(indexCount);

            if (i + interv > caracteres.length()) {

                c.setGroup(caracteres.substring(i, caracteres.length()));
                
            } else {
                
                c.setGroup(caracteres.substring(i, i + interv));
                
            }

            codigos.add(c);
            indexCount++;

        }
        
        System.out.println("");
        //criando threads
        
        int threadCount = 0;
        for(Codigo c : codigos){
            
            System.out.println("Criando Thread "+threadCount);
            
            FindObject fo = new FindObject();
            fo.setCodigo(c);
            fo.setTid(threadCount);
            
            Thread t = new Thread(fo);
            t.start();
            
            threadCount++;
            
        }

    }
    
}
