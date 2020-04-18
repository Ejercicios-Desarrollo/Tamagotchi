package domain;

public class Memetchi extends Mascota {
    private Integer hambre;

    public Memetchi(String nombre) {
        super(nombre);
        this.hambre = 0;
    }

    @Override
    public void caminaHacia(Punto unPunto) {
        super.caminaHacia(unPunto);
        this.hambre += 5;
    }

    public Boolean tenesHambre(){
        return this.hambre > 25;
    }
}
