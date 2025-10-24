package com.lucas.estruturadados.fila;

import java.util.NoSuchElementException;

/**
 * Fila circular baseada em vetor.
 */
public class Fila<T> {

    private Object[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila() {
        this(16);
    }

    public Fila(int capacidadeInicial) {
        if (capacidadeInicial <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser positiva");
        }
        this.elementos = new Object[capacidadeInicial];
    }

    public void enfileirar(T elemento) {
        garantirCapacidade();
        this.elementos[this.fim] = elemento;
        this.fim = (this.fim + 1) % this.elementos.length;
        this.tamanho++;
    }

    @SuppressWarnings("unchecked")
    public T desenfileirar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia");
        }
        T elemento = (T) this.elementos[this.inicio];
        this.elementos[this.inicio] = null;
        this.inicio = (this.inicio + 1) % this.elementos.length;
        this.tamanho--;
        return elemento;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    private void garantirCapacidade() {
        if (this.tamanho == this.elementos.length) {
            int novaCapacidade = this.elementos.length * 2;
            Object[] novoArray = new Object[novaCapacidade];
            for (int i = 0; i < this.tamanho; i++) {
                novoArray[i] = this.elementos[(this.inicio + i) % this.elementos.length];
            }
            this.elementos = novoArray;
            this.inicio = 0;
            this.fim = this.tamanho;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < this.tamanho; i++) {
            int indice = (this.inicio + i) % this.elementos.length;
            builder.append(this.elementos[indice]);
            if (i < this.tamanho - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
