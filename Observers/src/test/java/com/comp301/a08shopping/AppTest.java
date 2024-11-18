package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/** This class contains JUnit tests for the Shopping project */
public class AppTest {

  /** Default constructor for AppTest */
  public AppTest() {}

  /** Tests for ProductImpl */
  @Test
  public void testProductImpl() {
    Product product = new ProductImpl("Laptop", 999.99);
    assertEquals("Laptop", product.getName());
    assertEquals(999.99, product.getBasePrice(), 0.01);

    // Test invalid product creation
    try {
      new ProductImpl("", 500);
      fail("Expected IllegalArgumentException for empty name");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test invalid price
    try {
      new ProductImpl("TV", -100);
      fail("Expected IllegalArgumentException for negative price");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }

  /** Tests for StoreImpl basic functionality */
  @Test
  public void testStoreImplBasic() {
    Store store = new StoreImpl("Tech Store");

    // Add products
    Product laptop = store.createProduct("Laptop", 1000, 5);
    Product phone = store.createProduct("Phone", 800, 3);

    // Verify initial store state
    assertEquals("Tech Store", store.getName());
    assertEquals(5, store.getProductInventory(laptop));
    assertEquals(3, store.getProductInventory(phone));
    assertFalse(store.getIsOnSale(laptop));

    // Start a sale
    store.startSale(laptop, 0.1);
    assertTrue(store.getIsOnSale(laptop));
    assertEquals(900, store.getSalePrice(laptop), 0.01);

    // End the sale
    store.endSale(laptop);
    assertFalse(store.getIsOnSale(laptop));

    // Restock product
    store.restockProduct(phone, 2);
    assertEquals(5, store.getProductInventory(phone));

    // Test invalid sale discount
    try {
      store.startSale(phone, 1.5);
      fail("Expected IllegalArgumentException for invalid discount");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test invalid product retrieval
    try {
      store.purchaseProduct(new ProductImpl("Unknown", 100));
      fail("Expected ProductNotFoundException for unknown product");
    } catch (ProductNotFoundException e) {
      assertTrue(true);
    }
  }

  /** Tests for StoreImpl edge cases */
  @Test
  public void testStoreImplEdgeCases() {
    Store store = new StoreImpl("Edge Store");
    Product product = store.createProduct("Widget", 50, 2);

    // Test out-of-stock scenario
    store.purchaseProduct(product);
    store.purchaseProduct(product);

    try {
      store.purchaseProduct(product);
      fail("Expected OutOfStockException when out of stock");
    } catch (OutOfStockException e) {
      assertTrue(true);
    }

    // Test restocking
    store.restockProduct(product, 5);
    assertEquals(5, store.getProductInventory(product));

    // Test invalid restocking
    try {
      store.restockProduct(product, -3);
      fail("Expected IllegalArgumentException for negative restock");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }

  /** Tests for CustomerImpl */
  @Test
  public void testCustomerImpl() {
    // Create a customer with a budget
    Customer customer = new CustomerImpl("Alice", 200);
    assertEquals("Alice", customer.getName());
    assertEquals(200, customer.getBudget(), 0.01);

    Store store = new StoreImpl("Gadget Store");
    Product tablet = store.createProduct("Tablet", 150, 2);

    // Test making a purchase
    customer.purchaseProduct(tablet, store);
    assertEquals(50, customer.getBudget(), 0.01);

    // Check purchase history
    List<ReceiptItem> purchaseHistory = customer.getPurchaseHistory();
    assertEquals(1, purchaseHistory.size());
    assertEquals("Tablet", purchaseHistory.get(0).getProductName());

    // Test insufficient budget case
    Product expensiveGadget = store.createProduct("Gadget", 300, 1);
    try {
      customer.purchaseProduct(expensiveGadget, store);
      fail("Expected IllegalStateException for insufficient budget");
    } catch (IllegalStateException e) {
      assertTrue(true);
    }
  }

  /** Tests for StoreObserver behavior */
  @Test
  public void testStoreObserver() {
    Store store = new StoreImpl("Fashion Store");
    Customer customer = new CustomerImpl("Bob", 300);

    // Register customer as observer
    store.addObserver(customer);

    Product jacket = store.createProduct("Jacket", 200, 1);

    // Trigger notifications
    store.startSale(jacket, 0.2);
    store.endSale(jacket);
    store.purchaseProduct(jacket);

    // Test deregistration
    store.removeObserver(customer);

    // No notifications expected
    store.restockProduct(jacket, 1);
  }

  /**
   * Tests the SaleSpawner class by creating a SaleSpawner with two stores and running it in a
   * thread for a short period of time
   *
   * @throws InterruptedException if the thread is interrupted
   */
  @Test
  public void testSaleSpawner() throws InterruptedException {
    Store store1 = new StoreImpl("Store 1");
    Store store2 = new StoreImpl("Store 2");

    Product product1 = store1.createProduct("Product1", 100, 10);
    Product product2 = store2.createProduct("Product2", 200, 5);

    // Initialize stores in the SaleSpawner
    SaleSpawner spawner = new SaleSpawner(Arrays.asList(store1, store2));

    // Run spawner in a thread and stop it
    Thread thread = new Thread(spawner);
    thread.start();
    Thread.sleep(2000); // Wait for spawner to run
    thread.interrupt();
    thread.join(); // Ensure thread ends
  }

  /** Comprehensive tests for all exceptions and edge cases */
  @Test
  public void testAllExceptions() {
    Store store = new StoreImpl("Corner Store");
    Customer customer = new CustomerImpl("Eve", 50);
    Product soda = store.createProduct("Soda", 1.5, 2);

    // Out of stock
    customer.purchaseProduct(soda, store);
    customer.purchaseProduct(soda, store);

    // Test OutOfStockException
    try {
      customer.purchaseProduct(soda, store);
      fail("Expected OutOfStockException");
    } catch (OutOfStockException e) {
      assertTrue(true);
    }

    // Invalid sale discount
    try {
      store.startSale(new ProductImpl("Unknown", 100), 0.5);
      fail("Expected ProductNotFoundException");
    } catch (ProductNotFoundException e) {
      assertTrue(true);
    }

    // Invalid sale discount
    try {
      store.restockProduct(new ProductImpl("Unknown", 100), 5);
      fail("Expected ProductNotFoundException");
    } catch (ProductNotFoundException e) {
      assertTrue(true);
    }
  }

  /** Additional tests for StoreImpl */
  @Test
  public void testStoreImplAdditionalCases() {
    Store store = new StoreImpl("Extra Store");

    // Test creating multiple products
    Product product1 = store.createProduct("Laptop", 1500.50, 3);
    Product product2 = store.createProduct("Smartphone", 800.75, 5);
    Product product3 = store.createProduct("Headphones", 199.99, 10);

    // Verify initial inventory
    assertEquals(3, store.getProductInventory(product1));
    assertEquals(5, store.getProductInventory(product2));
    assertEquals(10, store.getProductInventory(product3));

    // Test getIsInStock
    assertTrue(store.getIsInStock(product1));
    assertTrue(store.getIsInStock(product2));
    assertTrue(store.getIsInStock(product3));

    // Test starting a sale
    store.startSale(product2, 0.25); // 25% off
    assertTrue(store.getIsOnSale(product2));
    assertEquals(600.56, store.getSalePrice(product2), 0.01);

    // Test ending a sale
    store.endSale(product2);
    assertFalse(store.getIsOnSale(product2));

    // Test purchasing multiple items
    ReceiptItem receipt1 = store.purchaseProduct(product1);
    assertEquals("Laptop", receipt1.getProductName());
    assertEquals(1500.50, receipt1.getPricePaid(), 0.01);

    // Verify inventory after purchase
    assertEquals(2, store.getProductInventory(product1));

    // Purchase remaining stock of a product
    store.purchaseProduct(product1);
    store.purchaseProduct(product1);

    // Product should be out of stock now
    assertFalse(store.getIsInStock(product1));
    assertEquals(0, store.getProductInventory(product1));

    // Test OutOfStockException when purchasing out-of-stock product
    try {
      store.purchaseProduct(product1);
      fail("Expected OutOfStockException when purchasing out-of-stock product");
    } catch (OutOfStockException e) {
      assertTrue(true);
    }

    // Test restocking a product
    store.restockProduct(product1, 5);
    assertEquals(5, store.getProductInventory(product1));
    assertTrue(store.getIsInStock(product1));

    // Test invalid restock amounts
    try {
      store.restockProduct(product1, -3);
      fail("Expected IllegalArgumentException for negative restock amount");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test invalid sale discounts
    try {
      store.startSale(product3, 1.5); // Invalid discount (greater than 100%)
      fail("Expected IllegalArgumentException for invalid discount percentage");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test invalid sale discounts
    try {
      store.startSale(product3, -0.1); // Invalid discount (negative)
      fail("Expected IllegalArgumentException for negative discount percentage");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test retrieving products from the store
    List<Product> products = store.getProducts();
    assertEquals(3, products.size());
    assertTrue(products.contains(product1));
    assertTrue(products.contains(product2));
    assertTrue(products.contains(product3));

    // Test attempting to retrieve an unknown product
    Product unknownProduct = new ProductImpl("Unknown", 100);
    try {
      store.getSalePrice(unknownProduct);
      fail("Expected ProductNotFoundException for unknown product");
    } catch (ProductNotFoundException e) {
      assertTrue(true);
    }

    // Test attempting to retrieve inventory for an unknown product
    try {
      store.getProductInventory(unknownProduct);
      fail("Expected ProductNotFoundException for unknown product");
    } catch (ProductNotFoundException e) {
      assertTrue(true);
    }

    // Test starting and ending a sale for products
    store.startSale(product3, 0.5); // 50% off
    assertTrue(store.getIsOnSale(product3));
    assertEquals(100.00, store.getSalePrice(product3), 0.01);
    store.endSale(product3);
    assertFalse(store.getIsOnSale(product3));

    // Test adding observers and notifications (monitor console for event triggers)
    Customer customer = new CustomerImpl("Observer", 10000);
    store.addObserver(customer);
    store.restockProduct(product2, 5); // Should trigger a BackInStockEvent
    store.startSale(product2, 0.2); // Should trigger a SaleStartEvent
    store.purchaseProduct(product2); // Should trigger a PurchaseEvent
    store.endSale(product2); // Should trigger a SaleEndEvent
    store.purchaseProduct(product2);
    store.purchaseProduct(product2);
    store.purchaseProduct(product2);
    store.purchaseProduct(product2);
    store.purchaseProduct(product2); // Last purchase, should trigger an OutOfStockEvent
  }

  /** Additional tests for CustomerImpl */
  @Test
  public void testCustomerImplEnhanced() {
    // Create a customer with an initial budget
    Customer customer = new CustomerImpl("Alice", 1000.00);

    // Validate initial properties
    assertEquals("Alice", customer.getName());
    assertEquals(1000.00, customer.getBudget(), 0.01);
    assertTrue(customer.getPurchaseHistory().isEmpty());

    // Create a store and add products
    Store store = new StoreImpl("Gadget Store");
    Product laptop = store.createProduct("Laptop", 700.00, 2);
    Product smartphone = store.createProduct("Smartphone", 300.00, 3);

    // Purchase a product within the budget
    customer.purchaseProduct(laptop, store);
    assertEquals(300.00, customer.getBudget(), 0.01);
    assertEquals(1, store.getProductInventory(laptop));
    assertEquals(1, customer.getPurchaseHistory().size());
    assertEquals("Laptop", customer.getPurchaseHistory().get(0).getProductName());

    // Purchase another product within the remaining budget
    customer.purchaseProduct(smartphone, store);
    assertEquals(0.00, customer.getBudget(), 0.01);
    assertEquals(2, store.getProductInventory(smartphone));
    assertEquals(2, customer.getPurchaseHistory().size());
    assertEquals("Smartphone", customer.getPurchaseHistory().get(1).getProductName());

    // Attempt to purchase a product with insufficient budget
    try {
      customer.purchaseProduct(laptop, store);
      fail("Expected IllegalStateException for insufficient budget");
    } catch (IllegalStateException e) {
      assertTrue(true);
    }

    // Exhaust stock
    store.purchaseProduct(laptop);

    // Attempt to purchase an out-of-stock product
    try {
      customer.purchaseProduct(laptop, store);
      fail("Expected IllegalStateException for out-of-stock product");
    } catch (IllegalStateException e) {
      assertTrue(true);
    }

    // Test notifications as an observer
    store.addObserver(customer);
    store.restockProduct(laptop, 5); // Should trigger a notification
    store.startSale(smartphone, 0.2); // Should trigger a notification

    // Test deregistration from observer
    store.removeObserver(customer);
    store.endSale(smartphone); // Should not trigger a notification

    // Test invalid operations
    try {
      customer.purchaseProduct(null, store);
      fail("Expected IllegalArgumentException for null product");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test invalid operations
    try {
      customer.purchaseProduct(laptop, null);
      fail("Expected IllegalArgumentException for null store");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }

  /** Additional tests for StoreImpl and CustomerImpl */
  @Test
  public void testCustomerImplEdgeCases() {
    // Create a customer with a small budget
    Customer customer = new CustomerImpl("Bob", 10.00);

    // Create a store and add inexpensive products
    Store store = new StoreImpl("Discount Store");
    Product candy = store.createProduct("Candy", 1.50, 5);
    Product soda = store.createProduct("Soda", 2.00, 3);

    // Purchase multiple inexpensive products
    customer.purchaseProduct(candy, store);
    customer.purchaseProduct(candy, store);
    assertEquals(7.00, customer.getBudget(), 0.01);
    assertEquals(3, store.getProductInventory(candy));
    assertEquals(2, customer.getPurchaseHistory().size());

    // Use up the entire budget
    customer.purchaseProduct(soda, store);
    customer.purchaseProduct(soda, store);
    assertEquals(3.00, customer.getBudget(), 0.01);

    // Verify that the purchase history matches the correct sequence
    List<ReceiptItem> history = customer.getPurchaseHistory();
    assertEquals(4, history.size());
    assertEquals("Candy", history.get(0).getProductName());
    assertEquals("Candy", history.get(1).getProductName());
    assertEquals("Soda", history.get(2).getProductName());
    assertEquals("Soda", history.get(3).getProductName());

    // Attempt to buy a product when there's no budget left
    customer.purchaseProduct(candy, store);
    assertEquals(1.50, customer.getBudget(), 0.01);
    try {
      customer.purchaseProduct(soda, store);
      fail("Expected IllegalStateException for insufficient budget");
    } catch (IllegalStateException e) {
      assertTrue(true);
    }

    // Test empty purchase history for a new customer
    Customer newCustomer = new CustomerImpl("New User", 500.00);
    assertTrue(newCustomer.getPurchaseHistory().isEmpty());
  }

  /** Additional tests for CustomerImpl */
  @Test
  public void testCustomerImplInvalidBudget() {
    // Test creating a customer with an invalid budget
    try {
      new CustomerImpl("Charlie", -50.00);
      fail("Expected IllegalArgumentException for negative budget");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }

    // Test creating a customer with a zero budget
    try {
      new CustomerImpl("Charlie", 0.00);
      fail("Expected IllegalArgumentException for zero budget");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }
}
