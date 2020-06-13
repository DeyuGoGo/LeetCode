/**
 * @param {string[]} words
 * @return {string[]}
 */
var stringMatching = function(words) {
    var result = {};
    for (var i = 0;i<words.length;i++) {
        for (var j = i+1 ; j<words.length;j++){
            if(i==j)continue;
            w1 = words[i] 
            w2 = words[j] 
            if(w1.length>w2.length){
                if(w1.includes(w2))
                result[w2] = true
                
            }else{
                if(w2.includes(w1))
                result[w1] = true
                
            }
        }
    }
    return Object.keys(result);
};

