package domain;

public class Tropicatchi extends Mascota {
    private Integer masaMuscular;
    private boolean enForma;

    public Tropicatchi(String nombre) {
        super(nombre);
        this.masaMuscular = 0;
        this.enForma = false;
    }

    @Override
    public void caminaHacia(Punto unPunto) {
        super.caminaHacia(unPunto);
        this.masaMuscular += 10;
        if(this.masaMuscular > 90){
            this.enForma = true;
        }
    }
}
