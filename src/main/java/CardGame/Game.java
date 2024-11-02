package CardGame;

import java.util.Collections;

public class Game {
    public static void main(String[] args) {

        // CRIANDO JOGADORES
        Player jogador1 = new Player("Yugi", 4000, false);
        Player jogador2 = new Player("Kaiba", 4000, false);

        // CRIANDO CARTAS
        MonsterCard carta1 = new MonsterCard(
                "Mago Negro", "Um mago que usa magia negra",
                2500, 2100, "Elfo", true, Element.Trevas);
        MonsterCard carta2 = new MonsterCard(
                "Guerreiro Guardião Celta", "Guerreiro Feroz das florestas",
                1400, 1200, "Elfo", true, Element.Terra);
        MonsterCard carta3 = new MonsterCard(
                "Dragão Branco de Olhos Azuis", "Dragão Branco que vive no alto das montanhas nevadas",
                3000, 2500, "Dragão", true, Element.Vento);

        // CRIANDO BARALHOS
        Deck jogador1Baralho = new Deck();
        jogador1Baralho.adicionarCartas(carta1);
        jogador1Baralho.adicionarCartas(carta2);

        Deck jogador2Baralho = new Deck();
        jogador2Baralho.adicionarCartas(carta3);

        // EXEMPLO DE BATALHA
        System.out.println("Iniciando a batalha entre " + jogador1.getName() + " e " + jogador2.getName() + "!");
        realizarBatalha(jogador1, jogador2, carta1, carta3);
    }

    public static void realizarBatalha(Player jogador1, Player jogador2, MonsterCard cartaJogador1, MonsterCard cartaJogador2) {
        System.out.println(jogador1.getName() + " escolheu " + cartaJogador1.getNome());
        System.out.println(jogador2.getName() + " escolheu " + cartaJogador2.getNome());

        // COMPARANDO ATAQUES DAS CARTAS
        if (cartaJogador1.getAtaque() > cartaJogador2.getAtaque()) {
            System.out.println(cartaJogador1.getNome() + " venceu a batalha!");
            jogador2.setLifePoints(jogador2.getLifePoints() - (cartaJogador1.getAtaque() - cartaJogador2.getAtaque()));
        } else if (cartaJogador1.getAtaque() < cartaJogador2.getAtaque()) {
            System.out.println(cartaJogador2.getNome() + " venceu a batalha!");
            jogador1.setLifePoints(jogador1.getLifePoints() - (cartaJogador2.getAtaque() - cartaJogador1.getAtaque()));
        } else {
            System.out.println("A batalha terminou em empate!");
        }

        // MOSTRANDO OS PONTOS DE VIDA APÓS A BATALHA
        System.out.println(jogador1.getName() + " agora tem " + jogador1.getLifePoints() + " pontos de vida.");
        System.out.println(jogador2.getName() + " agora tem " + jogador2.getLifePoints() + " pontos de vida.");
    }
}
