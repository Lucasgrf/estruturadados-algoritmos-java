package com.loiane.estruturadados.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Fila de prioridade baseada em heap binário máximo.
 */
public class FilaPrioridade<T extends Comparable<T>> {

    private Object[] heap;
    private int tamanho;

    public FilaPrioridade() {
        this(16);
    }

    public FilaPrioridade(int capacidadeInicial) {
        if (capacidadeInicial <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser positiva");
        }
        this.heap = new Object[capacidadeInicial];
    }

    public void inserir(T elemento) {
        garantirCapacidade();
        this.heap[this.tamanho] = elemento;
        subir(this.tamanho);
        this.tamanho++;
    }

    @SuppressWarnings("unchecked")
    public T removerMaximo() {
        if (this.tamanho == 0) {
            throw new NoSuchElementException("Fila de prioridade vazia");
        }
        T raiz = (T) this.heap[0];
        this.tamanho--;
        this.heap[0] = this.heap[this.tamanho];
        this.heap[this.tamanho] = null;
        descer(0);
        return raiz;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    private void subir(int indice) {
        int pai = (indice - 1) / 2;
        while (indice > 0 && comparar(indice, pai) > 0) {
            trocar(indice, pai);
            indice = pai;
            pai = (indice - 1) / 2;
        }
    }

    private void descer(int indice) {
        while (true) {
            int filhoEsquerdo = 2 * indice + 1;
            int filhoDireito = 2 * indice + 2;
            int maior = indice;
            if (filhoEsquerdo < this.tamanho && comparar(filhoEsquerdo, maior) > 0) {
                maior = filhoEsquerdo;
            }
            if (filhoDireito < this.tamanho && comparar(filhoDireito, maior) > 0) {
                maior = filhoDireito;
            }
            if (maior == indice) {
                break;
            }
            trocar(indice, maior);
            indice = maior;
        }
    }

    @SuppressWarnings("unchecked")
    private int comparar(int i, int j) {
        T a = (T) this.heap[i];
        T b = (T) this.heap[j];
        return a.compareTo(b);
    }

    private void trocar(int i, int j) {
        Object tmp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = tmp;
    }

    private void garantirCapacidade() {
        if (this.tamanho == this.heap.length) {
            this.heap = Arrays.copyOf(this.heap, this.heap.length * 2);
        }
    }
}
