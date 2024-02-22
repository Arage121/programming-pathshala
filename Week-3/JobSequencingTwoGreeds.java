import java.util.*;
class JobSequencingTwoGreeds
{
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        boolean[] slots = new boolean[n+1];
        int[] ans = new int[2];
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        for(int i=0;i<n;i++){
            for(int j=Math.min(n, arr[i].deadline);j>0;j--){
                if(!slots[j]){
                    slots[j] = true;
                    ans[0]++;
                    ans[1] += arr[i].profit;
                    break;
                }
            }
        }
        return ans;
    }
}


