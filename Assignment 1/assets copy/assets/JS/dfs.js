document.addEventListener("DOMContentLoaded", function () {
  function dfsIterative(startNode) {
    let stack = [startNode];
    let visited = new Set();

    while (stack.length > 0) {
      let currentNode = stack.pop();

      if (!visited.has(currentNode)) {
        visited.add(currentNode);
        console.log(currentNode);

        for (let child of Array.from(currentNode.children).reverse()) {
          stack.push(child);
        }
      }
    }
  }

  function dfsRecursive(node) {
    let visited = new Set();

    if (!node || visited.has(node)) return;

    visited.add(node);
    console.log(node);

    for (let child of node.children) {
      dfsRecursive(child);
    }
  }

  //   dfsIterative(document.documentElement);
  dfsRecursive(document.documentElement);
});
