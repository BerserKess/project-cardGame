package CardGame;

public class Battle {
    
    public void golpe(MonsterCard atacante, MonsterCard defensor, Player jogador1, Player jogador2) {
        int danoAoJogador;
        
        if (defensor.getModo() == Mode.Defesa) {
            if (atacante.getAtaque() > defensor.getDefesa()) {
                System.out.println(defensor.getNome() + " foi obliterado do campo!");
                defensor.setEstaVivo(false);
            
            } else if (atacante.getAtaque() < defensor.getDefesa()) {
                danoAoJogador = defensor.getDefesa() - atacante.getAtaque();
                System.out.println(atacante.getNome() + " não foi páreo para a defesa de " + defensor.getNome());
                jogador1.setPontosDeVida(jogador1.getPontosDeVida() - danoAoJogador);
           
            } else {
                System.out.println(atacante.getNome() + " conseguiu igualar a defesa de " + defensor.getNome());
           }
        } else { 
            danoAoJogador = Math.abs(atacante.getAtaque() - defensor.getAtaque());
            if (atacante.getAtaque() > defensor.getAtaque()) {
                System.out.println(defensor.getNome() + " foi obliterado do campo e o jogador " + jogador2.getNome() + " sofreu " + danoAoJogador + " de dano.");
                defensor.setEstaVivo(false);
                jogador2.setPontosDeVida(jogador2.getPontosDeVida() - danoAoJogador);
            
            } else {
                System.out.println(atacante.getNome() + " não conseguiu superar o ataque de " + defensor.getNome() + " e foi destruído. O jogador " + jogador1.getNome() + " sofreu " + danoAoJogador + " de dano.");
                atacante.setEstaVivo(false);
                jogador1.setPontosDeVida(jogador1.getPontosDeVida() - danoAoJogador);
            }
        }
        
        verificarVitoria(jogador1, jogador2);
    }
    
    private void verificarVitoria(Player jogador1, Player jogador2) {
        if (jogador1.getPontosDeVida() <= 0) {
            System.out.println(jogador2.getNome() + " venceu!");
        } else if (jogador2.getPontosDeVida() <= 0) {
            System.out.println(jogador1.getNome() + " venceu!");
        }
    }
}
