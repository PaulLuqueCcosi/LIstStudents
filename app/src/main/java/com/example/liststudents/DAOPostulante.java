package com.example.liststudents;

import java.util.ArrayList;
import java.util.List;

public class DAOPostulante {
    private static List<Postulante> listaPostulantes = new ArrayList<>();

    // Método para registrar un nuevo postulante
    public static void registrarPostulante(Postulante postulante) {
        listaPostulantes.add(postulante);
    }

    // Método para obtener todos los postulantes registrados
    public static List<Postulante> listarPostulantes() {
        return listaPostulantes;
    }
}
