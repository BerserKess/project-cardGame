package CardGame;



public class Game {
    public static void main(String[] args) {

        // CRIANDO JOGADORES
        Player jogador1 = new Player("Yugi", 4000, false);
        jogador1.setSuaVez(true);
        Player jogador2 = new Player("Kaiba", 4000, false);
        jogador2.setSuaVez(false);

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
        //for (Card carta : deckDuelista1.getCartas()){
          //  System.out.println(carta.nome);
        //}


        jogador1.mostrarCartasNaMao(jogador1.cartasNaMao);

        // CRIAR CAMPOS
        Board boardDuelista1 = new Board();
        Board boardDuelista2 = new Board();
//
        // CRIAR BATALHA
        Battle duelo = new Battle();

        // CRIA MÃO DO JOGADOR
//
            jogador1.comprarCarta(deckDuelista1,jogador1);
            jogador1.comprarCarta(deckDuelista1,jogador1);
            jogador1.comprarCarta(deckDuelista1,jogador1);


            jogador2.comprarCarta(deckDuelista2,jogador2);
            jogador2.comprarCarta(deckDuelista2,jogador2);
            jogador2.comprarCarta(deckDuelista2,jogador2);
        // SIMULAÇÃO DE TURNOS
        if (jogador1.isSuaVez()){
            if (!jogador1.cartasNaMao.isEmpty()){
                Card cartaJogada = jogador1.removerCartasDaMao(1);
                boardDuelista1.receberCarta(cartaJogada,jogador1,0);
                jogador1.setSuaVez(false);
            }
                System.out.println("FIM DO TURNO");

        }

        // TURNO 2
        jogador2.setSuaVez(true);
        if (jogador2.isSuaVez()) {
            Card cartaJogada = jogador2.removerCartasDaMao(0);
            boardDuelista2.receberCarta(cartaJogada,jogador2,0);
        }

        // BATALHA
        if (!boardDuelista2.getSlotDeMonstro().isEmpty()){
        MonsterCard atacante = boardDuelista2.escolherMonstro(0);
        MonsterCard defensor = boardDuelista1.escolherMonstro(0);
        duelo.golpe(atacante, defensor, jogador2, jogador1, boardDuelista1, boardDuelista2);
        }

        System.out.println("Pontos de vida de " + jogador1.nome + ": " + jogador1.getPontosDeVida());
        System.out.println("Pontos de vida de " + jogador2.nome + ": " + jogador2.getPontosDeVida());


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
//    public void duelistaDaVez(Player duelista, Deck deck, Battle duelo, Board campo){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("O que deseja fazer " + duelista.nome + " ?");
//        System.out.println("1 - Comprar carta\n");
//        System.out.println("2 - Duelo\n");
//        System.out.println("3 - Finalizar Turno\n");
//        int opcao = scanner.nextInt();
//
//        switch (opcao){
//            case 1:
//                duelista.comprarCarta(deck,duelista);
//                break;
//            case 2:
//                if (!campo.getSlotDeMonstro().isEmpty()){
//                    MonsterCard atacante = campo.escolherMonstro(0);
//                    MonsterCard defensor = campo.escolherMonstro(0);
//                    duelo.golpe(atacante, defensor, jogador2, jogador1, jogador1Campo, jogador2Campo);
//                }
//        }
//
//
//
//    }

}
