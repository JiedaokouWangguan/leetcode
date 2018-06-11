public class Question849{
    public int maxDistToClosest(int[] seats){
        int maxLength = 0;
        int count = 0;
        for(int i = 0;i<seats.length;i++){
            if(seats[i] == 0){
                count += 1;
            }
            else{
                maxLength = Math.max(maxLength, (count + 1)/2);
                count = 0;
            }
        }

        count = 0;
        for(int i = 0;i<seats.length;i++){
            if(seats[i] == 0){
                count += 1;
            }
            else{
                maxLength = Math.max(maxLength, count);
                break;
            }
        }
        count = 0;
        for(int i = seats.length-1; i >= 0;i--){
            if(seats[i] == 0){
                count += 1;
            }
            else{
                maxLength = Math.max(maxLength, count);
                break;
            }
        }
        return maxLength;
    }
}
