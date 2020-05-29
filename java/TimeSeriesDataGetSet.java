import java.sql.Time;
import java.util.Set;
import java.util.TreeMap;

public class TimeSeriesDataGetSet {

    public static void main(String[] args) {
        System.out.println("TimeSeriesDataGetSet.main");


        TreeMap<Integer,LogMessages> msgMap = new TreeMap<Integer, LogMessages>();

        LogMessages m1 = new LogMessages(101,"one hundred one");
        LogMessages m2 = new LogMessages(102,"one hundred two");
        LogMessages m3 = new LogMessages(103,"one hundred three");
        LogMessages m4 = new LogMessages(104,"one hundred four");

        msgMap.put(101,m1);
        msgMap.put(1020,m2);
        msgMap.put(1040,m4);
        msgMap.put(1030,m3);


        //find for 102
        int find = 1020;
        Set<Integer> keys = msgMap.keySet();
        System.out.println("keys = " + keys);
        
        Integer[] keysArray = new Integer[keys.size()];
        keys.toArray(keysArray);
        System.out.println("keysArray size  = " + keysArray.length);

        if(keys.contains(find)) {
            System.out.println("TimeSeriesDataGetSet.main  found key");
        } else {
            System.out.println("TimeSeriesDataGetSet.main find in array");

            //check boundary cases first
            int cur = keysArray[0];
            int prev = keysArray[0];
            int index = 0;
            while(find > cur) {
                prev = cur;
                cur = keysArray[index++];
            }
            System.out.println("prev = " + prev);
        }
    }
}

class LogMessages {
    long timeStamp;
    String message;

    public LogMessages(long t, String m) {
        this.timeStamp = t;
        this.message = m;
    }
}
