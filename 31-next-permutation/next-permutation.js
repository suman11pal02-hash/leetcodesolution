/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums)
{
    let i = nums.length - 2;

    // Step 1: Find the first decreasing element from the right
    while (i >= 0 && nums[i] >= nums[i + 1])
    {
        i--;
    }

    // Step 2: If a pivot is found, swap with the next larger element from the right
    if (i >= 0)
    {
        let j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        [nums[i], nums[j]] = [nums[j], nums[i]];
    }

    // Step 3: Reverse the sequence from i + 1 to the end
    let start = i + 1;
    let end = nums.length - 1;
    while (start < end) {
        [nums[start], nums[end]] = [nums[end], nums[start]];
        start++;
        end--;
    }
};