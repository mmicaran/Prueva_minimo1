package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.*;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        producto1 = new Producto( "zumo",1.5);
        producto2 = new Producto("cafe",0.8);
        producto3 = new Producto( "croasant",1);
        producto4 = new Producto( "bocata",3.5);
        producto1.ventas = 1;
        producto4.ventas = 2;
        producto2.ventas = 5;

        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);
        pm.addProducto(producto4);

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
        assertEquals("Maria", p.getUser());

        Pedido r = pm.servirPedido();
        assertEquals("Pepe", r.getUser());
    }

    @Test
    public void getAllProductosPorPrecioASC(){
        ArrayList<Producto> p = pm.getAllProductosPorPrecioASC();
        log.info("Lista ordenada test; "+ p);

        assertEquals(p.get(3).nombre, "bocata", "bocata");
        assertEquals(p.get(2).nombre, "zumo", "zumo");
        assertEquals(p.get(1).nombre, "croasant", "croasant");
        assertEquals(p.get(0).nombre, "cafe", "cafe");
    }

    @Test
    public void getAllProductosPorVentasDES(){
        List<Producto> p = pm.getAllProductosPorVentasDES();

        assertEquals(p.get(1).nombre, "bocata", "bocata");
        assertEquals(p.get(3).nombre, "cafe", "cafe");
        assertEquals(p.get(1).nombre, "croasant", "croasant");
        assertEquals(p.get(2).nombre, "zumo", "zumo");
    }

    @Test
    public void getPedidos(){
        try {
            LinkedList<Pedido> lp = pm.getPedidos("Maria");
            log.info("Pedido: "+lp);
        } catch (UserNotFoundException e) {
            log.error("Usuario no encontrado");
        }

    }
}
