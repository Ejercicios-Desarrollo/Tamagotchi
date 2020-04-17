package domain.estados;

import domain.Mascota;
import domain.Punto;

public interface Estado {
    public void come(Mascota mascota);
    public void juga(Mascota mascota);
    public Boolean podesJugar();
    public void caminaHacia(Mascota mascota, Punto unPunto);
    public void descansa(Mascota mascota);
}
