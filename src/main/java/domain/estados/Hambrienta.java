package domain.estados;

import domain.Mascota;

public class Hambrienta implements Estado {
    @Override
    public void come(Mascota mascota) {
        mascota.cambiarEstado(new Contenta());
    }

    @Override
    public void juga(Mascota mascota) {

    }

    @Override
    public Boolean podesJugar() {
        return false;
    }
}
