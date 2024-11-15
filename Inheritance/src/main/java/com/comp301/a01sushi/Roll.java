package com.comp301.a01sushi;

/**
 * This class represents a sushi roll. A sushi roll is a type of Sushi that contains a variety of
 * ingredients. A sushi roll has a name and a list of ingredients.
 */
public class Roll implements Sushi {
  private String name;
  private IngredientPortion[] ingredients;

  /**
   * This constructor initializes the sushi roll with its name and ingredients. The duplicated
   * ingredients in the sushi roll are combined to form a unique set of ingredients. The ingredients
   * in the sushi roll are ensured to contain at least 0.1 oz of seaweed.
   *
   * @param name The name of the sushi roll
   * @param ingredients The ingredients in the sushi roll
   */
  public Roll(String name, IngredientPortion[] ingredients) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }

    if (ingredients == null) {
      throw new IllegalArgumentException("Ingredients cannot be null");
    }

    if (ingredients.length == 0) {
      throw new IllegalArgumentException("Ingredients cannot be empty");
    }

    this.name = name;

    // A temporary array to store unique ingredients
    IngredientPortion[] ingredientsClone = new IngredientPortion[ingredients.length];
    // Tracks the number of unique ingredients
    int count = 0;

    // Loop through the ingredients array and combine any repeated ingredients
    for (int i = 0; i < ingredients.length; i++) {
      if (ingredients[i] == null) {
        throw new IllegalArgumentException("Ingredient cannot be null");
      }

      // Flag that checks if the current ingredient is already in the tempIngredients array
      boolean inTempIngredients = false;

      // Loop through the tempIngredients array to check if the current ingredient in the
      // ingredients array is already in the tempIngredients array
      for (int j = 0; j < count; j++) {
        boolean isSameIngredient =
            ingredientsClone[j].getIngredient().equals(ingredients[i].getIngredient());

        if (isSameIngredient) {
          // If current ingredient is already in the tempIngredients array, combine it with the
          // existing entry and exit the loop
          ingredientsClone[j] = ingredientsClone[j].combine(ingredients[i]);
          inTempIngredients = true;
          break;
        }
      }

      // If the ingredient was not found in the tempIngredients array, add it as a new entry
      if (!inTempIngredients) {
        ingredientsClone[count] = ingredients[i];
        count++;
      }
    }

    // Ensure there's at least 0.1 oz of seaweed
    boolean seaweedFound = false;

    // Loop through the tempIngredients array to check if seaweed is already in the array
    for (int i = 0; i < count; i++) {
      boolean isSeaweed = ingredientsClone[i].getIngredient().getName().equals("seaweed");

      // If seaweed is found, set the flag to true and ensure there's at least 0.1 oz of seaweed
      if (isSeaweed) {
        seaweedFound = true;

        if (ingredientsClone[i].getAmount() < 0.1) {
          ingredientsClone[i] = new SeaweedPortion(0.1);
        }

        break;
      }
    }

    // If seaweed wasn't found, add it
    if (!seaweedFound) {
      IngredientPortion[] updatedIngredients = new IngredientPortion[count + 1];

      for (int i = 0; i < count; i++) {
        updatedIngredients[i] = ingredientsClone[i];
      }

      updatedIngredients[count] = new SeaweedPortion(0.1);
      count++;
      ingredientsClone = updatedIngredients;
    }

    // Creates the final ingredients array with the correct size
    // Clones the original array to safely store the ingredients
    this.ingredients = new IngredientPortion[count];

    for (int i = 0; i < count; i++) {
      this.ingredients[i] = ingredientsClone[i];
    }
  }

  /**
   * This method returns the name of the sushi roll.
   *
   * @return The name of the sushi roll
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * This method returns the ingredients of the sushi roll.
   *
   * @return The ingredients of the sushi roll
   */
  @Override
  public IngredientPortion[] getIngredients() {
    // Return a copy of the ingredients array
    IngredientPortion[] ingredientsCopy = new IngredientPortion[this.ingredients.length];

    for (int i = 0; i < this.ingredients.length; i++) {
      ingredientsCopy[i] = this.ingredients[i];
    }

    return ingredientsCopy;
  }

  /**
   * This method returns the calories of the sushi roll.
   *
   * @return The calories of the sushi roll
   */
  @Override
  public int getCalories() {
    double calories = 0.0;

    for (int i = 0; i < this.ingredients.length; i++) {
      IngredientPortion ingredient = this.ingredients[i];
      calories = calories + ingredient.getCalories();
    }

    // Round first before converting to int to avoid integer truncation
    return (int) Math.round(calories);
  }

  /**
   * This method returns the cost of the sushi roll.
   *
   * @return The cost of the sushi roll
   */
  @Override
  public double getCost() {
    double cost = 0.0;

    for (int i = 0; i < this.ingredients.length; i++) {
      IngredientPortion ingredient = this.ingredients[i];
      cost = cost + ingredient.getCost();
    }

    // Round to two decimal places
    double roundedCost = Math.round(cost * 100.0);

    return roundedCost / 100.0;
  }

  /**
   * This method returns whether the sushi roll has rice.
   *
   * @return Whether the sushi roll has rice
   */
  @Override
  public boolean getHasRice() {
    boolean hasRice = false;

    for (int i = 0; i < this.ingredients.length; i++) {
      if (this.ingredients[i].getIsRice()) {
        hasRice = true;
      }
    }

    return hasRice;
  }

  /**
   * This method returns whether the sushi roll has shellfish.
   *
   * @return Whether the sushi roll has shellfish
   */
  @Override
  public boolean getHasShellfish() {
    boolean hasShellfish = false;

    for (int i = 0; i < this.ingredients.length; i++) {
      if (this.ingredients[i].getIsShellfish()) {
        hasShellfish = true;
      }
    }

    return hasShellfish;
  }

  /**
   * This method returns whether the sushi roll is vegetarian. A roll is vegetarian if all of its
   * ingredients are vegetarian.
   *
   * @return Whether the sushi roll is vegetarian
   */
  @Override
  public boolean getIsVegetarian() {
    boolean isVegetarian = true;

    for (int i = 0; i < this.ingredients.length; i++) {
      if (!this.ingredients[i].getIsVegetarian()) {
        isVegetarian = false;
      }
    }

    return isVegetarian;
  }
}
