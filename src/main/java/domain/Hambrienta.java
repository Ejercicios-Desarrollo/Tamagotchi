package domain;

public class Hambrienta extends Estado {

    public Hambrienta(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void comer(Mascota mascota) {
        mascota.cambiarEstado(new Contenta(mascota));
    }

    @Override
    public void jugar(Mascota mascota) {

    }
}
