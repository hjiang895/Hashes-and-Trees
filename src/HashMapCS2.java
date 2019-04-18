import java.util.*;

public class HashMapCS2<Key extends Comparable<Key>, Value> implements MapCS2<Key, Value>{

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
      int finalSum = 0;
      for(int i = 0; i < s.length(); i++) {
        finalSum = (int)s.charAt(i) * (1 + i);

      }
      hashcode = finalSum % 31;

    } else if (k instanceof Double) {
      Double d = (Double) k;
      // implement this Double hash function:
      /* hashcode is the remainder of the absolute value of d
      as an integer when divided by 31
      */
      hashcode = (int)Math.abs(d) % 31;


    } else if (k instanceof Integer) {
      Integer q = (Integer) k;
      // implement this Integer hash function:
      /* hashcode is the remainder of the absolute value of q
      when divided by 31
      */
      hashcode = Math.abs(q) % 31;


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

  public Value get(Key key) {
  /* 1. Finds the hashcode for the key and then assigns linkedlist LL to
    the linkedlist at the index corresponding to the hashcode in the arraylist.
    2. Iterates through linkedlist LL until it finds the key that matches
    the argument and returns the value of the KeyValuePair
    3. If the key is not found, return null
  */
    int hc = hashFunction(key);
    LinkedList<KeyValuePair> LL = storage.get(hc);
    for (KeyValuePair kvp : LL) {
      if(kvp.k.equals(key)) {
        return kvp.v;
      }
    }
    return null;
  }
/* 1. Creates a hashcode for the given key and then assigns the KeyValuePair
   to the index corresponding to the hashcode in the arraylist
   2. Size increments
  */
  public void put(Key key, Value val) {
    int hc = hashFunction(key);
    storage.get(hc).add(new KeyValuePair(key, val));
    size++;

  }
/* 1. Creates an ArrayList and then iterates through each LinkedList at every
  every index in the ArrayList and adds the kvp to the ArrayList we created
  in the beginning
  */

  public ArrayList <Key> getKeys() {
    ArrayList AL = new ArrayList();
    for(LinkedList<KeyValuePair> LL: storage) {
      for(KeyValuePair kvp : LL) {
        AL.add(kvp.k);
      }
    }
    return AL;
  }
/* 1. Creates an ArrayList of all the keys
   2. Assigns the first element in the ArrayList as the min value
   3. Compares the current min value to the next key value and if the next one
   is smaller, then the min value is reassigned to a new key value
   4. If empty, return null
   */
  public Key min() {
    ArrayList <Key> keyList = getKeys();
    Key min = keyList.get(0);
    if(isEmpty()) {
      return null;
    }
    for(int i = 0; i < keyList.size() - 1; i++) {
      if(min.compareTo(keyList.get(i + 1)) > 0) {
        min = keyList.get(i + 1);
      }
    }
    return min;
  }
/* 1. Creates an ArrayList of all the keys
   2. Assigns the first element in the ArrayList as the max value
   3. Compares the current max value to the next key value and if the next one
   is larger, then the max value is reassigned to a new key value
   4. If empty, return null
  */
  public Key max() {
    ArrayList <Key> keyList = new ArrayList();
    keyList = getKeys();
    Key max = keyList.get(0);
    if(isEmpty()) {
      return null;
    }
    for(int i = 0; i < keyList.size() - 1; i++) {
      if(max.compareTo(keyList.get(i + 1)) < 0) {
        max = keyList.get(i + 1);
      }
    }
    return max;
  }
/* 1. Creates an ArrayList containing all the keys
   2. Iterates through keyList until it finds a key that matches the
   argument and returns true
   3. If key not found, return null
  */
  public boolean contains(Key key) {
    ArrayList<Key> keyList = getKeys();
    for(Key k : keyList) {
      if(k.equals(key)) {
        return true;
      }
    }
    return false;

  }
  //if size is 0, return true; otherwise, return false
  public boolean isEmpty() {
    return(size == 0);
  }
  //returns variable size
  public int size() {
    return size;

  }
  //Creates StringBuilder and iterates through every linkedlist at every
  //index in the ArrayList and adds each kvp to StringBuilder sb 
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(LinkedList<KeyValuePair> LL: storage) {
      for(KeyValuePair kvp: LL) {
        sb.append(kvp);
      }
    }
    return sb.toString();

  }

  // -----------------------------------------------
  // Main method to test out your code
  // -----------------------------------------------
  public static void main (String[] args) {
    HashMapCS2 <Integer, String> hs = new HashMapCS2();
    hs.put(5, "dog");
    hs.put(22, "lion");
    hs.put(36, "cat");
    hs.put(73, "elephant");
    hs.put(89, "monkey");
    hs.put(177, "donkey");
    hs.put(215, "cheetah");
    hs.put(315, "panda");
    hs.put(470, "alligator");
    hs.put(496, "koala");

    System.out.println("min: " + hs.min());
    System.out.println("max: " + hs.max());

    HashMapCS2 <Integer, String> newHS = new HashMapCS2();
    newHS.put(177, "donkey");
    newHS.put(215, "cheetah");
    newHS.put(89, "monkey");
    newHS.put(315, "panda");
    newHS.put(73, "elephant");
    newHS.put(470, "alligator");
    newHS.put(22, "lion");
    newHS.put(5, "dog");
    newHS.put(36, "cat");
    newHS.put(496, "koala");

    System.out.println("min: " + newHS.min());
    System.out.println("max: " + newHS.max());
  }

}
