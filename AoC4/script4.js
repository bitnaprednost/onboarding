const fs = require("fs");
const data = fs
  .readFileSync(`${__dirname}/input4.txt`)
  .toString()
  .split("\n")
  .filter(Boolean)
  .map((data) => data.split("-").join(",").split(","))
  .map((eachArr) => {
    return eachArr.map(Number);
  });

// console.log(data);

const numberPairs = [];

data.map((array) => {
  const firstNumber = array.slice(0, array.length / 2);
  const secondNumber = array.slice(array.length / 2, array.length);

  numberPairs.push(firstNumber, secondNumber);
});

/* console.log(numberPairs); */

const range = numberPairs.map(([firstNumber, secondNumber]) => {
  return Array.from(
    { length: secondNumber - firstNumber + 1 },
    (_, i) => firstNumber + i
  );
});

/* console.log(range); */

let pairedRanges = [];

while (range.length > 0) {
  pairedRanges.push(range.splice(0, 2));
}
/* console.log(pairedRanges); */

//PART 1
let firstTotal = 0;

pairedRanges.map((array) => {
  const firstSet = new Set(array[0]);
  /* console.log(firstSet.size); */
  const secondSet = new Set(array[1]);
  /* console.log(secondSet.size); */

  if (firstSet.size <= secondSet.size && secondSet.isSupersetOf(firstSet)) {
    return (firstTotal += 1);
  } else if (
    secondSet.size <= firstSet.size &&
    firstSet.isSupersetOf(secondSet)
  ) {
    return (firstTotal += 1);
  } else {
    return;
  }
});

console.log(firstTotal);

//PART 2
let secondTotal = 0;

pairedRanges.map((array) => {
  /*   console.log(array); */
  const firstSet = new Set(array[0]);
  /* console.log(firstSet); */
  const secondSet = new Set(array[1]);
  /*   console.log(secondSet); */

  const allOverlapingNumbers = firstSet.intersection(secondSet);
  /* console.log(allOverlapingNumbers); */

  const setIter = allOverlapingNumbers.entries();
  const value = setIter.next().value;

  if (value) {
    return (secondTotal += 1);
  }
});

console.log(secondTotal);
