package view;

import model.*;
import persistence.Persistence;
import service.Lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Sistema de gerenciamento de uma biblioteca de arquivos PDF.
 * 
 * Permite adicionar, listar, buscar, editar e deletar entradas organizadas por
 * autor.
 *
 * Dá para adcionar alguns alias para facilitar a navegação do sistema e fazer
 * uma interface mais bonitinha.
 */
public class SystemLib {
  private Lib lib;
  private Scanner scanner = new Scanner(System.in);

  /**
   * Inicia o sistema carregando o caminho da biblioteca "persistence",
   * ou criando uma nova se necessário
   */
  public void start() {
    try {
      String path = Persistence.loadPath();
      if (path == null || !new File(path).exists()) {
        System.out.print("Insert the path for the new library: ");
        path = scanner.nextLine();
        new File(path).mkdirs();
        Persistence.savePath(path);
      }
      lib = new Lib(path);
      menu();
    } catch (IOException e) {
      System.out.println("Persistence error: " + e.getMessage());
    }
  }

  /**
   * Exibe o menu principal, as opções do CRUD vão aparecer aqui.
   */
  private void menu() {
    int choice;
    do {
      System.out.println("\n=== Welcome! ===");
      System.out.println("1. Add file");
      System.out.println("2. List file");
      System.out.println("3. Search file");
      System.out.println("4. Edit file");
      System.out.println("5. Delete file");
      System.out.println("0. exit");
      System.out.print("Choice: ");
      choice = Integer.parseInt(scanner.nextLine());

      switch (choice) {
        case 1 -> addInput();
        case 2 -> listInputs();
        case 3 -> searchInput();
        case 4 -> editFile();
        case 5 -> deleteFile();
        case 0 -> System.out.println("Saindo...");
        default -> System.out.println("Opção inválida!");
      }
    } while (choice != 0);
  }

  /**
   * Adiciona nova entrada (Livro, Anotação ou Slide) na biblioteca.
   */
  private void addInput() {
    System.out.println("\nEnter the type of entry (Book, Note, Slide): ");
    String type = scanner.nextLine();

    System.out.print("Title: ");
    String title = scanner.nextLine();

    System.out.print("Authors (separete by commas): ");
    String authors = scanner.nextLine();

    String subtitle = "";
    String area = "";
    String publisher = "";
    int year_publish = 0;
    String subject = "";
    String institute = "";
    int num_of_pages = 0;

    if (type.contains("book") || type.contains("note")) {
      System.out.print("Subtitle: ");
      subtitle = scanner.nextLine();
    }

    if (type.contains("book")) {
      System.out.print("Knowladge area: ");
      area = scanner.nextLine();

      System.out.print("Publisher: ");
      publisher = scanner.nextLine();

      System.out.print("Year of publish");
      year_publish = Integer.parseInt(scanner.nextLine());
    }

    if (type.contains("note") || type.contains("slide")) {
      System.out.print("Subject: ");
      subject = scanner.nextLine();
    }

    System.out.print("Institute: ");
    institute = scanner.nextLine();

    System.out.print("Path to PDF: ");
    String origin_path = scanner.nextLine();

    try {
      String new_path = copyToLib(origin_path, authors);
      InputLib entry = null;

      if (type.contains("livro")) {
        entry = new Book(authors, title, subtitle, area, year_publish, new_path, publisher, num_of_pages);
      } else if (type.contains("note")) {
        entry = new Notes(authors, title, new_path, subtitle, subject, institute, num_of_pages);
      } else if (type.contains("slide")) {
        entry = new Slide(authors, title, new_path, subject, institute);
      }
      lib.addInput(entry);
      System.out.println("Entry [" + entry.getType() + "] successfully added");

    } catch (IOException e) {
      System.out.println("Error to copy file: " + e.getMessage());
    }
  }

  /**
   * Copia o arquivo PDF original informado para um diretor do autor na
   * biblioteca.
   * 
   * @param originPath Caminho original do arquivo.
   * @param authors    Nome dos autores separados por vírgula.
   * @return Novo caminho do arquivo dentro da biblioteca.
   * @throws IOException Se ocorrer erro na cópia do arquivo.
   */
  private String copyToLib(String originPath, String authors) throws IOException {
    File original_file = new File(originPath);
    if (!original_file.exists()) {
      throw new FileNotFoundException("Can't find PDF" + originPath);
    }

    String first_author = authors.split(",")[0].trim();
    String author_folder = lib.getPathLib() + File.separator + first_author;

    File author_dir = new File(author_folder);
    if (!author_dir.exists()) {
      author_dir.mkdirs();
    }

    Path origin = Paths.get(originPath);
    Path destination = Paths.get(author_folder, original_file.getName());

    Files.copy(origin, destination, StandardCopyOption.REPLACE_EXISTING);
    return destination.toString();
  }

  /**
   * Busca e exibe entradas que tenham título (atributo mínimo).
   */
  private void searchInput() {
    System.out.print("Enter the title to search: ");
    String search = scanner.nextLine().toLowerCase();

    boolean finded = true;

    for (InputLib input : lib.findedLists()) {
      if (input.getTitle().toLowerCase().contains(search)) {
        System.out.println(input);
        finded = true;
      }
    }
    if (!finded) {
      System.out.println("Can't find a entry with this title");
    }
  }

  /**
   * Edita o nome e os autores de uma entrada.
   */
  private void editFile() {
    System.out.print("Enter the title of the entry you want to edit: ");
    String search = scanner.nextLine().toLowerCase();

    for (InputLib input : lib.findedLists()) {
      if (input.getTitle().toLowerCase().contains(search)) {
        System.out.print("New title (empty to keep): ");
        String new_title = scanner.nextLine();
        if (!new_title.isEmpty()) {
          input.setTitle(new_title);
        }

        System.out.print("New authors (empty to keep): ");
        String new_author = scanner.nextLine();
        if (!new_author.isEmpty()) {
          input.setAuthors(new_author);
        }

        System.out.println("Entry successfully edited");
        return;
      }
    }
    System.out.println("Error: Can't find entry");
  }

  /**
   * Deleta uma entrada existente, baseado no título dela.
   */

  private void deleteFile() {
    System.out.print("Enter the title of the entry you want to delete: ");
    String search = scanner.nextLine().toLowerCase();

    InputLib toRemove = null;
    for (InputLib input : lib.findedLists()) {
      if (input.getTitle().toLowerCase().contains(search)) {
        toRemove = input;
        break;
      }
    }

    if (toRemove != null) {
      lib.findedLists().remove(toRemove);
      System.out.println("Entry successfully removed");
    } else {
      System.out.println("Error: Can't find entry");
    }
  }

  /**
   * Lista as entradas cadastradas.
   */
  private void listInputs() {
    if (lib.findedLists().isEmpty()) {
      System.out.println("Empty dir");
      return;
    }
    for (InputLib input : lib.findedLists()) {
      System.out.println(input);
    }
  }

}
