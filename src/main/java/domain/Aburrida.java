package domain;

public class Aburrida extends Estado {

    private Integer minutos;

    public Aburrida(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void comer(Mascota mascota) {
        if(this.minutos > 80){
            mascota.cambiarEstado(new Contenta(mascota));
        }
    }

    @Override
    public void jugar(Mascota mascota) {
        mascota.cambiarEstado(new Contenta(mascota));
    }
}
