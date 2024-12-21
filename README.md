This repository demonstrates a common pitfall when working with Futures in Scala: blocking the main thread by using `blockingAwait` or similar methods. The `bug.scala` file showcases the problem, while `bugSolution.scala` provides a corrected version using callbacks or for comprehensions to handle the asynchronous result without blocking.