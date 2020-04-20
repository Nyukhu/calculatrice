fun String.sayHello():String{
    val retour = "$this-Bonjour"
    return retour
}
val part1 = "cc"

println(part1.sayHello())

data class Etudiant(var first: String, var last: String)

val etudiant = Etudiant(first = "Adrien", last = "guedes")

fun Etudiant.fullName() = "${this.first} ${this.last}"

println(etudiant.fullName())

fun Etudiant.invert(){
    var temp = this.first
    this.first = this.last
    this.last = temp
}

var students:List<Etudiant> = listOf(
    Etudiant("oui","non"),
    Etudiant("oui","non"),
    Etudiant("oui","non"),
    Etudiant("oui","non"),
    Etudiant("oui","non")
    )

/*students.forEach{
    println(it.fullName())
    it.invert()
    println(it.fullName())

}*/

fun List<Etudiant>.invert(){
    this.forEach{
        var temp = it.first
        it.first = it.last
        it.last = temp
        println(it.fullName())
    }
}

students.invert()