public class NumArray {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;             
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }         
            return ret;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {    
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}

class MyNumArray {
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
