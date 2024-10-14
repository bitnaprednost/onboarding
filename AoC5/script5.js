const fs = require("fs");
const data = fs
  .readFileSync(`${__dirname}/input5.txt`)
  .toString()
  .split("\n\n")
  .filter(Boolean)
  .map((data) => data.split("\n"));

//separate the input to get length, cargo and moves
const cargoStacks = data[0][data[0].length - 1].toString().split(" ");
const cargoManifest = data[0].slice(0, data[0].length - 1);
const cargoMoves = data[1];

//reverse the array to push them in correct order into object
let reversedCargoManifest = [...cargoManifest].reverse();

//create objects from length array to later store cargo manifest
const cargoObjectPartOne = {};
const cargoObjectPartTwo = {};

//Part1
cargoStacks.forEach((cargoStack) => {
  if (cargoStack !== "") {
    cargoObjectPartOne[cargoStack] = [];
    cargoObjectPartTwo[cargoStack] = [];
  }
});

let finalCargoManifest = [];

//merge 4 empty strings into 1 array element, push all elements into separate arrays and store each into finalManifest
reversedCargoManifest.forEach((cargoArr) => {
  let eachCargoArray = [];
  let emptyCount = 0;
  const newCargo = cargoArr.split(" ");

  newCargo.reduce((_, curr) => {
    if (curr !== "") {
      eachCargoArray.push(curr);
      emptyCount = 0;
    } else {
      emptyCount++;
    }

    if (emptyCount === 4) {
      eachCargoArray.push("");
      emptyCount = 0;
    }
    return curr;
  }, []);

  finalCargoManifest.push(eachCargoArray.splice(0, cargoArr.length - 1));

  return finalCargoManifest;
});

finalCargoManifest.forEach((array) => {
  for (let i = 0; i < array.length; i++) {
    if (array[i] !== "") {
      cargoObjectPartOne[i + 1].push(array[i]);
      cargoObjectPartTwo[i + 1].push(array[i]);
    }
  }
});

//separate each instruction
const instructions = cargoMoves.map((instruction) =>
  instruction.toString().split(" ")
);

//PART-1
instructions.forEach((instruction) => {
  const movingNumberOfCargo = instruction[1];
  const movingFrom = instruction[3];
  const movingTo = instruction[5];

  for (let i = 1; i <= movingNumberOfCargo; i++) {
    const movingCargo =
      cargoObjectPartOne[movingFrom][cargoObjectPartOne[movingFrom].length - 1];

    cargoObjectPartOne[movingTo].push(movingCargo);
    cargoObjectPartOne[movingFrom].pop();
  }
});

//PART-2
instructions.forEach((instruction) => {
  const movingNumberOfCargo = instruction[1];
  const movingFrom = instruction[3];
  const movingTo = instruction[5];

  const movingCargo = cargoObjectPartTwo[movingFrom].slice(
    -movingNumberOfCargo
  );

  cargoObjectPartTwo[movingTo].push(...movingCargo);
  cargoObjectPartTwo[movingFrom].splice(-movingNumberOfCargo);
});

//determine cargo on top
let topCargoPartOne = [];
let topCargoPartTwo = [];

Object.values(cargoObjectPartOne).forEach((cargoArr) => {
  topCargoPartOne.push(cargoArr[cargoArr.length - 1]);
});

Object.values(cargoObjectPartTwo).map((cargoArr) => {
  topCargoPartTwo.push(cargoArr[cargoArr.length - 1]);
});

console.log(topCargoPartOne, topCargoPartTwo);
