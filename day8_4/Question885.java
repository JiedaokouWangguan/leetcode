import java.util.Arrays;

public class Question885{
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int first = 0;
        int last = people.length-1;
        int result = 0;
        while(first < last){
            if(people[first] + people[last] <= limit){
                result += 1;
                first += 1;
                last -= 1;
            }
            else{
                result += 1;
                last -= 1;
            }
        }
        if(first == last) result += 1;
        return result;
    }
}
