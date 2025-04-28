package persistence;

import java.io.*;
import java.nio.file.*;

public class Persistence {
  private static final String PATH_FILE = "path.txt";

  public static void savePath(String path) throws IOException {
    Files.write(Paths.get(PATH_FILE), path.getBytes());
  }

  public static String loadPath() throws IOException {
    if (!Files.exists(Paths.get(PATH_FILE))) {
      return null;
    }
    return new String(Files.readAllBytes(Paths.get(PATH_FILE)));
  }
}
