/*
 * 序号119
 * 杨辉三角
 * */

/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function (rowIndex) {

    let res = [];

    for (let i = 0; i < rowIndex + 1; i++) {
        let temp;
        let prev = 1;


        for (let j = 1; j < res.length; j++) {
            temp = res[j];
            res[j] = temp + prev;
            prev = temp;
        }


        res.push(1);


    }

    return res;


};