import kotlinx.coroutines.*
import kotlin.reflect.typeOf
import kotlin.system.measureTimeMillis


//Concurrency with launch within run blocking
fun test1(){
    val time = measureTimeMillis{
        val books = ArrayList<String>();
        runBlocking {
            launch { books.add(book_api("LAyyr")) }
            launch { books.add(book_api("baba")) }
            launch { books.add(book_api("Wison")) }
        }
        println(books)
    }
    print("Execution time: ${time/1000} s")
}
//Concurrency with async within run blocking
fun test2(){

    val time = measureTimeMillis{
        val books = ArrayList<String>();
        runBlocking {
             books.add(async { book_api("larry") }.await())
             books.add(async { book_api("baba") }.await())
             books.add(async { book_api("nice") }.await())
        }
        println(books)
    }
    print("Execution time: ${time/1000} s")
}

suspend fun test3() = coroutineScope {
        val time  = measureTimeMillis {
            val book1 = async { book_api("boo1") };
            val book2 = async { book_api("boo2") };
            val book3 = async { book_api("boo3") };
            val book4 = async { book_api("boo3") };
            val book5 = async { book_api("boo3") };
            val book6 = async { book_api("boo3") };
            val book7 = async { book_api("boo3") };
            val book8 = async { book_api("boo3") };
            val book9 = async { book_api("boo3") };
            val book11 = async { book_api("boo3") };

            println(
                        book1.await() +
                        " ${book2.await()}" +
                        " ${book3.await()}"+
                        " ${book4.await()}"+
                        " ${book5.await()}"+
                        " ${book6.await()}"+
                        " ${book7.await()}"+
                        book8.await()
            )
        }
    println("Execution time: ${time/1000} s")
}


//Handling Exceptions
suspend fun test4() = coroutineScope {
    val time = measureTimeMillis{
            val books = ArrayList<Deferred<String>>();
            books.add(async { book_api("larry") })
            books.add(async { book_api("baba") })
            books.add(async { book_api("nice") })
            try{ books.add(async { errorData() }) }
            catch (e:AssertionError){println("ERRRO")}
            println(books.map { it.await() })
    }
    print("Execution time: ${time/1000} s")
}



//first async all then await , this will fetch all data at a time
suspend fun test5() = coroutineScope{
    val time  = measureTimeMillis{
        val asynclist = ArrayList<Deferred<String>>()
        for (i in 0..10) {
            asynclist.add(async { (book_api("book$i")) })
        }
        val awaitlist = asynclist.map {it.await()}
        println(awaitlist);
    }
    println(time );
}


//Cancelling request
suspend fun test6() = coroutineScope {
    val time = measureTimeMillis {
        val str = async{ cancelation_data() };
        delay(4000)
        str.cancel()
        println(str.await())
    }

}


suspend fun main() {
//    test1()
//    test2()
//    test3()
//    try{ test4() }catch (e:AssertionError){print("Handing error $e")}
//    test5()
    test6()
}


suspend fun book_api(str:String):String {
    delay(2000);
    return str;
}

suspend fun cancelation_data():String {
    delay(3000);
    return "Olla ai"
}

suspend fun errorData():String{
    delay(2000);
    throw AssertionError("Oh my god")
}