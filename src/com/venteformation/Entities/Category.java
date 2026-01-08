package com.venteformation.Entities;

public class Category {


  private final String name;
  private int id;


  // Constructeur
  public Category(final String name) {
    this.name = name;
  }

  /**
   * Méthode toString.
   */
  @Override
  public String toString() {
    return "Category{"
        + "id=" + id
        + ", name='"
        + name
        + '\''
        + '}';
  }

  // Getters

  /**
   * Méthode getId.
   *
   * @return : id
   */
  public int getId() {
    return id;
  }

  /**
   * Méthode setId.
   *
   * @param id : id
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Méthode getName.
   *
   * @return : nom
   */
  public String getName() {
    return name;
  }

}
