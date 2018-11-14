
import java.util.*;

public class ProductManagerImpl implements ProductManager {


    //SINGELTON
    private static ProductManagerImpl instance;

    protected ArrayList<Producto> productos;
    protected Queue<Pedido> pedidos;
    //HashMap(key: string; value: Usuario)
    protected HashMap<String, Usuario> usuarios;

    private ProductManagerImpl(){
        this.productos = new ArrayList<Producto>();
        this.pedidos = new LinkedList<Pedido>();
        this.usuarios = new HashMap<>();
    }

    public static ProductManager getInstance(){
        if(instance == null){
            instance = new ProductManagerImpl();
        }
        return instance;
    }

    //IMPLEMENTACIÓN METODOS
    public List<Producto> getAllProductosPorPrecioASC(){
        //Copia de la lista para ordenarla
        List<Producto> p = this.productos;
        p.addAll(this.productos);
        //****
        //log.info("Lista desordenada" + this.productos);
        //****
        //Indicamos que comparamos
        Collections.sort(p, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //Ascendente
                return (int)(o1.getPrecio()-o2.getPrecio());
            }
        });
        //****
        //log.info("Lista ordenada" + this.p);
        //****
        return p;
    }

    //log implementado
    public LinkedList<Pedido> getPedidos(String user) throws UserNotFoundException {
        //Creamos un lista de pedidos para el resultado
        //************
        //log.info("user" +user);
        //************
        LinkedList<Pedido> pedidos = null;

        //Obtenemos el objeto User a partir de la clave user en el HM usuarios
        Usuario User = this.usuarios.get(user);

        if(User!=null){
            pedidos = User.getPedidos();
        }
        else{
            //***
            //log.error("user not found");
            //***

            throw new UserNotFoundException();
        }

        //****
        //log.info("pedidos" +pedidos);
        //****

        return pedidos;

    }

    public List<Producto> getAllProductosPorVentasDES(){
        //Copia de la lista para ordenarla
        List<Producto> p = this.productos;
        p.addAll(this.productos);

        //Indicamos que comparamos
        Collections.sort(p, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //DESCENDENTE
                return (-1)*(o1.getVentas()-o2.getVentas());
            }
        });

        return p;
    }

    //log implementado
    public void hacerPedido(String user, Pedido p) throws UserNotFoundException {
        //Buscamos el usuario
        Usuario u = this.usuarios.get(user);
        //****
        //log.info("Usuario" + u + "Pedido" + p);
        //****
        if(u!=null){
            //nos guardamos el usuario en el pedio
            p.setUser(user);
            pedidos.add(p);
        }
        else{
            //***
            //log.error("user not found");
            //***
            throw new UserNotFoundException();
        }
        //****
        //log.info("Pedido añadido:" this.pedidos);
        //****

    }


    public void servirPedido(){

        Pedido p = this.pedidos.remove();
        //****
        //log.info("Pedidos atendido:" + p);
        //****
         for (LP lp: p.getProductos()) {
            int q = lp.getQ();
            String nProducto = lp.getProducto();
            Producto producto = this.getProducto(nProducto);
            producto.actualizarVentas(q);
         }
         String user = p.getUser();
         Usuario u = this.usuarios.get(user);
         u.addPedido(p);
         //****
        //log.info("Pedidos usuario:" + u
        //****

    }

    private Producto getProducto(String nProducto){
        boolean encontrado = false;
        Producto p;
        int i;
        for(i=0; i<this.productos.size() && !encontrado; i++){
            if(nProducto.equals(this.productos.get(i).nombre)){
                encontrado = true;
            }
        }
        return this.productos.get(i);
    }




}
