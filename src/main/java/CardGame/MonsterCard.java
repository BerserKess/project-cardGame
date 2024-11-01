package CardGame;

public class MonsterCard extends Card {
    public Element elemento;
    private  Mode modo;
    private int ataque;
    private int defesa;
    public String raca;
    private boolean estaVivo;

    // CONSTRUCTOR

    public MonsterCard(String nome, String descricao, Mode modo, int ataque, int defesa, String raca, boolean estaVivo, Element elemento) {
        this.nome = nome;
        this.descricao = descricao;
        this.modo = modo;
        this.ataque = ataque;
        this.defesa = defesa;
        this.raca = raca;
        this.estaVivo = estaVivo;
        this.elemento = elemento;
    }


    // GETTER AND SETTERS

    public Mode getModo() {
        return modo;
    }

    public void setModo(Mode modo) {
        this.modo = modo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    // METODOS
    public void vantagem(MonsterCard monster1, MonsterCard monster2){
        if (monster1.modo == Mode.Ataque || monster2.modo == Mode.Ataque) {

            if ((monster1.elemento == Element.Agua && monster2.elemento == Element.Fogo) || (monster2.elemento == Element.Agua && monster1.elemento == Element.Fogo)) {
                if (monster1.elemento == Element.Agua) {
                    System.out.println(monster1.nome + "ganhou 10% de ataque e defesa");
                    monster1.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster1.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                } else {
                    System.out.println(monster2.nome + "ganhou 10% de ataque e defesa");
                    monster2.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster2.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                }

            } else if ((monster1.elemento == Element.Terra && monster2.elemento == Element.Agua) || (monster2.elemento == Element.Terra && monster1.elemento == Element.Agua)) {
                if (monster1.elemento == Element.Terra) {
                    System.out.println(monster1.nome + "ganhou 10% de ataque e defesa");
                    monster1.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster1.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                } else {
                    System.out.println(monster2.nome + "ganhou 10% de ataque e defesa");
                    monster2.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster2.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                }

            } else if ((monster1.elemento == Element.Fogo && monster2.elemento == Element.Vento) || (monster2.elemento == Element.Fogo && monster1.elemento == Element.Vento)) {
                if (monster1.elemento == Element.Fogo) {
                    System.out.println(monster1.nome + "ganhou 10% de ataque e defesa");
                    monster1.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster1.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                } else {
                    System.out.println(monster2.nome + "ganhou 10% de ataque e defesa");
                    monster2.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster2.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                }

            } else if ((monster1.elemento == Element.Vento && monster2.elemento == Element.Luz) || (monster2.elemento == Element.Vento && monster1.elemento == Element.Luz)) {
                if (monster1.elemento == Element.Vento) {
                    System.out.println(monster1.nome + "ganhou 10% de ataque e defesa");
                    monster1.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster1.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                } else {
                    System.out.println(monster2.nome + "ganhou 10% de ataque e defesa");
                    monster2.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster2.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                }

            } else if ((monster1.elemento == Element.Luz && monster2.elemento == Element.Trevas) || (monster2.elemento == Element.Luz && monster1.elemento == Element.Trevas)) {
                if (monster1.elemento == Element.Luz) {
                    System.out.println(monster1.nome + "ganhou 10% de ataque e defesa");
                    monster1.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster1.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                } else {
                    System.out.println(monster2.nome + "ganhou 10% de ataque e defesa");
                    monster2.setAtaque(this.ataque + ((this.ataque / 100) * 10));
                    monster2.setDefesa(this.defesa + ((this.defesa / 100) * 10));
                }

            }

        }

    }

    public void atacar(){
        this.ataque = getAtaque();
    }


}
