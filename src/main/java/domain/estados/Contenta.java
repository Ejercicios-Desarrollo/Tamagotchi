package domain.estados;

import domain.Mascota;
import domain.Punto;

public class Contenta implements Estado {
    private Integer vecesJugadas;

    public Contenta(){
        this.vecesJugadas = 0;
    }

    @Override
    public void come(Mascota mascota) {
        mascota.aumentarFelicidadEn(1);
    }

    @Override
    public void juga(Mascota mascota) {
        this.vecesJugadas++;
        mascota.aumentarFelicidadEn(2);
        if(this.vecesJugadas > 5){
            mascota.cambiarEstado(new Hambrienta());
        }
    }

    @Override
    public Boolean podesJugar() {
        return true;
    }

    @Override
    public void caminaHacia(Mascota mascota, Punto unPunto){
        mascota.disminuirEnergiaEn(unPunto.getY());
        mascota.aumentarAnimoEn(2 * (unPunto.getX() + unPunto.getY()));
        if(mascota.getEnergia() < 40){
            mascota.cambiarEstado(new Cansada());
        }
    }

    @Override
    public void descansa(Mascota mascota){
        mascota.aumentarEnergiaEn(2);
    }
}
