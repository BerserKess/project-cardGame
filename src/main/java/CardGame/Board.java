package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<MonsterCard> slotDeMonstro = new ArrayList<>();
    private List<MagicCard> slotDeMagia = new ArrayList<>();
    public  static final int MAX_DE_CARTAS_NO_CAMPO = 5;

    // GETTER
    public List<MonsterCard> getSlotDeMonstro() {
        return slotDeMonstro;
    }

    // METODOS
    public MonsterCard escolherMonstro(int index){
        if (index >= 0 && index < slotDeMonstro.size()){
            return slotDeMonstro.get(index);
        }
        else {
            System.out.println("Indice inválido");
            return null;
        }
    }

    public void receberCarta(Card carta, Player jogador, int index){
        if (carta instanceof MonsterCard) {
            if (slotDeMonstro.size() < MAX_DE_CARTAS_NO_CAMPO){
                slotDeMonstro.add((MonsterCard) carta);
                System.out.println("Carta colocada no campo pelo duelista "
                        + jogador.nome + " foi: " + carta.nome);
                jogador.removerCartasDaMao(index);
            }
            else {
                System.out.println("Não tem mais espaço para colocar cartas");
            }
        }
        else if (carta instanceof MagicCard) {
            if (slotDeMagia.size() < MAX_DE_CARTAS_NO_CAMPO){
                slotDeMagia.add((MagicCard) carta);
                System.out.println("Carta colocada no campo pelo duelista "
                        + jogador.nome + " foi: " + carta.nome);
                jogador.removerCartasDaMao(index);
            }
            else {
                System.out.println("Não tem mais espaço para colocar cartas");
            }
        }

    }
}
