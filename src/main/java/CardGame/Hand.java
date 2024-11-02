package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> cartas = new ArrayList<>();

    // METODOS
    public void adicionarCarta(Deck baralho){
        this.cartas.add(baralho.pegarUltimaCarta());
        baralho.removerCarta();
    }
}
