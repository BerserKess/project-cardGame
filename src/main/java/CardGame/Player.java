package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String nome;
    public int PontosDeVida;
    private boolean suaVez;
    public List<Card> cartasNaMao = new ArrayList<>();

    //CONSTRUCTOR

    public Player(String nome, int pontosDeVida, boolean suaVez) {
        this.nome = nome;
        PontosDeVida = pontosDeVida;
        this.suaVez = suaVez;
    }


    //GET AND SETTERS

    public int getPontosDeVida() {
        return PontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        PontosDeVida = pontosDeVida;
    }

    public boolean isSuaVez() {
        return suaVez;
    }

    public void setSuaVez(boolean suaVez) {
        this.suaVez = suaVez;
    }

    // METODOS
    public void comprarCarta(Deck deck, Player jogador){
        if (cartasNaMao.size() <= 5){
            Card cartaComprada = deck.pegarUltimaCarta();
            cartasNaMao.add(cartaComprada);
            deck.removerCarta();
            System.out.println("A carta comprada por "
                    + jogador.nome + " foi: " + cartaComprada.nome);

        }
        else {
            System.out.println("Você só pode ter 5 cartas na mão.");
        }
    }

    public Card removerCartasDaMao(int index){
        if (index >= 0 && index <= cartasNaMao.size()){
            return cartasNaMao.remove(index);
        }
        else {
            System.out.println("Indice inválido");
            return null;
        }
    }

    public void mostrarCartasNaMao(List<Card> cartas){
       for (int i = 0; i < cartas.size(); i++){
           System.out.println(i + " - " + cartas.get(i).nome);
       }
    }

    public void finalizarTurno(){
        setSuaVez(false);
    }
}
