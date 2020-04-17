package domain;

public class Mascota {
    private String nombre;
    private Integer nivelDeFelicidad;
    private Estado estado;

    public Mascota(String nombre){
        this.nombre = nombre;
        this.nivelDeFelicidad = 0;
        this.estado = new Contenta(this);
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

    public void jugar(){
        this.estado.jugar(this);
    }

    public void comer(){
        this.estado.comer(this);
    }

    public boolean podesJugar(){
        return true;
    }

    public void cambiarEstado(Estado estado){

    }

    public void aumentarFelicidad(Integer unidades){
        this.nivelDeFelicidad += unidades;
    }
}
