## Composables
---
#### Preview composable
- Its just to see our `ui on IDE`.
```kotlin
    // syntax for preview
    @Preview(
        showBackground = true | false,
        showSystemUi = true | false // it will show like phoneUI
    )
    @Composable
    fun functionname(){}
```

#### Text
- Its used to `display Text`
- It should be used `inside the Composable` Function
```kotlin
    //syntax
    Text(
      text = "strings${}"
        ..args
    )
    
```
- __Text arguments__
    - text = "strings${}"


---
