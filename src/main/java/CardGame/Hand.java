package CardGame;

import java.util.List;

public class Hand {
    public List<Card> cartas;

    // METODOS
    public void adicionarCarta(Deck baralho){
        this.cartas.add(baralho.pegarUltimaCarta());
        baralho.removerCarta();
    }
}
