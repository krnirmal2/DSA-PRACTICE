package StandardProblemDSA.II_STRING;

import java.util.*;

class Pair {
    String original;
    int key;

    Pair(String original, int key) {
        this.original = original;
        this.key = key;
    }
}
public class SortDateChronicalOrder {
    /*You are given a list of strings where each string is a date in the format:
        dd MMM yyyy  (e.g. "03 Feb 2017")
You must sort these dates chronologically in ascending order.
💡 Idea:
Parse each string into a Date object or a sortable integer format (yyyyMMdd).
Use a custom comparator to sort based on year, month, and day.
Convert back to the original string format after sorting.

*/
   /* Define a Map<String, Integer> to convert month strings to numbers.
    Convert each date to an object that stores:
    the original string
    and a comparable format (yyyyMMdd as an int).
    Sort based on that integer.
    Return the list of original strings in sorted order.*/

    public static List<String> sortDates(List<String> dates) {
        List<Pair> result = new ArrayList<>();
        // define a map and put the date and its no.
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> monthMap = new HashMap<>();

        for (int i = 0; i < 12; i++) {
            monthMap.put(months[i], i + 1);
        }

        /// now iterate each
        for(String date:dates){
            String[] parts = date.split(" ");
            int day = Integer.parseInt(parts[0]);
            int month = monthMap.get(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // form the date like
            int key = year* 10000+month*100+day;
            result.add(new Pair(date,key));
        }

        // sort the computed key
        result.sort(Comparator.comparing(p->p.key));

        // now return the new string result
        List<String> res = new ArrayList<>();
        for(Pair p : result){
            res.add(p.original);
        }
        return res;
    }


}
