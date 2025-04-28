package model;

public abstract class InputLib {
  protected String authors;
  protected String title;
  protected String path_file;

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

  public abstract String getType();

  @Override
  public String toString() {
    return "[" + getType() + "] " + title + " - " + authors;
  }

}
