
package teest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map.Entry;
import java.util.Set;

public class Teest {

    public static void main(String[] args) {

        Graph g = new Graph(); //creating an new graph 

        String file = "teest\\twitter.csv";  //path
        BufferedReader reader = null;     
        String line = "";
        Graph graph = new Graph(); //creating a object from graph

        try {
            reader = new BufferedReader(new FileReader(file));  //reading the csv file 
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");                 //spliting the two columns
                g.addEdge(Integer.valueOf(row[1]), Integer.valueOf(row[0])); //adding both of them into the graph

            }
        }

        catch (Exception e) {
            e.printStackTrace();  //error masseges
        }

        finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Teest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Number of accounts = "+g.sizee());
        System.out.println();
        System.out.print("Top Influencer ");
        g.TopInfluencer(1);
        // System.out.println();
        // System.out.print("Second ");
        // g.TopInfluencer(2);
        // System.out.println();
        // System.out.print("Third ");
        // g.TopInfluencer(3);
        // System.out.println();

        // Bonus..

        // int id1=115485051; //aleady follow
        // int id2=40981798;

        // int id1=358083488; //no action
        // int id2=400689940;

        // int id1=303060652; //aleady follow
        // int id2=394407073;

        // int id1=294198566;
        // int id2=294198566;
        //
        // int id1=43003845; //new account suggestion to follow
        // int id2=43003845;
        //
        //
        // ArrayList<Integer> account1 = g.graph.get(id1);
        // ArrayList<Integer> account2 = g.graph.get(id2);
        //
        // int m = account1.size();
        // int n = account2.size();
        //
        // recommendation o = new recommendation();
        //
        // o.Print(id1,id2,account1,account2,m,n);
        //

        // System.out.println(g.num_followers(294198566));

    }

}
