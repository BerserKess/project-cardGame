package CardGame;

public class Battle {
    public void golpe(MonsterCard atacante, MonsterCard defensor, Player jogadorAtacante, Player jogadorDefensor, Board campoDoDefensor, Board campoDoAtacante) {
        // Aqui você pode definir o modo do atacante e do defensor conforme necessário
        // Por exemplo, você pode ter uma lógica que determina o modo com base no turno
        // Para fins de exemplo, vamos definir o modo manualmente
        // atacante.setModo(Mode.Ataque); // Defina o modo do atacante
        // defensor.setModo(Mode.Defesa); // Defina o modo do defensor

        // SE O JOGADOR DEFENSOR NÃO TIVER NENHUM MONSTRO NO CAMPO, ELE SOFRE UM ATAQUE DIRETO
        if (campoDoDefensor.getSlotDeMonstro().isEmpty()) {
            int dano = atacante.getAtaque();
            jogadorDefensor.setPontosDeVida(jogadorDefensor.getPontosDeVida() - dano);
            System.out.println("Ataque Direto de " + atacante.getNome() + " causou " + dano +
                    " de dano ao duelista " + jogadorDefensor.getNome());
        } else {
            // CASO O DEFENSOR ESTEJA EM MODO DE DEFESA
            if (defensor.getModo() == Mode.Defesa) {
                if (atacante.getAtaque() > defensor.getDefesa()) {
                    System.out.println(defensor.getNome() + " foi obliterado do campo!");
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                } else if (atacante.getAtaque() == defensor.getDefesa()) {
                    System.out.println(atacante.getNome() + " não conseguiu superar a defesa de " + defensor.getNome());
                } else {
                    int dano = defensor.getDefesa() - atacante.getAtaque();
                    System.out.println(atacante.getNome() + " não foi páreo para a defesa de " + defensor.getNome());
                    jogadorAtacante.setPontosDeVida(jogadorAtacante.getPontosDeVida() - dano);
                    System.out.println(jogadorAtacante.getNome() + " sofreu " + dano + " de dano.");
                }
            }
            // CASO O DEFENSOR ESTEJA EM MODO DE ATAQUE
            else {
                int dano = atacante.getAtaque() - defensor.getAtaque();
                if (dano > 0) {
                    System.out.println(defensor.getNome() + " foi obliterado do campo!");
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                } else if (dano == 0) {
                    System.out.println(atacante.getNome() + " e " + defensor.getNome() + " se destruíram mutuamente!");
                    atacante.setEstaVivo(false);
                    defensor.setEstaVivo(false);
                    campoDoAtacante.getSlotDeMonstro().remove(atacante);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                } else {
                    System.out.println(atacante.getNome() + " não foi páreo para a defesa de " + defensor.getNome());
                    jogadorAtacante.setPontosDeVida(jogadorAtacante.getPontosDeVida() - Math.abs(dano));
                    System.out.println(jogadorAtacante.getNome() + " sofreu " + Math.abs(dano) + " de dano.");
                }
            }
        }
    }
}