package com.comp301.a08shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** This class is the main entry point for the shopping simulation */
public class Main {

  /** Default constructor */
  private Main() {}
  ;

  /**
   * The main entry point for the shopping simulation
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Ask for the user's name and create a new Customer object
    System.out.println("Welcome to the COMP 301 Chapel Hill Mall!");
    System.out.print("What is your name? ");
    String name = in.next();
    Customer customer = new CustomerImpl(name, 100);
    System.out.println(
        "Hi, " + customer.getName() + "! You have $" + customer.getBudget() + " to spend");

    // Create stores
    List<Store> stores = createStores();

    // Spawn another process
    Runnable task = new SaleSpawner(stores);
    Thread thread = new Thread(task);
    thread.start();

    // Main program loop
    boolean isRunning = true;
    while (isRunning) {
      // Get command
      System.out.println("What do you want to do? Type \"help\" for options:");
      String command = in.next();

      // Handle command
      switch (command.toLowerCase()) {
        case "budget":
          System.out.println(customer.getName() + " has $" + customer.getBudget() + " to spend");
          break;
        case "stores":
          for (Store store : stores) {
            System.out.println(store.getName());
            for (Product product : store.getProducts()) {
              System.out.printf(
                  "\t%-18s$%6.2f   x%d\n",
                  product.getName(),
                  store.getSalePrice(product),
                  store.getProductInventory(product));
            }
          }
          break;
        case "help":
          System.out.println("Here are the commands you can try:");
          System.out.println("\tstores - List the stores and the products sold by those stores");
          System.out.println("\tregister - Start getting updates about product sales");
          System.out.println("\tderegister - Stop getting updates about product sales");
          System.out.println("\tbudget - Check how much money you still have to spend");
          System.out.println(
              "\tpurchase - Make a purchase! Buy a product at its current sale price");
          System.out.println("\tbags - View the items that you purchased");
          System.out.println("\thelp - Print this help message");
          System.out.println("\tquit - Exit the game");
          break;
        case "register":
          // Register the customer as an observer for all stores
          for (Store store : stores) {
            store.addObserver(customer);
          }
          System.out.println(customer.getName() + " is now a registered sale observer.");
          break;
        case "purchase":
          makePurchase(stores, customer);
          break;
        case "deregister":
          // Deregister the customer as an observer for all stores
          for (Store store : stores) {
            store.removeObserver(customer);
          }
          System.out.println(customer.getName() + " is no longer a registered sale observer.");
          break;
        case "bags":
          for (ReceiptItem receipt : customer.getPurchaseHistory()) {
            System.out.printf(
                "\tPurchased %s from %s for $%.2f\n",
                receipt.getProductName(), receipt.getStoreName(), receipt.getPricePaid());
          }
          break;
        case "quit":
        case "exit":
          isRunning = false;
          break;
        default:
          System.out.println("Unknown command. Try again or type \"help\" for options");
      }
    }

    // Exit message
    System.out.println("Thanks for playing! Goodbye.");
    thread.interrupt();
  }

  private static void makePurchase(List<Store> stores, Customer customer) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("From which store would you like to make a purchase?");
    for (int i = 0; i < stores.size(); i++) {
      System.out.println((i + 1) + ". " + stores.get(i).getName());
    }
    int choice = 0;
    while (choice < 1 || choice > stores.size()) {
      choice = scanner.nextInt();
    }
    System.out.println("Which item would you like to purchase?");
    Store store = stores.get(choice - 1);
    List<Product> products = store.getProducts();
    for (int i = 0; i < products.size(); i++) {
      System.out.println((i + 1) + ". " + products.get(i).getName());
    }
    choice = 0;
    while (choice < 1 || choice > products.size()) {
      choice = scanner.nextInt();
    }
    Product product = products.get(choice - 1);
    if (store.getSalePrice(product) > customer.getBudget()) {
      System.out.println("I'm sorry, you don't have enough money in your budget to buy that!");
    } else {
      customer.purchaseProduct(product, store);
      System.out.println("You purchased " + product.getName() + "!");
    }
  }

  private static List<Store> createStores() {
    List<Store> stores = new ArrayList<>();
    Store store;

    // CVS
    store = new StoreImpl("CVS");
    store.createProduct("Toothbrush", 4.0, 3);
    store.createProduct("Toothpaste", 2.5, 5);
    store.createProduct("Asprin", 5.3, 4);
    stores.add(store);

    // Hot Topic
    store = new StoreImpl("Hot Topic");
    store.createProduct("Band Shirt", 35.0, 10);
    store.createProduct("Sticker", 5.0, 4);
    store.createProduct("Eyeliner", 13.49, 4);
    stores.add(store);

    // JC Penney
    store = new StoreImpl("JC Penney");
    store.createProduct("Shoes", 75.0, 3);
    store.createProduct("Expensive Coat", 135.0, 4);
    store.createProduct("Expensive Dress", 85.0, 2);
    stores.add(store);

    return stores;
  }
}
