public class Question810{
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int i: nums) xor ^= i;
        return xor == 0 || nums.length % 2 == 0;
    }
}
