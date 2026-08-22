/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
     if (n <= 2) return n;

    let oneStepBefore = 1;
    let twoStepsBefore = 2;

    for (let step = 3; step <= n; step++)
    {
        let currentWays = oneStepBefore + twoStepsBefore;
        oneStepBefore = twoStepsBefore;
        twoStepsBefore = currentWays;
    }
    return twoStepsBefore;
};