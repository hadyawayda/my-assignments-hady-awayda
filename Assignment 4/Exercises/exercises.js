function factorial(n) {
  if (n === 0) {
    return 1;
  } else {
    return n * factorial(n - 1);
  }
}

function fibonacci(n) {
  if (n <= 1) {
    return n;
  } else {
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

function sumOfDigits(n) {
  if (n === 0) {
    return 0;
  } else {
    return (n % 10) + sumOfDigits(Math.floor(n / 10));
  }
}

function power(a, b) {
  if (b === 0) {
    return 1;
  } else {
    return a * power(a, b - 1);
  }
}

function gcd(a, b) {
  if (b === 0) {
    return a;
  } else {
    return gcd(b, a % b);
  }
}

function reverse(str) {
  if (str === "") {
    return str;
  } else {
    return reverse(str.substring(1)) + str.charAt(0);
  }
}

function generatePermutations(prefix, str, result) {
  let n = str.length;
  if (n === 0) {
    result.push(prefix);
  } else {
    for (let i = 0; i < n; i++) {
      generatePermutations(
        prefix + str.charAt(i),
        str.substring(0, i) + str.substring(i + 1, n),
        result
      );
    }
  }
}
