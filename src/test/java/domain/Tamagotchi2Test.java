package domain;

import domain.estados.Aburrida;
import domain.estados.Cansada;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tamagotchi2Test {

    private Tropicatchi tropicatchi;
    private Memetchi memetchi;
    private Entrenador entrenador;
    private Punto punto1;
    private Punto punto2;
    private Punto punto3;

    @Before
    public void init(){
        this.tropicatchi = new Tropicatchi("tropicatchi");
        this.memetchi = new Memetchi("memetchi");
        this.entrenador = new Entrenador("entrenador", 40);
        this.punto1 = new Punto(1,2);
        this.punto2 = new Punto(2,3);
        this.punto3 = new Punto(70,70);
    }

    //Tropicatchi cuando camina aumenta su masa muscular en 10 unidades. Si esta masa muscular
    //supera las 90 unidades, entonces estará en forma. El resto de las mascotas nunca están en
    //forma.

    @Test
    public void test1(){
        Assert.assertEquals(false, tropicatchi.estasEnForma());

        for (int i = 0; i < 10; i++) {
            tropicatchi.caminaHacia(punto1);
        }

        Assert.assertEquals(true, tropicatchi.estasEnForma());
    }

    //Por otro lado, Memetchi cada vez que camina aumenta su hambre en 5 unidades. Si
    //supera las 25 unidades, esta mascota comenzará a decir que tiene hambre.

    @Test
    public void test2(){
        Assert.assertEquals(false, memetchi.tenesHambre());

        for (int i = 0; i < 6; i++) {
            memetchi.caminaHacia(punto1);
        }

        Assert.assertEquals(true, memetchi.tenesHambre());
    }

    //Cuando las mascotas están aburridas y les pedimos que caminen hacia un punto (x;y), su energía
    //disminuye en “x” unidades pero su ánimo aumenta en “x+y” unidades.

    @Test
    public void test3(){
        memetchi.cambiarEstado(new Aburrida());

        memetchi.caminaHacia(punto2); // x = 2, y = 3

        Assert.assertEquals(Integer.valueOf(98), memetchi.getEnergia());
        Assert.assertEquals(Integer.valueOf(5), memetchi.getAnimo());
    }

    //Si una mascota está aburrida y le pedimos que descanse, su energía aumentará en 2 unidades.

    @Test
    public void test4(){
        memetchi.cambiarEstado(new Aburrida());

        memetchi.descansa();

        Assert.assertEquals(Integer.valueOf(102), memetchi.getEnergia());
    }

    //Una mascota estará contenta cuando su ánimo supere las 15 unidades.

    @Test
    public void test5(){
        memetchi.cambiarEstado(new Aburrida());

        Assert.assertEquals("Aburrida", memetchi.getEstado());

        memetchi.caminaHacia(punto2); // x = 2, y = 3
        memetchi.caminaHacia(punto2); // x = 2, y = 3
        memetchi.caminaHacia(punto2); // x = 2, y = 3
        memetchi.caminaHacia(punto1); // x = 1, y = 2

        Assert.assertEquals(Integer.valueOf(18), memetchi.getAnimo());

        Assert.assertEquals("Contenta", memetchi.getEstado());
    }

    //Si le pedimos a una mascota contenta que camine hacia un punto (x;y), su energía va a disminuir en
    //“y” unidades pero su ánimo aumentará como el doble de la suma de “x+y”.

    @Test
    public void test6(){
        Assert.assertEquals(Integer.valueOf(0), memetchi.getAnimo());

        memetchi.caminaHacia(punto2); // x = 2, y = 3

        Assert.assertEquals(Integer.valueOf(97), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(10), memetchi.getAnimo());
    }

    //Cuando una mascota contenta está debilitada (su energía es menor a 40 unidades), comenzará a decir
    //que está cansada.

    @Test
    public void test7(){
        Assert.assertEquals(Integer.valueOf(100), memetchi.getEnergia());

        memetchi.caminaHacia(punto3); // x = 70, y = 70

        Assert.assertEquals("Cansada", memetchi.getEstado());
    }

    //Si a una mascota cansada le pedimos que camine, su ánimo disminuirá en 20 unidades. Pero si le
    //pedimos que descanse, aumentará la energía en 20 unidades.

    @Test
    public void test8(){
        memetchi.cambiarEstado(new Cansada());
        Assert.assertEquals(Integer.valueOf(0), memetchi.getAnimo());

        memetchi.caminaHacia(punto2); // x = 2, y = 3

        Assert.assertEquals(Integer.valueOf(-20), memetchi.getAnimo());
    }

    @Test
    public void test9(){
        Assert.assertEquals(Integer.valueOf(100), memetchi.getEnergia());

        memetchi.caminaHacia(punto3); // x = 70, y = 70

        Assert.assertEquals("Cansada", memetchi.getEstado());

        Assert.assertEquals(Integer.valueOf(30), memetchi.getEnergia());

        memetchi.descansa();

        Assert.assertEquals(Integer.valueOf(50), memetchi.getEnergia());
    }

    //Si una mascota cansada recuperó suficiente energía (la energía supera las 80 unidades), entonces
    //volverá a estar aburrida y a la espera de entrenamiento.

    @Test
    public void test10(){
        Assert.assertEquals(Integer.valueOf(100), memetchi.getEnergia());

        memetchi.caminaHacia(punto3); // x = 70, y = 70

        Assert.assertEquals("Cansada", memetchi.getEstado());

        Assert.assertEquals(Integer.valueOf(30), memetchi.getEnergia());

        memetchi.descansa();

        memetchi.descansa();

        memetchi.descansa();


        Assert.assertEquals(Integer.valueOf(90), memetchi.getEnergia());

        Assert.assertEquals("Aburrida", memetchi.getEstado());
    }

    //El entrenador deberá poder darle un respiro a todas sus mascotas que estén cansadas. Cuando les dé un
    //respiro, éstas descansarán.

    @Test
    public void test11(){
        entrenador.agregarMascota(memetchi);
        entrenador.agregarMascota(tropicatchi);

        Assert.assertEquals(Integer.valueOf(100), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(100), tropicatchi.getEnergia());

        entrenador.desplazarseA(punto3); // x = 70, y = 70

        Assert.assertEquals(Integer.valueOf(30), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(30), tropicatchi.getEnergia());

        Assert.assertEquals("Cansada", memetchi.getEstado());

        Assert.assertEquals("Cansada", tropicatchi.getEstado());

        entrenador.darRespiroAMascotas();

        Assert.assertEquals(Integer.valueOf(50), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(50), tropicatchi.getEnergia());
    }

    // entrenador.darRespiroAMascotas() no produce nada ya que las mascotas no estan cansadas

    @Test
    public void test12(){
        entrenador.agregarMascota(memetchi);
        entrenador.agregarMascota(tropicatchi);

        Assert.assertEquals(Integer.valueOf(100), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(100), tropicatchi.getEnergia());

        entrenador.desplazarseA(punto2); // x = 2, y = 3

        Assert.assertEquals(Integer.valueOf(97), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(97), tropicatchi.getEnergia());

        entrenador.darRespiroAMascotas();

        Assert.assertEquals(Integer.valueOf(97), memetchi.getEnergia());

        Assert.assertEquals(Integer.valueOf(97), tropicatchi.getEnergia());
    }

}
