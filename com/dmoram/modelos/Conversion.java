package com.dmoram.modelos;

public class Conversion {
    private final String monedaOrigen;
    private final String monedaDestino;
    private final double montoInicial;
    private final double montoConvertido;

    public Conversion(ConversionAPI convAPI, double montoInicial) {
        monedaOrigen = convAPI.base_code();
        monedaDestino = convAPI.target_code();
        this.montoInicial = montoInicial;
        montoConvertido = convAPI.conversion_result();
    }

    @Override
    public String toString() {
        return "Conversion{" +
                ", monedaOrigen='" + monedaOrigen + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                ", montoInicial=" + montoInicial +
                ", montoConvertido=" + montoConvertido +
                '}';
    }
}
