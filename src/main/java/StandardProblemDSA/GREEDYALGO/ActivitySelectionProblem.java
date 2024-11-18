package StandardProblemDSA.GREEDYALGO;

import StandardProblemDSA.STACK.StackUsingArray;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ActivitySelectionProblem {
    // so it is a stand Greedy algo
    // independent subproblem give optimal solution of the whole problem
    // they are not overlap
    // either sort or heap can solve it or by both
    public static void main(String [] arg){
        // given two array of start and finished time
        int [] start = {1,3,0,5,8,5};
        int [] finish = {2,4,6,7,9,9};

        // call the method to solve this
        // so if the array is given already sorted then we need
        // to compare only last finished time with new satrt time
        // start time is smaller than finished time
        activitySelection(start, finish);
    }

    // we need to create a pair of start and finished time from both the array
   static class  StartEndPair {
        int start ;
        int end;

        StartEndPair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void activitySelection(int[] start, int[] finish) {
        // so we need to sort the finished array time
        // and put them into priority queue for picking up based on the minimum finished time
        // lamda function shorthand of compartor for sorting based on end date in ascending order
        PriorityQueue<StartEndPair> pq = new PriorityQueue<>((a, b) -> a.end - b.end); // lamda funciton
        // now put them in the priority queue
        for (int i=0 ;i< start.length;i++)
        {
            pq.add(new StartEndPair(start[i],finish[i]));
        }

        // now we have to select the first element which is always a pick
        ArrayList<StartEndPair> activities = new ArrayList<>();
        StartEndPair activity = pq.poll();
        activities.add(activity);

        // now loop through the priority queue and check the
        // last finished time should smaller than the new start time
        // if yes take the
        while(!pq.isEmpty()){

            StartEndPair nextActivity = pq.poll();
            if(activity.end<= nextActivity.start){
                activities.add(nextActivity);
                activity = nextActivity;


            }
        }




    }
}
