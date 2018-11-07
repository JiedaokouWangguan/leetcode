import java.util.Arrays;

public class Question881{
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int right = people.length-1;
        int left = 0;
        while(left < right){
            if(people[left] + people[right] <= limit){
                right -= 1;
                left += 1;
                count += 1;
            }
            else {
                right -= 1;
                count += 1;
            }
        }
        if(left == right) count += 1;
        return count;
    }
}
