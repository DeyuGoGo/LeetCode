/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var index = 0
    var lastnum = "幹你娘"
    nums.forEach(num => {
        if(num!=lastnum) {
            nums[index] = num
            index++
            lastnum = num
        }
    });
    return index
};