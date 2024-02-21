//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
import java.util.*;
public class NmeetingsInOneRoomGreedyAlgo { // used greedy algorithm logic here
    public static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return Integer.compare(a.second, b.second);
        }
    }

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(start[i], end[i]));
        }

        Collections.sort(list, new PairComparator());
        int currSecond = 0;
        int maxNoOfMeetings = 0;
        for(int i=0;i<n;i++){
            if(list.get(i).first > currSecond){
                maxNoOfMeetings++;
                currSecond = list.get(i).second;
            }
        }

        return maxNoOfMeetings;
    }
}
