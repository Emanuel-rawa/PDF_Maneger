package service;

import model.InputLib;

import java.util.ArrayList;
import java.util.List;

public class Lib {
  private String path_lib;
  private List<InputLib> inputs;

  public Lib(String path_lib) {
    this.path_lib = path_lib;
    this.inputs = new ArrayList<>();
  }

  public void addInput(InputLib input) {
    inputs.add(input);
  }

  public List<InputLib> findedLists() {
    return inputs;
  }

  public String getPathLib() {
    return path_lib;
  }
}
