package CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cartas;

    // CONSTRUTOR
    public Deck() {
        this.cartas = new ArrayList<>();
    }

    // GETTER
    public List<Card> getCartas() {
        return cartas;
    }

    // METODOS
        // ADICIONAR CARTA AO DECK
    public void add(Card carta){
        this.cartas.add(carta);
    }

    public static void criarDeck(List<Card> cartas, Deck deck1, Deck deck2){
        Collections.shuffle(cartas);

        for (int i =0; i < cartas.size(); i++){
            if (i % 2 == 0){
                deck1.add(cartas.get(i));
            }
            else {
                deck2.add(cartas.get(i));
            }
        }

    }

    public void exibirCartas(){
        for (Card carta : cartas){
            System.out.println(carta.nome);
        }
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
