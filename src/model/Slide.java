package model;

/**
 * Representa um Slide dentro da biblioteca de PDFs.
 */
public class Slide extends InputLib {
  private String ssubject;
  private String institute;

  /**
   * Constructor da classe Slide.
   * 
   * @param authors   Autor do Slide.
   * @param title     Título do Slide.
   * @param path_file Caminho para o PDF.
   * @param ssubject  Disciplina/matéria do slide.
   * @param institute Instituto gerador do PDF.
   */
  public Slide(String authors, String title, String path_file, String ssubject, String institute) {
    super(authors, title, path_file);
    this.ssubject = ssubject;
    this.institute = institute;
  }

  @Override
  public String getType() {
    return "Slide";
  }
}
