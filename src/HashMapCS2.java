import java.util.*;

public class HashMapCS2<Key extends Comparable<Key>, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add
  //      implements MapCS2<Key, Value>
  // in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Inner class: KeyValuePair
  // ------------------------------------------
  public class KeyValuePair {
    Key k;
    Value v;

    public KeyValuePair(Key k, Value v) {
      this.k = k;
      this.v = v;
    }
  }


  // -----------------------------------------
  // Member variables: storage array and size
  // ------------------------------------------

  // An ArrayList of LinkedLists.
  // The indices into the ArrayList will correspond
  // to hashcodes. At each index in the ArrayList, you will have
  // a LinkedList of KeyValuePairs. This is how you will implement
  // separate chaining when your hash function produces collisions.
  ArrayList<LinkedList<KeyValuePair>> storage;

  // A variable containing the size of the storage array.
  int size;

  // -----------------------------------------------
  // Constructor
  // -----------------------------------------------
  // I have written the HashMapCS2 constructor for you.
  // We create an ArrayList with 31 elements.
  // Each element is an empty LinkedList.
  // Each LinkedList will hold KeyValuePair objects,
  // one for each key you add with that hashcode.
  public HashMapCS2() {
    this.storage = new ArrayList<LinkedList<KeyValuePair>>();
    for (int i=0; i < 31; i++) {
      storage.add(new LinkedList<KeyValuePair>());
    }
    this.size = 0;
  }


  // -----------------------------------------------
  // Hash functions
  // -----------------------------------------------
  // Fill in the blanks below, following the instructions.
  int hashFunction(Key k) {
    int hashcode = 0;

    if (k instanceof String) {
      String s = (String) k;
      // implement this String hash function:
      /* for each char in the String s:
           multiply the int value of the char by 1 + its position in the String
           add that to the current total
         hashcode is the remainder of the final sum divided by 31
      */

    } else if (k instanceof Double) {
      Double d = (Double) k;
      // implement this Double hash function:
      /* hashcode is the remainder of the absolute value of d
         as an integer when divided by 31
      */


    } else if (k instanceof Integer) {
      Integer q = (Integer) k;
      // implement this Integer hash function:
      /* hashcode is the remainder of the absolute value of q
         when divided by 31
      */


    } else {
      // If hashcode returns -1, you have a problem! Throw an exception
      throw new IllegalArgumentException("Invalid key type.");
    }
    return hashcode;
  }


  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------
  /*
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Key> getKeys();     // returns the keys of the map as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string with each key : value pair
  */



  // -----------------------------------------------
  // Main method to test out your code
  // -----------------------------------------------
  public static void main (String[] args) {

  }

}
