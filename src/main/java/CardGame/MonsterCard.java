package CardGame;

public class MonsterCard extends Card {
    private int ataque;        // Atributo para o ataque do monstro
    private int defesa;        // Atributo para a defesa do monstro
    private String tipo;       // Tipo do monstro
    private boolean estaVivo;  // Indica se o monstro está vivo ou não
    private Element elemento;   // Elemento do monstro
    private Mode modo;         // Modo do monstro (Ataque ou Defesa)

    // Construtor da classe MonsterCard
    public MonsterCard(String nome, String descricao, int ataque, int defesa, String tipo, boolean estaVivo, Element elemento) {
        super(nome, descricao);
        this.ataque = ataque;
        this.defesa = defesa;
        this.tipo = tipo;
        this.estaVivo = estaVivo;
        this.elemento = elemento;
    }

    // GETTERS E SETTERS
    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public Element getElemento() {
        return elemento;
    }

    public Mode getModo() {
        return modo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public void setModo(Mode modo) {
        this.modo = modo;
    }
}