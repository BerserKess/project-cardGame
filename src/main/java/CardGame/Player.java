package CardGame;

import java.util.List;

public class Player {
    public String nome;
    public int PontosDeVida;
    private boolean suaVez;

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
}
