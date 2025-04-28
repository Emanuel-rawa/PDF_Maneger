package model;

public class Slide extends InputLib {
  private String ssubject;
  private String institute;

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
