package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.*;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ProductManagerTest {

    final static Logger log = Logger.getLogger(ProductManagerTest.class.getName());
    static ProductManager pm;

    static Producto producto1, producto2, producto3, producto4;
    static Pedido p1, p2, p3;

    @BeforeClass
    public static void setUp() {
        //Inicimos una instancia
        pm = ProductManagerImpl.getInstance();
        //Antes de empezar inicimaos usuarios
        pm.addUsuario("Maria");
        pm.addUsuario("Pepe");
        pm.addUsuario("Juan");
        //inicimaos productos
        producto1 = new Producto(1.5, "zumo");
        producto2 = new Producto(0.8,"cafe");
        producto3 = new Producto(1, "croasant");
        producto4 = new Producto(3.5, "bocata");
        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);
        p1 =  new Pedido();
        p2 = new Pedido();

    }

    @AfterClass
    public static void tearDown(){
        pm = null;
    }

    //Probamos la funcion hacer pedido y servir
    @Test
    public void testPedido() {
        p1.addProducto(2, "cafe");
        p1.addProducto(1, "bocata");

        try {
            this.pm.hacerPedido("Maria", p1);
        } catch (UserNotFoundException e) {
            log.error("Usuario no encontrado");
        }

        p2.addProducto(4, "zumo");
        p2.addProducto(3, "croasant");

        try {
            this.pm.hacerPedido("Pepe", p2);
        }catch (UserNotFoundException e) {
            log.error("Usuario no encontrado");
        }
        Pedido p = pm.servirPedido();
        Assert.assertEquals("Maria", p.getUser());

        Pedido r = pm.servirPedido();
        Assert.assertEquals("Pepe", r.getUser());
    }

    @Test
    public void getAllProductosPorPrecioASC(){
        List<Producto> p = pm.getAllProductosPorPrecioASC();

        Assert.assertEquals(p.get(0).nombre, "bocata", "bocata");
        Assert.assertEquals(p.get(1).nombre, "zumo", "zumo");
        Assert.assertEquals(p.get(2).nombre, "croasant", "croasant");
        Assert.assertEquals(p.get(3).nombre, "cafe", "cafe");
    }

    @Test
    public void getAllProductosPorVentasDES(){
        List<Producto> p = pm.getAllProductosPorVentasDES();

        Assert.assertEquals(p.get(0).nombre, "bocata", "bocata");
        Assert.assertEquals(p.get(0).nombre, "cafe", "cafe");
        Assert.assertEquals(p.get(0).nombre, "croasant", "croasant");
        Assert.assertEquals(p.get(0).nombre, "zumo", "zumo");
    }

    @Test
    public void getPedidos(){
        try {
            LinkedList<Pedido> lp = pm.getPedidos("Maria");
        } catch (UserNotFoundException e) {
            log.error("Usuario no encontrado");
        }
    }
}
