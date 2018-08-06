package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("generic")
public class ComprasWS {

    @Context
    private UriInfo context;

    public ComprasWS() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
      
        Compras compra = new Compras("Sabão", 2 , Float.parseFloat("2"),"Rua C");
        
        Gson gson = new Gson();
        
        return gson.toJson(compra);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("compras/list")
    public String getAllCompras() {
    
        ConnectionFactory.createConnection();
        
        List<Compras> allcompra = ConnectionFactory.getAllCompras();
        
        System.out.println(allcompra);
        
        Gson gson = new Gson();
        
        return gson.toJson(allcompra);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("compras/compras_usuarios")
    public String getetAllCompras_Usuarios() {
    
        ConnectionFactory.createConnection();
        
        List<Compra_usuario> allcompra = ConnectionFactory.getAllCompras_Usuarios();
        
        System.out.println(allcompra);
        
        Gson gson = new Gson();
        
        return gson.toJson(allcompra);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("compra/{id}")
    public String getCompra(@PathParam("id") Integer id) {
    
        ConnectionFactory.createConnection();
        Compras compra = ConnectionFactory.getCompraBuyId(id);
        
        Gson gson = new Gson();
        
        return gson.toJson(compra);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login/{login}/{senha}")
    public String getStatus(@PathParam("login") String login,@PathParam("senha") String senha ) {
    
        ConnectionFactory.createConnection();
        Usuario user = ConnectionFactory.getLogin(login,senha);
        
        Gson gson = new Gson();
        
        return gson.toJson(user);
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
