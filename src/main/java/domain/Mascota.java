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
        this.energia = 0;
        this.animo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivelDeFelicidad() {
        return nivelDeFelicidad;
    }

    public Estado getEstado() {
        return estado;
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

    }

    public void caminarHacia(Punto unPunto){

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
