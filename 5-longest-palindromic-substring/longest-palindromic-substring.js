/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
const n = s.length;
if(n <= 1) return s;
const dp = Array.from({ length: n }, () => Array(n).fill(false));
let start = 0;
let maxLength = 1;
for (let i = 0; i < n; i++) {
        dp[i][i] = true;
    }
for(let len = 2; len <= n; len++){
    for(let i = 0; i <= n - len; i++){
        const j = i + len - 1;
        if(s[i] === s[j]){
            if(len === 2 || dp[i + 1][j - 1]){
                dp[i][j] = true;
                if(len > maxLength){
                    start = i;
                    maxLength = len;
                }
            }
        }
    }
    }
    return s.substring(start, start + maxLength);
};