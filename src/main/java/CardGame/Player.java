package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String nome;
    private int pontosDeVida;
    private boolean suaVez;
    List<Card> cartasNaMao;

    public Player(String nome, int pontosDeVida, boolean suaVez) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.suaVez = suaVez;
        this.cartasNaMao = new ArrayList<>();
    }

    public void comprarCarta(Deck deck, Player jogador) {
        if (!deck.cartas.isEmpty()) {
            Card carta = deck.cartas.remove(0); // Remove a carta do deck e adiciona à mão do jogador
            cartasNaMao.add(carta);
            System.out.println(jogador.nome + " comprou " + carta.nome);
        } else {
            System.out.println("O deck está vazio.");
        }
    }

    public Card removerCartasDaMao(int indice) {
        return cartasNaMao.remove(indice); // Remove e retorna a carta da mão
    }

    public void mostrarCartasNaMao(List<Card> cartas) {
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println(i + " - " + cartas.get(i).nome);
        }
    }

    public void finalizarTurno() {
        this.suaVez = false;
    }



    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public boolean isSuaVez() {
        return suaVez;
    }

    public void setSuaVez(boolean suaVez) {
        this.suaVez = suaVez;
    }
}