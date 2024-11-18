package com.comp301.a08shopping;

import com.comp301.a08shopping.events.StoreEvent;

/** This interface represents an observer that listens for events that occur at a store. */
public interface StoreObserver {

  /**
   * This method is called when an event occurs at a store. The observer should update its state
   * based on the event.
   *
   * @param event The event that occurred at the store
   */
  void update(StoreEvent event);
}
