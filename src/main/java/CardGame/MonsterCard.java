package CardGame;

public class MonsterCard extends Card {
    private int ataque;        // Atributo para o ataque do monstro
    private int defesa;        // Atributo para a defesa do monstro
    private String tipo;       // Tipo do monstro (ex: Fogo, Água, etc.)
    private boolean estaVivo;  // Indica se o monstro está vivo ou não
    private Element elemento;   // Elemento do monstro (se houver)
    private Mode modo;         // Modo do monstro (Ataque ou Defesa)

    // Construtor da classe MonsterCard
    public MonsterCard(String nome, String descricao, int ataque, int defesa, String tipo, boolean estaVivo, Element elemento) {
        super(nome, descricao); // Chama o construtor da classe pai (Card)
        this.ataque = ataque;
        this.defesa = defesa;
        this.tipo = tipo;
        this.estaVivo = estaVivo;
        this.elemento = elemento;
        this.modo = Mode.Ataque; // Modo padrão é Ataque
    }

    // Métodos getters
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

    // Métodos setters
    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public void setModo(Mode modo) {
        this.modo = modo;
    }
}