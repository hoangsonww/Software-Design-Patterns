# Model-View-Controller (MVC) - A 2048 Game in JavaFX

The **Model-View-Controller (MVC)** directory demonstrates the implementation of the **MVC design pattern** in a **2048 puzzle game** using **JavaFX**. The MVC pattern is a widely used software design principle that divides an application into three interconnected components, enhancing modularity and enabling efficient management of user interfaces, logic, and data.

In this directory, the MVC pattern is used to clearly separate the game's core logic (Model), user interface (View), and user input handling (Controller). This separation of concerns allows for better code organization, easier maintenance, and scalability.

## Overview of MVC Pattern in the 2048 Game

In this project, the **MVC pattern** is implemented to manage the game's functionality in three distinct layers:

- **Model**: Handles the game state and logic (e.g., board, score, tile movements, and merging).
- **View**: Displays the game’s interface, including the grid, tiles, and scores.
- **Controller**: Manages user input (e.g., arrow keys for tile movement) and updates both the Model and View accordingly.

Each of these components is designed to interact with one another but remain independent, which helps in isolating logic, simplifying testing, and allowing each component to evolve independently.

## Key Components of the MVC Architecture

### 1. **Model (Game2048)**

The **Model** is the core of the game, responsible for managing the game state and implementing game rules. In the case of this 2048 game, the model handles the board state, tile movements, merging of tiles, adding new tiles, and detecting game over conditions.

#### Key Features:
- **Game State**: The grid (represented as a 2D array) and the score are stored in the `board` and `score` properties.
- **Tile Logic**: It includes methods for merging tiles when two tiles with the same value collide and adding new tiles (either a 2 or 4) after every move.
- **Game Over Check**: The Model checks if the game is over when there are no available moves left.

The Model is completely independent of the user interface, making it easily testable and reusable. It’s updated by the Controller, and the View simply reflects the current state of the Model.

### 2. **View (Main)**

The **View** represents the graphical user interface (GUI). In this game, the View is implemented using **JavaFX**, which provides various components like labels, buttons, and panes to display the game.

#### Key Features:
- **Grid Rendering**: The View displays a 4x4 grid, where each tile has a value. It dynamically updates the UI whenever the game state changes.
- **Score Display**: The View updates the current score and the best score.
- **Animations**: The View includes smooth animations for tile movement and merging, which make the gameplay visually appealing.
- **User Interface**: Includes buttons for starting a new game or exiting the game.

The View is responsible for presenting the Model's data to the user and does not contain any game logic. It listens for updates from the Controller and reflects those changes on the screen.

### 3. **Controller (GameController)**

The **Controller** acts as an intermediary between the Model and the View. It listens for user input (such as key presses for moving the tiles) and then updates the Model accordingly. It also notifies the View to update the display after each action.

#### Key Features:
- **Input Handling**: The Controller listens for arrow key presses (Up, Down, Left, Right) and passes this input to the Model to perform the corresponding action (e.g., moving tiles).
- **Game Updates**: After each valid move, the Controller calls methods on the Model to update the board and score. It then notifies the View to render the new state.
- **Game Reset**: The Controller handles the logic for starting a new game or exiting the game.

The Controller does not directly manipulate the game’s data but orchestrates the interactions between the Model and View. It decouples the user interface from the game logic, making the system more flexible and maintainable.

## Key Design Patterns Used

### **Model-View-Controller (MVC) Pattern**

The **MVC pattern** is at the heart of this implementation. It divides the game into three distinct parts:
- **Model**: Manages the game’s state and logic.
- **View**: Handles rendering and updating the user interface.
- **Controller**: Processes user inputs and updates both the Model and View.

This separation allows for a clear organization of code, makes each component easier to manage, and allows for easier updates and testing.

## Advantages of Using MVC in the 2048 Game

- **Separation of Concerns**: The logic is separate from the user interface. The game mechanics (Model) and rendering (View) can be developed and modified independently.
- **Maintainability**: Each part of the game is isolated, making it easier to test, debug, and extend.
- **Reusability**: The Model can be reused with a different View (e.g., console-based) if desired.
- **Flexibility**: It’s easy to add new features like additional animations or game modes without disturbing the core logic or interface.

## Conclusion

This directory demonstrates the use of the **Model-View-Controller (MVC) design pattern** to implement a **2048 game in JavaFX**. By separating the game logic, user interface, and user input handling, the code is made more modular, maintainable, and flexible. The MVC pattern also enhances the game’s scalability, making it easy to add new features or even change the game’s presentation style without altering the underlying game mechanics.
