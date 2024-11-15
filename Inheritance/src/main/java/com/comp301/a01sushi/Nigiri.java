package com.comp301.a01sushi;

/**
 * This class represents a Nigiri sushi item. Nigiri is a type of Sushi that consists of a seafood
 * ingredient portion and a rice ingredient portion.
 */
public class Nigiri implements Sushi {
  private IngredientPortion seafoodPortion;
  private IngredientPortion ricePortion;
  private String name;

  /**
   * This enum represents the type of Nigiri sushi item. Each type of Nigiri has a specific seafood
   * ingredient portion and rice ingredient portion.
   */
  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  };

  /**
   * This constructor initializes the Nigiri sushi item with its type. The type determines the
   * seafood and rice ingredient portions of the Nigiri.
   *
   * @param type The type of Nigiri sushi item
   */
  public Nigiri(NigiriType type) {
    switch (type) {
      case TUNA:
        this.seafoodPortion = new TunaPortion(0.75);
        this.ricePortion = new RicePortion(0.5);
        this.name = "tuna nigiri";
        break;
      case YELLOWTAIL:
        this.seafoodPortion = new YellowtailPortion(0.75);
        this.ricePortion = new RicePortion(0.5);
        this.name = "yellowtail nigiri";
        break;
      case EEL:
        this.seafoodPortion = new EelPortion(0.75);
        this.ricePortion = new RicePortion(0.5);
        this.name = "eel nigiri";
        break;
      case CRAB:
        this.seafoodPortion = new CrabPortion(0.75);
        this.ricePortion = new RicePortion(0.5);
        this.name = "crab nigiri";
        break;
      case SHRIMP:
        this.seafoodPortion = new ShrimpPortion(0.75);
        this.ricePortion = new RicePortion(0.5);
        this.name = "shrimp nigiri";
        break;
      default:
        throw new IllegalArgumentException("Invalid nigiri type");
    }
  }

  /**
   * This method returns the name of the Nigiri sushi item.
   *
   * @return The name of the Nigiri sushi item
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * This method returns the ingredients of the Nigiri sushi item.
   *
   * @return The ingredients of the Nigiri sushi item
   */
  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingredientPortions = new IngredientPortion[2];
    ingredientPortions[0] = this.seafoodPortion;
    ingredientPortions[1] = this.ricePortion;

    return ingredientPortions;
  }

  /**
   * This method returns the calories of the Nigiri sushi item.
   *
   * @return The calories of the Nigiri sushi item
   */
  @Override
  public int getCalories() {
    // Round first before converting to int to avoid truncation
    int convertedCalories =
        (int) Math.round(this.seafoodPortion.getCalories() + this.ricePortion.getCalories());
    return convertedCalories;
  }

  /**
   * This method returns the cost of the Nigiri sushi item.
   *
   * @return The cost of the Nigiri sushi item
   */
  @Override
  public double getCost() {
    return this.seafoodPortion.getCost() + this.ricePortion.getCost();
  }

  /**
   * This method returns whether the Nigiri sushi item has rice.
   *
   * @return Whether the Nigiri sushi item has rice
   */
  @Override
  public boolean getHasRice() {
    return true;
  }

  /**
   * This method returns whether the Nigiri sushi item has shellfish.
   *
   * @return Whether the Nigiri sushi item has shellfish
   */
  @Override
  public boolean getHasShellfish() {
    return this.seafoodPortion.getIsShellfish();
  }

  /**
   * This method returns whether the Nigiri sushi item is vegetarian.
   *
   * @return Whether the Nigiri sushi item is vegetarian
   */
  @Override
  public boolean getIsVegetarian() {
    return this.seafoodPortion.getIsVegetarian();
  }
}
