class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++)
        {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        long ans = Long.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i + l; j <= Math.min(n, i + r); j++){
                long sum = prefix[j] - prefix[i];
                if(sum > 0){
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}
