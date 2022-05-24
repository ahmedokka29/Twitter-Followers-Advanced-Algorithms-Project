
package teest;

import java.util.ArrayList;

public class recommendation {

    public int MaxLength(int id1, int id2, ArrayList<Integer> account1, ArrayList<Integer> account2, int m, int n) {
        int max = 0;

        if (!account2.contains(id1) && id1 != id2) { // if id1 not follow id2 and id1 not equal id2

            for (int i = 0; i < m; i++) {

                if (account2.contains(account1.get(i))) 
                    max++;

            }

            return max;
        }

        else if (id1 == id2)
            return -2;

        else
            return -1;

    }

    public void Print(int id1, int id2, ArrayList<Integer> account1, ArrayList<Integer> account2, int m, int n) {

        if (MaxLength(id1, id2, account1, account2, m, n) == -1)
            System.out.println("You already follow this account ");

        else if (MaxLength(id1, id2, account1, account2, m, n) > 50) {
            System.out.println(id1 + ", You have a new account suggestion to follow -->  " + id2);
            System.out.println();
            System.out.println(MaxLength(id1, id2, account1, account2, m, n) + "  mutual followers");

        }

        else if (MaxLength(id1, id2, account1, account2, m, n) == -2)
            System.out.println("IT IS YOUR ACCOUNT ID!");

        else
            System.out.println(MaxLength(id1, id2, account1, account2, m, n) + "  mutual followers --> No Action");

    }
}
