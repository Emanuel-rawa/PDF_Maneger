package model;

/**
 * Representa uma anotação dentro da biblioteca de PDFs.
 */
public class Notes extends InputLib {

  private String subtitle;
  private String ssubject;
  private String institute;
  private int num_of_pages;

  /**
   * Construtor da classe Notes.
   * 
   * @param authors      Nomes dos autores.
   * @param title        Título da anotação.
   * @param subtitle     Subtítulo do anotação.
   * @param ssubject     Área de conhecimento da anotação.
   * @param institute    Instituto da qual a anotação pertence.
   * @param path_file    Caminho do arquivo PDF na biblioteca.
   * @param num_of_pages Número de páginas (opcional).
   */
  public Notes(String authors, String title, String path_file, String subtitle, String ssubject, String institute,
      int num_of_pages) {
    super(authors, title, path_file);
    this.subtitle = subtitle;
    this.ssubject = ssubject;
    this.institute = institute;
    this.num_of_pages = num_of_pages;
  }

  @Override
  public String getType() {
    return "Notes";
  }
}
