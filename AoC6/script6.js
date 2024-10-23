const fs = require("fs");
const data = fs.readFileSync(`${__dirname}/input6.txt`).toString().split("");

let packetPartOne = [];
let markerPartOne = 0;

function isUnique(value, _, array) {
  return array.indexOf(value) === array.lastIndexOf(value);
}

for (let i = 0; i <= data.length - 1; i++) {
  packetPartOne.push(data.slice(i, i + 4));
  const arrayIsUnique = packetPartOne[i].every(isUnique);

  if (!arrayIsUnique) {
    markerPartOne++;
  } else {
    markerPartOne += 4;
    break;
  }
}

console.log(markerPartOne);

//PART2
let packetPartTwo = [];
let markerPartTwo = 0;

for (let i = 0; i <= data.length - 1; i++) {
  packetPartTwo.push(data.slice(i, i + 14));
  const arrayIsUnique = packetPartTwo[i].every(isUnique);

  if (!arrayIsUnique) {
    markerPartTwo++;
  } else {
    markerPartTwo += 14;
    break;
  }
}

console.log(markerPartTwo);
