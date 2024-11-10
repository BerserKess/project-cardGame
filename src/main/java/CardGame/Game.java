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

        for (Card carta : cartasDeMonstro) {
            if (carta instanceof MonsterCard) {
                MonsterCard monstro = (MonsterCard) carta; // CASTING
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

            while ((jogador1.getPontosDeVida() > 0 && jogador2.getPontosDeVida() > 0)) {
                // EXIBIR PONTOS DE VIDA
                System.out.println("\n");
                System.out.println("*****************************");
                System.out.println("Pontos de vida de " + jogador1.nome + ": " + jogador1.getPontosDeVida());
                System.out.println("Pontos de vida de " + jogador2.nome + ": " + jogador2.getPontosDeVida());
                System.out.println("*****************************");
                System.out.println("\n");

                // TURNOS
                if (jogador1.isSuaVez()) {
                    if (deckDuelista1.cartas.isEmpty()){
                        // VERIFICAÇÃO PARA ENCERRAR A PARTIDA SE O DECK ESTIVER VAZIO
                        System.out.println("As cartas do duelista " + jogador1.nome + " acabaram");
                        break;
                    }
                    if (jogador1.getPontosDeVida() <= 0){
                        System.out.println(jogador1.nome + " ficou sem pontos de vida");
                        break;
                    }
                    jogador1.comprarCarta(deckDuelista1, jogador1);
                    System.out.println("Restam " + deckDuelista1.getNumeroDeCartas() + " no deck");
                    System.out.println("\n");
                    duelistaDaVez(jogador1, deckDuelista1, duelo, boardDuelista1, jogador2, boardDuelista2);
                    jogador1.finalizarTurno();
                    jogador2.setSuaVez(true);
                }
                System.out.println("\n");
                System.out.println("*****************************");
                System.out.println("Pontos de vida de " + jogador1.nome + ": " + jogador1.getPontosDeVida());
                System.out.println("Pontos de vida de " + jogador2.nome + ": " + jogador2.getPontosDeVida());
                System.out.println("*****************************");
                System.out.println("\n");

                // Turno do Jogador 2
                if (jogador2.isSuaVez()) {
                    if (deckDuelista2.cartas.isEmpty()){
                        System.out.println("As cartas do duelista " + jogador2.nome + " acabaram");
                        break;
                    }
                    if (jogador2.getPontosDeVida() <= 0){
                        System.out.println(jogador2.nome + " ficou sem pontos de vida");
                        break;
                    }
                    jogador2.comprarCarta(deckDuelista2, jogador2);
                    System.out.println("Restam " + deckDuelista1.getNumeroDeCartas() + " no deck");
                    System.out.println("\n");
                    duelistaDaVez(jogador2, deckDuelista2, duelo, boardDuelista2, jogador1, boardDuelista1);
                    jogador2.finalizarTurno();
                    jogador1.setSuaVez(true);
                }


            }

            // VERIFICAÇÃO DE VITÓRIA
            if (jogador1.getPontosDeVida() <= 0 || deckDuelista1.cartas.isEmpty()) {
                System.out.println(jogador2.nome + " venceu!");
            } else if (jogador2.getPontosDeVida() <= 0 || deckDuelista2.cartas.isEmpty()) {
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
        System.out.println("1 - Jogar um monstro");
        System.out.println("2 - Atacar");
        System.out.println("3 - Finalizar Turno");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // LIMPAR BUFFER

        switch (opcao) {
            case 1:
                duelista.mostrarCartasNaMao(duelista.cartasNaMao);
                System.out.println("Escolha um índice da carta para jogar:");
                int indiceCarta = scanner.nextInt();
                if (indiceCarta >= 0 && indiceCarta < duelista.cartasNaMao.size()) {
                    Card cartaJogada = duelista.removerCartasDaMao(indiceCarta);
                    if (cartaJogada instanceof MonsterCard) {
                        System.out.println("Deseja colocar o monstro em que modo?");
                        System.out.println("1 - Ataque");
                        System.out.println("2 - Defesa");
                        int escolhaDeModo = scanner.nextInt();
                        scanner.nextLine();
                        switch (escolhaDeModo){
                            case 1:
                                ((MonsterCard) cartaJogada).setModo(Mode.Ataque);
                                campoDoDuelista.receberCarta((MonsterCard) cartaJogada, duelista);
                                break;
                            case  2:
                                ((MonsterCard) cartaJogada).setModo(Mode.Defesa);
                                campoDoDuelista.receberCarta((MonsterCard) cartaJogada, duelista);
                                break;
                            default:
                                System.out.println("Escolha inválida");
                        }
                    } else {
                        System.out.println("A carta jogada não é um monstro!");
                    }
                } else {
                    System.out.println("Índice inválido.");
                }
                break;
            case 2:
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
                    }
                } else {
                    System.out.println("Você não tem monstros no campo para atacar.");
                }
                break;
            case 3:
                duelista.finalizarTurno();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}