class NumArray {
    int[] seg = null;
    int[] nums = null;
    public NumArray(int[] num) {
        nums = new int[num.length];
        seg = new int[4*nums.length];
        for(int i = 0;i<num.length;i++) nums[i] = num[i];
        buildTree(nums, seg, 0, 0, nums.length-1);
    }

    private int buildTree(int[] nums, int[] seg, int root, int begin, int end){
        if(begin > end) return 0;
        if(begin == end){
            seg[root] = nums[begin];
            return seg[begin];
        }
        int mid = (end - begin)/2 + begin;
        seg[root] = buildTree(nums, seg, 2*root+1, begin, mid) + buildTree(nums, seg, 2*root+2, mid+1, end);
        return seg[root];
    }
    
    public void update(int i, int val) {
        int diff = nums[i] - val;
        nums[i] = val;
        update1(seg, 0, 0, nums.length-1, i, diff);
    }

    private void update1(int[] seg, int root, int begin, int end, int targetIndex, int diff){
        if(begin > end) return;
        seg[root] += diff;
        int mid = (end - begin)/2 + begin;
        if(targetIndex <= mid){
            update1(seg, root*2+1, begin, mid, targetIndex, diff);
        }
        else{
            update1(seg, root*2+2, mid+1, end, targetIndex, diff);
        }
    }
    
    public int sumRange(int i, int j) {
        return getRange(i, j, 0, 0, seg.length-1);    
    }

    private int getRange(int i, int j, int root, int begin, int end){
        if(i >= begin && j <= end) return seg[root];
        else if(i > end || j < begin) return 0;
        else{
            int mid = (end - begin)/2 + begin;
            if(begin > mid){
                return getRange(mid+1, j, 2*root+2, begin, end);
            }
            else if(end <= mid){
                return getRange(i, mid, 2*root+1, begin, end);
            }
            else{
                return getRange(i, mid, 2*root+1, begin, end) + getRange(mid+1, j, 2*root+2, begin, end);
            }
        }
    }
}
