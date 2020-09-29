// --== CS400 File Header Information ==--
// Name: Jack Robey
// Email: jmrobey@wisc.edu
// Team: Team AA
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class consists of methods for creating, observing, and editing a hash table using LinkedList
 * arrays.
 * 
 * @author Jack Robey
 *
 * @param <KeyType>   Type of the key.
 * @param <ValueType> Type of the key's corresponding value.
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private int capacity;
  private int size;
  private LinkedList<ValueType>[] valueList;
  private LinkedList<KeyType>[] keyList;

  /**
   * This constructors creates a hash table by initializing two LinkedList arrays with the given
   * capacity: one for storing keys, and another for storing the values of the keys at corresponding
   * indices.
   * 
   * @param capacity the maximum capacity of keys/values the hash table can hold.
   */
  public HashTableMap(int capacity) {
    this.capacity = capacity;
    valueList = new LinkedList[capacity];
    keyList = new LinkedList[capacity];
    for (int i = 0; i < capacity; ++i) {
      valueList[i] = new LinkedList<ValueType>();
      keyList[i] = new LinkedList<KeyType>();
    }
  }

  /**
   * This constructor creates a hash table with a fixed capacity of 5.
   */
  public HashTableMap() {
    this.capacity = 10;
    valueList = new LinkedList[capacity];
    keyList = new LinkedList[capacity];
    for (int i = 0; i < capacity; ++i) {
      valueList[i] = new LinkedList<ValueType>();
      keyList[i] = new LinkedList<KeyType>();
    }
  }

  /**
   * This method stores a key with its corresponding value into the hash table.
   * 
   * @param key   The key that is to be stored in the hash table.
   * @param value The corresponding value of the key that is to be stored in the hash table.
   * @return True if the key-value pair was succesfully added to the hash table, and false if the
   *         hash table already contains the key.
   */
  public boolean put(KeyType key, ValueType value) {
    if (containsKey(key)) {
      return false;
    }
    int index = Math.abs(key.hashCode()) % capacity;
    valueList[index].add(value);
    keyList[index].add(key);
    size = size + 1;
    if (((double) size / (double) capacity) >= 0.8) {
      resize(valueList, keyList);
    }
    return true;
  }

  /**
   * This method retrieves the value of the key that was passed as an argument.
   * 
   * @param key The key to retrieve the value from.
   * @return The value of the key that was passed as an argument.
   * @throws NoSuchElementException when the key being passed as an argument is not stored inside
   *                                the hash table.
   */
  public ValueType get(KeyType key) {
    if (containsKey(key) == false) {
      throw new NoSuchElementException("The key was not found in the hashtable.");
    }
    ValueType value = null;
    int index = Math.abs(key.hashCode()) % capacity;
    for (int i = 0; i < keyList[index].size(); ++i) {
      if (key.equals(keyList[index].get(i))) {
        value = valueList[index].get(i);
      }
    }
    return value;
  }

  /**
   * Takes a key as an argument and checks whether that key is in the hash table or not.
   * 
   * @param key The key that is to be checked.
   * @return True if the key is in the hash table, false if the key is not in the hash table.
   */
  public boolean containsKey(KeyType key) {
    int index = Math.abs(key.hashCode()) % capacity;
    for (int i = 0; i < keyList[index].size(); ++i) {
      if (key.equals(keyList[index].get(i))) {
        return true;
      }
    }
    return false;
  }

  public int size() {
    return size;
  }

  /**
   * This method is passed a specific key and removes that specific key along with its corresponding
   * value.
   * 
   * @param key The key that is to be removed from the hash table.
   * @return The corresponding value of the removed key. Returns null if the entered key is not in
   *         the hash table.
   */
  public ValueType remove(KeyType key) {
    if (containsKey(key) == false) {
      return null;
    }
    ValueType value = null;
    int index = Math.abs(key.hashCode()) % capacity;
    for (int i = 0; i < keyList[index].size(); ++i) {
      if (key.equals(keyList[index].get(i))) {
        value = valueList[index].get(i);
        valueList[index].remove(i);
        keyList[index].remove(i);
      }
    }
    size = size - 1;
    return value;
  }

  /**
   * This method removes all values/keys from the hash table.
   */
  public void clear() {
    for (int i = 0; i < capacity; ++i) {
      valueList[i] = new LinkedList<ValueType>();;
      keyList[i] = new LinkedList<KeyType>();;
    }
    size = 0;
  }

  /**
   * This is a private helper array for the put() method> The method doubles the size of the array
   * when the load factor reaches 0.8 or more. The method creates new LinkedList arrays and copies
   * the keys/values from the older LinkedList arrays (the ones taken as an argument for the
   * method).
   * 
   * @param valueList The LinkedList array of values that is being resized.
   * @param keyList   The LinkedList array of keys that is being resized.
   */
  private void resize(LinkedList<ValueType>[] valueList, LinkedList<KeyType>[] keyList) {
    capacity = 2 * capacity;
    this.valueList = new LinkedList[capacity];
    this.keyList = new LinkedList[capacity];
    for (int i = 0; i < capacity; ++i) {
      this.valueList[i] = new LinkedList<ValueType>();
      this.keyList[i] = new LinkedList<KeyType>();
    }
    for (int i = 0; i < capacity / 2; ++i) {
      for (int j = 0; j < valueList[i].size(); ++j) {
        if (keyList[i].size() > 0) {
          int index = Math.abs(keyList[i].get(j).hashCode()) % capacity;
          this.valueList[index].add(valueList[i].get(j));
          this.keyList[index].add(keyList[i].get(j));
        }
      }
    }
  }

}
