# `Observers` Directory - A Price Watching Application Using the Observer Design Pattern

The **Observers** directory demonstrates the application of the **Observer Design Pattern** within the context of a **price-watching application** for a mall shopping scenario. This application simulates a customer trying to monitor sales events at multiple stores in order to buy products at the best prices. The Observer pattern allows customers (observers) to receive updates from stores (subjects) whenever a relevant sale event occurs, such as a product going on sale or coming back in stock.

In this directory, the Observer pattern is used to notify customers of various sales events, and customers can react to these notifications by purchasing products or waiting for better deals. This setup not only demonstrates how the Observer pattern works but also provides a real-world example of how this design pattern can be applied in interactive applications.

## Overview of the Observer Pattern

The **Observer Design Pattern** is a behavioral pattern where an object (the **subject**) maintains a list of its dependents (the **observers**) and notifies them of any state changes, usually by calling one of their methods. This pattern is commonly used for implementing distributed event handling systems.

In this project, **stores** are the subjects, and **customers** are the observers. When an event like a sale starts, a product restocking, or an out-of-stock situation occurs, the store notifies all of its registered customers about the event.

### Key Concepts:
1. **Subject**: The object that holds a list of observers and notifies them about changes.
2. **Observer**: The object that receives updates from the subject when an event occurs.
3. **Event**: Represents a specific occurrence that the observers are interested in (e.g., a sale starting or an item going out of stock).

## Key Components of the Observer Pattern in the Application

### 1. **Event Classes (`StoreEvent`)**

In this application, there are different types of sale events that customers may want to observe. These events are encapsulated as concrete classes implementing the `StoreEvent` interface.

#### Types of Events:
- **`BackInStockEvent`**: This event occurs when a product that was previously out of stock is now available for purchase.
- **`OutOfStockEvent`**: This event occurs when a product is sold out (i.e., no stock left).
- **`PurchaseEvent`**: This event occurs when a product is purchased from a store.
- **`SaleEndEvent`**: This event signals that a sale on a particular product has ended.
- **`SaleStartEvent`**: This event signals the start of a sale on a product.

Each event class encapsulates a **`Product`** and a **`Store`**, and implements the `StoreEvent` interface. These events are immutable and notify observers (customers) about the changes.

### 2. **Product (`ProductImpl`)**

The `ProductImpl` class represents a product in the store. Each product has a name and a base price. Products may also have additional properties, such as sale prices or availability (whether they're in stock or not).

#### Key Features:
- **Product Name**: The name of the product.
- **Base Price**: The product's original price before any discounts.
- **Sale Price** (optional): The price of the product if it's on sale.

### 3. **Store (`StoreImpl`)**

The `StoreImpl` class represents a store in the mall. It maintains a list of products and also tracks the customers who are observing the store for sale events. The store is the **subject** in the observer pattern and notifies its observers whenever a relevant event occurs.

#### Key Features:
- **Products**: The list of products that the store sells.
- **Observers**: A list of customers (observers) who are registered to receive notifications from the store.
- **Inventory and Sale Information**: The store tracks how many units of each product are in stock and whether any sales are active.
- **Methods**:
  - `startSale()`: Starts a sale for a product and notifies customers.
  - `endSale()`: Ends a sale for a product and notifies customers.
  - `restockProduct()`: Restocks a product and notifies customers if it is back in stock.
  - `purchaseProduct()`: Processes a purchase, deducts stock, and notifies customers of the purchase event.

### 4. **Customer (`CustomerImpl`)**

The `CustomerImpl` class represents a customer who is observing stores for sales events. Customers are **observers** in the observer pattern and respond to events by purchasing products or simply observing sales announcements.

#### Key Features:
- **Customer Information**: The customer's name and budget.
- **Purchasing**: Customers can purchase products if they have enough money in their budget. A `ReceiptItem` object is created to record each purchase.
- **Event Handling**: The `update()` method handles incoming sale events, such as when a product goes on sale or comes back in stock. It prints messages to the console to inform the customer about the event.

### 5. **Main Class (`Main`)**

The `Main` class is responsible for simulating the shopping experience in the mall. It initializes stores, products, and customers. It also registers customers as observers of the stores, so they can be notified of events.

#### Key Features:
- **Game Loop**: Simulates a mall shopping trip, where customers monitor stores for deals.
- **Customer and Store Registration**: Customers can register or deregister as observers of stores.
- **Console Interaction**: Provides a simple command-line interface where customers can view events and make purchases.

## How the Observer Pattern Works

1. **Store (Subject)**: A store contains a list of observers (customers) and notifies them whenever a relevant event occurs (e.g., a product going on sale, restocking, or being sold out).
2. **Customer (Observer)**: A customer listens for store events. When a store announces a sale, the customer receives the notification through the `update()` method, which then processes the event (e.g., prints a message to the console and possibly makes a purchase).
3. **Event**: Each type of event (`BackInStockEvent`, `SaleStartEvent`, etc.) encapsulates the product and the store where the event occurred. When an event happens, it is passed to all observers who are interested in that store.

### Example Event Flow:
- A store starts a sale on a product.
- The store notifies all registered customers (observers) via their `update()` method.
- The customers are informed about the sale and may choose to purchase the product if they have the budget.

## Summary of the `Observers` Directory

The **Observer** pattern is an essential part of this price-watching application. The design ensures that:
- **Stores** act as the **subjects**, notifying **customers** (observers) when events like sales or restocks occur.
- **Customers** respond to these notifications, updating their purchase decisions accordingly.

By using the Observer pattern, this directory demonstrates how stores can notify multiple customers about important events without the need for tight coupling between them. Customers can be added or removed from the notification list without affecting the store’s functionality.

This implementation highlights the advantages of the Observer pattern:
- **Decoupling**: The store does not need to know anything about the customer’s behavior beyond notifying them of events. This reduces complexity and improves maintainability.
- **Flexibility**: Multiple customers can observe a store simultaneously, and each customer can react differently to the same event (e.g., one customer may buy the product, while another may decide to wait for a better deal).
- **Scalability**: New event types and customers can be added easily without changing the core logic of the stores.

By using the Observer pattern, this directory provides a simple, scalable, and modular implementation for a shopping trip simulation that tracks sales and customer behavior.
