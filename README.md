# Design Patterns Repository

Welcome to the **Design Patterns Repository**! This project provides a hands-on exploration of several essential object-oriented design patterns. Each directory in this repository introduces a distinct design pattern, offering fully implemented classes, interfaces, and methods. Through practical examples, this repository aims to illustrate how design patterns solve common software engineering challenges by improving code reusability, flexibility, and maintainability.

The design patterns covered include:
1. **Inheritance** - Structured around the concept of building a hierarchy of sushi ingredients.
2. **Composition and Aggregation** - Demonstrated in a text-based adventure game scenario.
3. **Exceptions** - Exception handling pattern examples for robust error management.
4. **Iterators** - Custom iterators in a ride-sharing context.
5. **Decorators** - Visual modifications to digital images using the decorator pattern.
6. **Singleton, Multiton, and Factory Method** - Designing a pizza ordering system with creational patterns.

Each directory includes fully implemented code to demonstrate these patterns in realistic scenarios. Below is a comprehensive breakdown of each directory, detailing the design patterns, core components, and practical applications.

## Table of Contents

- [`Inheritance` Directory](#1-inheritance-directory)
- [`Adventure-Game` Directory](#2-adventure-game-directory)
- [`Exceptions` Directory](#3-exceptions-directory)
- [`Iterators` Directory](#4-iterators-directory)
- [`Decorators` Directory](#5-decorators-directory)
- [`Singleton-Multiton-Factory` Directory](#6-singleton-multiton-factory-directory)
- [Summary of Design Patterns and Applications](#summary-of-design-patterns-and-applications)
- [Build Tool](#build-tool)
- [Additional Resources](#additional-resources)
- [Conclusion](#conclusion)
- [Creator & Attributions](#creator--attributions)

## 1. `Inheritance` Directory

**Pattern**: **Inheritance Design Pattern**

**Context**: Representing ingredients and portions for sushi recipes.

The `Inheritance` directory provides an introductory look at how inheritance organizes shared traits and enables specialized subclasses. The code here simulates a sushi restaurant where ingredients like **Avocado**, **Tuna**, and **Eel** share common properties (e.g., calories, vegetarian status, cost per ounce). The project builds a class hierarchy with ingredients as the base layer, allowing specialized ingredient portions and sushi types to extend these classes.

**Components**:
- **Ingredient Classes**: Define the basic traits of sushi ingredients.
- **Ingredient Portion Classes**: Represent specific amounts of each ingredient.
- **Sushi Types**: Classes like `Sashimi`, `Nigiri`, and `Roll` combine ingredients to form distinct sushi dishes.

**Key Insights**: This directory demonstrates the strength of inheritance by organizing shared traits in a superclass and extending it into specific subclasses for different ingredients. The hierarchical structure allows easy reuse of properties and behaviors, keeping the code organized and modular.

**Link to Directory**: [Inheritance](Inheritance)

## 2. `Adventure-Game` Directory

**Pattern**: **Composition & Aggregation Design Patterns**

**Context**: Creating a text-based adventure game.

The `Adventure-Game` directory showcases the composition pattern in a modular game design, where objects like **Player**, **Inventory**, **Position**, and **Cell** interact to form a navigable, treasure-hunting world. Rather than inheriting from a common superclass, each component encapsulates smaller components, forming a more flexible structure that enables independent development of each part.

**Components**:
- **Core Objects**: `Item`, `Inventory`, `Position`, and `Cell` represent the foundational elements of the game world.
- **Map and Game Structure**: `MapImpl` and `GameImpl` aggregate these core components into a coherent game structure.

**Key Insights**: Composition allows for modular and reusable code by assembling objects rather than inheriting properties. This pattern is ideal for games, where components like players, maps, and items must work together flexibly without rigid hierarchical constraints.

**Link to Directory**: [Adventure-Game](Adventure-Game)

## 3. `Exceptions` Directory

**Pattern**: **Exception Handling**

**Context**: Error handling and robustness in Java applications.

The `Exceptions` directory provides structured exercises to practice exception handling, illustrating how to manage and control unexpected behaviors in a program. By using custom exceptions and managing errors with `try-catch` blocks, this directory focuses on creating reliable, user-friendly applications that respond gracefully to various error conditions.

**Components**:
- **Novice, Adept, and Jedi Levels**: Different levels offer exercises in basic to advanced exception handling, from catching common errors to chaining exceptions and managing resources.

**Key Insights**: Exception handling patterns enhance code reliability by managing and containing errors, ensuring that unexpected events don’t crash the program. This directory highlights how exceptions can be anticipated, caught, and managed in layered ways to create robust software.

**Link to Directory**: [Exceptions](Exceptions)

## 4. `Iterators` Directory

**Pattern**: **Iterator Design Pattern**

**Context**: Accessing collections of drivers for a ride-sharing app.

The `Iterators` directory demonstrates how the iterator design pattern enables controlled, customized access to data. In a ride-sharing application, where the client searches for nearby drivers, the repository includes three custom iterators—each with unique traversal logic, from filtering by proximity to interleaving data from multiple collections.

**Components**:
- **`ProximityIterator`**: Filters drivers based on their proximity to the client.
- **`ExpandingProximityIterator`**: Iterates through drivers in increasing distance “rings,” prioritizing close drivers.
- **`SnakeOrderAcrossPoolsIterator`**: Interleaves drivers from multiple pools in a “snake” order to balance selection.

**Key Insights**: The iterator pattern simplifies complex traversal logic by encapsulating it within iterator classes, allowing for flexible, readable, and reusable data access methods without altering the underlying collections.

**Link to Directory**: [Iterators](Iterator)

## 5. `Decorators` Directory

**Pattern**: **Decorator Design Pattern**

**Context**: Applying visual modifications to digital images.

The `Decorators` directory leverages the decorator design pattern to incrementally enhance images with visual effects. Starting with a base image, decorators like **SquareDecorator**, **CircleDecorator**, **BorderDecorator**, and **ZoomDecorator** apply effects layer-by-layer, allowing the user to customize and compose effects dynamically.

**Components**:
- **Base Images**: `SolidColorImage` and `PictureImage` serve as foundations for decorators.
- **Decorators**:
  - **`SquareDecorator`**: Adds a colored square overlay.
  - **`CircleDecorator`**: Adds a colored circular overlay.
  - **`BorderDecorator`**: Surrounds the image with a solid border.
  - **`ZoomDecorator`**: Scales the image by a specified multiplier.

**Key Insights**: The decorator pattern is particularly effective in scenarios where dynamic, layered modifications are needed. It allows for flexible and modular visual transformations, where each effect builds on the previous one without requiring changes to the base image class.

**Link to Directory**: [Decorators](Decorators)

## 6. `Singleton-Multiton-Factory` Directory

**Patterns**: **Singleton, Multiton, and Factory Method Design Patterns**

**Context**: Building a pizza ordering system with standardized ingredients.

The `Singleton-Multiton-Factory` directory showcases creational design patterns in a pizza ordering system. By implementing the **Singleton** and **Multiton** patterns for standard ingredients and the **Factory Method** pattern for creating different pizza types, this directory demonstrates how to centralize ingredient management and automate pizza creation.

**Components**:
- **Ingredients**: Standardized ingredients like `Sauce`, `Cheese`, and `Topping`.
- **`IngredientImpl`**: Singleton and Multiton classes for ingredient instances.
- **`PizzaImpl`**: Factory method for creating different pizza types.
- **Pizza Types**: `CheesePizza`, `HawaiianPizza`, `MeatLoversPizza`, and `VeggieSupremePizza`.
- **`PizzaFactory`**: Centralized factory for creating pizza instances.
- **Immutability**: Ensuring ingredient and pizza objects are immutable for consistency.
- **Dynamic Pricing**: Calculating pizza prices based on size and toppings.
- **Customization**: Creating custom daily special pizzas with unique toppings.
- **Consistency**: Standardizing ingredient instantiation and pizza creation for reliability.
- **Centralization**: Using factory methods to simplify pizza type creation and management.

**Key Insights**: The Singleton, Multiton, and Factory Method patterns provide a structured approach to managing ingredient instances and creating complex pizza objects. By centralizing ingredient control and automating pizza creation, this directory demonstrates how creational patterns can streamline system design and enhance code maintainability.

**Link to Directory**: [Singleton-Multiton-Factory](Singleton-Multiton-Factory)

## Summary of Design Patterns and Applications

This repository provides a practical guide to core design patterns, each applied in real-world contexts to solve common software challenges. Here’s a quick recap of each pattern’s application:

- **Inheritance**: Organizing shared properties in a hierarchy for sushi ingredients and portions.
- **Composition**: Creating flexible, modular components for a text-based adventure game.
- **Exception Handling**: Building robust software by managing unexpected events with exceptions.
- **Test-Driven Development (TDD)**: Ensuring code reliability through early and thorough unit testing.
- **Iterator**: Customizing data traversal for a ride-sharing app with proximity filtering and interleaving.
- **Decorator**: Incrementally adding visual layers and effects to images for modular image processing.

Each pattern is implemented with realistic examples and scenarios, illustrating not only how to apply these patterns but also why they matter in building scalable, maintainable, and effective software. Whether you’re looking to improve your understanding of object-oriented programming or seeking examples of design patterns in action, this repository offers a comprehensive, hands-on guide to mastering design patterns in Java.

## Build Tool

All subdirectories use Maven as the build tool. To compile and run the code, navigate to the desired directory and use the following commands:

- **Compile**: `mvn compile`
- **Run**: `mvn exec:java`
- **Test**: `mvn test`
- **Package**: `mvn package`
- **Clean**: `mvn clean`

These commands will help you build, test, and run the code in each directory, allowing you to explore the design patterns and their applications in detail.

Alternatively, if you are using an IDE like IntelliJ IDEA or Eclipse, you can import the project as a Maven project and run the code directly from the IDE. Just be sure to configure the project settings to use Maven for building and running the code.

## Additional Resources

For more in-depth explanations, code snippets, and practical examples of design patterns, check out the individual directories in this repository. Each directory provides detailed insights into the pattern’s application, components, and design considerations, making it a valuable resource for learning and mastering design patterns in Java.

Also, be sure to check out this detailed document (README) in the `Design-Patterns-Info` directory to learn more about Design Patterns and their applications in software development: [Design-Patterns-Info](Design-Patterns-Info/README.md)

Additionally, I also recommend the `Gang of Four (GoF)` book, _Design Patterns: Elements of Reusable Object-Oriented Software,_ as an essential reference for understanding design patterns and their applications in software development. The book offers comprehensive insights into the principles, benefits, and implementation strategies of various design patterns, making it a foundational resource for software engineers, architects, and designers.

## Conclusion

Design patterns are powerful tools for structuring code, enhancing reusability, and simplifying complex software systems. By exploring the design patterns in this repository, you’ll gain a deeper understanding of how to apply these patterns effectively in your projects, improving code quality, maintainability, and scalability.

Whether you’re a beginner looking to grasp the basics of design patterns or an experienced developer seeking practical examples and insights, this repository offers a structured, hands-on approach to mastering essential design patterns in Java. Dive into the directories, explore the code, and discover how design patterns can transform your software development journey.

## Creator & Attributions

This repository is created and maintained by [Son Nguyen](https://github.com/hoangsonww), a passionate software developer who enjoys crafting clean, efficient code and exploring the intricacies of software design. The examples and explanations in this repository are designed to provide a comprehensive guide to design patterns, offering practical insights and hands-on experience for developers at all levels.

Additionally, resources from the UNC-Chapel Hill Computer Science Department, Prof. Prairie Goodwin at UNC, and the Gang of Four (GoF) book have been instrumental in shaping the content and structure of this repository. Their contributions to software engineering education and design pattern literature have been invaluable in creating this repository. This repository has been deeply influenced and inspired by them.

If you find this repository helpful or have suggestions for improvement, feel free to reach out or contribute to the project. Your feedback and contributions are always welcome and appreciated!

---

Happy coding and pattern crafting! 🚀🎨
