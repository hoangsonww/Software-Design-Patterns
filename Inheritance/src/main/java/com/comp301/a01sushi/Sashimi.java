package com.comp301.a01sushi;

/**
 * This class represents a sashimi sushi item. Sashimi is a type of Sushi that consists of a single
 * ingredient portion.
 */
public class Sashimi implements Sushi {
  private IngredientPortion ingredientPortion;
  private String name;

  /** This enum represents the different types of sashimi that can be created. */
  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  };

  /**
   * This constructor initializes the sashimi sushi item with its type. The type determines the
   * ingredient portion of the sashimi.
   *
   * @param type The type of sashimi sushi item
   */
  public Sashimi(SashimiType type) {
    switch (type) {
      case TUNA:
        this.ingredientPortion = new TunaPortion(0.75);
        this.name = "tuna sashimi";
        break;
      case YELLOWTAIL:
        ingredientPortion = new YellowtailPortion(0.75);
        name = "yellowtail sashimi";
        break;
      case EEL:
        ingredientPortion = new EelPortion(0.75);
        name = "eel sashimi";
        break;
      case CRAB:
        ingredientPortion = new CrabPortion(0.75);
        name = "crab sashimi";
        break;
      case SHRIMP:
        ingredientPortion = new ShrimpPortion(0.75);
        name = "shrimp sashimi";
        break;
      default:
        throw new IllegalArgumentException("Invalid sashimi type");
    }
  }

  /**
   * This method returns the name of the sashimi sushi item.
   *
   * @return The name of the sashimi sushi item
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * This method returns the ingredient portions of the sashimi sushi item.
   *
   * @return The ingredient portions of the sashimi sushi item
   */
  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingredientPortions = new IngredientPortion[1];
    ingredientPortions[0] = this.ingredientPortion;

    return ingredientPortions;
  }

  /**
   * This method returns the calories of the sashimi sushi item.
   *
   * @return The calories of the sashimi sushi item
   */
  @Override
  public int getCalories() {
    int convertedCalories = (int) Math.round(this.ingredientPortion.getCalories());
    return convertedCalories;
  }

  /**
   * This method returns the cost of the sashimi sushi item.
   *
   * @return The cost of the sashimi sushi item
   */
  @Override
  public double getCost() {
    return this.ingredientPortion.getCost();
  }

  /**
   * This method returns whether the sashimi sushi item has rice.
   *
   * @return Whether the sashimi sushi item has rice
   */
  @Override
  public boolean getHasRice() {
    return this.ingredientPortion.getIsRice();
  }

  /**
   * This method returns whether the sashimi sushi item has shellfish.
   *
   * @return Whether the sashimi sushi item has shellfish
   */
  @Override
  public boolean getHasShellfish() {
    return this.ingredientPortion.getIsShellfish();
  }

  /**
   * This method returns whether the sashimi sushi item is vegetarian.
   *
   * @return Whether the sashimi sushi item is vegetarian
   */
  @Override
  public boolean getIsVegetarian() {
    return this.ingredientPortion.getIsVegetarian();
  }
}
