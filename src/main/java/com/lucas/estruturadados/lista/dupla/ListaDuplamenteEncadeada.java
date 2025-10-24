package com.lucas.estruturadados.lista.dupla;

import java.util.NoSuchElementException;

/**
 * Lista duplamente encadeada com acesso às extremidades.
 */
public class ListaDuplamenteEncadeada<T> {

    private static class No<E> {
        E elemento;
        No<E> anterior;
        No<E> proximo;

        No(E elemento) {
            this.elemento = elemento;
        }
    }

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanho;

    public void adicionarInicio(T elemento) {
        No<T> novo = new No<>(elemento);
        novo.proximo = this.cabeca;
        if (this.cabeca != null) {
            this.cabeca.anterior = novo;
        }
        this.cabeca = novo;
        if (this.cauda == null) {
            this.cauda = novo;
        }
        this.tamanho++;
    }

    public void adicionarFim(T elemento) {
        No<T> novo = new No<>(elemento);
        novo.anterior = this.cauda;
        if (this.cauda != null) {
            this.cauda.proximo = novo;
        }
        this.cauda = novo;
        if (this.cabeca == null) {
            this.cabeca = novo;
        }
        this.tamanho++;
    }

    public T removerInicio() {
        if (this.cabeca == null) {
            throw new NoSuchElementException("Lista vazia");
        }
        T valor = this.cabeca.elemento;
        this.cabeca = this.cabeca.proximo;
        if (this.cabeca != null) {
            this.cabeca.anterior = null;
        } else {
            this.cauda = null;
        }
        this.tamanho--;
        return valor;
    }

    public T removerFim() {
        if (this.cauda == null) {
            throw new NoSuchElementException("Lista vazia");
        }
        T valor = this.cauda.elemento;
        this.cauda = this.cauda.anterior;
        if (this.cauda != null) {
            this.cauda.proximo = null;
        } else {
            this.cabeca = null;
        }
        this.tamanho--;
        return valor;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.cabeca;
        while (atual != null) {
            builder.append(atual.elemento);
            if (atual.proximo != null) {
                builder.append(", ");
            }
            atual = atual.proximo;
        }
        builder.append(']');
        return builder.toString();
    }
}
