# 📚 PDF Library Manager

Gerenciador de arquivos PDF em linha de comando, desenvolvido em Java, com estrutura de Programação Orientada a Objetos (POO).
🛠 Funcionalidades

- 📂 Criação de bibliotecas de PDFs organizadas por autor.

- ➕ Adicionar novas entradas (Livro, Notas de Aula, Slide).

- 🔎 Buscar entradas pelo título.

- ✏️ Editar entradas (título e autores).

- ❌ Deletar entradas da biblioteca.

- 📥 Cópia automática dos arquivos PDF para a pasta do autor.

- 🗃️ Persistência do caminho da biblioteca entre execuções.
---
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
#### 🎯 Status:
✅ CRUD completo
✅ Persistência
✅ Organização em camadas (MVC simples)
✅ Documentação gerada via Javadoc
📜 Licença

Este projeto é acadêmico e de uso educacional.
