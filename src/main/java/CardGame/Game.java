package CardGame;

public class Game {
    public static void main(String[] args) {

        // CRIANDO JOGADORES
        Player jogador1 = new Player("Yugi", 4000, false);
        Player jogador2 = new Player("Kaiba", 4000, false);

        // CRIANDO CARTAS
        MonsterCard carta1 = new MonsterCard(
                "Mago Negro", "Um mago que usa magia negra",
                2500, 2100, "Humano", true, Element.Trevas);
        carta1.setModo(Mode.Ataque);
        MonsterCard carta2 = new MonsterCard(
                "Guerreiro Guardião Celta", "Guerreiro Feroz das florestas",
                1400, 1200, "Elfo", true, Element.Terra);
        carta2.setModo(Mode.Ataque);
        MonsterCard carta3 = new MonsterCard(
                "Dragão Branco de Olhos Azuis", "Dragão Branco que vive no alto das montanhas nevadas",
                3000, 2500, "Dragão", true, Element.Vento);
        carta3.setModo(Mode.Ataque);

        // CRIANDO BARALHOS
        Deck jogador1Baralho = new Deck();
        jogador1Baralho.adicionarCartas(carta1);
        jogador1Baralho.adicionarCartas(carta2);

        Deck jogador2Baralho = new Deck();
        jogador2Baralho.adicionarCartas(carta3);

        // CRIANDO MÃO
        Hand jogador1Mao = new Hand();
        Hand jogador2Mao = new Hand();

        // CRIAR CAMPOS
        Board jogador1Campo = new Board();
        Board jogador2Campo = new Board();

        // CRIAR BATALHA
        Battle batalhar = new Battle();


        // TESTE ADICIONAR CARTA NO CAMPO
//        if (!jogador1Mao.cartas.isEmpty()){
//            Card cartaSelecionada = jogador1Mao.removerCarta(0);
//            boolean adicionada = jogador1Campo.receberCarta(cartaSelecionada);
//
//            if (adicionada){
//                System.out.println(cartaSelecionada.nome + " Foi invocado no campo");
//            } else {
//                System.out.println("Não foi possivel adicionar esta carta ao campo");
//            }
//    }

        // SIMULAÇÃO DE TURNOS
        // COMPRAR CARTA NO INICIO DO TURNO

        // jogador1Mao.adicionarCarta(jogador1Baralho, jogador1);

        System.out.println("COMEÇO DO JOGO");
        System.out.println(" ");

        // TURNO UM
        System.out.println("TURNO UM");
        jogador1Mao.adicionarCarta(jogador1Baralho,jogador1);
        if (!jogador1Mao.cartas.isEmpty()){
            Card cartaJogada = jogador1Mao.removerCarta(0);
            jogador1Campo.receberCarta(cartaJogada, jogador1);
            System.out.println("FIM DE TURNO");
        }
        // FIM DE TURNO

        // TURNO DOIS
        System.out.println("TURNO DOIS");
        jogador2Mao.adicionarCarta(jogador2Baralho, jogador2);
        if (!jogador2Mao.cartas.isEmpty()){
            Card cartaJogada = jogador2Mao.removerCarta(0);
            jogador2Campo.receberCarta(cartaJogada, jogador2);
        }

        // BATALHA
        System.out.println("DUELO");
        if (!jogador2Campo.getSlotDeMonstro().isEmpty()){
            MonsterCard atacante = jogador2Campo.escolherMonstro(0);
            MonsterCard defensor = jogador1Campo.escolherMonstro(0);
            batalhar.golpe(atacante, defensor, jogador2, jogador1, jogador1Campo, jogador2Campo);
        }

        System.out.println("Pontos de vida de " + jogador1.nome + ": " + jogador1.getPontosDeVida());
        System.out.println("Pontos de vida de " + jogador2.nome + ": " + jogador2.getPontosDeVida());


    }

}
