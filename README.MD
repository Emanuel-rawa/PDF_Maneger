# 📚 PDF Library Manager

Sistema de linha de comando em Java para gerenciar uma biblioteca de arquivos PDF (livros, anotações e slides).

## 🚀 Funcionalidades

- ✅ Cadastro de entradas (Book, Notes, Slide)
- 📂 Organização por autor
- 🔍 Busca, edição e exclusão de arquivos
- 🗃️ Sistema de coleções:
  - Criação de coleções por tipo e autor
  - Adição e remoção de entradas
  - Exportação `.bib` (BibTeX) para coleções de livros
  - Compactação `.zip` com os PDFs da coleção
- 💾 Persistência do caminho da biblioteca

## 📦 Estrutura---
### 📦 Estrutura de diretórios
```
    PDFLibraryManager/
    ├── src/
    │   ├── model/
    │   ├── service/
    │   ├── persistence/
    │   ├── view/
    │   └── Main.java
    ├── biblioteca_path.txt
    ├── README.md
    └── doc/ (gerado pelo Javadoc)
```
---
### 🚀 Como executar

Compile o projeto:

    javac -d bin src/**/*.java

Execute o projeto:

    java -cp bin Main
---
### 🖋️ Documentação

A documentação Javadoc está disponível no diretório doc/.

Para gerar novamente:

    javadoc -d doc src/**/*.java
---
### 👨‍💻 Tecnologias utilizadas

- Java 17+

- Programação Orientada a Objetos

- Javadoc
---
### 📅 Projeto acadêmico

Projeto desenvolvido para a disciplina Projeto I - DIM0116
Professor: Valdigleis S. Costa
Universidade: Universidade Federal do Rio Grande do Norte
---
### 🎯 Status:
- ✅ CRUD completo
- ✅ Persistência
- ✅ Organização em camadas (MVC simples)
- ✅ Documentação gerada via Javadoc

###📜 Licença

Este projeto é acadêmico e de uso educacional.
