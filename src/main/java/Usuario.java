import java.util.LinkedList;

public class Usuario {
    String nombre;

    LinkedList<Pedido> pedidos;

    public Usuario(String nombre, LinkedList<Pedido> pedidos){
        this.pedidos = pedidos;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPedidos(LinkedList<Pedido> pedidos) {

        this.pedidos = pedidos;
    }
    public void addPedido(Pedido p){
        this.pedidos.add(p);
    }

    public LinkedList<Pedido> getPedidos() {
        return pedidos;
    }
}
