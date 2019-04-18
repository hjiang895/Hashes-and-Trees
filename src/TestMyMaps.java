public class TestMyMaps {
  public static void main (String[] args) {
    // your code goes here
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

    TreeMapCS2 <Integer, String> tm = new TreeMapCS2();
    tm.put(5, "dog");
    tm.put(22, "lion");
    tm.put(36, "cat");
    tm.put(73, "elephant");
    tm.put(89, "monkey");
    tm.put(177, "donkey");
    tm.put(215, "cheetah");
    tm.put(315, "panda");
    tm.put(470, "alligator");
    tm.put(496, "koala");

    System.out.println("min: " + tm.min());
    System.out.println("max: " + tm.max());

    TreeMapCS2 <Integer, String> newTM = new TreeMapCS2();
    newTM.put(177, "donkey");
    newTM.put(215, "cheetah");
    newTM.put(89, "monkey");
    newTM.put(315, "panda");
    newTM.put(73, "elephant");
    newTM.put(470, "alligator");
    newTM.put(22, "lion");
    newTM.put(5, "dog");
    newTM.put(36, "cat");
    newTM.put(496, "koala");

    System.out.println("min: " + newTM.min());
    System.out.println("max: " + newTM.max());
  }
}

/** HashMapCS2 Case 1: min() and max() make 10 comparisons because the function
iterates through the entire arraylist to make sure that the current min/max value
is the min and max of the entire arraylist
HashMapCS2 Case 2: min() and max() make 10 comparisons because the function
iterates through the entire arraylist to make sure that the current min/max value
is the min/max of the entire arraylist
TreeMapCS2 Case 1: min () only makes one comparison because the BST is linear and
only increases from the beginningso there's no left child; max() makes 10 comparisons because the BST is linear
and the rightmost (largest) child is at the very end of the tree
TreeMapCS2 Case2: min() makes 5 comparisons and max() makes 5 comparisons
**/
