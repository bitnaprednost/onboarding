const fs = require("fs");
const data = fs
  .readFileSync(`${__dirname}/input3.txt`)
  .toString()
  .split("\n")
  .filter(Boolean);

// console.log(data);

const eachCharacter = data.map((data) => data.split(""));

const sameCharacter = [];
let firstTotal = 0;

eachCharacter.map((array) => {
  const twoPartArray = [];
  // console.log(twoPartArray);

  const part1 = array.slice(0, array.length / 2);
  const part2 = array.slice(array.length / 2, array.length);

  twoPartArray.push(part1, part2);
  // console.log(twoPartArray);

  const sameElement = [
    ...new Set(part1.filter((element) => part2.includes(element))),
  ];
  sameCharacter.push(sameElement);
});

// console.log(sameCharacter);

sameCharacter.map((element) => {
  const arrayCharacter = element.toString();
  // console.log(arrayCharacter);

  const charCode = arrayCharacter.charCodeAt(0);
  // console.log(charCode);

  //lowerCaseValues -> a-z (97 - 122)
  //upperCaseValues -> A-Z (65 - 90)

  if (charCode >= 97 && charCode <= 122) {
    firstTotal += charCode - 97 + 1;
  }
  if (charCode >= 65 && charCode <= 90) {
    firstTotal += charCode - 65 + 27;
  }
});

console.log(firstTotal);

//PART 2
/* console.log(data); */

const size = 3;
const threePartArray = [];
const sameElementsArray = [];
let secondTotal = 0;

while (data.length > 0) {
  const piece = data.splice(0, size);
  // console.log(piece);
  threePartArray.push(piece);
}
// console.log(threePartArray);

threePartArray.map((array) => {
  const arrays = array.map((arr) => arr.split(""));
  /* console.log(arrays); */

  const part1 = arrays[0];
  const part2 = arrays[1];
  const part3 = arrays[2];

  /*   console.log('part1:',part1, 'part2:',part2, 'part3:',part3); */

  const sameElement = [
    ...new Set(
      part1.filter(
        (element) => part2.includes(element) && part3.includes(element)
      )
    ),
  ];
  sameElementsArray.push(sameElement);
  // console.log(sameElement);
});

/* console.log(arrays); */

/* console.log(sameElementsArray); */

sameElementsArray.map((element) => {
  const arrayCharacter = element.toString();
  /*  console.log(arrayCharacter); */

  const charCode = arrayCharacter.charCodeAt(0);
  /* console.log(charCode); */

  //lowerCaseValues -> a-z (97 - 122)
  //upperCaseValues -> A-Z (65 - 90)

  if (charCode >= 97 && charCode <= 122) {
    secondTotal += charCode - 97 + 1;
  }
  if (charCode >= 65 && charCode <= 90) {
    secondTotal += charCode - 65 + 27;
  }
});

console.log(secondTotal);
