package persistence;

import java.io.*;
import java.nio.file.*;

/**
 * Classe responsável por gerenciar a persistência do caminho da biblioteca.
 */
public class Persistence {
  private static final String PATH_FILE = "path.txt";

  /**
   * Salva o caminho da biblioteca em um arquivo de texto.
   * 
   * @param path Caminho a ser salvo.
   * @throws IOException Caso ocorra erro de escrita no arquivo.
   */
  public static void savePath(String path) throws IOException {
    Files.write(Paths.get(PATH_FILE), path.getBytes());
  }

  /**
   * Carrega o caminho da biblioteca do arquivo de texto.
   * 
   * @return Caminho da biblioteca ou null se o arquivo não existir.
   * @throws IOException Caso ocorra erro de leitura do arquivo.
   */
  public static String loadPath() throws IOException {
    if (!Files.exists(Paths.get(PATH_FILE))) {
      return null;
    }
    return new String(Files.readAllBytes(Paths.get(PATH_FILE)));
  }
}
