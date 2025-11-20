import CardGame.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBattle {

    private Battle battle;
    private Player jogadorDefensor;
    private Player jogadorAtacante;
    private MonsterCard monstroAtacante;
    private MonsterCard monstroDefensor;
    private Board campoAtacante;
    private Board campoDefensor;
    private int vidaInicial;

    // Executa esse metodo antes de cada teste
    @Before
    public void setup(){
        battle = new Battle();

        jogadorDefensor = new Player("Kaiba",4000,false);
        jogadorAtacante = new Player("Yugi",4000,true);

        vidaInicial = jogadorDefensor.getPontosDeVida();

        campoAtacante = new Board();
        campoDefensor = new Board();

        monstroAtacante = new MonsterCard("Vulto do Rei Louco",
                "Um espectro de um antigo rei enlouquecido, cuja sede de poder o levou à ruína.",
                2600,2100,"Demônio",true, Element.Trevas);

        monstroDefensor = new MonsterCard("Arbórea Ancestral",
                "Uma árvore viva que guarda o conhecimento do antigo mundo.",
                1700,2000,"Planta",true,Element.Terra);
    }


    @Test
    public void deveCausarDanoDireto(){
       battle.ataqueDireto(monstroAtacante, jogadorDefensor);

        Assert.assertEquals(vidaInicial - monstroAtacante.getAtaque(),jogadorDefensor.getPontosDeVida());

    }

    @Test
    public void deveCausaZeroDeDanoDiretoQuandoAtaqueZero(){
        monstroAtacante.setAtaque(0);
        battle.ataqueDireto(monstroAtacante, jogadorDefensor);

        Assert.assertEquals(vidaInicial, jogadorDefensor.getPontosDeVida());
    }

    @Test
    public void deveCausaMaximoDeDano(){
        monstroAtacante.setAtaque(9999);
        battle.ataqueDireto(monstroAtacante, jogadorDefensor);

        Assert.assertEquals(vidaInicial - monstroAtacante.getAtaque(), jogadorDefensor.getPontosDeVida());
    }

    @Test
    public void naoDeveAtacarEmModoDefesa(){
        monstroAtacante.setModo(Mode.Defesa);

        battle.golpe(monstroAtacante,null,jogadorAtacante,jogadorDefensor,campoDefensor,campoAtacante);

        Assert.assertEquals(vidaInicial, jogadorDefensor.getPontosDeVida());
    }

    @Test
    public void naoPodeAtacarDiretoSeCampoDoDefensorNaoEstiverVazio(){
        monstroDefensor.setModo(Mode.Defesa);
        campoDefensor.receberCarta(monstroDefensor,jogadorDefensor);

        battle.golpe(monstroAtacante,monstroDefensor,jogadorAtacante,jogadorDefensor,campoAtacante,campoDefensor);

        Assert.assertEquals(vidaInicial,jogadorDefensor.getPontosDeVida());
    }
}
