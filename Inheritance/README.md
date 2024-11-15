# `Inheritance` Directory - An Exploration of Inheritance with Sushi as a Metaphor

The `Inheritance` directory provides an engaging introduction to the principles of inheritance in object-oriented programming, all through the familiar (and delicious) lens of sushi ingredients and dishes. The directory is organized to reflect a sushi restaurant experience, where each class and interface plays a role in constructing sushi pieces, plates, and portions. This approach is designed to make the abstract concept of inheritance concrete by connecting it to recognizable elements of Japanese cuisine, specifically focusing on the sushi-making process and its components.

## Concept Overview

In object-oriented programming, inheritance allows us to define shared characteristics in a parent class and extend or specialize them in child classes. In the `Inheritance` directory, the sushi metaphor simplifies this concept. Each ingredient—like avocado, tuna, and shrimp—becomes a child class that inherits from a general ingredient parent class. This setup mirrors real-world objects where items share common traits but also retain unique attributes, making inheritance a perfect fit for creating a structured hierarchy of sushi ingredients and recipes.

## Ingredient Classes: Building Blocks of Sushi

The foundation of the sushi hierarchy begins with ingredients, each represented by a class inheriting from a base ingredient class. In this base class, shared characteristics of sushi ingredients are captured, such as:
- **Price per ounce**: Cost in dollars for each ounce of the ingredient
- **Calories per ounce**: Nutritional value, represented by calorie count
- **Dietary properties**: Boolean values for attributes like vegetarian, containing rice, and containing shellfish

These shared characteristics form the basis for a parent ingredient class, which the following subclasses expand on:
- **Avocado**: Vegetarian, no shellfish, no rice
- **Crab**: Contains shellfish, not vegetarian, no rice
- **Eel, Shrimp, Tuna, Yellowtail**: Unique seafood options, with varying prices and calories
- **Rice**: A vegetarian option that includes rice
- **Seaweed**: Often serves as a wrapper for sushi, vegetarian-friendly

Each of these ingredients inherits basic properties from the parent class but is configured in its subclass with its specific attributes (e.g., unique price, calorie count, dietary properties).

### Example:
The `Avocado` class, for instance, will have a parameterless constructor that initializes its characteristics by calling the parent class's constructor with avocado-specific values (like its price per ounce, calorie count, and whether it's vegetarian). This approach reduces redundancy and ensures all ingredients share a consistent structure, managed by the parent class.

## Ingredient Portions: Scaling Ingredients for Sushi Creations

With the ingredients in place, we delve into portions—representing quantities of each ingredient in ounces, which is essential for making sushi pieces like sashimi, nigiri, and rolls. Each portion class encapsulates an instance of the ingredient it represents, allowing it to retain specific characteristics while adding functionality:
- **Portion Size**: Each portion class allows users to define how much of an ingredient is needed, in ounces.
- **Combining Portions**: Classes implementing the `IngredientPortion` interface provide a `combine` method, which lets two portions of the same ingredient be combined into a larger portion.

This setup models real-world sushi preparation, where ingredient quantities are adjusted based on the type of sushi being made. Additionally, the inheritance structure here allows for elegant reuse of ingredient properties within portions, avoiding duplication and keeping the code streamlined.

## Sushi Types: Composing Sashimi, Nigiri, and Rolls

With ingredients and portions established, we can now create full sushi pieces: sashimi, nigiri, and rolls, each represented by a class implementing a `Sushi` interface.

### Sashimi: Pure Seafood Simplicity
A `Sashimi` class models the simplest type of sushi, consisting of a 0.75-ounce portion of seafood. Different types of sashimi—like tuna, yellowtail, and shrimp—are handled by a public enumeration, `SashimiType`, allowing the `Sashimi` class to represent a variety of sashimi dishes. The constructor initializes the correct seafood portion based on the chosen type, making each instance reflect the unique name and properties of the selected seafood, such as "tuna sashimi" or "crab sashimi."

### Nigiri: Seafood with a Rice Foundation
The `Nigiri` class extends the sashimi concept by adding a 0.5-ounce portion of rice. Similar to sashimi, nigiri offers variations based on its seafood component, which is managed by a `NigiriType` enumeration. Each type of nigiri is a blend of rice and seafood, with a constructor that initializes both ingredients, naming the dish accordingly (e.g., "eel nigiri"). The combination of ingredients shows the power of composition within the inheritance framework, combining different ingredient objects to form a complete dish.

### Rolls: Complex and Customizable
The `Roll` class takes sushi creation to the next level, supporting a customizable array of ingredient portions, allowing for unique and intricate sushi rolls. When creating a `Roll`, the user provides a name and an array of ingredient portions:
- **Ingredient Validation**: Ensures each portion in the array is valid, throwing an exception if any ingredient is invalid.
- **Wrapper Requirement**: If no seaweed is included in the ingredients, the `Roll` constructor automatically adds a minimum 0.1-ounce portion of seaweed to represent the wrapper, unless the roll already contains sufficient seaweed.

Additionally, rolls are equipped to handle repeated ingredient types, combining portions to maintain a single ingredient type for simplicity and consistency. This feature demonstrates a flexible approach to sushi design, accommodating diverse ingredients while adhering to specific constraints.

## Summary

The `Inheritance` directory is a carefully structured simulation of inheritance, composition, and object-oriented organization, making abstract design principles tangible through the assembly of sushi. By following this directory, you will explore how a parent class can encapsulate shared traits, while subclasses can refine and extend these characteristics in specialized ways. Sushi creation provides a rich analogy for these principles:
- **Hierarchy and Shared Traits**: The shared qualities of ingredients form a solid hierarchy, allowing specific types of sushi to inherit, modify, and combine ingredients.
- **Composition**: By combining portions, you can create complex and layered sushi dishes, showing how composition works hand-in-hand with inheritance to create versatile, modular code.

The sushi-inspired organization of this directory provides an engaging, memorable introduction to inheritance, leaving you with both a better understanding of object-oriented design and perhaps a craving for your favorite sushi roll!
