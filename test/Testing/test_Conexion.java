
package Testing;

import Conexion.ConectarBD;

public class test_Conexion {
    public static void main(String[] args) {
        //color_values_to_print_in_console
        String AlertOpen =(char)27 + "[31;43m";
        String AlertOpenAlt =(char)27 + "[31m";
        String vOp = (char)27 + "[36m";
        String vC = (char)27 + "[0m";
        
        ConectarBD conn = new ConectarBD();
        boolean CONNECTION_OK = conn.mensaje.equalsIgnoreCase("OK");
        
        //TEST DE CONEXION
        if (CONNECTION_OK){
            System.out.println("CONNECTION STATUS: "+vOp+conn.mensaje+vC);
            
        }else{
            System.out.println(AlertOpen+"[!!!]"+vC+ " CONNECTION STATUS:"+ AlertOpen+"ERROR"+vC);
            System.out.println("Revisa alguno de estos Parametros\n");
            System.out.println("********************************************"+
                    vOp+"\nDRIVER: "+vC+           ConectarBD.DRIVER+
                    vOp+"\nPORT: "+vC+             ConectarBD.PORT+
                    vOp+"\nDATABASE NAME: "+vC+    ConectarBD.DATABASE+
                    vOp+"\nPATH: "+vC+             ConectarBD.RUTA+
                    vOp+"\nUSER: "+vC+             ConectarBD.USUARIO+
                    vOp+"\nPASSWORD: "+vC+         ConectarBD.CLAVE+
                    vOp+"\n********************************************"
            );
        }
    }
 
}
