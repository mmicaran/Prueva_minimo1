
import java.util.LinkedList;
import java.util.List;

public interface ProductManager {

    //METODOS
    List<Producto> getAllProductosPorPrecioASC();
    void hacerPedido(String user, Pedido p) throws UserNotFoundException;
    void servirPedido();
    LinkedList<Pedido> getPedidos(String user) throws UserNotFoundException;
    List<Producto> getAllProductosPorVentasDES();

}
