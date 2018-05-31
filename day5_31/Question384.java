import java.util.Random;

public class Question384{
    
    int[] array;
    Random random;
    public Question384(int[] nums){
        array = new int[nums.length];
        random = new Random();
        for(int i = 0;i<nums.length;i++){
            array[i] = nums[i];
        }
    }

    public int[] reset(){
        int[] result = new int[array.length];
        for(int i = 0;i<array.length;i++){
            result[i] = array[i];
        }
        return result;
    }

    public int[] shuffle(){
        int[] result = new int[array.length];
        for(int i = 0;i<array.length;i++){
            result[i] = array[i];
        }

        for(int i = 0;i<result.length;i++){
            int index = random.nextInt(i+1);
            int tmp = result[index];
            result[index] = result[i];
            result[i] = tmp;
        }
        return result;
    }
}
