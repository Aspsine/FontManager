# FontManager
Android Font Manager

### How to use
Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
  repositories {
  	...
  	maven { url "https://jitpack.io" }
  }
}
```

Step 2. Add the dependency
```groovy
dependencies {
  compile 'com.github.Aspsine:FontManager:-SNAPSHOT'
}
```

Step 3. Load font into memory
Note: If the font files are big, this may take some times (several seconds). You'd better do this asynchronously.
Once the fonts were loaded. It will be cached.
```java
// fonts paths in asserts
String[] FontPaths = {"fonts/Lanehum.ttf", "fonts/OrangeJuice.ttf", "fonts/OrmontLight.ttf", "fonts/WedgieRegular.ttf"};
// load assert fonts into memory
FontManager.getInstance().init(context, FontPaths);
```
Set Typeface
```java
AssetManager assetManager = context.getAssets();
// obtain the Typeface. The 'path' is the font file path in asserts folder
Typeface typeface = FontManager.getInstance().getTypeface(assetManager, path);
// set font
textView.setTypeface(typeface);
```

### What's in Demo

- A FontsUtils is provided for easier use. Please check demo code.
```java
// set font to TextView/EditText/Button or any child class instance of TextView
FontsUtils.setFonts(textView, fontType);
// change font of textView in the viewGroup
FontsUtils.setFonts(viewGroup, fontType)
```

- Customised TextView and EditText widget
```xml
<com.aspsine.fontmanager.demo.FontTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World!"
    app:textFont="Lanehum" />
```
```xml
<com.aspsine.fontmanager.demo.FontEditText
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World!"
    app:textFont="Lanehum" />
```
