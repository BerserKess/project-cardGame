package CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
        private List<Card> cartas = new ArrayList<>();

    public List<Card> getCartas() {
        return cartas;
    }

    // METODOS

        public void criarDeck(Card[] cartas){
            Collections.addAll(this.cartas,cartas);
        }

        public void embaralhar(){
            Collections.shuffle(cartas);
        }

        public void removerCarta(){
            cartas.remove(cartas.size() - 1);
        }
        public Card pegarUltimaCarta(){
           return cartas.get(cartas.size() - 1);
        }
}
