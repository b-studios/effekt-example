import effekt._

object helloWorld {

  trait Amb extends Eff {
    def flip(): Op[Boolean]
  }
  def flip(): Boolean using Amb = implicit c =>
    use(c)(c.handler.flip())

  trait AmbList[R] extends Amb with Handler.Basic[R, List[R]] {
    def unit = a => List(a)
    def flip() = for {
      ts <- resume(true)
      fs <- resume(false)
    } yield ts ++ fs
  }
  def ambList[R](p: R using Amb) = handle(new AmbList[R] {})(p)

  val res = ambList {
    for {
      x <- flip()
      y <- flip()
    } yield (x, y)
  }

  // in console, try `helloWorld.res.run()`

}
