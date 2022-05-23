package teest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class Graph {
    
    public int counter=0;
    int key;                      
    Map<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>() ;                                       
    ArrayList<obj> Key_followers = new ArrayList<obj>() ; 
    
    
    // Build HashMap
    
     public void addEdge(int k, int v) {
        

        if(graph.containsKey(k)) {                  //check if account id is already exist (added before)
            
            ArrayList<Integer> followers ;
            followers = graph.get(k);               //get arraylist of his followers 
            
            if (!followers.contains(v)){            //check if this follower isn't already added before
                
                counter=followers.remove(followers.size()-1);       //get number of followers for this account (we select last index of each arraylist for counter of followers in this arraylist)
                followers.add(v);                                     //add follower id

                counter++;                                          //number of followers++
                followers.add(counter);                             //add counter at last index of arraylist after updating number of followers
                graph.put(k, followers);                            //add account id and arraylist of his followers in " key / value " pairs 
                   
             }
         }   
        
        else {
            ArrayList<Integer> followers = new ArrayList<Integer>();
            followers.add(v);
            followers.add(1);
            graph.put(k, followers);
            followers=null;
        }
        
                          
    }
     
  
     
      public int sizee(){                                                  
       
          Set<Integer> s = graph.keySet();
          return s.size();
          
        }
      
      
      public int num_followers(int k){
          
          int followers;
          ArrayList<Integer> n = graph.get(k);
          followers = n.size()-1;
          return followers;
          
        }
      
     
      public void TopInfluencer(int i){
          
         Set<Integer>Kset =graph.keySet();
         ArrayList<Integer> sortFollowers = new ArrayList<Integer>() ;
         
       for(Object j : Kset ){
            
            ArrayList<Integer> value ;
            value = graph.get(j);
            int c = value.remove(value.size()-1);
            sortFollowers.add(c);
            
            obj e = new obj((Integer)j,c);
            Key_followers.add(e);
            value.add(c);
            graph.put((Integer)j, value);

            
          }
       
       Collections.sort(sortFollowers);
       
       
       int f = sortFollowers.get(sortFollowers.size()-i);
       
        for(obj element : Key_followers){
            
            if (element.counter==f) {
                
                int k = element.key;
                
                key=k;
            }
          }
               
        System.out.println(key+"  has  "+f+"  Followers ");
    }
    
}
