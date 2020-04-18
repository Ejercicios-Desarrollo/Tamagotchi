package domain;

import domain.estados.Aburrida;
import domain.estados.Contenta;
import domain.estados.Hambrienta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TamagotchiTest {

    private Tropicatchi tropicatchi;
    private Memetchi memetchi;
    private Entrenador entrenador;

    @Before
    public void init(){
        this.tropicatchi = new Tropicatchi("tropicatchi");
        this.memetchi = new Memetchi("memetchi");
        this.entrenador = new Entrenador("entrenador", 40);
    }

    @Test
    public void mascotaComeTest(){
        tropicatchi.come();
        Assert.assertEquals(Integer.valueOf(1), tropicatchi.getNivelDeFelicidad());
    }

    @Test
    public void mascotaJugaTest(){
        this.tropicatchi.juga();
        Assert.assertEquals(Integer.valueOf(2), tropicatchi.getNivelDeFelicidad());
    }

    @Test
    public void mascotaPodesJugarTest(){
        Assert.assertEquals(true, tropicatchi.podesJugar());
    }

    @Test
    public void mascotaNoPodesJugarTest(){
        // Cambiar al unico estado en el que no puede jugar.
        tropicatchi.cambiarEstado(new Hambrienta());
        Assert.assertEquals(false, tropicatchi.podesJugar());
    }

    @Test
    public void mascotaCambiaEstadoHambrientaAContenta(){
        tropicatchi.cambiarEstado(new Hambrienta());
        Assert.assertEquals("Hambrienta", tropicatchi.getEstado());
        tropicatchi.come();
        Assert.assertEquals("Contenta", tropicatchi.getEstado());
    }

    @Test
    public void mascotaSigueAburridaDespuesDeComer(){
        // La mascota sigue aburrida porque esta aburrida desde hace 80 minutos o menos
        tropicatchi.cambiarEstado(new Aburrida());
        tropicatchi.come();
        Assert.assertEquals("Aburrida", tropicatchi.getEstado());
    }


    @Test
    public void mascotaJuega5VecesTest(){
        for (int i = 0; i < 5; i++) {
            tropicatchi.juga();
        }
        Assert.assertEquals(Integer.valueOf(10), tropicatchi.getNivelDeFelicidad());
        Assert.assertEquals("Contenta", tropicatchi.getEstado());
        tropicatchi.juga();
        Assert.assertEquals(Integer.valueOf(12), tropicatchi.getNivelDeFelicidad());
        Assert.assertEquals("Hambrienta", tropicatchi.getEstado());
    }

    @Test
    public void mascotaJuegaYCambiaEstadoTest(){
        tropicatchi.cambiarEstado(new Aburrida());
        tropicatchi.juga();
        Assert.assertEquals("Contenta", tropicatchi.getEstado());
    }

}
