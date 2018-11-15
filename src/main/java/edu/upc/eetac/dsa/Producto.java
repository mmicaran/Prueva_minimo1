package edu.upc.eetac.dsa;

public class Producto {

    String nombre;
    double precio;
    int ventas;

    public Producto() {
    }

    public Producto(String nombre, double precio){
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

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio +", ventas=" + ventas +"]";
    }

}
