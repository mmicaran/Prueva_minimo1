import java.util.LinkedList;
import java.util.List;

public class Pedido {

    List<LP> lps;
    String user;

    public Pedido (){
        this.lps = new LinkedList<LP>();
    }

    public void add(int q, String prod) {

        this.lps.add(new LP(prod, q));
    }

    public List<LP> getProductos() {
        return lps;
    }

    public void setProductos(List<LP> productos) {
        this.lps = productos;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }


}
