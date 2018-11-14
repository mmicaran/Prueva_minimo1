
public class ProductManagerTest {

    ProductManagerImpl pm;

    public void setUp() {
        this.pm = ProductManagerImpl.getInstance();
    }



    @Test
    public void testHacerPedido() {
        Pedido p = new Pedido();
        p.add(2, "cafe");
        p.add(1, "bocata");

        try {
            this.pm.hacerPedido("maria", p);
        }catch (UserNotFoundException){

        }



        Pedido p2 = new Pedido();
        p2.add(2, "zumo");
        p2.add(1, "bocata2");

        this.pm.hacerPedido("pepe", p1);
        this.pm.hacerPedido("juam", p);


        p = this.pm.servirPedido();
        Assert.assertEquals("maria", p.getUser())

        p = this.pm.servirPedido();
        Assert.assertEquals("pepe", p1.getUser())

    }
}
