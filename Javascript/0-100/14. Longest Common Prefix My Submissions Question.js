/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if(strs===null)
    return "";
    if(strs.length <1)
    return "";
    var checksize = strs[0].length;
    strs.forEach(function(s) {
        if(s.length<checksize)
        checksize = s.length;
    });
    var result = "";
    for(var i = 0 ; i < checksize ; i++){
        var x  = strs[0].charAt(i);
        var ko ;
        for(ko of strs)
        if(ko.charAt(i)!=x)
        return result;
        result+=x;
        }
    return result;
};
