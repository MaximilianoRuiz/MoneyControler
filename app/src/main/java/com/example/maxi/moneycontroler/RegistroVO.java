package com.example.maxi.moneycontroler;

import java.util.Date;

/**
 * Created by Maxi on 18/04/2015.
 */
public class RegistroVO {

    private int id;
    private double monto;
    private Date fecha;
    private CategoriaVO categoria;
    private boolean debitado;

    public RegistroVO(int id, double monto, Date fecha, CategoriaVO categoria, boolean debitado) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.debitado = debitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CategoriaVO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVO categoria) {
        this.categoria = categoria;
    }

    public boolean isDebitado() {
        return debitado;
    }

    public void setDebitado(boolean debitado) {
        this.debitado = debitado;
    }
}
