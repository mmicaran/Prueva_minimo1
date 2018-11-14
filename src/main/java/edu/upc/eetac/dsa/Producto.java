package edu.upc.eetac.dsa;

public class Producto {

    double precio;
    String nombre;
    int ventas;

    public Producto(double precio, String nombre){
        this.nombre = nombre;
        this.precio = precio;
        this.ventas = 0;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void actualizarVentas(int q){
        this.ventas += q;
    }



}
