
class HelloWorldWithCommandLine {
    fun main(args: Array<String>) {
        if (args.isNotEmpty()) {
            println(args[0])
        } else {
            println("Hello World!")
        }
    }
}
