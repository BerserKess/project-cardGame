package CardGame;

public class Game {
    public static void main(String[] args) {

        // CRIANDO JOGADORES
        Player jogador1 = new Player("Yugi", 4000, false);
        Player jogador2 = new Player("Kaiba", 4000, false);

        // CRIANDO CARTAS
        MonsterCard magoNegro = new MonsterCard(
                "Mago Negro", "Um mago que usa magia negra",
                2500, 2100, "Humano", true, Element.Trevas);
//        magoNegro.setModo(Mode.Ataque);
        MonsterCard guardiaoCelta = new MonsterCard(
                "Guerreiro Guardião Celta",
                "Guerreiro Feroz das florestas",
                1400, 1200, "Elfo", true, Element.Terra);
//        guardiaoCelta.setModo(Mode.Ataque);
        MonsterCard dragaoBranco = new MonsterCard(
                "Dragão Branco de Olhos Azuis",
                "Dragão Branco que vive no alto das montanhas nevadas",
                3000, 2500, "Dragão", true, Element.Vento);
//        dragaoBranco.setModo(Mode.Ataque);
        MonsterCard magoDoTempo = new MonsterCard("Mago do Tempo",
                "Um pequeno mago capaz de viajar no tempo", 500,400,
                "Feiticeiro",true,Element.Trevas);
        MonsterCard darkClown = new MonsterCard("Saggi, o Palhaço Sombrio",
                "Este palhaço aparece do nada e usa movimentos estranhos para se esquivar de ataques inimigos.",
                600,1500,"Demônio",true,Element.Trevas);
        MonsterCard hitotsume = new MonsterCard("Gigante Hitotsu-me",
                "Um gigante de um olho só com braços largos e poderosos.",
                1200,1000,"Besta-Guerreira",true,Element.Terra);

        // CRIANDO BARALHOS
        Card[] cartasDuelista1 = {magoNegro,magoDoTempo,guardiaoCelta};
        Card[] cartasDuelista2 = {dragaoBranco,darkClown,hitotsume};
        Deck deckDuelista1 = new Deck();
        Deck deckDuelista2 = new Deck();
        deckDuelista1.criarDeck(cartasDuelista1);
        deckDuelista1.embaralhar();
        deckDuelista2.criarDeck(cartasDuelista2);

        // mostrar cartas do deck
        for (Card carta : deckDuelista1.getCartas()){
            System.out.println(carta.nome);
        }

        jogador1.comprarCarta(deckDuelista1,jogador1);
        jogador1.comprarCarta(deckDuelista1,jogador1);
        jogador1.mostrarCartasNaMao(jogador1.cartasNaMao);


        // CRIANDO MÃO
//        Hand jogador1Mao = new Hand();
//        Hand jogador2Mao = new Hand();
//
        // CRIAR CAMPOS
        Board boardDuelista1 = new Board();
        Board boardDuelista2 = new Board();
//
        // CRIAR BATALHA
//        Battle batalhar = new Battle();
//
        // SIMULAÇÃO DE TURNOS
        // COMPRAR CARTA NO INICIO DO TURNO
//
//        // jogador1Mao.adicionarCarta(jogador1Baralho, jogador1);
//
//        System.out.println("COMEÇO DO JOGO");
//        System.out.println(" ");
//
        // TURNO UM
//        System.out.println("TURNO UM");
//        jogador1Mao.adicionarCarta(jogador1Baralho,jogador1);
//        if (!jogador1Mao.cartas.isEmpty()){
//            Card cartaJogada = jogador1Mao.removerCarta(0);
//            jogador1Campo.receberCarta(cartaJogada, jogador1);
//            System.out.println("FIM DE TURNO");
//        }
        // FIM DE TURNO
//
        // TURNO DOIS
//        System.out.println("TURNO DOIS");
//        jogador2Mao.adicionarCarta(jogador2Baralho, jogador2);
//        if (!jogador2Mao.cartas.isEmpty()){
//            Card cartaJogada = jogador2Mao.removerCarta(0);
//            jogador2Campo.receberCarta(cartaJogada, jogador2);
//        }
//
       // BATALHA
//        System.out.println("DUELO");
//        if (!jogador2Campo.getSlotDeMonstro().isEmpty()){
//            MonsterCard atacante = jogador2Campo.escolherMonstro(0);
//            MonsterCard defensor = jogador1Campo.escolherMonstro(0);
//            batalhar.golpe(atacante, defensor, jogador2, jogador1, jogador1Campo, jogador2Campo);
//        }
//
//        System.out.println("Pontos de vida de " + jogador1.nome + ": " + jogador1.getPontosDeVida());
//        System.out.println("Pontos de vida de " + jogador2.nome + ": " + jogador2.getPontosDeVida());


    }

}
