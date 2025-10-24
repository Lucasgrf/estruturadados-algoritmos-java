package com.lucas.estruturadados.pilha;

import java.util.EmptyStackException;
import java.util.Arrays;

/**
 * Pilha baseada em vetor com redimensionamento automático.
 */
public class Pilha<T> {

    private Object[] elementos;
    private int topo;

    public Pilha() {
        this(16);
    }

    public Pilha(int capacidadeInicial) {
        if (capacidadeInicial <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser positiva");
        }
        this.elementos = new Object[capacidadeInicial];
        this.topo = 0;
    }

    public void empilhar(T elemento) {
        garantirCapacidade();
        this.elementos[this.topo++] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T desempilhar() {
        if (estaVazia()) {
            throw new EmptyStackException();
        }
        T elemento = (T) this.elementos[--this.topo];
        this.elementos[this.topo] = null;
        return elemento;
    }

    @SuppressWarnings("unchecked")
    public T topo() {
        if (estaVazia()) {
            throw new EmptyStackException();
        }
        return (T) this.elementos[this.topo - 1];
    }

    public boolean estaVazia() {
        return this.topo == 0;
    }

    public int tamanho() {
        return this.topo;
    }

    private void garantirCapacidade() {
        if (this.topo == this.elementos.length) {
            this.elementos = Arrays.copyOf(this.elementos, this.elementos.length * 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = this.topo - 1; i >= 0; i--) {
            builder.append(this.elementos[i]);
            if (i > 0) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
