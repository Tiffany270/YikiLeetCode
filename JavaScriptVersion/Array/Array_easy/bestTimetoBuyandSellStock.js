/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit1 = function (prices) {

    let max = 0;
    for (let i = 0; i < prices.length; i++) {
        for (let j = i + 1; j < prices.length; j++) {
            max = max > prices[j] - prices[i] ? max : prices[j] - prices[i];
        }
    }

    return max;

};

var maxProfit2 = function (prices) {

    let minPrice = Number.MAX_VALUE;
    let maxProfit = 0;
    for (let i = 0; i < prices.length; i++) {
        if (minPrice > prices[i]) {
            minPrice = prices[i];
        } else {
            maxProfit = maxProfit > prices[i] - minPrice ? maxProfit : prices[i] - minPrice;
        }
    }

    return maxProfit;
};

var maxProfit = function (prices) {

    let maxCur = 0;
    let maxSoFar = 0;

    for (let i = 1; i < prices.length; i++) {
        maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
        maxSoFar = Math.max(maxCur, maxSoFar);
    }

    return maxSoFar;
};