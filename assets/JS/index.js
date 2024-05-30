function removeMiddleElement(arr) {
  const middleIndex = Math.floor(arr.length / 2);
  const arr1 = arr.slice(0, middleIndex);
  const arr2 = arr.slice(middleIndex + 1);
  return arr1.concat(arr2);
}

const a = removeMiddleElement([1, 2, 3, 4, 5, 6, 7, 8, 9]);

console.log(a);
