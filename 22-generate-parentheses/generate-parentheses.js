/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
   const result = [];

    const buildCombinations = (currentStr, openCount, closeCount) => {
        if (currentStr.length === n * 2)
        {
            result.push(currentStr);
            return;
        }

        if (openCount < n){
            buildCombinations(currentStr + '(', openCount + 1, closeCount);
        }

        if (closeCount < openCount){
            buildCombinations(currentStr + ')', openCount, closeCount + 1);
        }
    };

    buildCombinations('', 0, 0);
    return result;
};