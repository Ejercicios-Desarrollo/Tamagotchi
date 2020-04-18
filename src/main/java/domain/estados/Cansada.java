package domain.estados;

import domain.Mascota;
import domain.Punto;

public class Cansada implements Estado{
    @Override
    public void come(Mascota mascota) {

    }

    @Override
    public void juga(Mascota mascota) {

    }

    @Override
    public Boolean podesJugar() {
        return null;
    }

    @Override
    public void caminaHacia(Mascota mascota, Punto unPunto){
        mascota.disminuirAnimoEn(20);
    }

    @Override
    public void descansa(Mascota mascota){
        mascota.aumentarEnergiaEn(20);
        if(mascota.getEnergia() > 80){
            mascota.cambiarEstado(new Aburrida());
        }
    }

    public String getEstado(){
        return "Cansada";
    }
}
