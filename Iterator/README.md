# `Iterators` Directory - The Iterator Design Pattern in Ride-Sharing Data Traversal

The `Iterators` directory in this project applies the **Iterator Design Pattern** to solve real-world data traversal problems within a ride-sharing service context. Here, three iterator classes—**ProximityIterator**, **ExpandingProximityIterator**, and **SnakeOrderAcrossPoolsIterator**—demonstrate how custom iteration strategies can streamline and enhance data handling in applications where access patterns need to be tailored. Each iterator class is designed to solve a specific problem in how a collection of `Driver` objects is accessed, providing both a robust illustration of design patterns and a practical approach to handling data dynamically.

These iterator implementations are fully coded to showcase different uses of iterators:
1. **ProximityIterator**: Filters drivers based on proximity to the client’s location.
2. **ExpandingProximityIterator**: Uses an increasing search range to prioritize closer drivers first.
3. **SnakeOrderAcrossPoolsIterator**: Interleaves multiple driver collections in a back-and-forth, or "snake-like," order.

By examining these implementations, you’ll gain insight into how to build modular, purpose-driven iterators that can adapt to complex real-world requirements.

## Components of the `Iterators` Directory

### Provided Interfaces and Classes

Before diving into the iterators themselves, three primary interfaces form the building blocks for the classes:
- **`Driver`**: Represents a ride-sharing driver. Each `Driver` is associated with a `Vehicle`.
- **`Vehicle`**: Represents the vehicle assigned to a driver and holds a `Position`.
- **`Position`**: Represents the GPS location of a vehicle as an `(x, y)` coordinate. This interface includes a `getManhattanDistanceTo(Position p)` method, which calculates the distance based on a grid system, mimicking urban navigation.

These interfaces allow the iterator classes to access driver information, vehicle locations, and distances, providing essential functionality for each iterator’s specific purpose.

## Custom Iterators and Their Design Patterns

Each iterator implements `Iterator<Driver>` and is designed to handle data selection differently, showcasing unique applications of the iterator design pattern.

### `ProximityIterator`: Filtering Drivers by Distance

The `ProximityIterator` class focuses on filtering drivers based on their distance from a client’s location. It iterates through a pool of drivers but only returns drivers within a specified `proximityRange`, measured in Manhattan distance. Drivers outside this range are ignored.

- **Purpose**: This iterator is ideal when a ride-sharing app needs to display only the closest drivers, ensuring that faraway drivers are excluded without changing the original driver order.
- **Constructor Parameters**:
  - `driverPool`: The available collection of `Driver` objects.
  - `clientPosition`: The client’s location, used as a reference for measuring proximity.
  - `proximityRange`: The maximum distance within which drivers are included in the iterator.

#### Design Insights and Mechanism:
1. **Encapsulation of Filtering Logic**: `ProximityIterator` encapsulates the logic for filtering within the iterator itself. Instead of creating a new filtered collection, it dynamically checks each driver’s distance as it iterates.
2. **Deferred Retrieval**: By maintaining a reference to the next eligible driver, the iterator retrieves drivers one by one based on the `hasNext()` and `next()` methods.
3. **Efficient Data Selection**: This iterator showcases how to apply a **filtering pattern** within an iterator, allowing selective access to data without modifying the original collection.

**Usage Example**: When iterating with `ProximityIterator`, the application can display nearby drivers based on distance to the client’s location, ignoring drivers outside the `proximityRange`.

### `ExpandingProximityIterator`: Prioritized Driver Retrieval with Expanding Range

The `ExpandingProximityIterator` goes beyond simple proximity filtering by iterating through drivers within a progressively expanding distance range. Initially, it retrieves drivers within a 1-unit range. Once these drivers are exhausted, it increases the range by a configurable `expansionStep`, searching the pool again for drivers within this new range. This process continues, expanding the range each time until all drivers have been retrieved.

- **Purpose**: This iterator is designed for situations where closest drivers should be prioritized, but with the flexibility to search a wider area if no close drivers are found.
- **Constructor Parameters**:
  - `driverPool`: The collection of `Driver` objects to iterate through.
  - `clientPosition`: The client’s position, used as a central reference point.
  - `expansionStep`: The incremental amount by which to increase the search range each time through the pool.

#### Design Insights and Mechanism:
1. **Layered Iteration**: The iterator resets and searches through the driver pool at each range increment, allowing each range expansion to act like a layer, where drivers closer to the client are retrieved first.
2. **Looped Search with Range Expansion**: This iterator captures the **expansion pattern**, allowing the search criteria to expand dynamically as it iterates. By looping through the pool repeatedly, it ensures a comprehensive yet prioritized traversal.
3. **End Condition Management**: The iterator tracks when all drivers have been accessed, ensuring `hasNext()` returns `false` once no more drivers remain, regardless of range.

**Usage Example**: `ExpandingProximityIterator` could be used to find the closest drivers to a client and only broaden the search to farther drivers when no closer options are available.

### `SnakeOrderAcrossPoolsIterator`: Interleaving Drivers from Multiple Pools in Snake Order

The `SnakeOrderAcrossPoolsIterator` iterates through multiple collections of drivers, interleaving them in a “snake-like” order—moving from the first to the last collection and back again. This back-and-forth sequence continues until all drivers across the collections have been retrieved.

- **Purpose**: This iterator is ideal for load balancing, ensuring fair selection across multiple driver pools or regions by accessing each pool one by one in a structured order.
- **Constructor Parameters**:
  - `driverPools`: A list of multiple collections (`Iterable<Driver>`) representing different driver pools.

#### Design Insights and Mechanism:
1. **Multi-Pool Access**: By interleaving drivers from multiple pools, this iterator balances access across all available collections, supporting situations where data from multiple sources must be combined.
2. **Alternating Snake Pattern**: The iterator leverages a **snake order pattern**, alternating between first-to-last and last-to-first sequences, ensuring equitable retrieval from each collection.
3. **Dynamic Pool Management**: As each pool is exhausted, the iterator dynamically skips over empty pools, maintaining its interleaved pattern until all pools are empty.

**Usage Example**: `SnakeOrderAcrossPoolsIterator` could be used in a ride-sharing system to balance driver selection across multiple service zones or regions, ensuring that drivers from all pools are fairly rotated.

## Summary of the `Iterators` Directory

The `Iterators` directory provides a hands-on demonstration of the **Iterator Design Pattern** applied to different data traversal needs within a ride-sharing application. Each iterator class encapsulates a unique data-access strategy:
- **ProximityIterator**: Selects nearby drivers only, demonstrating filtering within an iterator.
- **ExpandingProximityIterator**: Retrieves drivers by expanding the search range incrementally, prioritizing closer drivers first.
- **SnakeOrderAcrossPoolsIterator**: Interleaves drivers across multiple collections in a balanced snake order, enabling equitable access across pools.

These classes exemplify how custom iterators can provide highly adaptable, purpose-driven solutions to data handling challenges, aligning with application-specific goals such as proximity filtering, dynamic prioritization, and multi-source interleaving. This directory illustrates the adaptability of the iterator design pattern, equipping you with tools to create tailored data access mechanisms that efficiently manage and prioritize information.
