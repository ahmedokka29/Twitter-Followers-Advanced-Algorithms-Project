
package teest;

import java.util.ArrayList;

public class recommendation {

    public int MaxLength(int id1, int id2, ArrayList<Integer> account1, ArrayList<Integer> account2, int m, int n) {

        if (!account2.contains(id1)) { 

            int[][] dp = new int[m + 1][n + 1]; // create a matrix which act as a table for LCS
            
            // fill the table in the bottom up way
            for (int i = 0; i <= m; i++)
                for (int j = 0; j <= n; j++)
                    dp[i][j] = 0; // Fill each cell corresponding to first row and first column with 0  

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    if (account1.get(i) == account2.get(j))
                        dp[j][i] = dp[j + 1][i + 1] + 1;
                }
            }
            int maxm = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maxm = Math.max(maxm, dp[i][j]);
                }
            }
            return maxm;
        }

        else
            return -1;

    }

    public void Print(int id1, int id2, ArrayList<Integer> account1, ArrayList<Integer> account2, int m, int n) {

        if (MaxLength(id1, id2, account1, account2, m, n) == -1)
            System.out.println("You already follow this account ");

        else if (MaxLength(id1, id2, account1, account2, m, n) > 1242) {
            System.out.println(id1 + ", You have a new account suggestion to follow -->  " + id2);
            System.out.println();
            System.out.println(MaxLength(id1, id2, account1, account2, m, n) + "  mutual followers");

        }

        else
            System.out.println(MaxLength(id1, id2, account1, account2, m, n) + "  mutual followers --> No Action");

    }
}
