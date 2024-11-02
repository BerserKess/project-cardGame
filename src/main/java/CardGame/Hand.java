package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> cartas = new ArrayList<>();

    // METODOS

    // ADICIONAR CARTAS A MÃO
    public void adicionarCarta(Deck baralho, Player jogador){
        if (!baralho.getCartas().isEmpty()){
            Card cartaComprada = baralho.pegarUltimaCarta();
            this.cartas.add(cartaComprada);
            baralho.removerCarta();
            System.out.println("A carta comprada por "
                    + jogador.nome + " foi: " + cartaComprada.nome);
        }
         else {
            System.out.println("O baralho está vazio");
        }
    }

    // REMOVER CARTAS DA MÃO QUANDO FOR PARA O CAMPO
    public Card removerCarta(int index){
        if (index >= 0 && index < cartas.size()){
            return cartas.remove(index);
        }
        else {
            System.out.println("indice inválido!");
            return null;
        }
    }
}


