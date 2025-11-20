import CardGame.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPlayer {
    private Player jogador;
    private Deck deck;
    private Card carta;
    private Card carta2;

    @Before
    public void Setup(){
        jogador = new Player("Yugi",4000,true);

        carta =  new MonsterCard("Guardião do Abismo",
                "Um ser que reside nas profundezas do Abismo, onde a luz não alcança.",
                2400,1800, "Demônio",true, Element.Trevas);
        carta2 = new MonsterCard("Vulto do Rei Louco",
                "Um espectro de um antigo rei enlouquecido, cuja sede de poder o levou à ruína.",
                2600,2100,"Demônio",true, Element.Trevas);

        deck = new Deck();

        deck.add(carta);
        deck.add(carta2);
    }

    // comprarCarta()

    @Test
    public void DeveComprarCartaQuandoDeckNaoEstaVazio(){
        jogador.comprarCarta(deck,jogador);

        Assert.assertEquals(1, jogador.getCartasNaMao().size());
        Assert.assertEquals(1, deck.getNumeroDeCartas());
    }

    @Test
    public void naoDeveComprarCartaQuandoDeckVazio(){
        deck.removerCarta();
        deck.removerCarta();

        jogador.comprarCarta(deck, jogador);

        Assert.assertTrue(jogador.getCartasNaMao().isEmpty());
    }

    // removerCartasDaMao()

    @Test
    public void deveRemoverCartaIndiceZero(){
        jogador.comprarCarta(deck,jogador);

         Card cartaRemovida = jogador.removerCartasDaMao(0);

         Assert.assertNotNull(cartaRemovida);
         Assert.assertTrue(jogador.getCartasNaMao().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deveFalharQuandoIndiceNegativo(){
        jogador.removerCartasDaMao(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deveFalharQuandoIndiceMaiorQueTamanho(){
        jogador.comprarCarta(deck,jogador);

        jogador.removerCartasDaMao(1);
    }

    // testes de turno

    @Test
    public void deveIndicarOTurnoDoJogador(){
        Assert.assertTrue(jogador.isSuaVez());
    }

    @Test
    public void deveFinalizarTurno(){
        jogador.finalizarTurno();

        Assert.assertFalse(jogador.isSuaVez());
    }

    // Testede pontos de vida

    @Test
    public void deveAlterarPontosDeVida(){
        jogador.setPontosDeVida(2000);

        Assert.assertEquals(2000, jogador.getPontosDeVida());
    }

    @Test
    public void deveAceitarPontosDeVidaZeroValorLimite(){
        jogador.setPontosDeVida(0);

        Assert.assertEquals(0, jogador.getPontosDeVida());
    }

}
