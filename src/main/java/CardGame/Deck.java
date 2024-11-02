package CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
        private List<Card> cartas = new ArrayList<>();


    // METODOS

        public void adicionarCartas(Card carta){
            this.cartas.add(carta);
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
