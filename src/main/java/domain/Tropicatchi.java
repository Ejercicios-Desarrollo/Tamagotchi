package domain;

public class Tropicatchi extends Mascota {
    private Integer masaMuscular;

    public Tropicatchi(String nombre) {
        super(nombre);
        this.masaMuscular = 0;
    }

    @Override
    public void caminaHacia(Punto unPunto) {
        super.caminaHacia(unPunto);
        this.masaMuscular += 10;
    }

    public Boolean estasEnForma(){
        return masaMuscular > 90;
    }
}
