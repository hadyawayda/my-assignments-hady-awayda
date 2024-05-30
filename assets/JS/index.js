function removeMiddleElement(arr) {
  const middleIndex = Math.floor(arr.length / 2);
  const arr1 = arr.slice(0, middleIndex);
  const arr2 = arr.slice(middleIndex + 1);
  return arr1.concat(arr2);
}

function countTrue(arr) {
  return arr.filter((x) => x === true).length;
}

function toArray(obj) {
  const len = Object.keys(obj).length;
  const arr = Array(len).fill("");

  const arr1 = Object.keys(obj);
  const arr2 = Object.values(obj);

  for (let i = 0; i < len; i++) {
    arr[i] = [arr1[i], arr2[i]];
  }

  return arr;
}

function luckyNumbers(arr) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i].toString().includes("7")) {
      return "LUCKY";
    }
  }
  return "there is no 7 in the array :(";
}

function oddishOrEvenish(num) {
  let sum = 0;

  for (let i = 0; i < num.toString().length; i++) {
    sum += parseInt(num.toString()[i]);
  }

  return sum % 2 === 0 ? "Evenish" : "Oddish";
}
