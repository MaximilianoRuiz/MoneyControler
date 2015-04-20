package com.example.maxi.moneycontroler;

/**
 * Created by Maxi on 18/04/2015.
 */
public class CategoriaVO {
    private int id;
    private String categoria;
    private double monto;
    private boolean fijo;

    public CategoriaVO(int id, String categoria, double monto, boolean fijo) {
        this.id = id;
        this.categoria = categoria;
        this.monto = monto;
        this.fijo = fijo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }
}
