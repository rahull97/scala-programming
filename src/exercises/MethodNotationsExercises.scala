package exercises

/*
    1.  Overload the + operator
        mary + "the rockstar" => new person "Mary (the rockstar)"

    2.  Add an age to the Person class
        Add a  unary + operator => new person with the age + 1
        + mary =>  mary with the age incremented

    3.  Add a "learns" method in Person class => "Mary learns Scala"
        Add a learnsScala method, calls learn method with "Scala"
        Use it in the postfix notation

     4.  Overload the apply method
         mary.apply(2) => "Mary watched Inception 2 times"

 */


object  MethodNotationsExercises  extends  App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie
    def + (person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck ?!"
    def isAlive(): Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie."

    def + (nicKName: String): Person = new Person(s"$name ($nicKName)", favoriteMovie, age)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(lang: String): String = s"$name learns $lang"

    def learnScala : String = this.learns("Scala")

    def apply(nTimesWatched: Int): String = s"$name watched his/her favorite movie $favoriteMovie $nTimesWatched times"

  }

  val mary = new Person("Mary", "Inception", 10)
  val bob = new Person("Bob", "Fight Club", 1)

  println(mary + bob)
  val newMary = mary + "the rockstar"
  println(newMary.name)

  val incAgeOfBob = +bob
  println(incAgeOfBob.age)

  println(mary learnScala)

  println(mary())
  println(mary(2))

}
