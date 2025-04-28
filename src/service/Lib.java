package service;

import model.InputLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma biblioteca que gerencia uma coleção de entradas (arquivos
 * PDF).
 */
public class Lib {
  private String path_lib;
  private List<InputLib> inputs;

  /**
   * Construtor da Biblioteca.
   * 
   * @param path_lib Caminho do diretório da biblioteca no sistema.
   */
  public Lib(String path_lib) {
    this.path_lib = path_lib;
    this.inputs = new ArrayList<>();
  }

  /**
   * Adiciona uma nova entrada na biblioteca.
   * 
   * @param input Entrada a ser adicionada.
   */
  public void addInput(InputLib input) {
    inputs.add(input);
  }

  /**
   * Retorna a lista de entradas da biblioteca.
   * 
   * @return Lista de entradas.
   */
  public List<InputLib> findedLists() {
    return inputs;
  }

  public String getPathLib() {
    return path_lib;
  }
}
