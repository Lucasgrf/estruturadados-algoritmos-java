package com.lucas.estruturadados.hash;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Tabela hash simples com tratamento de colisões por encadeamento separado.
 */
public class TabelaHash<K, V> {

    private static class Entrada<K, V> {
        final K chave;
        V valor;

        Entrada(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private List<Entrada<K, V>>[] baldes;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public TabelaHash(int capacidadeInicial) {
        if (capacidadeInicial <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser positiva");
        }
        this.baldes = new List[capacidadeInicial];
    }

    public TabelaHash() {
        this(16);
    }

    public void inserir(K chave, V valor) {
        int indice = indice(chave);
        List<Entrada<K, V>> balde = obterOuCriarBalde(indice);
        for (Entrada<K, V> entrada : balde) {
            if (Objects.equals(entrada.chave, chave)) {
                entrada.valor = valor;
                return;
            }
        }
        balde.add(new Entrada<>(chave, valor));
        this.tamanho++;
        if (fatorDeCarga() > 0.75) {
            redimensionar();
        }
    }

    public V buscar(K chave) {
        int indice = indice(chave);
        List<Entrada<K, V>> balde = this.baldes[indice];
        if (balde == null) {
            return null;
        }
        for (Entrada<K, V> entrada : balde) {
            if (Objects.equals(entrada.chave, chave)) {
                return entrada.valor;
            }
        }
        return null;
    }

    public boolean remover(K chave) {
        int indice = indice(chave);
        List<Entrada<K, V>> balde = this.baldes[indice];
        if (balde == null) {
            return false;
        }
        for (int i = 0; i < balde.size(); i++) {
            if (Objects.equals(balde.get(i).chave, chave)) {
                balde.remove(i);
                this.tamanho--;
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

    private double fatorDeCarga() {
        return (double) this.tamanho / this.baldes.length;
    }

    private int indice(K chave) {
        return (this.baldes.length - 1) & hash(chave);
    }

    private int hash(K chave) {
        return chave == null ? 0 : chave.hashCode();
    }

    private List<Entrada<K, V>> obterOuCriarBalde(int indice) {
        List<Entrada<K, V>> balde = this.baldes[indice];
        if (balde == null) {
            balde = new LinkedList<>();
            this.baldes[indice] = balde;
        }
        return balde;
    }

    @SuppressWarnings("unchecked")
    private void redimensionar() {
        List<Entrada<K, V>>[] antigo = this.baldes;
        this.baldes = new List[antigo.length * 2];
        this.tamanho = 0;
        for (List<Entrada<K, V>> balde : antigo) {
            if (balde != null) {
                for (Entrada<K, V> entrada : balde) {
                    inserir(entrada.chave, entrada.valor);
                }
            }
        }
    }
}
