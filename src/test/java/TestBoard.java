import CardGame.Board;
import CardGame.Element;
import CardGame.MonsterCard;
import CardGame.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {
    private Board board;
    private MonsterCard carta;
    private MonsterCard carta2;
    private MonsterCard carta3;
    private MonsterCard carta4;
    private MonsterCard carta5;
    private MonsterCard cartaExtra;
    private Player jogador;

    @Before
    public void setup(){
        board = new Board();

        jogador = new Player("Yugi", 4000, false);

        carta = new MonsterCard("Mago Negro",
                "Um mago que usa magia negra",
                2500, 2100, "Feiticeiro", true, Element.Trevas);
        carta2 = new MonsterCard("Guerreiro Guardião Celta",
                "Guerreiro Feroz das florestas",
                1400, 1200, "Guerreiro", true, Element.Terra);
        carta3 = new MonsterCard("Dragão Branco de Olhos Azuis",
                "Dragão Branco que vive no alto das montanhas nevadas",
                3000, 2500, "Dragão", true, Element.Vento);
        carta4 = new MonsterCard("Mago do Tempo",
                "Um pequeno mago capaz de viajar no tempo",
                500, 400, "Feiticeiro", true, Element.Trevas);
        carta5 = new MonsterCard("Saggi, o Palhaço Sombrio",
                "Este palhaço aparece do nada e usa movimentos estranhos para se esquivar de ataques inimigos.",
                600, 1500, "Demônio", true, Element.Trevas);

        cartaExtra = new MonsterCard("Soldado do Lustro Negro",
                "Guerreiro de uma ordem há muito desaparecida",
                3000, 2500, "Guerreiro", true, Element.Terra);
    }

    @Test
    public void deveReceberCartaQuandoHaEspaco(){
        board.receberCarta(carta, jogador);

        Assert.assertEquals(carta, board.getSlotDeMonstro().get(0));
    }

    @Test
    public void devePreencherVariosSlotsNaOrdem(){
        board.receberCarta(carta, jogador);
        board.receberCarta(carta2, jogador);
        board.receberCarta(carta3, jogador);

        Assert.assertEquals(carta, board.getSlotDeMonstro().get(0));
        Assert.assertEquals(carta2, board.getSlotDeMonstro().get(1));
        Assert.assertEquals(carta3, board.getSlotDeMonstro().get(2));
    }

    @Test
    public void naoDeveSubstituirCartaQuandoCampoCheio(){
        board.receberCarta(carta, jogador);
        board.receberCarta(carta2, jogador);
        board.receberCarta(carta3, jogador);
        board.receberCarta(carta4, jogador);
        board.receberCarta(carta5, jogador);

        board.receberCarta(cartaExtra, jogador);

        Assert.assertFalse(board.getSlotDeMonstro().contains(cartaExtra));
    }

    @Test
    public void deveRetornarPrimeiroSlotQuandoIndiceZero(){
        board.receberCarta(carta, jogador);

        Assert.assertEquals(carta, board.escolherMonstro(0));
    }

    @Test
    public void deveRetornarUltimoSlotQuandoIndiceQuatro(){
        board.receberCarta(carta, jogador);
        board.receberCarta(carta2, jogador);
        board.receberCarta(carta3, jogador);
        board.receberCarta(carta4, jogador);
        board.receberCarta(carta5, jogador);

        Assert.assertEquals(carta5, board.escolherMonstro(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deveLancarErroQuandoIndiceNegativo(){
        board.escolherMonstro(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deveLancarErroQuandoIndiceMaiorLimite(){
        board.escolherMonstro(5);
    }

    @Test
    public void deveRetornarTrueQuandoTodosSlotsEstaoVazios(){
        Assert.assertTrue(board.todosOsSlotsVazios());
    }

    @Test
    public void deveRetornarFalseQuandoUmSlotNaoEstaVazio(){
        board.receberCarta(carta,jogador);

        Assert.assertFalse(board.todosOsSlotsVazios());
    }
}
