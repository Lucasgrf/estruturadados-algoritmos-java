package com.loiane.estruturadados.vetor;

public class Vetor {
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    /*public void adicionarElemento(String elemento) {
        for(int i = 0; i < this.elementos.length; i++){
            if(this.elementos[i] == null){
                this.elementos[i] = elemento;
                break;
            }
        }
    }*/

    /*public void adiciona(String elemento) throws Exception {
        if(this.tamanho < this.elementos.length) {
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        } else {
            throw new Exception("Vetor já esta cheio, não é possível adicionar mais elementos");
        }
    }*/

    public boolean adiciona(String elemento) {
        if(this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < this.tamanho-1; i++) {
            builder.append(this.elementos[i]);
            builder.append(", ");
        }

        if(this.tamanho > 0) {
            builder.append(this.elementos[this.tamanho-1]);
        }
        builder.append("]");

        return builder.toString();
    }
}
