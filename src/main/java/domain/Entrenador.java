package domain;

import domain.estados.Cansada;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entrenador {
    private String nombre;
    private Integer edad;
    private List<Mascota> mascotas;

    public Entrenador(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota unaMascota){
        this.mascotas.add(unaMascota);
    }

    public void desplazarseA(Punto unPunto){
        this.mascotas.forEach(m -> m.caminarHacia(unPunto));
    }

    public void darRespiroAMascotas(){
        this.mascotas
                .stream()
                .filter(m -> m.getEstado().equals(new Cansada()))
                .collect(Collectors.toList())
                .forEach(m -> m.descansa());
    }

}
