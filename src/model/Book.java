package model;

public class Book extends InputLib {
  private String subtitle;
  private String area;
  private int year_publish;
  private String publisher;
  private int num_of_pages;

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
