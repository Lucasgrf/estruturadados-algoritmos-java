# Estruturas de Dados e Algoritmos em Java

Repositório educativo com implementações clássicas de estruturas de dados em Java. Cada estrutura possui código-fonte comentado, exemplos de uso e documentação complementar em português para apoiar seus estudos.

## Conteúdo

- Vetor dinâmico (`com.lucas.estruturadados.vetor`)
- Listas encadeadas (simples e duplamente) (`com.lucas.estruturadados.lista`)
- Pilha (`com.lucas.estruturadados.pilha`)
- Fila e fila circular (`com.lucas.estruturadados.fila`)
- Fila de prioridade com heap binário (`com.lucas.estruturadados.heap`)
- Tabela hash aberta (`com.lucas.estruturadados.hash`)
- Árvore binária de busca (`com.lucas.estruturadados.arvore`)
- Grafo com lista de adjacência (`com.lucas.estruturadados.grafo`)

A pasta [`docs/estruturas.md`](docs/estruturas.md) traz, para cada estrutura, definições, operações, pseudocódigos, implementações em Java e fluxogramas Mermaid.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.8+

## Executando os exemplos

1. Clone o repositório e entre na pasta do projeto.
2. Compile os módulos com o Maven:
   ```bash
   mvn -q -DskipTests package
   ```
3. Execute as aulas de exemplo (por exemplo, `Aula03`):
   ```bash
   mvn -q exec:java -Dexec.mainClass="com.lucas.estruturadados.testes.Aula03"
   ```

> **Observação:** em ambientes sem acesso ao Maven Central, utilize um mirror ou faça o download prévio das dependências necessárias (o projeto usa apenas plugins padrão do Maven).

## Estrutura do projeto

```
├── docs/                   # Documentação detalhada das estruturas de dados
├── src/main/java/          # Código-fonte das implementações
│   └── com/lucas/          # Pacotes organizados por tipo de estrutura
├── src/test/java/          # (Reservado para testes automatizados)
└── pom.xml                 # Configuração Maven
```

## Como contribuir

- Abra issues para reportar problemas ou sugerir novas estruturas.
- Faça um fork, crie uma branch com a sua melhoria e envie um pull request.
- Mantenha os exemplos e a documentação sincronizados com o código.

## Licença

Distribuído sob a licença MIT. Consulte o arquivo [`LICENSE`](LICENSE) (ou adicione-o caso ainda não exista) para mais detalhes.
