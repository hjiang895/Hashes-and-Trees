import java.util.*;

public class TreeMapCS2<Key extends Comparable<Key>, Value> implements MapCS2<Key, Value>{

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add
  //      implements MapCS2<Key, Value>
  // in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Member variables:
  Node top;
  int size;
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
  public class Node {
    Key k;
    Value v;
    Node rightchild;
    Node leftchild;

    public Node(Key k, Value v){
      this.k = k;
      this.v = v;
    }

    public Node(){
      leftchild = null;
      rightchild = null;
    }
  }


  // -----------------------------------------------
  // Constructor(s)
  // -----------------------------------------------
  // Write a constructor for TreeMapCS2, if you wish.
  public TreeMapCS2(){
    this.top = new Node();
    top = null;
  }


  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------
  /*
  Value get(Key key);           // returns a Value for the specified key
  */
  //traverses through the tree and compares it to each node; if the argument key
  //is equal to the current node's key, it returns the current ndoe's Value
  //if it's smaller than the current node key, it looks at the node's left child
  //if it's larger than the currend node's key, it looks at the right child
  //repeats until the key is found or returns null
  public Value get(Key key){
    Node n = top;

    while(n!=null){
      if(key.compareTo(n.k) == 0){
        return n.v;
      }
      else if(key.compareTo(n.k) < 0){
        n = n.leftchild;
      }
      else{
        n = n.rightchild;
      }
    }
    return null;
  }
  /*
  void put(Key key, Value val); // puts a Key-Value pair in the map
  */
  //if the top is null and the tree is empty, assigns the top node to the
  //key and value
  //traverses through the tee; if the current node's key equals the argument key
  //assigns the val to the value of the current node
  //if it's smaller and its left child is null, assigns variable putnode to
  //left child of node n and increments size
  //does the same with the right child if putnode's key is larger and right child
  //is null
  //otherwise, it reassigns node n to n's right child
  public void put(Key key, Value val){
    //System.out.println("put function");
    Node putnode = new Node(key, val);

    if(top == null){
      top = putnode;
      size++;
      return;
    }

    Node n = top;

    while(n!=null){
      if(key.compareTo(n.k) == 0){
        n.v = val;
      }
      else if(key.compareTo(n.k) < 0){
        if(n.leftchild==null){
          n.leftchild = putnode;
          size++;
          break;
        }
        else{
          n = n.leftchild;
        }
      }
      else{
        if(n.rightchild==null){
          n.rightchild = putnode;
          size++;
          break;
        }
        else{
          n = n.rightchild;
        }
      }
    }
  }
  /*
  ArrayList<Key> getKeys();     // returns the *SORTED* keys as an ArrayList
  */
  //helper array that puts the nodes of the tree in order in a new arraylist

  public void array_helper(Node n, ArrayList<Key> result){
    if(n==null){
      return;
    }
    array_helper(n.leftchild, result);
    result.add(n.k);
    array_helper(n.rightchild, result);
  }

  //creates a new ArrayList and calls on the helper method to add
  //the keys in order to the ArrayList sortedkeys

  public ArrayList<Key> getKeys(){
    ArrayList<Key> sortedkeys = new ArrayList<Key>();
    array_helper(top, sortedkeys);
    return sortedkeys;


  }
  /*
  Key min();                    // returns the minimum key in the map
  */
  //finds the min by finding the leftmost child recursively
  public Key min(){
    Node n = top;
    if(isEmpty()){
      return null;
    }
    else if(size==1){
      return n.k;
    }
    else {
      while(n.leftchild!=null){
        n = n.leftchild;
      }
      return n.k;
    }
  }
  /*
  Key max();                    // returns the maximum key in the map
  */
  //finds the max by accessing the rightmost child that isn't recursively
  public Key max(){
    Node n = top;
    if(isEmpty()){
      return null;
    }
    else if(size==1){
      return n.k;
    }
    else{
      while(n.rightchild!=null){
        n = n.rightchild;
      }
      return n.k;
    }
  }
  /*
  boolean contains(Key key);    // returns true if the map contains the key
  */
  //traverses the tree recurisvely and compares it to the key of the current node
  //if the smaller, it looks at the current node's left child; if larger,
  //it looks at the right child

  public boolean contains(Key key){
    Node n = top;

    while(n!=null){
      if(key.compareTo(n.k) == 0){
        return true;
      }
      else if(key.compareTo(n.k) < 0){
        n = n.leftchild;
      }
      else{
        n = n.rightchild;
      }
    }
    return false;
  }
  /*
  boolean isEmpty();            // returns true if map is empty
  */
  //if the variable size is 0, returns true; otherwise, return false
  public boolean isEmpty(){
    if(size==0){
      return true;
    }
    return false;
  }
  /*
  int size();                   // returns size of map
  */
  //returns the variable size
  public int size(){
    return size;
  }
  /*
  String toString();            // returns a string with each key : value pair
  */
  //helper method that creates StringBuilder and appends each node of the tree by traversing
  //the tree recursively
  public String toString(Node n){
    StringBuilder sb = new StringBuilder();
    if(n==null){
      return "";
    }

    sb.append(toString(n.leftchild));
    sb.append(n.k + ":" + n.v + ", ");
    sb.append(toString(n.rightchild));

    return sb.toString();
  }

  //calls on the helper method to append nodes in the tree to StringBuilder sb 
  public String toString(){
    System.out.println("toString function");
    StringBuilder sb = new StringBuilder();
    sb.append(toString(top));
    return sb.toString();
  }


  // -----------------------------------------------
  // Main method to test your code
  // -----------------------------------------------
  //see:TestMyMaps
  public static void main (String[] args) {
    MapCS2<Integer, String> new_map = new TreeMapCS2<Integer, String>();

    new_map.put(5,"dog");
    new_map.put(22,"lion");
    new_map.put(36,"cat");
    new_map.put(73,"elephant");
    new_map.put(89,"monkey");
    new_map.put(177,"donkey");
    new_map.put(215, "cheetah");
    System.out.println(new_map.getKeys());
    System.out.println(new_map);


  }
}
