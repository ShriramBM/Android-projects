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
- It should be used `inside the Composable` functions
```kotlin
    //syntax
    Text(
      text = "strings $name", //text to display
      modifier = modifier, //for ui
      fontSize = 100.sp, //  sp good for all sizable phone
      lineHeigth = 100.sp, // line heigth will give more more heigth over you app
      textAlign = TextAlign.Center,
    

        ..args
    )
    
```

#### UI Hierarchy
- The UI hierarchy is based on containment
-  will learn about `Column`, `Row`, and `Box` composables
```kotlin
    //syntax
    // XXX -> (Row, Column, Box) non scrollable
    XXX {
        Text("Text1")
        Text("Text2")
    }
    
```

#### Image
- To add image follow the steps on IDE
    - go to `ResourseManager`
    - click `+` on left then click `import Drawbles`
    - select Qualifier type as `Density` and Value as `No Density`
    - Next and `import`  
- `No density` will not give blurry images on different phone 
- After import you can see the image file on the ResourseManager i.e `app > res > drawable` 

```kotlin
    //syntax
    import androidx.compose.foundation.Image;
    Image(
        painter = painterResource(R.drawable.image_file_name), //select the image_file
        contentDescription = null, //description about image
        alpha = 0.5f //for opacity
    )
```


---
