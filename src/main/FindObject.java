
package main;

import util.SerialGenerator;

public class FindObject implements Runnable{

    private int tid;
    private Codigo codigo;

    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
    
    @Override
    public void run() {
    
        String result = "";
        
        while(!result.equals(codigo.getGroup())){
            
            SerialGenerator sg = new SerialGenerator();
            result = sg.generateAlphaNumericSerial(1, codigo.getGroup().length(), true);
            
            //System.out.println("Resultado Thread "+tid+" - "+result);
            
        }
        
        System.out.println("\nThread "+tid+" concluida, index: "+codigo.getGroupIndex()+", caracteres: "+result);
    
    }
    
}
