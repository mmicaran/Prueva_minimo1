package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/ProductManager", description = "Endpoint to Track Service")
@Path("/ProductManager")
public class ProductManagerService {

    private ProductManager pm;
    private Producto producto1, producto2, producto3, producto4;
    private Pedido p1, p2;
    public ProductManagerService() {
        this.pm = ProductManagerImpl.getInstance();

        pm = ProductManagerImpl.getInstance();
        //Antes de empezar inicimaos usuarios
        pm.addUsuario("Maria");
        pm.addUsuario("Pepe");
        pm.addUsuario("Juan");
        //inicimaos productos
        producto1 = new Producto( "zumo",1.5);
        producto2 = new Producto("cafe",0.8);
        producto3 = new Producto( "croasant",1);
        producto4 = new Producto("bocata",3.5);
        producto1.setVentas(1);
        producto4.setVentas(2);
        producto2.setVentas(5);
        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);
        pm.addProducto(producto4);

        p1 =  new Pedido();
        p2 = new Pedido();
    }

    //PRODUCTOS POR PRECIO ASCENDENTE
    @GET
    @ApiOperation(value = "obtener productos por precio ASC", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="ArrayList"),
    })
    @Path("/ASC")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductosPorPrecioASC() {
        ArrayList<Producto> productos = this.pm.getAllProductosPorPrecioASC();
        GenericEntity<ArrayList<Producto>> entity = new GenericEntity<ArrayList<Producto>>(productos) {};
        return Response.status(201).entity(entity).build();
    }
/*
    //PRODUCTOS POR VENTA DESCENDETE
    @GET
    @ApiOperation(value = "obtener productos por vetas DES", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Producto.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductosPorVentasDES() {
        List<Producto> productos = this.pm.getAllProductosPorVentasDES();
        GenericEntity<List<Producto>> entity = new GenericEntity<List<Producto>>(productos) {};
        return Response.status(201).entity(entity).build();
    }

    //PEDIDOS DE UN USUARIO
    @GET
    @ApiOperation(value = "obtener los pedidos de un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Pedido.class),
            @ApiResponse(code = 404, message = "usuario no encontrado")
    })
    @Path("/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedidos(@PathParam("user") String user) {
        try {
            LinkedList<Pedido> p = this.pm.getPedidos(user);
            return Response.status(201).entity(p).build();
        } catch (UserNotFoundException e) {
            return Response.status(404).build();
        }
    }

    //SERVIR PEDIDO
    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "ERROR")
    })
    @Path("/")
    public Response servirPedido() {
        Pedido p = this.pm.servirPedido();
        if (p == null) return Response.status(404).build();
        else return Response.status(201).build();
    }

    //HACER PEDIDO
    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/")
    public Response hacerPedido(Track track) {
        Track t = this.tm.getTrack(track.getId());
        if (t == null) return Response.status(404).build();
        else this.tm.updateTrack(t);
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }*/

}