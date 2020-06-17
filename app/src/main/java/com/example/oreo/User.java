package com.example.oreo;

public class User {


    public String Codviaje;
    public String Destino;
    public String Nopersonas;
    public String Tipobus;
    public String Descripcionv;
    public String Precioviaje;


    public String getCodviaje() {
        return Codviaje;
    }

    public void setCodviaje(String codviaje) {
        Codviaje = codviaje;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getNopersonas() {
        return Nopersonas;
    }

    public void setNopersonas(String nopersonas) {
        Nopersonas = nopersonas;
    }

    public String getTipobus() {
        return Tipobus;
    }

    public void setTipobus(String tipobus) {
        Tipobus = tipobus;
    }

    public String getDescripcionv() {
        return Descripcionv;
    }

    public void setDescripcionv(String descripcionv) {
        Descripcionv = descripcionv;
    }

    public String getPrecioviaje() {
        return Precioviaje;
    }

    public void setPrecioviaje(String precioviaje) {
        Precioviaje = precioviaje;
    }

    @Override
    public String toString() {
        return Destino;
    }
}
