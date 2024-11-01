package CardGame;

public class Battle {
    public void golpe(MonsterCard atacante, MonsterCard defensor,Player jogador1, Player jogador2){
        // CASO O DEFENSOR ESTEJA EM MODO DE DEFESA
        if (defensor.getModo() == Mode.Defesa){
            if (atacante.getAtaque() > defensor.getDefesa()){
                System.out.println(defensor.nome + " foi obliterado do campo!");
                defensor.setEstaVivo(false);
            }
            else if (atacante.getAtaque() == defensor.getDefesa()){
                System.out.println(atacante.nome + " conseguiu superar a defesa de " + defensor.nome);
            }
            else {
                int golpeNoJogador = atacante.getAtaque() - defensor.getDefesa();
                System.out.println(atacante.nome + " não foi pareo para a defesa de " + defensor.nome);
                jogador1.setPontosDeVida(jogador1.getPontosDeVida() - golpeNoJogador);

            }
        }
        // CASO O DEFENSOR ESTEJA EM MODO DE ATAQUE
        else {
            int golpeNoJogador = atacante.getAtaque() - defensor.getAtaque();
            if (atacante.getAtaque() > defensor.getAtaque()){
                System.out.println(defensor.nome + " foi obliterado do campo! e o jogador " + jogador1.nome + " sofreu um dano de " + golpeNoJogador);
                defensor.setEstaVivo(false);
                jogador2.setPontosDeVida(jogador2.getPontosDeVida() - golpeNoJogador);
            }
            else {
                System.out.println(atacante.nome + " não conseguiu superar o ataque de " + defensor.nome + " e foi desttruido. O jogador1 " + jogador1.nome + "sofreu " + golpeNoJogador + " de dano." );
                jogador1.setPontosDeVida(jogador1.getPontosDeVida() - golpeNoJogador);
                atacante.setEstaVivo(false);
            }
        }
    }
}
