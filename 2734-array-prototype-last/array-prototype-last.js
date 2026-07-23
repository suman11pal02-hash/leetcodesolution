/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
        return this.length === 0 ? -1 : this[this.length - 1];
};
// Example 1
let nums1 = [null, {}, 3];
console.log(nums1.last());

// Example 2
let nums2 = [];
console.log(nums2.last());
/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */