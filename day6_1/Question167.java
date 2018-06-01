public class Question167{
    public int[] twoSum(int[] numbers, int target){
        int begin = 0;
        int end = numbers.length-1;
        
        while(begin < end){
            if(numbers[begin] + numbers[end] == target){
                int[] result = new int[2];
                result[0] = begin;
                result[1] = end;
                return result;
            }
            else if(numbers[begin] + numbers[end] < target){
                begin += 1;
            }
            else{
                end -= 1;
            }
        }
        return null;
    }
}
