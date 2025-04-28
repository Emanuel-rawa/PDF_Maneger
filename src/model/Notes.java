package model;

public class Notes extends InputLib {

  private String subtitle;
  private String ssubject;
  private String institute;
  private int num_of_pages;

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
