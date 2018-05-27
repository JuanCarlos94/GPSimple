package com.seminario.juancarlos.gpsimple.model;

/**
 * Created by juancarlos on 26/05/18.
 */

public class Percurso {
    private String origem, destino;
    private double latOrigem, longOrigem, latDestino, longDestino, distancia;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getLatOrigem() {
        return latOrigem;
    }

    public void setLatOrigem(double latOrigem) {
        this.latOrigem = latOrigem;
    }

    public double getLongOrigem() {
        return longOrigem;
    }

    public void setLongOrigem(double longOrigem) {
        this.longOrigem = longOrigem;
    }

    public double getLatDestino() {
        return latDestino;
    }

    public void setLatDestino(double latDestino) {
        this.latDestino = latDestino;
    }

    public double getLongDestino() {
        return longDestino;
    }

    public void setLongDestino(double longDestino) {
        this.longDestino = longDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
