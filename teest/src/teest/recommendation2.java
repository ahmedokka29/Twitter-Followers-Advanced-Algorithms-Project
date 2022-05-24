
package teest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class recommendation2 {

    int id;
    recommendation o = new recommendation();
    Graph g = new Graph();
    Map<Integer, ArrayList<Integer>> r = new HashMap<Integer, ArrayList<Integer>>();
    Set<Integer> kset;

    public recommendation2(int id, Graph g) {
        this.id = id;
        this.g = g;
        this.r = g.graph;
        this.kset = r.keySet();
    }

    public void MaxLength() {
        for (Object i : kset) { //looping on every k in the graph O(n) where n is the number of keys  

            if (o.MaxLength(id, (Integer) i, r.get(id), r.get(i), r.get(id).size(), r.get(i).size()) > 10) {
                System.out.println(id + ", You have a new account suggestion to follow -->  " + (Integer) i);
                System.out.println(o.MaxLength(id, (Integer) i, r.get(id), r.get(i), r.get(id).size(), r.get(i).size())
                        + "  mutual followers");
                System.out.println();

            }

        }

    }

}
