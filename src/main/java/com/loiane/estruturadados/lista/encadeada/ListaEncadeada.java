package com.loiane.estruturadados.lista.encadeada;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementação simples de uma lista simplesmente encadeada genérica.
 */
public class ListaEncadeada<T> implements Iterable<T> {

    private static class No<E> {
        E elemento;
        No<E> proximo;

        No(E elemento) {
            this.elemento = elemento;
        }
    }

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanho;

    public void adicionarPrimeiro(T elemento) {
        No<T> novo = new No<>(elemento);
        novo.proximo = this.cabeca;
        this.cabeca = novo;
        if (this.cauda == null) {
            this.cauda = novo;
        }
        this.tamanho++;
    }

    public void adicionarUltimo(T elemento) {
        No<T> novo = new No<>(elemento);
        if (this.cauda == null) {
            this.cabeca = novo;
            this.cauda = novo;
        } else {
            this.cauda.proximo = novo;
            this.cauda = novo;
        }
        this.tamanho++;
    }

    public T removerPrimeiro() {
        if (this.cabeca == null) {
            throw new NoSuchElementException("Lista vazia");
        }
        T valor = this.cabeca.elemento;
        this.cabeca = this.cabeca.proximo;
        if (this.cabeca == null) {
            this.cauda = null;
        }
        this.tamanho--;
        return valor;
    }

    public boolean remover(T elemento) {
        No<T> anterior = null;
        No<T> atual = this.cabeca;
        while (atual != null) {
            if ((elemento == null && atual.elemento == null)
                || (elemento != null && elemento.equals(atual.elemento))) {
                if (anterior == null) {
                    this.cabeca = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                if (atual == this.cauda) {
                    this.cauda = anterior;
                }
                this.tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    public boolean contem(T elemento) {
        for (T valor : this) {
            if ((elemento == null && valor == null)
                || (elemento != null && elemento.equals(valor))) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private No<T> atual = cabeca;

            @Override
            public boolean hasNext() {
                return this.atual != null;
            }

            @Override
            public T next() {
                if (this.atual == null) {
                    throw new NoSuchElementException();
                }
                T valor = this.atual.elemento;
                this.atual = this.atual.proximo;
                return valor;
            }
        };
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
