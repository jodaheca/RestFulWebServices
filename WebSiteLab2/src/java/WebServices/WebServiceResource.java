/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import DTO.FeedObjects;
import DTO.FeedWS;
import DTO.Respuesta;
import MODEL.ProjectManager;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Joaquin David
 */
@Path("WebService")
public class WebServiceResource {

    @Context
    private UriInfo context;

    @GET
    @Path("/GetFeeds")
    @Produces(MediaType.APPLICATION_JSON)
    public String feed() {
        System.out.println("Entro al servicio");
        String feeds = "";
        try {
            ArrayList<FeedObjects> feedData = new ArrayList<>();
            ProjectManager proyectManager = new ProjectManager();
            feedData = proyectManager.GetFeeds();
            System.out.println("Paso");
            Gson gson = new Gson();
            System.out.println(gson.toJson(feedData));
            feeds = (gson.toJson(feedData));
        } catch (Exception e) {
            System.out.println("Exception Error");
        }
        return feeds;

    }

    @PUT
    @Path("/SetFeeds")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response InsertarPagina(@HeaderParam("title") String title,
            @HeaderParam("description") String description,
            @HeaderParam("url") String url) throws Exception {
        
        Respuesta respuesta = new Respuesta();
        ProjectManager managerPagina = new ProjectManager();
        String representacionJSON = "";
        FeedObjects pg = new FeedObjects();
        
        if ("".equals(title) || "".equals(description) || "".equals(url) || title == null 
                || description == null || url == null) {
            respuesta.setTipo(Respuesta.FALTA_CAMPOS);
            respuesta.setMensaje("Ingrese todos los campos de la petición");
            return Response.status(Response.Status.BAD_REQUEST)
                           .type(MediaType.APPLICATION_JSON)
                           .entity(respuesta)
                           .build();
        }
        pg.setTitle(title);
        pg.setDescription(description);
        pg.setUrl(url);
        try {
            int result = managerPagina.setFeeds(pg);
            if (result == 1) {
                final Gson gson = new Gson();
                representacionJSON = gson.toJson(pg);
            }
        } catch (Exception e) {
            respuesta.setTipo(Respuesta.ERROR);
            respuesta.setMensaje("Ocurrio un error registrando la pagina, Intente luego");
            return Response.status(Response.Status.CONFLICT)
                           .type(MediaType.APPLICATION_JSON)
                           .entity(respuesta)
                           .build();
        }
        respuesta.setTipo(Respuesta.CREADO);
            respuesta.setMensaje("La pagina se registro exitosamente");
            return Response.status(Response.Status.CREATED)
                           .type(MediaType.APPLICATION_JSON)
                           .entity(respuesta)
                           .build();
    }
    
//    @PUT
//    @Path("/SetFeeds")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response InsertarPagina(FeedWS pagina) {
//        
//        Respuesta respuesta = new Respuesta();
//        ProjectManager managerPagina = new ProjectManager();
//        String representacionJSON = "";
//        FeedObjects pg = new FeedObjects();
//        
//        if (pagina== null) {
//            respuesta.setTipo(Respuesta.FALTA_CAMPOS);
//            respuesta.setMensaje("Ingrese todos los campos de la petición");
//            return Response.status(Response.Status.BAD_REQUEST)
//                           .type(MediaType.APPLICATION_JSON)
//                           .entity(respuesta)
//                           .build();
//        }
//        pg.setTitle(pagina.getTitle());
//        pg.setDescription(pagina.getDescription());
//        pg.setUrl(pagina.getUrl());
//        try {
//            int result = managerPagina.setFeeds(pg);
//            if (result == 1) {
//                final Gson gson = new Gson();
//                representacionJSON = gson.toJson(pg);
//            }
//        } catch (Exception e) {
//            respuesta.setTipo(Respuesta.ERROR);
//            respuesta.setMensaje("Ocurrio un error registrando la pagina, Intente luego");
//            return Response.status(Response.Status.CONFLICT)
//                           .type(MediaType.APPLICATION_JSON)
//                           .entity(respuesta)
//                           .build();
//        }
//        respuesta.setTipo(Respuesta.CREADO);
//            respuesta.setMensaje("La pagina se registro exitosamente");
//            return Response.status(Response.Status.CREATED)
//                           .type(MediaType.APPLICATION_JSON)
//                           .entity(respuesta)
//                           .build();
//    }


}
