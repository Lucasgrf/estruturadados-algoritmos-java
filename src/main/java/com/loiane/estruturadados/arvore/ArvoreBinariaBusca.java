package com.loiane.estruturadados.arvore;

import java.util.ArrayList;
import java.util.List;

/**
 * Árvore binária de busca com operações básicas.
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> {

    private static class No<E> {
        E elemento;
        No<E> esquerdo;
        No<E> direito;

        No(E elemento) {
            this.elemento = elemento;
        }
    }

    private No<T> raiz;
    private int tamanho;

    public void inserir(T elemento) {
        this.raiz = inserir(this.raiz, elemento);
    }

    private No<T> inserir(No<T> no, T elemento) {
        if (no == null) {
            this.tamanho++;
            return new No<>(elemento);
        }
        int comparacao = elemento.compareTo(no.elemento);
        if (comparacao < 0) {
            no.esquerdo = inserir(no.esquerdo, elemento);
        } else if (comparacao > 0) {
            no.direito = inserir(no.direito, elemento);
        }
        return no;
    }

    public boolean contem(T elemento) {
        return buscar(this.raiz, elemento) != null;
    }

    private No<T> buscar(No<T> no, T elemento) {
        if (no == null) {
            return null;
        }
        int comparacao = elemento.compareTo(no.elemento);
        if (comparacao == 0) {
            return no;
        } else if (comparacao < 0) {
            return buscar(no.esquerdo, elemento);
        }
        return buscar(no.direito, elemento);
    }

    public List<T> emOrdem() {
        List<T> elementos = new ArrayList<>();
        percorrerEmOrdem(this.raiz, elementos);
        return elementos;
    }

    private void percorrerEmOrdem(No<T> no, List<T> elementos) {
        if (no == null) {
            return;
        }
        percorrerEmOrdem(no.esquerdo, elementos);
        elementos.add(no.elemento);
        percorrerEmOrdem(no.direito, elementos);
    }

    public int tamanho() {
        return this.tamanho;
    }
}
