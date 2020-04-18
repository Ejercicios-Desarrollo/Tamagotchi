package domain;

import domain.estados.Contenta;
import domain.estados.Estado;

public abstract class Mascota {
    private String nombre;
    private Integer nivelDeFelicidad;
    private Estado estado;
    private Integer energia;
    private Integer animo;

    public Mascota(String nombre){
        this.nombre = nombre;
        this.nivelDeFelicidad = 0;
        this.estado = new Contenta();
        this.energia = 100;
        this.animo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivelDeFelicidad() {
        return nivelDeFelicidad;
    }

    public String getEstado() {
        return this.estado.getEstado();
    }

    public void juga(){
        this.estado.juga(this);
    }

    public void come(){
        this.estado.come(this);
    }

    public boolean podesJugar(){
        return this.estado.podesJugar();
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public void aumentarFelicidadEn(Integer unidades){
        this.nivelDeFelicidad += unidades;
    }

    public void descansa(){
        this.estado.descansa(this);
    }

    public void caminaHacia(Punto unPunto){
        this.estado.caminaHacia(this, unPunto);
    }

    public void disminuirEnergiaEn(Integer unidades){
        this.energia -= unidades;
    }

    public void aumentarEnergiaEn(Integer unidades){
        this.energia += unidades;
    }

    public void aumentarAnimoEn(Integer unidades){
        this.animo += unidades;
    }

    public void disminuirAnimoEn(Integer unidades){
        this.animo -= unidades;
    }

    public Integer getAnimo() {
        return animo;
    }

    public Integer getEnergia() {
        return energia;
    }

}
