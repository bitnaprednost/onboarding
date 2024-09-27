const fs = require("fs");
const data = fs.readFileSync(`${__dirname}/input1.txt`).toString();

//remove empty lines and create a stringl
const newData = data.split("\n").toString();
// console.log(newData);

//separate string into groups
const groups = newData.split(",,");
// console.log(groups);

//group strings into arrays of numbers (filter to account for empty space after last element)
const groupedNumbers = groups.map((group) =>
  group
    .split(",")
    .filter(Boolean)
    .map((group) => parseInt(group))
);
// console.log(groupedNumbers);

//sum up each array
const sumsArr = groupedNumbers.map((array) =>
  array.reduce(function (acc, cur) {
    return acc + cur;
  }, 0)
);
// console.log(sumsArr);

//PART 1//

//find the elf with max value of calories
const elfWithMostCalories = (array) => {
  let max = array[0];
  array.forEach((number) => {
    if (number > max) {
      max = number;
    }
  });
  return max;
};

const partOneResult = elfWithMostCalories(sumsArr);
console.log(partOneResult);

//PART 2//

//find the sum of the top 3 elves
const partTwoResult = sumsArr
  .sort((a, b) => b - a)
  .splice(0, 3)
  .reduce((a, b) => a + b, 0);
console.log(partTwoResult);
