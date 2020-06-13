/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    var index = 0
    var lastnum = val
    nums.forEach(num => {
        if(num!=lastnum) {
            nums[index] = num
            index++
        }
    });
    return index
};