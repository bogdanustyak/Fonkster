[![Hits-of-Code](https://hitsofcode.com/github.com/yegor256/hoc)](https://hitsofcode.com/view/github.com/yegor256/hoc)

# Fonkster
Fonkster is Android library for dynamically loading fonts from URL written in Kotlin.

## Requirements
Android SDK 16+

## Usage
Add to your root build.gradle:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Add the dependency:

```
dependencies {
	implementation 'com.github.bogdanustyak:Fonkster:0.0.1'
}
```

## How to use this library in your project?
```kotlin
  val fontLink = "https://site.com/fontFile.ttf"
  val fontFileName = "fontFile.ttf"
  val fonkster = Fonkster.with(applicationContext)
  tv_text.typeface = fonkster.typeFace(fontLink, fontFileName)
```

## License

```
The MIT License (MIT)

Copyright © 2018 KeyToTech, https://keytotech.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
