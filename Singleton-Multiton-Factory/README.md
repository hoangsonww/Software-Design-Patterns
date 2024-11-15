# `Singleton-Multiton-Factory` Directory - Designing a Pizza Ordering System Using Creational Design Patterns

The `Singleton-Multiton-Factory` directory demonstrates how to implement **creational design patterns**—specifically the **Singleton, Multiton, and Factory Method** patterns—in the context of a pizza ordering system. By modeling ingredients, pizzas, and specialized pizza factories, this directory highlights the flexibility and power of design patterns in controlling the instantiation process and creating modular, reusable components.

This directory is organized into three phases:
1. **Novice**: Models individual pizza ingredients using immutable classes and applies the Multiton pattern to standardize ingredient instances.
2. **Adept**: Constructs the `PizzaImpl` class to represent fully customizable pizzas, integrating the relationships between size, crust, sauce, cheese, and toppings.
3. **Jedi**: Implements a `PizzaFactory` to automate the creation of predefined pizza types using the Factory Method pattern.

## Key Components and Design Patterns

### Ingredient Modeling with the Multiton Pattern

#### `IngredientImpl` and Subclasses
The `IngredientImpl` class implements the `Ingredient` interface, encapsulating the name of the ingredient, its vegetarian status, and its vegan status. This class is **immutable**, ensuring ingredient properties cannot change after creation. Specialized subclasses—`Crust`, `Sauce`, `Cheese`, and `Topping`—use the **Multiton Design Pattern** to manage specific predefined ingredient instances.

Each subclass defines `public static final` fields to represent available options. For example:
- **`Crust`**: Options include `HAND_TOSSED`, `THIN`, and `DEEP_DISH`.
- **`Sauce`**: Options include `TOMATO`, `BARBECUE`, `PESTO`, `ALFREDO`, and `RANCH`.
- **`Cheese`**: Options include `MOZZARELLA`, `BLEND`, and `VEGAN`.
- **`Topping`**: A wide array of toppings like `MUSHROOMS`, `PEPPERONI`, `ONION`, and `BACON`.

**Multiton Design Pattern**:
- Ingredient instances are predefined and exposed as constants.
- Centralizes control over ingredient instantiation, reducing redundancy and ensuring consistent behavior.

This setup allows for efficient and reusable ingredient management while maintaining immutability.

### Pizza Modeling with the `PizzaImpl` Class

#### `PizzaImpl`
The `PizzaImpl` class models a pizza as a composition of:
1. A `Size` (small, medium, or large) represented by an `enum`.
2. A `Crust` instance.
3. A `Sauce` instance.
4. A `Cheese` instance.
5. A list of `Topping` instances.

This class implements the `Pizza` interface and is also **immutable**, ensuring pizzas cannot be altered after creation.

Key features include:
- **Customizable Construction**: Pizzas are constructed with user-specified size, crust, sauce, cheese, and toppings.
- **Dynamic Pricing**: The `getPrice()` method calculates the pizza’s price based on its size and number of toppings:
  - **Small**: Base price $7.00 + $0.25 per topping.
  - **Medium**: Base price $9.00 + $0.50 per topping.
  - **Large**: Base price $11.00 + $0.75 per topping.
- **Encapsulation**: Each field is a private, final property, preserving immutability and ensuring consistent pizza objects.

This class represents the core of the pizza ordering system, offering flexibility while adhering to clean design principles.

### Pizza Creation with the Factory Method Pattern

#### `PizzaFactory`
The `PizzaFactory` class automates the creation of specific pizza types using the **Factory Method Design Pattern**. By centralizing pizza creation, this class ensures consistency and reusability while simplifying client code.

Key factory methods include:
1. **`makeCheesePizza(Size size)`**: Creates a cheese pizza with hand-tossed crust, tomato sauce, and cheese blend.
2. **`makeHawaiianPizza(Size size)`**: Creates a Hawaiian pizza with hand-tossed crust, tomato sauce, cheese blend, ham, and pineapple.
3. **`makeMeatLoversPizza(Size size)`**: Creates a meat lover’s pizza with deep-dish crust, tomato sauce, cheese blend, and toppings like pepperoni, sausage, bacon, and ground beef.
4. **`makeVeggieSupremePizza(Size size)`**: Creates a veggie pizza with thin crust, tomato sauce, cheese blend, and toppings like sun-dried tomato, mushrooms, green peppers, and olives.
5. **`makeDailySpecialPizza()`**: Creates a unique pizza defined by the developer (e.g., favorite size and toppings).

**Factory Method Design Pattern**:
- Centralizes the logic for creating different types of pizzas.
- Simplifies client interaction with the system by hiding instantiation details.

Each factory method outputs a fully configured `Pizza` instance, ensuring that client code does not need to manage ingredient combinations manually.

## Summary of the `Singleton-Multiton-Factory` Directory

This directory exemplifies the **creational design patterns** within the context of a pizza ordering system. It demonstrates how to control instantiation effectively and how to structure modular, reusable components for complex systems.

- **Singleton and Multiton Patterns**: Used for managing standard ingredient instances, ensuring consistency and efficient resource usage.
- **Factory Method Pattern**: Simplifies the creation of complex pizza objects, centralizing logic and providing ready-to-use instances.
- **Immutability**: Both `IngredientImpl` and `PizzaImpl` ensure data integrity by making instances immutable, preventing accidental modifications.

By integrating these patterns, the directory highlights the elegance and power of design patterns in creating a robust, scalable system for real-world applications like a pizza shop.
