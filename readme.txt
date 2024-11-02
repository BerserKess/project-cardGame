Falta implmentar
    - Classe Player
        - Metodo vantagens, verificar como fazer para implementar na batalha; Verificar se ela fica nessa classe mesmo ou se muda pra classe batalha
        -
    - MagicCard (Transformar ela em uma classe abstrata para gerar cartas de magia normal ou equipamento?
     Talvez cartas armadilhas também, Mas não muito necessário no momento)
    - Classe Hand
        - fazer com que a hand receba as cartas do topo do baralho ao compra-las e remover essa carta do baralho ao realizar esse processo
        - fazer com que, assim que as cartas sairem da mão para ir pro campo, elas sejam removidas da mão
        - só pode ter no maximo, 5 cartas na mão.
    - - Hand e Deck (melhorar e verificar questões do tipo do ArrayList se servem para batalha ou se é melhor trocar pra
          pra array list de outros tipos como MonsterCard e MagicCard)
    - Classe Board
        - vai ter 5 slots pra colocar carta de monstro e slots para carta de magia, para cada jogador
        - Ao monstro ser destruido, carta tem de ser removida do campo
        - só pode aceitar cartas que venham da mão dos jogadores e não do baralho

    - Game (Classe Main)
        - Testar Batalha: implementar a classe battle para gerar uma batalha
        - ver questão dos turnos: o jogador só pode jogar no seu turno, sempre que jogar uma carta, finalizar o turno dele


