package domain;

public class Contenta extends Estado {

    private Integer vecesQueJugo;

    public Contenta(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void comer(Mascota mascota) {
        mascota.aumentarFelicidad(1);
    }

    @Override
    public void jugar(Mascota mascota) {
        mascota.aumentarFelicidad(2);
        if(vecesQueJugo > 5){
            mascota.cambiarEstado(new Hambrienta(mascota));
        }
    }
}
