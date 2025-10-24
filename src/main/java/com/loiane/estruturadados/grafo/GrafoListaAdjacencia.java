package com.loiane.estruturadados.grafo;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Representação de grafo não direcionado utilizando lista de adjacência.
 */
public class GrafoListaAdjacencia {

    private final Map<String, Set<String>> adjacencias = new HashMap<>();

    public void adicionarVertice(String vertice) {
        this.adjacencias.computeIfAbsent(vertice, v -> new HashSet<>());
    }

    public void adicionarAresta(String origem, String destino) {
        adicionarVertice(origem);
        adicionarVertice(destino);
        this.adjacencias.get(origem).add(destino);
        this.adjacencias.get(destino).add(origem);
    }

    public Set<String> vizinhos(String vertice) {
        return this.adjacencias.containsKey(vertice)
            ? Collections.unmodifiableSet(this.adjacencias.get(vertice))
            : Collections.emptySet();
    }

    public Set<String> vertices() {
        return Collections.unmodifiableSet(this.adjacencias.keySet());
    }

    public boolean contemVertice(String vertice) {
        return this.adjacencias.containsKey(vertice);
    }

    public boolean contemAresta(String origem, String destino) {
        Set<String> vizinhosOrigem = this.adjacencias.get(origem);
        return vizinhosOrigem != null && vizinhosOrigem.contains(destino);
    }
}
