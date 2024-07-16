
package Conexion;

public interface Parametros {
    String DRIVER="com.mysql.cj.jdbc.Driver";
    String PORT = "3306";
    String DATABASE = "bdbotica";
    String RUTA="jdbc:mysql://localhost:"+PORT+"/"+DATABASE ;
    String USUARIO="root";
    String CLAVE="123123";
 
    
    /*
    nuevas credenciales para la bd
    *********************************
    String USUARIO="userbdbotica";
    String CLAVE="TodoPor1Sol";
    
    En MySQl Workbench
    ----------------------------
    CREATE USER 'userbdbotica'@'localhost' IDENTIFIED BY 'TodoPor1Sol';
    GRANT ALTER, CREATE, DELETE, DROP, INDEX, INSERT, REFERENCES, SELECT, UPDATE ON bdbotica.* TO 'userbdbotica'@'localhost';
    FLUSH PRIVILEGES;
    
    En MyphpAdmin
    ----------------------------
    Crear el usuario por la interfaz grafica
    */
}
