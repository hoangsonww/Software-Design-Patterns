package com.comp301.a01sushi;

/**
 * This class represents a general ingredient. Ingredients have a name, price per ounce, calories
 * per ounce, and whether they are vegetarian, rice, or shellfish.
 */
public abstract class IngredientGeneral implements Ingredient {
  private String name;
  private double pricePerOunce;
  private int caloriesPerOunce;
  private boolean isVegetarian;
  private boolean hasRice;
  private boolean hasShellfish;

  /**
   * This constructor initializes the ingredient with its name, price per ounce, calories per ounce,
   * and whether it is vegetarian, rice, or shellfish.
   *
   * @param name The name of the ingredient
   * @param pricePerOunce The price of the ingredient per ounce
   * @param caloriesPerOunce The calories of the ingredient per ounce
   * @param isVegetarian Whether the ingredient is vegetarian
   * @param isRice Whether the ingredient is rice
   * @param isShellfish Whether the ingredient is shellfish
   */
  public IngredientGeneral(
      String name,
      double pricePerOunce,
      int caloriesPerOunce,
      boolean isVegetarian,
      boolean isRice,
      boolean isShellfish) {
    this.name = name;
    this.pricePerOunce = pricePerOunce;
    this.caloriesPerOunce = caloriesPerOunce;
    this.isVegetarian = isVegetarian;
    this.hasRice = isRice;
    this.hasShellfish = isShellfish;
  }

  /**
   * This method returns the name of the ingredient.
   *
   * @return The name of the ingredient
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * This method returns the number of calories per dollar of the ingredient.
   *
   * @return The number of calories per dollar's worth of the ingredient
   */
  @Override
  public double getCaloriesPerDollar() {
    double caloriesPerDollar = this.caloriesPerOunce / this.pricePerOunce;
    return caloriesPerDollar;
  }

  /**
   * This method returns the number of calories in one ounce of the ingredient.
   *
   * @return The number of calories per ounce of the ingredient
   */
  @Override
  public int getCaloriesPerOunce() {
    return this.caloriesPerOunce;
  }

  /**
   * This method returns the price of one ounce of the ingredient.
   *
   * @return The price per ounce of the ingredient, in dollars
   */
  @Override
  public double getPricePerOunce() {
    return this.pricePerOunce;
  }

  /**
   * This method returns true if the ingredient is vegetarian.
   *
   * @return True if the ingredient is vegetarian; false if otherwise
   */
  @Override
  public boolean getIsVegetarian() {
    return this.isVegetarian;
  }

  /**
   * This method returns true if the ingredient is rice.
   *
   * @return True if the ingredient is rice; false if otherwise
   */
  @Override
  public boolean getIsRice() {
    return this.hasRice;
  }

  /**
   * This method returns true if the ingredient is shellfish.
   *
   * @return True if the ingredient is shellfish; false if otherwise
   */
  @Override
  public boolean getIsShellfish() {
    return this.hasShellfish;
  }

  /**
   * This method determines whether the ingredient is the same as another ingredient.
   *
   * @param other The other ingredient to compare
   * @return If other is null, returns false; otherwise, compares the name, calories, price (within
   *     1 cent), vegetarian, rice, and shellfish properties of the two ingredients. If all of them
   *     are the same, returns true. If any are different, returns false.
   */
  @Override
  public boolean equals(Ingredient other) {
    if (other == null) {
      return false;
    }

    boolean isSameName = this.getName().equals(other.getName());
    boolean isSameCaloriesPerOunce = this.getCaloriesPerOunce() == other.getCaloriesPerOunce();
    boolean isSameVegetarian = this.getIsVegetarian() == other.getIsVegetarian();
    boolean isSameRice = this.getIsRice() == other.getIsRice();
    boolean isSameShellfish = this.getIsShellfish() == other.getIsShellfish();
    double priceDifference = Math.abs(this.getPricePerOunce() - other.getPricePerOunce());
    boolean isSamePrice = false;

    if (priceDifference <= 0.01) {
      isSamePrice = true;
    }

    boolean areEqualIngredients =
        isSameName
            && isSameCaloriesPerOunce
            && isSamePrice
            && isSameVegetarian
            && isSameRice
            && isSameShellfish;

    return areEqualIngredients;
  }
}
