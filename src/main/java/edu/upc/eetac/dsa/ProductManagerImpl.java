package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager {

    final static Logger log = Logger.getLogger(ProductManagerImpl.class.getName());

    //SINGELTON
    private static ProductManagerImpl instance;

    protected ArrayList<Producto> productos;
    protected Queue<Pedido> pedidos;
    //HashMap(key: string; value: edu.upc.eetac.dsa.Usuario)
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
    public ArrayList<Producto> getAllProductosPorPrecioASC(){
        //Copia de la lista para ordenarla
        ArrayList<Producto> p = new ArrayList<>();
        p.addAll(this.productos);
        log.info("Lista desordenada" + this.productos);

        //Indicamos que comparamos
        Collections.sort(p, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //Ascendente
                double d = o1.getPrecio()-o2.getPrecio();
                if(d < 0.0)
                    return -1;
                else if(d> 0.0)
                    return 1;
                else
                    return 0;
            }
        });
        log.info("Lista ordenada" + p);

        return p;
    }

    public LinkedList<Pedido> getPedidos(String user) throws UserNotFoundException {
        //Creamos un lista de pedidos para el resultado
        log.info("user: " + user);
        LinkedList<Pedido> pedidos;

        //Obtenemos el objeto User a partir de la clave user en el HM usuarios
        Usuario User = this.usuarios.get(user);

        if(User!=null){
            pedidos = User.getPedidos();
        }
        else{
            log.error("user not found");
            throw new UserNotFoundException();
        }
        log.info("pedidos: " + pedidos);
        return pedidos;

    }

    public List<Producto> getAllProductosPorVentasDES(){
        //Copia de la lista para ordenarla
        List<Producto> p = this.productos;
        p.addAll(this.productos);

        log.info("lista desordenada: " + p);

        //Indicamos que comparamos
        Collections.sort(p, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                //DESCENDENTE
                double d = o1.getVentas()-o2.getVentas();
                if(d < 0.0)
                    return 1;
                else if(d> 0.0)
                    return -1;
                else
                    return 0;
            }
        });
        log.info("lista ordenada: " + p);
        return p;
    }

    public void hacerPedido(String user, Pedido p) throws UserNotFoundException {
        //Buscamos el usuario
        Usuario u = this.usuarios.get(user);
        log.info("Usuario" + u + "Pedido" + p);

        if(u!=null){
            //nos guardamos el usuario en el pedio
            p.setUser(user);
            pedidos.add(p);
        }
        else{
            log.error("user not found");
            throw new UserNotFoundException();
        }
        log.info("Pedido añadido:" + this.pedidos);
    }

    public Pedido servirPedido(){

        Pedido p = this.pedidos.remove();

        log.info("Pedidos atendido:" + p);

         for (LP lp: p.getProductos()) {
            int q = lp.getQ();
            String nProducto = lp.getProducto();
            Producto producto = this.getProducto(nProducto);
            producto.actualizarVentas(q);
         }
         String user = p.getUser();
         Usuario u = this.usuarios.get(user);
         u.addPedido(p);

         log.info("Pedidos usuario:" + u.pedidos);
        return p;
    }

    private Producto getProducto(String nProducto) {
        boolean encontrado = false;
        Producto p;
        int i;
        for (i = 0; i < this.productos.size() && !encontrado; i++) {
            if (nProducto.equals(this.productos.get(i).nombre)) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            productos.add(new Producto(nProducto, 5));
            return this.productos.get(i++);
        } else {
            return this.productos.get(i);
        }
    }

    public void addUsuario(String u){
        usuarios.put(u,new Usuario(u));
    }

    public void addProducto(Producto p){
        boolean encontrado = false;
        int i;
        for (i = 0; (i < this.productos.size()) && (encontrado==false); i++) {
            if (p.nombre.equals(this.productos.get(i).nombre)) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            productos.add(p);
        }
    }




}
