
package servlets;

import Modelo.Proveedor;
import Services.ServiceProveedor;
import Services.WebService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "SvProveedor", urlPatterns = {"/SvProveedor"})
public class SvProveedor extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        WebService serviceProveedor = new ServiceProveedor();
        List<Proveedor> ListProveedores = serviceProveedor.FindAll();
        
        //Lo serializamos a Json
        final Gson gson = new Gson();
        String jsonProv = gson.toJson(ListProveedores);
        
        //respondemos con el Json
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonProv);
        out.flush();
        
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        // Leer el cuerpo de la solicitud
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        
        // Convertir JSON a objeto Java
        String jsonData = sb.toString();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
        
        
        //generamos un JSON para la respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JsonObject jsonResponse = new JsonObject();
        
        
        //Creamos un Objeto Servicio
        WebService serviceProveedor = new ServiceProveedor();
        
        // Dterminamos si el prooveedor con ruc ingresado ya existe
        String ruc = jsonObject.get("ruc").getAsString();
        boolean ExistProv = new ServiceProveedor().FindById(ruc);
        
        if(ExistProv){
            jsonResponse.addProperty("status","Error");
            jsonResponse.addProperty("message", "El proveedor con el ruc "+ruc+" ya existe");
            response.getWriter().write(jsonResponse.toString());
            
        }else{
            String nombre = jsonObject.get("nombre").getAsString();
            String pais = jsonObject.get("pais").getAsString();
            String telefono = jsonObject.get("telefono").getAsString();
            String correo = jsonObject.get("correo").getAsString();

            Proveedor prov = new Proveedor(ruc, nombre, pais, telefono, correo);

            // Enviar una respuesta

            jsonResponse.addProperty("status","OK");
            jsonResponse.addProperty("message", "Datos recibidos correctamente");
            jsonResponse.addProperty("ruc", ruc);
            jsonResponse.addProperty("nombre", nombre);
            jsonResponse.addProperty("pais", pais);
            jsonResponse.addProperty("telefono", telefono);
            jsonResponse.addProperty("correo", correo);
            response.getWriter().write(jsonResponse.toString());
            serviceProveedor.Insert(prov);   
        }
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    



    
    
}
