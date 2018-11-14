package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductManagerTest {

    ProductManager pm;

    Producto producto1, producto2, producto3;
    Pedido p1, p2, p3;

    @BeforeClass
    public void setUp() {
        //Inicimos una instancia
        this.pm = ProductManagerImpl.getInstance();
        //Antes de empezar inicimaos usuarios
        pm.addUsuario("Maria");
        pm.addUsuario("Pepe");
        pm.addUsuario("Juan");
        //inicimaos productos
        producto1 = new Producto(1.5, "zumo");
        producto2 = new Producto(0.8,"cafe");
        producto3 = new Producto(1, "croasant");
        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);


    }




    @Test
    public void testHacerPedido() {
        Pedido p1 = new Pedido();
        p1.add(2, "cafe");
        p1.add(1, "bocata");

        try {
            this.pm.hacerPedido("maria", p1);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }


        /*edu.upc.eetac.dsa.Pedido p2 = new edu.upc.eetac.dsa.Pedido();
        p2.add(2, "zumo");
        p2.add(1, "bocata2");

        try {
            this.pm.hacerPedido("pepe", p2);
        }catch (edu.upc.eetac.dsa.UserNotFoundException e) {
            e.printStackTrace();
        }

        edu.upc.eetac.dsa.Pedido p3 = new edu.upc.eetac.dsa.Pedido();
        p3.add(2, "colaco");
        p3.add(1, "crusan");

        try {
            this.pm.hacerPedido("juam", p3);
        } catch (edu.upc.eetac.dsa.UserNotFoundException e) {
            e.printStackTrace();
        }*/


        p1 = this.pm.servirPedido();
        Assert.assertEquals("maria", p1.getUser());

        /*p2 = this.pm.servirPedido();
        Assert.assertEquals("pepe", p2.getUser());*/

    }
}
