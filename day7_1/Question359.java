import java.util.HashMap;

public class Question359{

}

class Logger {
    /** Initialize your data structure here. */
    HashMap<String, Integer> map = new HashMap<>();
    
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     *         If this method returns false, the message will not be printed.
     *                 The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean re = false;
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            re = true;
        }
        else{
            if(timestamp - map.get(message) < 10){
                re = false;
            }
            else{
                map.put(message, timestamp);
                re = true;
            }
        }
        return re;
    }   
}
