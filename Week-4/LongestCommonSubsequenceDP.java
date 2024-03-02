//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequenceDP {
    public int longestCommonSubsequence(String text1, String text2) { // bottom-top dp (space optimized)
        int n = text1.length(); // here space complexity is only O(M)
        int m = text2.length();
        int[] ans = new int[m+1];
        int[] temp = new int[m+1];

        for(int i=1;i<=n;i++){
            temp[0] = 0;
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    temp[j] = 1+ans[j-1];
                }else{
                    temp[j] = Math.max(temp[j-1], ans[j]);
                }
            }
            // Copy temp array to ans array for the next iteration
            System.arraycopy(temp, 0, ans, 0, m + 1);
        }
        return ans[m];
    }

    // public int longestCommonSubsequence(String text1, String text2) { // bottom-top dp (but same
    // // space and time complexity as top-bottom one i.e O(n*m))
    //     int n = text1.length();
    //     int m = text2.length();
    //     int[][] dp = new int[n+1][m+1];
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(text1.charAt(i-1) == text2.charAt(j-1)){
    //                 dp[i][j] = 1+dp[i-1][j-1];
    //             }else{
    //                 dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }

    // public int longestCommonSubsequence(String text1, String text2) { // top-bottom dp
    //     int n = text1.length();
    //     int m = text2.length();
    //     int[][] LCS = new int[n][m];
    //     for(int[] row : LCS){
    //         Arrays.fill(row, -1);
    //     }
    //     return lcs(LCS, n-1, m-1, text1, text2);
    // }

    // public int lcs(int[][] LCS, int i, int j, String text1, String text2){
    //     if(i < 0 || j < 0) return 0;
    //     if(LCS[i][j] != -1) return LCS[i][j];

    //     if(text1.charAt(i) == text2.charAt(j)){
    //         LCS[i][j] = 1 + lcs(LCS, i-1, j-1, text1, text2);
    //     }else{
    //         LCS[i][j] = Math.max(lcs(LCS, i, j-1, text1, text2), lcs(LCS, i-1, j, text1, text2));
    //     }

    //     return LCS[i][j];
    // }
}
