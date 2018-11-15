package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.Pedido;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface ProductManager {

    //METODOS
    //GET
    ArrayList<Producto> getAllProductosPorPrecioASC();


    //POST/PUT
    void hacerPedido(String user, Pedido p) throws UserNotFoundException;

    //DELETE
    Pedido servirPedido();

    //GET{user}
    LinkedList<Pedido> getPedidos(String user) throws UserNotFoundException;

    //GET
    List<Producto> getAllProductosPorVentasDES();

    void addUsuario(String u);
    void addProducto(Producto p);

}
