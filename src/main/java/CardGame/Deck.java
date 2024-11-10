package CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> cartas; // Lista de cartas no deck

    // CONSTRUTOR
    public Deck() {
        this.cartas = new ArrayList<>();
    }

    // ADICIONAR CARTAS
    public void add(Card carta){this.cartas.add(carta);}

    // EXIBIR CARTAS
    public void exibirCartas(Player jogador){
        System.out.println("Deck do duelista: " + jogador.nome);
        for (Card carta : cartas){
            System.out.println(carta.getNome());
        }
    }

    // METODO PARA CRIAR DECK DO JOGADOR
    public static void criarDeck(List<Card> cartasDeMonstro, Deck deck1, Deck deck2) throws IllegalArgumentException {
        Random random = new Random();
        Collections.shuffle(cartasDeMonstro);

        // Verifica se há cartas suficientes para distribuir
        if (cartasDeMonstro.size() < 10) {
            throw new IllegalArgumentException("É necessário ter pelo menos 10 cartas para distribuir entre os dois jogadores.");
        }

        for (int i = 0; i < cartasDeMonstro.size(); i ++){
            if (i % 2 == 0){
                deck1.add(cartasDeMonstro.get(i));
            }
            else {
                deck2.add(cartasDeMonstro.get(i));
            }
        }

        // VERIFICA
        if (!cartasDeMonstro.isEmpty()) {
            int indiceAleatorio = random.nextInt(cartasDeMonstro.size()); // Gera um índice aleatório
            Card cartaAleatoria = cartasDeMonstro.get(indiceAleatorio);
            if (cartaAleatoria instanceof MonsterCard) {
                MonsterCard cartaMonstro = (MonsterCard) cartaAleatoria; // Casting seguro
            } else {
                System.out.println("A carta aleatória não é um MonsterCard.");
            }
        } else {
            System.out.println("Não há mais cartas no deck de monstros.");
        }

    }

    // METODO PARA VERIFICAR NUMERO DE CARTAS DO DECK
    public int getNumeroDeCartas() {
        return cartas.size();
    }

    // METODO PARA PEGAR A CARTA DO TOPO DO DECK
    public Card pegarUltimaCarta(){
        if (!cartas.isEmpty()){
        return cartas.get(cartas.size() - 1);
        }
        else {
            System.out.println("baralho está vazio");
            return null;
        }
    }

    // REMOVER CARTA
    public Card removerCarta(){
        if (!cartas.isEmpty()){
            return cartas.remove(cartas.size() - 1);
        }
        else {
            System.out.println("baralho está vazio");
            return null;
        }

    }
}