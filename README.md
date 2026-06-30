# ♟️ Chess System

<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/OOP-Orientação%20a%20Objetos-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Terminal-CLI-black?style=for-the-badge&logo=gnubash&logoColor=white"/>
  <img src="https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge"/>
</p>

<p align="center">
  Sistema completo de xadrez desenvolvido em Java, executado via terminal, com implementação das regras oficiais do jogo e arquitetura orientada a objetos.
</p>


## 🖥️ Preview
```
8 R  N  B  Q  K  B  N  R
7 P  P  P  P  P  P  P  P
6 -  -  -  -  -  -  -  -
5 -  -  -  -  -  -  -  -
4 -  -  -  -  p  -  -  -
3 -  -  -  -  -  -  -  -
2 p  p  p  p  -  p  p  p
1 r  n  b  q  k  b  n  r
  a  b  c  d  e  f  g  h

Turn: White | Captured: []
Source: _
```

> 💡 **Dica:** Use `Ctrl +` no terminal Git Bash para ampliar o tabuleiro e ter uma melhor experiência visual.

## ✨ Funcionalidades
- ♟️ Movimentação completa de todas as peças
- 🔄 Controle de turnos (brancas e pretas)
- ⚔️ Captura de peças com exibição das peças capturadas
- 👑 Detecção de **Check**
- ☠️ Detecção de **Checkmate**
- 🏆 **Promoção de peão**
- 🏰 **Roque** (curto e longo)
- 🎯 **En passant**
- 🧩 Validação completa de jogadas (movimentos inválidos são bloqueados)
- 📋 Exibição do tabuleiro atualizada a cada turno no terminal


## 🛠️ Tecnologias e Conceitos
| Tecnologia / Conceito | Descrição |
|---|---|
| ☕ Java 17+ | Linguagem principal |
| 🧱 POO | Herança, polimorfismo, encapsulamento e abstração |
| 🎯 Estruturas de dados | Matrizes para representação do tabuleiro |
| 🏗️ Arquitetura em camadas | Separação entre camada de xadrez e camada de aplicação |
| ⚠️ Tratamento de exceções | Exceções customizadas para erros de jogo |


## 📁 Estrutura do Projeto

```
chess-system/
├── src/
│   ├── application/
│   │   ├── Program.java          # Ponto de entrada da aplicação
│   │   └── UI.java               # Interface do terminal (exibição e input)
│   ├── boardgame/
│   │   ├── Board.java            # Tabuleiro genérico
│   │   ├── Piece.java            # Peça genérica (abstrata)
│   │   └── Position.java         # Posição na matriz
│   └── chess/
│       ├── ChessMatch.java       # Regras e lógica da partida
│       ├── ChessPiece.java       # Peça de xadrez (abstrata)
│       ├── ChessPosition.java    # Posição no formato xadrez (ex: e4)
│       ├── Color.java            # Enum de cores (BLACK/WHITE)
│       └── pieces/
│           ├── King.java
│           ├── Queen.java
│           ├── Rook.java
│           ├── Bishop.java
│           ├── Knight.java
│           └── Pawn.java
└── bin/                          # Bytecode compilado (.class)
```

## 🚀 Como Executar

### Pré-requisitos
- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Git](https://git-scm.com/) com Git Bash

### Passo a passo
**1. Clone o repositório**
```bash
git clone https://github.com/Raphael-Java/chess-system.git
```

**2. Acesse a pasta de bytecode**
```bash
cd chess-system/bin
```

**3. Execute o programa**
```bash
java application/Program
```

## 🎮 Como Jogar
1. O jogo exibe o tabuleiro e indica de qual cor é o turno
2. Digite a **posição de origem** da peça (ex: `e2`)
3. O tabuleiro destacará os **movimentos possíveis** para a peça selecionada
4. Digite a **posição de destino** (ex: `e4`)
5. Em caso de promoção de peão, escolha a peça desejada: `B` (bispo), `N` (cavalo), `R` (torre) ou `Q` (rainha)

## 📐 Arquitetura
O projeto é dividido em duas camadas principais:
- **`boardgame`** — camada genérica de tabuleiro, independente das regras do xadrez
- **`chess`** — camada específica do xadrez, com peças, movimentos especiais e lógica da partida
- **`application`** — responsável pela interface com o usuário no terminal

Essa separação facilita a manutenção e permite reaproveitar a camada `boardgame` em outros jogos de tabuleiro.

## 👨‍💻 Autor
Feito com ☕ por **Raphael Alvim**

[![GitHub](https://img.shields.io/badge/GitHub-Raphael--Java-181717?style=flat-square&logo=github)](https://github.com/Raphael-Java)

