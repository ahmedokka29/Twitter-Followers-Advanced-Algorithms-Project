
package teest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teest {

    public static void main(String[] args) {

        Graph g = new Graph(); // creating an new graph

        String file = "teest\\twitter.csv"; // path
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file)); // reading the csv file
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(","); // spliting the two columns
                g.addEdge(Integer.valueOf(row[1]), Integer.valueOf(row[0])); // adding both of them into the graph

            }
        }

        catch (Exception e) {
            e.printStackTrace(); // error masseges
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
        // Scanner scanner = new Scanner(System.in);
        // int x = scanner.nextInt();
        // g.TopInfluencer(x);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Bonus..

        // int id1=115485051; // suggest
        // int id2=40981798;

        // int id1=303060652; //aleady follow
        // int id2=394407073;

        // int id1=294198566; //No Action
        // int id2=40981798;

        // int id1=294198566;
        // int id2=294198566;

        // ArrayList<Integer> account1 = g.graph.get(id1);
        // ArrayList<Integer> account2 = g.graph.get(id2);
        //
        // int m = account1.size();
        // int n = account2.size();
        //
        // recommendation o = new recommendation();
        // o.Print(id1,id2,account1,account2,m,n);
        //

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int id=532655718;
        recommendation2 o = new recommendation2(id,g);
        o.MaxLength();

        // System.out.println(g.graph.get(61989945));
        // System.out.println(g.graph.get(532655718));
        

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

}
