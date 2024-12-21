```scala
import scala.concurrent.{ExecutionContext, Future}

class MyService(implicit ec: ExecutionContext) {
  def myMethod(input: String): Future[String] = Future {
    // Some long-running operation
    Thread.sleep(5000) // Simulate a delay
    input.toUpperCase
  }
}

// Example usage
object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global

  val service = new MyService()
  val resultFuture = service.myMethod("hello")

  // This will print immediately and then block until the future is completed
  println(resultFuture.blockingAwait)
}
```