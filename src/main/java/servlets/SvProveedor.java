
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
        
        // Procesar los datos recibidos
        String Ruc = jsonObject.get("RUC").getAsString();
        String Nombre = jsonObject.get("Nombre").getAsString();
        String Pais = jsonObject.get("Pais").getAsString();
        String Telefono = jsonObject.get("Telefono").getAsString();
        String Correo = jsonObject.get("Correo").getAsString();
        
        Proveedor prov = new Proveedor(Ruc, Nombre, Pais, Telefono, Correo);
        
        // Enviar una respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("message", "Datos recibidos correctamente");
        jsonResponse.addProperty("RUC", Ruc);
        jsonResponse.addProperty("Nombre", Nombre);
        jsonResponse.addProperty("Pais", Pais);
        jsonResponse.addProperty("Telefono", Telefono);
        jsonResponse.addProperty("Correo", Correo);
        response.getWriter().write(jsonResponse.toString());
        
        WebService serviceProveedor = new ServiceProveedor();
        serviceProveedor.Insert(prov);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    



    
    
}
