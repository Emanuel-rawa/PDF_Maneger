package model;

import java.util.ArrayList;
import java.util.List;

public class PdfCollection<T extends InputLib> {
  private String name;
  private String author;
  private int maxSize;
  private Class<T> type;
  private List<T> entries;

  public PdfCollection(String name, String author, int maxSize, Class<T> type) {
    this.name = name;
    this.author = author;
    this.maxSize = maxSize;
    this.type = type;
    this.entries = new ArrayList<>();
  }

  public boolean addEntry(T entry) {
    if (entries.size() >= maxSize)
      return false;
    if (!entry.getAuthors().equalsIgnoreCase(author))
      return false;
    if (!type.isInstance(entry))
      return false;
    entries.add(entry);
    return true;
  }

  public boolean removeEntry(T entry) {
    return entries.remove(entry);
  }

  public boolean isEmpty() {
    return entries.isEmpty();
  }

  public String getName() {
    return name;
  }

  public String getAuthor() {
    return author;
  }

  public List<T> getEntries() {
    return entries;
  }

  public Class<T> getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Collection '" + name + "' [" + type.getSimpleName() + "] by " + author + ", "
        + entries.size() + "/" + maxSize + " items";
  }
}
