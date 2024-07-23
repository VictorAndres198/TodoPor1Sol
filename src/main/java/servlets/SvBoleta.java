
package servlets;

import Modelo.Categoria;
import Modelo.ClientePersona;
import Modelo.Comprobante;
import Modelo.Empleado;
import Modelo.Item;
import Modelo.Pedido;
import Modelo.Producto;
import Services.ServiceBoleta;
import Services.ServicePedidos;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvBoleta", urlPatterns = {"/SvBoleta"})
public class SvBoleta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");      
        
        //instanciamos el servicio para ejecutar acciones de consulta
        ServiceBoleta serviceBoleta = new ServiceBoleta();
        //instaciones un objeto para manejar datos JSON
        Gson gson = new Gson();
        String jsonData;
        
        //obtenemos todos los nombres de los parametros en la peticion GET
        Enumeration<String> params = request.getParameterNames();
        
        //guardamos todos estos nombres en un conjunto
        Set<String> requestParams = new HashSet<>();
        while (params.hasMoreElements()) {
            String value= params.nextElement();
            System.out.println(value);
            requestParams.add(value);
        }
        
        //Ejecutamos acciones segun que parametro viaja en la peticion
        //si es un parametro ?idCliente=AlgunValor
        if (requestParams.contains("idCliente")) {
            
            String id = request.getParameter("idCliente");
            ClientePersona cli = serviceBoleta.FindCliPersonaById(id);
            if (cli==null) { //si no se encuentra al cliente
                JsonObject jsonResponse = new JsonObject();
                jsonResponse.addProperty("status","Error");
                jsonResponse.addProperty("message", "No se ha encontrado cliente con id: "+id);
                response.getWriter().write(jsonResponse.toString());
            } else { //si se encuentra lo mandamos en formato JSON
                jsonData = gson.toJson(cli);
                PrintWriter out = response.getWriter();
                out.print(jsonData);
                out.flush();
            }
            
        //si es un parametro ?categoriae=idCategoria
        // buscamos todos los productos dentro de esa categoria
        } else if(requestParams.contains("categoria")){
            System.out.println("Buscar productos de una categoria");
            
            String id = request.getParameter("categoria");
            List<Producto> listProductos = serviceBoleta.FindProducts(Integer.parseInt(id));
            jsonData= gson.toJson(listProductos);
            response.getWriter().print(jsonData); 
            
        //si es un parametro ?producto=idProducto
        // buscamos la descripcion y precio unitario de ese producto
        } else if(requestParams.contains("producto")){
            System.out.println("Buscar descripcion y precio de un producto");
        
            String id = request.getParameter("producto");
            Producto product = serviceBoleta.FindProductInfo(Integer.parseInt(id));
            jsonData= gson.toJson(product);
            response.getWriter().print(jsonData); 
            
        //si no hay ningun parametro en la peticion buscamos todas las categorias
        }else if(requestParams.contains("numBoleta")){
            System.out.println("Buscando el ultimo num de Boleta posible");
            String numBoleta = serviceBoleta.CalcIdComprobante();
            jsonData= gson.toJson(numBoleta);
            response.getWriter().print(jsonData); 
        
        }else{
            List<Categoria> listCategorias = serviceBoleta.FindCategorias();
            jsonData= gson.toJson(listCategorias);
            response.getWriter().print(jsonData); 
            
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");     
        
        //instanciamos el servicios necesarios para crear la boleta
        ServiceBoleta serviceBoleta = new ServiceBoleta();
        ServicePedidos servicePedido = new ServicePedidos();
        
        //instaciones un objeto para manejar datos JSON
        Gson gson = new Gson();
        
        // Leer el cuerpo de la solicitud
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        
        String jsonData = sb.toString();
        
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("status","OK");
        jsonResponse.addProperty("message", "INFO RECIBIDA");
        response.getWriter().write(jsonResponse.toString());
        
        System.out.println("Contenido:\n"+jsonData);
        
        // Convertir JSON a objeto Java
        JsonObject JsonBody = gson.fromJson(jsonData, JsonObject.class);
        
        
        //CONSTRUYENDO LOS ITEMS
        List<JsonElement> itemsJson = JsonBody.get("pedido")
                                      .getAsJsonObject()
                                      .get("items").getAsJsonArray().asList();
        List<Item> items = new ArrayList<>();
        for(JsonElement e:itemsJson){
            JsonObject itemJson = e.getAsJsonObject();
            
            int idProducto = itemJson.get("id").getAsInt();
            int cant = itemJson.get("cantidad").getAsInt();
            BigDecimal subtotal = itemJson.get("subtotal").getAsBigDecimal();
            
            items.add(new Item(new Producto(idProducto), cant, subtotal));
        }
 
        
        //FEECHA_ACTUAL
        LocalDateTime  hoy = LocalDateTime.now();
        
        //CONSTRUYENDO EL PEDIDO
        JsonObject  pedidoJson= JsonBody.get("pedido").getAsJsonObject();
        BigDecimal  precioTotal= pedidoJson.get("precioTotal").getAsBigDecimal();
        BigDecimal  igv= pedidoJson.get("igv").getAsBigDecimal();
        BigDecimal  precioFinal= pedidoJson.get("precioFinal").getAsBigDecimal();
        Pedido pedido = new Pedido(hoy, precioTotal, igv, precioFinal, items);
        
        //CONSTRUYENDO COMPROBANTE
        ClientePersona cli= new ClientePersona(JsonBody.get("cliente")
                                               .getAsJsonObject()
                                               .get("id").getAsString());
        
        Empleado emp = new Empleado(JsonBody.get("empleado").getAsString());
        int tipoCompbante = JsonBody.get("tipoComprobante").getAsInt();
        
        //CONSTRUYENDO EL CODIGO DE BOLETA DEL COMPROBANTE
        String lastIdComp = serviceBoleta.CalcIdComprobante();
        String Header = lastIdComp.split("-[0]*")[0];
        char[] Body = lastIdComp.split("-")[1].toCharArray();
        
        String oldNumSec = lastIdComp.split("-[0]*")[1];
        int newNumSec = Integer.parseInt(oldNumSec)+1;
       
        if(oldNumSec.length()<String.valueOf(newNumSec).length()){
            /*
            si la longitud del numSecuencia antiguo es menor al numSecuencianuevo
            entonces el numero aumentó en una cifra
            por consiguiente la cadena de 0's disminuye en 1
            para conservarse en 7 cifras*/
            Body=lastIdComp.split("-0")[1].toCharArray(); //quitamos el 0 al inicio del body
        }

        String idComprobante = Header+"-";
        for(char c:Body){
            if(c=='0'){
               idComprobante+="0";
            }else{
                idComprobante+=String.valueOf(newNumSec);
                break;
            }
        }
        Comprobante comp = new Comprobante(idComprobante, hoy, pedido, cli, emp, tipoCompbante);
        System.out.println(comp);
        
        //GUARDANDO DATOS EN LA BD
        //1°->PEDIDO
        long idPedido = servicePedido.InsertPedido(pedido);
        pedido.setId((int)idPedido);
        
        //2°->ITEMS DEL PEDIDO
        for(Item i: pedido.getItems()){
            servicePedido.InsertItem(i, idPedido);
        }
        
        //3°->COMPROBANTE
        serviceBoleta.InsertBoleta(comp);
        
        //Se puede corroborar en la BD o en la pagina Gestionar Pedidos de Admin
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
