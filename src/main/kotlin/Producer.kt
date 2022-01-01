import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        produceSquares().consumeEach {
            println(it)
        }

        println()

        // alternative way to receive from channel
        for(y in produceSquares()) {
            println(y)
        }
    }
}

fun CoroutineScope.produceSquares() = produce {
    for(x in 1..5)
        send(x * x)
}