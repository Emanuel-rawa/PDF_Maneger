package service;

import model.*;
import model.PdfCollection;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class CollectionService {
  private Map<String, PdfCollection<? extends InputLib>> collections = new HashMap<>();

  public <T extends InputLib> void createCollection(String name, String author, int maxSize, Class<T> type) {
    PdfCollection<T> collection = new PdfCollection<>(name, author, maxSize, type);
    collections.put(name, collection);
  }

  public boolean addEntryToCollection(String name, InputLib entry) {
    PdfCollection<? extends InputLib> collection = collections.get(name);
    if (collection == null || !collection.getType().isInstance(entry))
      return false;

    @SuppressWarnings("unchecked")
    PdfCollection<InputLib> rawCollection = (PdfCollection<InputLib>) collection;

    return rawCollection.addEntry(entry);
  }

  public boolean removeEntryFromCollection(String name, InputLib entry) {
    PdfCollection<? extends InputLib> collection = collections.get(name);
    if (collection == null)
      return false;

    @SuppressWarnings("unchecked")
    PdfCollection<InputLib> rawCollection = (PdfCollection<InputLib>) collection;

    boolean removed = rawCollection.removeEntry(entry);

    if (collection.isEmpty())
      collections.remove(name);
    return removed;
  }

  public void generateBibTex(String name, String outputPath) throws IOException {
    PdfCollection<?> collection = collections.get(name);
    if (collection == null || !collection.getType().equals(Book.class))
      return;

    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath))) {
      for (InputLib input : collection.getEntries()) {
        Book book = (Book) input;
        writer.write(String.format("""
            @book{%s,
              author = {%s},
              title = {%s},
              year = {%d},
              publisher = {%s}
            }
            """,
            book.getTitle().replaceAll("\\s", ""),
            book.getAuthors(),
            book.getTitle(),
            book.getYearPublish(),
            book.getPublisher()));
        writer.newLine();
      }
    }
  }

  public void zipCollection(String name, String outputZipPath) throws IOException {
    PdfCollection<?> collection = collections.get(name);
    if (collection == null)
      return;

    try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputZipPath))) {
      for (InputLib entry : collection.getEntries()) {
        Path path = Paths.get(entry.getPath());
        zos.putNextEntry(new ZipEntry(path.getFileName().toString()));
        Files.copy(path, zos);
        zos.closeEntry();
      }
    }
  }

  public List<PdfCollection<? extends InputLib>> listByAuthor(String author) {
    List<PdfCollection<? extends InputLib>> result = new ArrayList<>();
    for (PdfCollection<? extends InputLib> c : collections.values()) {
      if (c.getAuthor().equalsIgnoreCase(author)) {
        result.add(c);
      }
    }
    return result;
  }

  public List<PdfCollection<? extends InputLib>> listAll() {
    return new ArrayList<>(collections.values());
  }

}
