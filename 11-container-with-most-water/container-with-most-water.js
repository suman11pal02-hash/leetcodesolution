/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let maxWater = 0;
    let left = 0;
    let right = height.length - 1;
    while(left < right){
    const currentHeight = Math.min(height[left], height[right]);
    const width = right - left;        
    const currentArea = currentHeight * width;
    maxWater = Math.max(maxWater, currentArea);
        if(height[left]< height[right]){
            left++;
        }
        else{
            right--;
       }
    }
    return maxWater;
};