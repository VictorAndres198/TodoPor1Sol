
package servlets;

import Modelo.Empleado;
import Modelo.Item;
import Modelo.Pedido;
import Services.ServicePedidos;
import Services.ServiceProveedor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvPedidos", urlPatterns = {"/SvPedidos"})
public class SvPedidos extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    ServicePedidos servPedidos = new ServicePedidos();
    List<Pedido> listPedidos = servPedidos.FindAll();
    
    // Configurar Gson para serializar LocalDateTime
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            @Override
            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.format(formatter));
            }
        })
        .create();

    // Convertir la lista de pedidos a JSON
    String jsonPedidos = gson.toJson(listPedidos);
    
    // Responder con el JSON
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    out.print(jsonPedidos);
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
        
      // Dterminamos si el prooveedor con determinadoruc ya esta registrado para actualizar
        ServicePedidos servItems = new ServicePedidos();
        String id = jsonObject.get("id").getAsString();
        List<Item> items = servItems.FindById(Integer.parseInt(id));
        
        for(Item i:items){
            System.out.println(i);
        }
        
        //generamos un JSON para la respuesta
        String jsonItems = gson.toJson(items);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonItems);
        out.flush();
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
