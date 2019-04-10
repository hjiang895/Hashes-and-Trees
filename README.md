# Problem Set 9: Hashes and Trees

### Due Wednesday, April 17th @ 11.59pm

---

This is a pair problem set. If you can't find a partner, contact me ASAP to so I can connect you with someone.

In this problem set, you will be implementing two different maps and running experiments to compare their efficiency under different circumstances. For both maps, you will be implementing the following map ADT interface, which you will find in the `src` directory:

``` java

public interface MapCS2<Key extends Comparable<Key>, Value> { 
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Keys> getKeys();    // returns the keys of the map as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string that lists each key-value pair
}

```

**Helpful Hints**

* Keys are unique in a map! If the user calls `put()` with a key that has already been added to the map, replace the current value for that key with the new value.

* The `toString()` method should return a string with key-value pairs, where the key is separated from the value by a space-colon-space, and the pairs are separated by a comma-space, e.g., ``dog : animal, tree : vegetable, salt : mineral``.

* I expect you to use the files I have provided. Do not create new `.java` files, do not create new directories, and keep all your `.java` files in the `src` directory. In addition, do not change the names of the methods. I will be testing your code using these specific methods.


### Part 1: Hash map with separate chaining: `HashMapCS2.java`
I have provided skeleton code for a hash-based implementation of the `MapCS2` interface in the `HashMapCS2.java` file. Your hash map implementation will include all of the above interface methods, as well as the following components:

* You will be storing your values in an `ArrayList` **of size 31** of `LinkedList` objects, each of which will contain elements of the `KeyValuePair` type. (I have defined the `KeyValuePair` class for you in the `HashMapCS2.java` file.) That is, you will have an `ArrayList`, and every element in the `ArrayList` will be a `LinkedList` of `KeyValuePair` objects. This will allow you to implement separate chaining for collision resolution. For more information on how separate chaining works, see the textbook and the lecture notes on maps.

* You must also finishing writing the hash function. To keep things manageable, you will generate hash codes only for  **these three data types:** `String`, `Integer`, and `Double`. The hash function will convert an instance of the `String`, `Integer`, or `Double` data type into an integer between 0 and 30.  I have provided some code for the `hashFunction()` method. Details are provided in the `HashMapCS2.java` file. Your code needs to handle keys of these three types only. Do not use a different hash function than the one described in the file.

*There are many implementations of the hash map data structure on the web. You must implement your hash map as I have described above using the skeleton code I have provided.*


### Part 2: Tree map with a binary search tree: `TreeMapCS2.java`
I have provided skeleton code for a binary search tree-based implementation of the `MapCS2` interface in the `TreeMapCS2.java` file. Your tree map implementation will include all of the interface methods, plus the following components:

* You will create your trees using an inner `Node` class, whose instance variables will include `Key k, Value v, Node rightchild`, and `Node leftchild`. You will define this inner class.

* Every `TreeMapCS2` object will have a pointer to the top `Node` and a size variable.

* You will use a binary search tree to store your key-value pairs. Therefore, your keys can be anything that implements `Comparable`. You don't need to write a `compareTo()` method. You can just assume that the user will only use keys that already implement `Comparable`.

* When you are writing the code for `getKeys()` to return an ArrayList of ordered keys, consult the class notes on tree traversal to remember how to traverse the tree in the correct order to return an ordered list. (Hint: it's in-order!)

*There are many implementations of the tree map data structure on the web. You must implement your tree map as I have described above using the skeleton code I have provided. Remember that I have provided [a ton of BST sample code here](  https://github.com/BC-CSCI-1102-S19-TTh3/example_code/tree/master/week8/BInarySearchTrees). You definitely can and should use the code, though you will have to change it to make it work with these different data types, of coursE!*


### Part 3: Testing your data structures

In each of the two maps, add code to keep track of and print out the number of comparisons required to (1) find the minimum key, and (2) find the maximum key.

Then in the `TestMyMap.java` file, write a main method that does the following.

1. Create a `HashMapCS2` object and a `TreeMapCS2` object.

2. Populate each map with the following key-value pairs. You must insert them in this order!

| key | value |
| --- | --- |
| 5   | "dog" |
| 22  | "lion" |
| 36  | "cat" |
| 73  | "elephant" |
| 89  | "monkey" |
| 177 | "donkey" |
| 215 | "cheetah" |
| 315 | "panda" |
| 470 | "aligator" |
| 496 | "koala" |

3. Call `min()` and `max()` on both maps.

4. Now populate a new map of each kind with the following key-value pairs **in this order**.

| key | value |
| --- | --- |
| 177 | "donkey" |
| 215 | "cheetah" |
| 89  | "monkey" |
| 315 | "panda" |
| 73  | "elephant" |
| 470 | "aligator" |
| 22  | "lion" |
| 5   | "dog" |
| 36  | "cat" |
| 496 | "koala" |

5. Call `min()` and `max()` on both new maps.

6. In the comments of `TestMyMap.java` explain any differences you see in the number of comparisons required for the two different maps under the two different circumstances.


