package com.example.entregable.models;

public class Residuo {

    private int id;
    private String tipo;
    private double cantidad;
    private String ubicacion;
    private String fecha;

    public Residuo() {
    }

    public Residuo(int id, String tipo, double cantidad, String ubicacion, String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}