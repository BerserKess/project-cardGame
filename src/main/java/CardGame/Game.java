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
                new MonsterCard("Mago Negro", "Um mago que usa magia negra", 2500, 2100, "Feiticeiro", true, Element.Trevas),
                new MonsterCard("Guerreiro Guardião Celta", "Guerreiro Feroz das florestas", 1400, 1200, "Elfo", true, Element.Terra),
                new MonsterCard("Dragão Branco de Olhos Azuis", "Dragão Branco que vive no alto das montanhas nevadas", 3000, 2500, "Dragão", true, Element.Vento),
                new MonsterCard("Mago do Tempo", "Um pequeno mago capaz de viajar no tempo", 500, 400, "Feiticeiro", true, Element.Trevas),
                new MonsterCard("Saggi, o Palhaço Sombrio", "Este palhaço aparece do nada e usa movimentos estranhos para se esquivar de ataques inimigos.", 600, 1500, "Demônio", true, Element.Trevas),
                new MonsterCard("Gigante Hitotsu-me", "Um gigante de um olho só com braços largos e poderosos.", 1200, 1000, "Besta-Guerreira", true, Element.Terra),
                new MonsterCard("Fênix", "Uma fênix renascente", 2200, 1800, "Fogo", true, Element.Fogo),
                new MonsterCard("Lobo", "Um lobo feroz", 1400, 1200, "Ar", true, Element.Agua),
                new MonsterCard("Zumbi", "Um zumbi vagante", 1300, 1100, "Trevas", true, Element.Trevas),
                new MonsterCard("Cavaleiro", "Um cavaleiro destemido", 1600, 1400, "Luz", true, Element.Luz))

        );
        for (Card carta : cartasDeMonstro) {
            if (carta instanceof MonsterCard) {
                MonsterCard monstro = (MonsterCard) carta; // Casting seguro
                System.out.println("Monstro: " + monstro.getNome() + ", Ataque: " + monstro.getAtaque());
            } else {
                System.out.println("Esta carta não é um monstro.");
            }
        }

        // CRIANDO DECKS
        Deck deckDuelista1 = new Deck();
        Deck deckDuelista2 = new Deck();
        Deck.criarDeck(cartasDeMonstro, deckDuelista1, deckDuelista2);

        // CRIAR CAMPOS
        Board boardDuelista1 = new Board();
        Board boardDuelista2 = new Board();
        // CRIAR BATALHA
        Battle duelo = new Battle();

        System.out.println("Olá, você gostaria de jogar?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
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
            jogador1.comprarCarta(deckDuelista1, jogador1);
            jogador1.comprarCarta(deckDuelista1, jogador1);
            jogador1.comprarCarta(deckDuelista1, jogador1);

            jogador2.comprarCarta(deckDuelista2, jogador2);
            jogador2.comprarCarta(deckDuelista2, jogador2);
            jogador2.comprarCarta(deckDuelista2, jogador2);

            while (jogador1.getPontosDeVida() > 0 && jogador2.getPontosDeVida() > 0) {
                // Turno do Jogador 1
                if (jogador1.isSuaVez()) {
                    duelistaDaVez(jogador1, deckDuelista1, duelo, boardDuelista1, jogador2, boardDuelista2);
                    jogador1.finalizarTurno();
                    jogador2.setSuaVez(true);
                }

                // Turno do Jogador 2
                if (jogador2.isSuaVez()) {
                    duelistaDaVez(jogador2, deckDuelista2, duelo, boardDuelista2, jogador1, boardDuelista1);
                    jogador2.finalizarTurno();
                    jogador1.setSuaVez(true);
                }

                // Exibir pontos de vida
                System.out.println("Pontos de vida de " + jogador1.nome + ": " + jogador1.getPontosDeVida());
                System.out.println("Pontos de vida de " + jogador2.nome + ": " + jogador2.getPontosDeVida());
            }

            // Verificar quem venceu
            if (jogador1.getPontosDeVida() <= 0) {
                System.out.println(jogador2.nome + " venceu!");
            } else {
                System.out.println(jogador1.nome + " venceu!");
            }
        } else {
            System.out.println("Obrigado por jogar!");
        }

        scanner.close();
    }

    public static void duelistaDaVez(Player duelista, Deck deck, Battle duelo, Board campoDoDuelista, Player oponente, Board campoDoOponente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que deseja fazer " + duelista.nome + "?");
        System.out.println("1 - Comprar carta");
        System.out.println("2 - Jogar um monstro");
        System.out.println("3 - Atacar");
        System.out.println("4 - Finalizar Turno");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        switch (opcao) {
            case 1:
                duelista.comprarCarta(deck, duelista);
                break;
            case 2:
                duelista.mostrarCartasNaMao(duelista.cartasNaMao);
                System.out.println("Escolha um índice da carta para jogar:");
                int indiceCarta = scanner.nextInt();
                if (indiceCarta >= 0 && indiceCarta < duelista.cartasNaMao.size()) {
                    Card cartaJogada = duelista.removerCartasDaMao(indiceCarta);
                    if (cartaJogada instanceof MonsterCard) {
                        campoDoDuelista.receberCarta((MonsterCard) cartaJogada, duelista, 0); // Supondo que jogue no slot 0
                    } else {
                        System.out.println("A carta jogada não é um monstro!");
                    }
                } else {
                    System.out.println("Índice inválido.");
                }
                break;
            case 3:
                if (!campoDoDuelista.getSlotDeMonstro().isEmpty()) {
                    System.out.println("Escolha um monstro para atacar:");
                    campoDoDuelista.mostrarMonstros();
                    int indiceAtacante = scanner.nextInt();
                    MonsterCard atacante = campoDoDuelista.escolherMonstro(indiceAtacante);

                    if (!campoDoOponente.getSlotDeMonstro().isEmpty()) {
                        System.out.println("Escolha um monstro do oponente para atacar:");
                        campoDoOponente.mostrarMonstros();
                        int indiceDefensor = scanner.nextInt();
                        MonsterCard defensor = campoDoOponente.escolherMonstro(indiceDefensor);
                        duelo.golpe(atacante, defensor, duelista, oponente, campoDoOponente, campoDoDuelista);
                    } else {
                        // Ataque direto se não houver monstros no campo do oponente
                        duelo.golpe(atacante, null, duelista, oponente, campoDoOponente, campoDoDuelista);
                    }
                } else {
                    System.out.println("Você não tem monstros no campo para atacar.");
                }
                break;
            case 4:
                duelista.finalizarTurno();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}