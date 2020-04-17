package domain.estados;

import domain.Mascota;
import domain.Punto;

import java.time.Duration;
import java.time.LocalTime;

public class Aburrida implements Estado {
    private LocalTime horaInicio;

    public Aburrida(){
        this.horaInicio = LocalTime.now();
    }

    @Override
    public void come(Mascota mascota) {
        if(haceMuchoEstaAburrida()){
            mascota.cambiarEstado(new Contenta());
        }
    }

    private boolean haceMuchoEstaAburrida(){
        LocalTime ahora = LocalTime.now();
        long diferencia = Duration.between(horaInicio, ahora).toMinutes();
        return diferencia > 80;
    }

    @Override
    public void juga(Mascota mascota) {
        mascota.cambiarEstado(new Contenta());
    }

    @Override
    public Boolean podesJugar() {
        return true;
    }

    @Override
    public void caminaHacia(Mascota mascota, Punto unPunto){
        mascota.disminuirEnergiaEn(unPunto.getX());
        mascota.aumentarAnimoEn(unPunto.getX() + unPunto.getY());

        if(mascota.getAnimo() > 15){
            mascota.cambiarEstado(new Contenta());
        }
    }

    @Override
    public void descansa(Mascota mascota){
        mascota.aumentarEnergiaEn(2);
    }
}
