package model;

/**
 * Classe abstrata que representa uma entrada genérica na biblioteca de PDFs.
 * Contém informações comuns a livros, notas de aula e slides.
 */
public abstract class InputLib {
  protected String authors;
  protected String title;
  protected String path_file;

  /**
   * Construtor da entrada da biblioteca.
   * 
   * @param authors   Nomes dos autores.
   * @param title     Título do documento.
   * @param path_file Caminho do arquivo PDF na biblioteca.
   */
  public InputLib(String authors, String title, String path_file) {
    this.authors = authors;
    this.title = title;
    this.path_file = path_file;
  }

  public String getAuthors() {
    return authors;
  }

  public String getTitle() {
    return title;
  }

  public String getPath() {
    return path_file;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setPath(String path_file) {
    this.path_file = path_file;
  }

  /**
   * Retorna o tipo da entrada (Livro, Nota de Aula ou Slide).
   * 
   * @return Tipo da entrada.
   */
  public abstract String getType();

  @Override
  public String toString() {
    return "[" + getType() + "] " + title + " - " + authors;
  }

}
