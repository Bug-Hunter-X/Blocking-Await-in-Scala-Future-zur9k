```scala
import scala.concurrent.{ExecutionContext, Future}

class MyService(implicit ec: ExecutionContext) {
  def myMethod(input: String): Future[String] = Future {
    // Some long-running operation
    Thread.sleep(5000) // Simulate a delay
    input.toUpperCase
  }
}

object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global

  val service = new MyService()
  val resultFuture = service.myMethod("hello")

  // Correct approach using onComplete callback
  resultFuture.onComplete { 
    case scala.util.Success(result) => println(s"Result: $result")
    case scala.util.Failure(exception) => println(s"Error: ${exception.getMessage}")
  }

  //Alternatively using for comprehension:
  // for { 
  //   result <- resultFuture 
  // } yield println(s"Result: $result")
  
  Thread.sleep(6000) // Keep the main thread alive to see the result
}
```