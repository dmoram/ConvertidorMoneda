package com.dmoram.modelos;

import java.util.ArrayList;

public class RegistroConversiones {
    private ArrayList<Conversion> listaConversiones;

    public RegistroConversiones() {
        listaConversiones = new ArrayList<Conversion>();
    }

    public void añadirRegistro(Conversion conversion){
        listaConversiones.add(conversion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registro de Conversiones:\n");
        for (Conversion conversion : listaConversiones) {
            sb.append(conversion.toString()).append("\n");
        }
        return sb.toString();
    }

}
