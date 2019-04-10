import java.util.*;

public class TreeMapCS2<Key extends Comparable<Key>, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add
  //      implements MapCS2<Key, Value>
  // in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Member variables:
  // ------------------------------------------
  // Create pointer to top Node and a size variable


  // -----------------------------------------------
  // Node inner class
  // -----------------------------------------------
  // Create an inner class called Node which has the
  // following instance variable:
  // Key k, Value v, Node rightchild, Node leftchild
  // Also create one or more constructors for the Node class.
  // Remember that your binary search tree will be organized
  // according to the Key only (not the value).


  // -----------------------------------------------
  // Constructor(s)
  // -----------------------------------------------
  // Write a constructor for TreeMapCS2, if you wish.


  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------
  /*
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Key> getKeys();     // returns the *SORTED* keys as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string with each key : value pair
  */


  // -----------------------------------------------
  // Main method to test your code
  // -----------------------------------------------
  public static void main (String[] args) {

  }

}
