package CardGame;

public class Battle {
    public void golpe(MonsterCard atacante, MonsterCard defensor, Player jogadorAtacante, Player jogadorDefensor, Board campoDoDefensor, Board campoDoAtacante) {
        // DEFININDO QUE O MONSTRO NÃO PODE ATACAR SE ESTIVER EM MODO DE DEFESA
        if (atacante.getModo() == Mode.Defesa){
            System.out.println("O monstro não pode atacar em modo de defesa!");
            return;
        }

        // VERIFICAR CONDIÇÃO DO DEFENSOR PARA REALIZAR O ATAQUE
        if (defensor == null){
            if (!campoDoDefensor.todosOsSlotsVazios()){
                System.out.println("Não pode atacar o oponente diretamente se ele tiver monstros no campo");
            }
            else {
                ataqueDireto(atacante,jogadorDefensor);
            }
        }
        else {
            // CASO O DEFENSOR ESTEJA EM MODO DE DEFESA
            if (defensor.getModo() == Mode.Defesa) {
                if (atacante.getAtaque() > defensor.getDefesa()) {
                    System.out.println(defensor.getNome() + "não foi pareo para " + atacante.getNome() + " e foi obliterado do campo!");
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                    campoDoDefensor.getSlotDeMonstro().add(null);
                } else if (atacante.getAtaque() == defensor.getDefesa()) {
                    System.out.println(atacante.getNome() + " não conseguiu superar a defesa de " + defensor.getNome());
                } else {
                    int dano = defensor.getDefesa() - atacante.getAtaque();
                    System.out.println(atacante.getNome() + " não foi páreo para a defesa de " + defensor.getNome());
                    jogadorAtacante.setPontosDeVida(jogadorAtacante.getPontosDeVida() - dano);
                    System.out.println(jogadorAtacante.nome + " sofreu " + dano + " de dano.");
                }
            }
            // CASO O DEFENSOR ESTEJA EM MODO DE ATAQUE
            else {
                int dano = atacante.getAtaque() - defensor.getAtaque();
                if (dano > 0) {
                    System.out.println(defensor.getNome() + " foi obliterado do campo!");
                    System.out.println(jogadorDefensor.nome + " Sofreu " + dano + " de dano.");
                    jogadorDefensor.setPontosDeVida(jogadorDefensor.getPontosDeVida() - dano);
                    defensor.setEstaVivo(false);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                    campoDoDefensor.getSlotDeMonstro().add(null);
                } else if (dano == 0) {
                    System.out.println(atacante.getNome() + " e " + defensor.getNome() + " se destruíram mutuamente!");
                    atacante.setEstaVivo(false);
                    defensor.setEstaVivo(false);
                    campoDoAtacante.getSlotDeMonstro().remove(atacante);
                    campoDoAtacante.getSlotDeMonstro().add(null);
                    campoDoDefensor.getSlotDeMonstro().remove(defensor);
                    campoDoDefensor.getSlotDeMonstro().add(null);
                } else {
                    System.out.println(atacante.getNome() + " não foi páreo para carta " + defensor.getNome() + " e foi  destruido!");
                    jogadorAtacante.setPontosDeVida(jogadorAtacante.getPontosDeVida() + dano);
                    System.out.println(jogadorAtacante.nome + " sofreu " + dano + " de dano.");
                    campoDoAtacante.getSlotDeMonstro().remove(atacante);
                    campoDoAtacante.getSlotDeMonstro().add(null);
                }
            }
        }

    }

    // REALIZA UM ATAQUE DIRETO AO MONSTRO
    public void ataqueDireto(MonsterCard atacante, Player jogadorDefensor){
        int dano = atacante.getAtaque();
        jogadorDefensor.setPontosDeVida(jogadorDefensor.getPontosDeVida() - dano);
        System.out.println("Ataque Direto de " + atacante.getNome() + " causou " + dano +
                " de dano ao duelista " + jogadorDefensor.nome);
    }


}