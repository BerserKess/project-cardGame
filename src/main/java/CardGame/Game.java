package CardGame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // CRIANDO CARTAS
        List<Card> cartasDeMonstro = new ArrayList<>(Arrays.asList(
        new MonsterCard("Mago Negro", "Um mago que usa magia negra",
                2500, 2100, "Feiticeiro", true, Element.Trevas),
        new MonsterCard("Guerreiro Guardião Celta","Guerreiro Feroz das florestas",
                1400, 1200, "Elfo", true, Element.Terra),
        new MonsterCard("Dragão Branco de Olhos Azuis",
                "Dragão Branco que vive no alto das montanhas nevadas",
                3000, 2500, "Dragão", true, Element.Vento),
        new MonsterCard("Mago do Tempo", "Um pequeno mago capaz de viajar no tempo",
                500,400,"Feiticeiro",true,Element.Trevas),
        new MonsterCard("Saggi, o Palhaço Sombrio",
                "Este palhaço aparece do nada e usa movimentos estranhos para se esquivar de ataques inimigos.",
                600,1500,"Demônio",true,Element.Trevas),
        new MonsterCard("Gigante Hitotsu-me","Um gigante de um olho só com braços largos e poderosos.",
                1200,1000,"Besta-Guerreira",true,Element.Terra)
        ));

        // CRIANDO DECKS
        Deck deckDuelista1 = new Deck();
        Deck deckDuelista2 = new Deck();

        Deck.criarDeck(cartasDeMonstro,deckDuelista1,deckDuelista2);

//        System.out.println("Deck do duelista 1: ");
//        deckDuelista1.exibirCartas();
//        System.out.println("Deck do duelista 2: ");
//        deckDuelista2.exibirCartas();

        // CRIAR CAMPOS
        Board boardDuelista1 = new Board();
        Board boardDuelista2 = new Board();
        // CRIAR BATALHA
        Battle duelo = new Battle();


        System.out.println("Olá, você gostaria de jogar?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int option = scanner.nextInt();

        if (option == 1){
            // CRIANDO JOGADORES
            System.out.println("Informe o nome do duelista 1: ");
            String duelista1 = scanner.nextLine();
            System.out.println("Informe o nome do duelista 2: ");
            String duelista2 = scanner.nextLine();

            Player jogador1 = new Player(duelista1, 4000, false);
            jogador1.setSuaVez(true);
            Player jogador2 = new Player(duelista2, 4000, false);
            jogador2.setSuaVez(false);

            // CARTAS NA MÃO DOS JOGADORES
            jogador1.comprarCarta(deckDuelista1,jogador1);
            jogador1.comprarCarta(deckDuelista1,jogador1);
            jogador1.comprarCarta(deckDuelista1,jogador1);

            jogador2.comprarCarta(deckDuelista2,jogador2);
            jogador2.comprarCarta(deckDuelista2,jogador2);
            jogador2.comprarCarta(deckDuelista2,jogador2);

            while (jogador1.getPontosDeVida() > 0 || jogador2.getPontosDeVida() > 0){



            }
            if (jogador1.getPontosDeVida() <= 0){
                System.out.println(jogador2.nome + " É o vencedor!");
            }
            else if (jogador2.getPontosDeVida() <= 0){
                System.out.println(jogador1.nome + " É o vencedor!");
            }

        }
        else {
            System.out.println("Obrigado");
            System.out.println("Saindo");
        }

        // CRIANDO JOGADORES





        // mostrar cartas do deck
        //for (Card carta : deckDuelista1.getCartas()){
          //  System.out.println(carta.nome);
        //}


//        jogador1.mostrarCartasNaMao(jogador1.cartasNaMao);


//


        // CRIA MÃO DO JOGADOR
//
//            jogador1.comprarCarta(deckDuelista1,jogador1);
//            jogador1.comprarCarta(deckDuelista1,jogador1);
//            jogador1.comprarCarta(deckDuelista1,jogador1);
//
//
//            jogador2.comprarCarta(deckDuelista2,jogador2);
//            jogador2.comprarCarta(deckDuelista2,jogador2);
//            jogador2.comprarCarta(deckDuelista2,jogador2);
        // SIMULAÇÃO DE TURNOS
//        if (jogador1.isSuaVez()){
//            if (!jogador1.cartasNaMao.isEmpty()){
//                Card cartaJogada = jogador1.removerCartasDaMao(1);
//                boardDuelista1.receberCarta(cartaJogada,jogador1,0);
//                jogador1.setSuaVez(false);
//            }
//                System.out.println("FIM DO TURNO");
//
//        }
//
//        // TURNO 2
//        jogador2.setSuaVez(true);
//        if (jogador2.isSuaVez()) {
//            Card cartaJogada = jogador2.removerCartasDaMao(0);
//            boardDuelista2.receberCarta(cartaJogada,jogador2,0);
//        }
//
//        // BATALHA
//        if (!boardDuelista2.getSlotDeMonstro().isEmpty()){
//        MonsterCard atacante = boardDuelista2.escolherMonstro(0);
//        MonsterCard defensor = boardDuelista1.escolherMonstro(0);
//        duelo.golpe(atacante, defensor, jogador2, jogador1, boardDuelista1, boardDuelista2);
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
