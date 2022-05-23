package teest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Graph {

  public int counter = 0;
  int key;
  Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
  ArrayList<Integer> list = new ArrayList<Integer>();
  ArrayList<obj> Key_followers = new ArrayList<obj>(); 

  // Build HashMap

  public void addEdge(int k, int v) {

    if (graph.containsKey(k)) { // check if account id is already exist (added before)

      ArrayList<Integer> followers;
      followers = graph.get(k); // get arraylist of its followers

      if (!followers.contains(v)) { // check if this follower isn't already added before in arraylist

        counter = followers.remove(followers.size() - 1); // get number of followers for this account (we select last
                                                          // index of each arraylist for counter of followers in this
                                                          // arraylist)
        followers.add(v); // add follower value

        counter++; // number of followers++
        followers.add(counter); // add counter at last index of arraylist after updating number of followers (values)
        graph.put(k, followers); // add account id and arraylist of his followers in " key / value " pairs

      }
    }

    else { // if account id isn't exist
      ArrayList<Integer> followers = new ArrayList<Integer>();
      followers.add(v); // add follower id
      followers.add(1); // number of followers=1
      graph.put(k, followers); // add account id and arraylist of his followers in " key / value " pairs
      followers = null;
    }

  }

  public int sizee() { // Number of accounts

    Set<Integer> s = graph.keySet();
    return s.size();

  }

  public int num_followers(int k) { // NUMBER OF FOLLOWERS FOR SPECIFIC ACCOUNT

    int followers;
    ArrayList<Integer> n = graph.get(k);
    followers = n.size() - 1; // we select last index of each arraylist for counter of followers in this
                              // arraylist
    return followers; // return number of followers for this account

  }

  public void TopInfluencer(int i) {

    Set<Integer> Kset = graph.keySet();
    ArrayList<Integer> sortFollowers = new ArrayList<Integer>(); // Create ArrayList that carry number of followers for each account(key)

    // Complexity O(n) where n is the number of element in the Kset Set
    for (Object j : Kset) {

      ArrayList<Integer> value;
      value = graph.get(j); // Store list of followers for each key per itretion
      int c = value.remove(value.size() - 1); // Get the Number of followers for each key that always in the last of the list
      sortFollowers.add(c); // adding c to the arraylist

      obj e = new obj((Integer) j, c);
      Key_followers.add(e);   //key_followers is an array of objects that carry the key and the number of its followers(counter)
      value.add(c);
      graph.put((Integer) j, value);

    }

    Collections.sort(sortFollowers); // Built in sort time complexity is O(n*log(n)) - Sort Element in ascending order

    int f = sortFollowers.get(sortFollowers.size() - i); // Store the number of followers for the key i passed to the function in f.
    
    
    // As sorting number of followers calculated seperately, we need to get the key related to that number of followers that stored in f.
    // by looping on each key stored in key_followers(array of objects that carry the key and the number of its followers(counter).
   
    // Complexity O(n) where n is the number of element in the Key_followers Arraylist
    for (obj element : Key_followers) { 
      if (element.counter == f) { 
        int k = element.key;

        key = k;
      }
    }

    System.out.println(key + "  has  " + f + "  Followers ");
  }

}
