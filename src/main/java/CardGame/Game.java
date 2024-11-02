package CardGame;

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


    }
}
