package CardGame;

public class Battle {
    public void golpe(MonsterCard atacante, MonsterCard defensor, Player jogadorAtacante, Player jogadorDefensor, Board campoDoDefensor, Board campoDoAtacante) {
        // SE O JOGADOR DEFENSOR NÃO TIVER NENHUM MONSTRO NO CAMPO ELE SOFRE UM ATAQUE DIRETO
        if (campoDoDefensor.getSlotDeMonstro().isEmpty()) {
            int dano = atacante.getAtaque();
            jogadorDefensor.setPontosDeVida(jogadorDefensor.getPontosDeVida() - dano);
            System.out.println("Ataque Direto de " + atacante.nome + " causou " + dano +
                    " de dano ao duelista " + jogadorDefensor.nome);

        }
        else {
            // ESCOLHA DO MONSTRO

            // CASO O DEFENSOR ESTEJA EM MODO DE DEFESA
            if (defensor.getModo() == Mode.Defesa) {
                if (atacante.getAtaque() > defensor.getDefesa()) {
                    System.out.println(defensor.nome + " foi obliterado do campo!");
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                } else if (atacante.getAtaque() == defensor.getDefesa()) {
                    System.out.println(atacante.nome + " não conseguiu superar a defesa de " + defensor.nome);
                } else {
                    int dano = defensor.getDefesa() - atacante.getAtaque();
                    System.out.println(atacante.nome + " não foi pareo para a defesa de " + defensor.nome);
                    jogadorAtacante.setPontosDeVida(jogadorAtacante.getPontosDeVida() - dano);
                    System.out.println(jogadorAtacante.nome + " sofreu " + dano + " de dano.");

                }
            }
            // CASO O DEFENSOR ESTEJA EM MODO DE ATAQUE
            else {
                int dano = atacante.getAtaque() - defensor.getAtaque();
                if (dano > 0) {
                    System.out.println(defensor.nome + " foi obliterado do campo! e o jogador "
                            + jogadorDefensor.nome + " sofreu um dano de " + dano);
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                    jogadorDefensor.setPontosDeVida(jogadorDefensor.getPontosDeVida() - dano);
                } else if (dano < 0) {
                    System.out.println(atacante.nome + " não conseguiu superar o ataque de "
                            + defensor.nome + " e foi desttruido. O duelista "
                            + jogadorAtacante.nome + "sofreu " + dano + " de dano.");
                    atacante.setEstaVivo(false);
                    campoDoAtacante.getSlotDeMonstro().remove(atacante);
                    jogadorAtacante.setPontosDeVida(jogadorAtacante.getPontosDeVida() - dano);

                } else {
                    System.out.println("Os poderes de " + atacante.nome + " e " +
                            defensor.nome + " são iguais. Ambos se destruiram");
                    atacante.setEstaVivo(false);
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                    campoDoAtacante.getSlotDeMonstro().remove(atacante);
                }
            }
        }
    }
}
