package edu.upc.eetac.dsa;

public class LP {

    String producto;
    int q;

    public LP(){}

    public LP (String p , int q) {
        this.producto=p;
        this.q=q;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getQ() {
        return q;
    }

    public String getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + producto + ", cantidad=" + q +"]";
    }
}
