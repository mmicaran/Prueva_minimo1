package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.Pedido;

import java.util.LinkedList;
import java.util.List;

public interface ProductManager {

    //METODOS
    List<Producto> getAllProductosPorPrecioASC();
    void hacerPedido(String user, Pedido p) throws UserNotFoundException;
    Pedido servirPedido();
    LinkedList<Pedido> getPedidos(String user) throws UserNotFoundException;
    List<Producto> getAllProductosPorVentasDES();

    void addUsuario(String u);
    void addProducto(Producto p);

}
