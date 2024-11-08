package CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> cartas; // Lista de cartas no deck

    // Construtor da classe Deck
    public Deck() {
        this.cartas = new ArrayList<>();
    }

    // Método estático para criar o deck e distribuir cartas entre dois jogadores
    public static void criarDeck(List<Card> cartasDeMonstro, Deck deck1, Deck deck2) throws IllegalArgumentException {
        Random random = new Random();

        // Verifica se há cartas suficientes para distribuir
        if (cartasDeMonstro.size() < 10) {
            throw new IllegalArgumentException("É necessário ter pelo menos 10 cartas para distribuir entre os dois jogadores.");
        }

        for (int i = 0; i < 5; i++) { // Cada jogador recebe 5 cartas
            // Adiciona uma carta aleatória ao deck do jogador 1
            deck1.cartas.add(cartasDeMonstro.remove(random.nextInt(cartasDeMonstro.size())));
            // Adiciona uma carta aleatória ao deck do jogador 2
            deck2.cartas.add(cartasDeMonstro.remove(random.nextInt(cartasDeMonstro.size())));
        }

        // Verifica se ainda há cartas no deck de monstros
        if (!cartasDeMonstro.isEmpty()) {
            int indiceAleatorio = random.nextInt(cartasDeMonstro.size()); // Gera um índice aleatório
            Card cartaAleatoria = cartasDeMonstro.get(indiceAleatorio);
            if (cartaAleatoria instanceof MonsterCard) {
                MonsterCard cartaMonstro = (MonsterCard) cartaAleatoria; // Casting seguro
                System.out.println("Carta aleatória: " + cartaMonstro.getNome());
            } else {
                System.out.println("A carta aleatória não é um MonsterCard.");
            }
        } else {
            System.out.println("Não há mais cartas no deck de monstros.");
        }
    }

    // Método para obter o número de cartas no deck
    public int getNumeroDeCartas() {
        return cartas.size();
    }
}