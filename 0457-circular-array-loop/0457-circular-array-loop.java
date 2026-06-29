class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextIndex(nums, forward, slow);
                if (slow == -1) break;

                fast = nextIndex(nums, forward, fast);
                if (fast == -1) break;
                fast = nextIndex(nums, forward, fast);
                if (fast == -1) break;

                if (slow == fast) return true;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, boolean forward, int current) {
        boolean direction = nums[current] > 0;
        if (direction != forward) return -1;

        int n = nums.length;
        int next = ((current + nums[current]) % n + n) % n;
        if (next == current) return -1;
        return next;
    }
}
