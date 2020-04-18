package domain.estados;

import domain.Mascota;
import domain.Punto;

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

    @Override
    public void caminaHacia(Mascota mascota, Punto unPunto) {

    }

    @Override
    public void descansa(Mascota mascota) {

    }

    public String getEstado(){
        return "Hambrienta";
    }
}
