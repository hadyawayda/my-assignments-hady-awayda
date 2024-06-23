document.addEventListener("DOMContentLoaded", function () {
  function bfs(startNode) {
    let queue = [startNode];
    let visited = new Set();

    while (queue.length > 0) {
      let currentNode = queue.shift();

      if (!visited.has(currentNode)) {
        visited.add(currentNode);
        console.log(currentNode);

        for (let child of currentNode.children) {
          queue.push(child);
        }
      }
    }
  }

  //   bfs(document.documentElement);
});
