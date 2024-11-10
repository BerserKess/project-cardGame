package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<MonsterCard> slotDeMonstro;

    public Board() {
        this.slotDeMonstro = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            slotDeMonstro.add(null);
        }
    }
    // METODO PARA RECEBER A CARTA NO CAMPO
    public void receberCarta(MonsterCard carta, Player jogador) {
        boolean cartaColocada = false;

        for (int i = 0; i < slotDeMonstro.size(); i++){
            if(slotDeMonstro.get(i) == null){
                slotDeMonstro.set(i, carta);
                System.out.println(jogador.nome + " jogou " + carta.nome + " no campo. em modo de " + carta.getModo());
                cartaColocada = true;
                break;
            }
        }

        if (!cartaColocada){
            System.out.println("teste");
        }



    }

    // MOSTRAR OS MONSTROS DO CAMPO
    public void mostrarMonstros() {
        for (int i = 0; i < slotDeMonstro.size(); i++) {
            MonsterCard monstro = slotDeMonstro.get(i);
            if (monstro != null) {
                System.out.println(i + " - " + slotDeMonstro.get(i).nome);

            }
            else {
                System.out.println(i + " -  slot vazio");
            }
        }
    }

    public MonsterCard escolherMonstro(int indice) {
        return slotDeMonstro.get(indice); // Retorna o monstro no slot escolhido
    }

    public List<MonsterCard> getSlotDeMonstro() {
        return slotDeMonstro;
    }

    // VERIFICAR SE TODOS OS SLOTS ESTÃO VAZIOS
    public boolean todosOsSlotsVazios(){
        for (MonsterCard monstro : slotDeMonstro){
            if (monstro != null){
                return false;
            }
        }

        return true;
    }
}