### Coroutines in Kotlin
---

#### Intro
- Its like Thread in java but it is not
- Working `Concurrently` is necessary when gettting data from Internet

#### launch
- Below syntax is not for Internet but for the concurrency mechanizm
```kotlin
    //Concurrency code should wrap up with :runBlocking 
    // launch: is used to tell the compiler to do not sync
    // use suspend keyword for the function which is async request
    runBlocking {
            launch { books.add(book_api("LAyyr")) }
            launch { books.add(book_api("baba")) }
            launch { books.add(book_api("Wison")) }
    }
    
    suspend fun book_api(str:String):Stirng{
        //....
    }
```
#### async
- If you want to work with Internet the `async` keyword is used
- `async` is used to retrive the `data from internet` as the speed of internet
- `.await()` is achual data 
```kotlin

    val asynclist = ArrayList<String>();
    //async
    runBlocking {
            asynclist.add(async { book_api("larry") })
            asynclist.add(async { book_api("baba") })
            asynclist.add(async { book_api("nice") })
            asynclist.add(async { (book_api("book")) })
    }
    //await
    val books = asynclist.map {it.await()}
    println(books)
```

#### Corountine scope
- Without run block with can excecute coroutines by function level scope i.e by `coroutineScope {}`
- function should be `in suspended` state
```kotlin
    // Function scope which is clean and no need for run blocking
    suspend fun test3() = coroutineScope {
        val book1 = async { book_api("boo1") };
        val book2 = async { book_api("boo2") };
        val book3 = async { book_api("boo3") };
        println("${book1.await()} ${book2.await()} ${book3.await()}")
    }

```
#### Exception and Cancelation
- __Cancelation__: cancel the request within some time period
```kotlin
    // if request takes longer than 4000 then request it canceled and exeption is show otherwise request is satisfiesd  
    val str = async{ request() };
    delay(4000)
    str.cancel()
    print(str.await())
```
---
#### Thank you