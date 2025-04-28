package model;

/**
 * Representa um livro dentro da biblioteca de PDFs.
 */
public class Book extends InputLib {
  private String subtitle;
  private String area;
  private int year_publish;
  private String publisher;
  private int num_of_pages;

  /**
   * Construtor da classe Livro.
   * 
   * @param authors      Nomes dos autores.
   * @param title        Título do livro.
   * @param subtitle     Subtítulo do livro.
   * @param area         Área de conhecimento do livro.
   * @param year_publish Ano de publicação do livro.
   * @param path_file    Caminho do arquivo PDF na biblioteca.
   * @param publisher    Nome da editora (opcional).
   * @param num_of_pages Número de páginas (opcional).
   */
  public Book(String authors, String title, String subtitle, String area, int year_publish, String path_file,
      String publisher, int num_of_pages) {
    super(authors, title, path_file);
    this.subtitle = subtitle;
    this.area = area;
    this.year_publish = year_publish;
    this.publisher = publisher;
    this.num_of_pages = num_of_pages;
  }

  @Override
  public String getType() {
    return "Book";
  }
}
