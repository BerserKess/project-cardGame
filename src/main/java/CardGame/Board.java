package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<MonsterCard> slotDeMonstro;

    public Board() {
        this.slotDeMonstro = new ArrayList<>();
    }

    public void receberCarta(MonsterCard carta, Player jogador, int slot) {
        if (slot < slotDeMonstro.size()) {
            slotDeMonstro.set(slot, carta);
            System.out.println(jogador.nome + " jogou " + carta.nome + " no campo. em modo de " + carta.getModo());
        } else {
            slotDeMonstro.add(carta); // Adiciona a carta ao campo
            System.out.println(jogador.nome + " jogou " + carta.nome + " no campo.");
        }
    }

    public void mostrarMonstros() {
        for (int i = 0; i < slotDeMonstro.size(); i++) {
            System.out.println(i + " - " + slotDeMonstro.get(i).nome);
        }
    }

    public MonsterCard escolherMonstro(int indice) {
        return slotDeMonstro.get(indice); // Retorna o monstro no slot escolhido
    }

    public List<MonsterCard> getSlotDeMonstro() {
        return slotDeMonstro;
    }
}