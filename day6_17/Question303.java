class NumArray{
    int[] preSum;
    public NumArray(int[] nums){
        preSum = new int[nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            preSum[i] = sum;
        }
    }

    public int sumRange(int i, int j){
        if(i == 0)
            return preSum[j];
        else
            return preSum[j] - preSum[i-1];
    }
}
