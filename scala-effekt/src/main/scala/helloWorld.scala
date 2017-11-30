import effekt._

object helloWorld {

  trait Amb extends Eff {
    def flip(): Op[Boolean]
  }
  def flip()(implicit c: Use[Amb]): Control[Boolean] =
    use(c)(c.handler.flip())

  trait AmbList[R] extends Amb with Handler.Basic[R, List[R]] {
    def unit = a => List(a)
    def flip() = s => resume => for {
      ts <- resume(true)(s)
      fs <- resume(false)(s)
    } yield ts ++ fs
  }
  def ambList[R] = new AmbList[R] {}

  val res = ambList { implicit c =>
    for {
      x <- flip()
      y <- flip()
    } yield (x, y)
  }

  // in console, try `helloWorld.res.run()`

}
