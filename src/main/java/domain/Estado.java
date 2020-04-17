package domain;

public abstract class Estado {
    protected Mascota mascota;

    public Estado(Mascota mascota){
        this.mascota = mascota;
    }
    public abstract void comer(Mascota mascota);

    public abstract void jugar(Mascota mascota);
}
