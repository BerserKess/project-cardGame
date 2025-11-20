import CardGame.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDeck {

    private Deck deckDuelista1;
    private Deck deckDuelista2;
    private MonsterCard carta;

    @Before
    public void setup(){
        deckDuelista1 = new Deck();
        deckDuelista2 = new Deck();

        carta = new MonsterCard("O Mago Cinzento",
                "O poderoso mago errante, conhecido por sua sabedoria e habilidades mágicas.",
                2200,2500,"Feiticeiro",true, Element.Luz);
    }

    // LISTA DE CARTAS
    List<Card> cartasDeMonstro = new ArrayList<>(Arrays.asList(
            new MonsterCard("Mago Negro",
                    "Um mago que usa magia negra",
                    2500, 2100, "Feiticeiro", true, Element.Trevas),
            new MonsterCard("Guerreiro Guardião Celta",
                    "Guerreiro Feroz das florestas",
                    1400, 1200, "Guerreiro", true, Element.Terra),
            new MonsterCard("Dragão Branco de Olhos Azuis",
                    "Dragão Branco que vive no alto das montanhas nevadas",
                    3000, 2500, "Dragão", true, Element.Vento),
            new MonsterCard("Mago do Tempo",
                    "Um pequeno mago capaz de viajar no tempo",
                    500, 400, "Feiticeiro", true, Element.Trevas),
            new MonsterCard("Saggi, o Palhaço Sombrio",
                    "Este palhaço aparece do nada e usa movimentos estranhos para se esquivar de ataques inimigos.",
                    600, 1500, "Demônio", true, Element.Trevas),
            new MonsterCard("Gigante Hitotsu-me",
                    "Um gigante de um olho só com braços largos e poderosos.",
                    1200, 1000, "Besta-Guerreira", true, Element.Terra),
            new MonsterCard("Guerreiro Desolado",
                    "Um guerreiro caído que vaga eternamente pelas terras devastadas, sua espada ecoa o lamento de almas perdidas.",
                    1500, 1000, "Guerreiro", true, Element.Trevas),
            new MonsterCard("Soldado do Lustro Negro",
                    "Guerreiro de uma ordem há muito desaparecida",
                    3000, 2500, "Guerreiro", true, Element.Terra),
            new MonsterCard("Dragão Zumbi",
                    "Um dragão renascido por feitiçaria. O seu hálito é altamente corrosivo.",
                    1600, 0, "Trevas", true, Element.Trevas),
            new MonsterCard("Gaia, O Cavaleiro Feroz",
                    "Um cavaleiro com um cavalo que galopa mais rápido que o vento.",
                    2300, 2100, "Luz", true, Element.Terra),
            new MonsterCard("Dragão de Cinzas",
                    "Uma colossal criatura feita de cinzas e brasas, queima tudo em seu caminho com seu",
                    2200,1500,"Dragão",true,Element.Fogo),
            new MonsterCard("Guardião do Abismo",
                    "Um ser que reside nas profundezas do Abismo, onde a luz não alcança.",
                    2400,1800, "Demônio",true,Element.Trevas),
            new MonsterCard("Arbórea Ancestral",
                    "Uma árvore viva que guarda o conhecimento do antigo mundo.",
                    1700,2000,"Planta",true,Element.Terra),
            new MonsterCard("Vulto do Rei Louco",
                    "Um espectro de um antigo rei enlouquecido, cuja sede de poder o levou à ruína.",
                    2600,2100,"Demônio",true, Element.Trevas),
            new MonsterCard("O Mago Cinzento",
                    "O poderoso mago errante, conhecido por sua sabedoria e habilidades mágicas.",
                    2200,2500,"Feiticeiro",true, Element.Luz),
            new MonsterCard("O Espectro do Anel",
                    "Antigo rei corrompido pelo poder dos Anéis, agora servo do Senhor do Escuro.",
                    2700,2100,"Zumbi",true,Element.Trevas),
            new MonsterCard("O Pequeno Hobbit",
                    "Um ser pequenino que vive no condado e não gosta de aventuras, até ser convidado.",
                    1200,700,"Guerreiro",true, Element.Terra),
            new MonsterCard("Parry Hotter, O  Bruxo sobrevivente",
                    "Um jovem bruxo que sobreviveu à maldição da morte.",
                    2200,1900,"Feiticeiro",true,Element.Luz),
            new MonsterCard("Lord Valdemart, o Impronunciável",
                    "O mais temido bruxo das trevas",
                    2500,2800,"Feiticeiro",true, Element.Trevas),
            new MonsterCard("Tobby, Um Elfo Livre",
                    "Um elfo doméstico de grande coração, agora livre das amarras de seus antigos mestres.",
                    1300,500,"Elfo", true, Element.Vento)
    ));

    // TESTES PARA criarDeck()
    @Test
    public void deveCriarDoisDecksCom20Cartas(){

        Deck.criarDeck(cartasDeMonstro,deckDuelista1,deckDuelista2);

        Assert.assertEquals(10, deckDuelista1.getNumeroDeCartas());
        Assert.assertEquals(10,deckDuelista2.getNumeroDeCartas());
    }

    @Test
    public void deveLancarIllegalArgumentExceptionAoCriarDeckComMenosDe10Cartas(){
       List<Card> cartas = new ArrayList<>();
       cartas.add(carta);

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Deck.criarDeck(cartas,deckDuelista1,deckDuelista2);
        });
    }


    //TESTES PARA pegarUltimaCarta()

    //pegarUltimaCarta() em deck vazio deve retornar null
    @Test
    public void naoDevePegarUltimaCartaSeDeckVazio(){
        Assert.assertNull(deckDuelista1.pegarUltimaCarta());
    }

    // pegarUltimaCarta() com 1 carta no Deck
    @Test
    public void devePegarUltimaCartaSeDeckPossuirUmaCarta(){
        deckDuelista1.add(carta);
        Assert.assertEquals(carta,deckDuelista1.pegarUltimaCarta());
    }
    //pegarUltimaCarta() deve retornar a última carta inserida
    @Test
    public void devePegarUltimaCartaInserida(){
        MonsterCard carta2 = new MonsterCard("Tobby, Um Elfo Livre",
                "Um elfo doméstico de grande coração, agora livre das amarras de seus antigos mestres.",
                1300,500,"Elfo", true, Element.Vento);

        deckDuelista1.add(carta);
        deckDuelista1.add(carta2);

        Assert.assertEquals(carta2.getNome(),deckDuelista1.pegarUltimaCarta().getNome());
    }

    // TESTES PARA removerCarta()

    // removerCarta() deve remover a ultima carta e verificar a quantidade de cartas após a remoção
    @Test
    public void deveRemoverUltimaCartaECompararQuantidadeDeCartas(){
        MonsterCard carta2 =  new MonsterCard("Parry Hotter, O  Bruxo sobrevivente",
                "Um jovem bruxo que sobreviveu à maldição da morte.",
                2200,1900,"Feiticeiro",true,Element.Luz);

        deckDuelista1.add(carta);
        deckDuelista1.add(carta2);

        Card cartaRemovida = deckDuelista1.removerCarta();

        Assert.assertEquals(carta2.getNome(),cartaRemovida.getNome());
        Assert.assertEquals(1, deckDuelista1.getNumeroDeCartas());
    }

    // removerCarta() Deve retornar Null ao tentar remover a carta de um deck vazio
    @Test
    public void DeveRetornarNullAoTentarRemoverCartaDeDeckVazio(){
        Assert.assertNull(deckDuelista1.removerCarta());
    }

    // TESTES PARA add()
    @Test
    public void DeveAumentarONumeroDeCartasAoAdicionarUmaCarta(){
       deckDuelista1.add(carta);

       Assert.assertEquals(1,deckDuelista1.getNumeroDeCartas());
    }
}
