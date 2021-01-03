[![Codacy Badge](https://app.codacy.com/project/badge/Grade/55d6efdea3d34a0ea16b44b0c1e27174)](https://www.codacy.com/gh/mbobiosio/LifecycleConnectivity/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mbobiosio/LifecycleConnectivity&amp;utm_campaign=Badge_Grade)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=mbobiosio_LifecycleConnectivity&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=mbobiosio_LifecycleConnectivity)
[![Platform](https://img.shields.io/badge/platform-android-brightgreen)](https://developer.android.com/reference)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://developer.android.com/studio/releases/platforms#4.1)
[![](https://jitpack.io/v/mbobiosio/ConnectivityLiveData.svg)](https://jitpack.io/#mbobiosio/ConnectivityLiveData)

<br>
A super simple, super light-weight lifecycle aware solution written in Kotlin that helps you to capture network connectivity events with support for lower APIs

USAGE
-----

## Including in your project
Add below codes to your <b>root</b> build.gradle
```
allprojects {
   repositories {
      maven { url 'https://jitpack.io' }
   }
}
```

Add lifecycleconnectivity dependency to your project's <b>module</b> build.gradle

```groovy
implementation 'com.github.mbobiosio:lifecycleconnectivity:1.0.2'
```

-   Use in your Activity

```kotlin
 val lifecycleService = LifecycleService(this)
 lifecycleService.observe(this, {
     Log.d("Status", "$it")
 })
```

-   Use in your Fragment

```kotlin
 val lifecycleService = LifecycleService(activity as Activity)
 lifecycleService.observe(viewLifecycleOwner, {

 })
```

## Contribute

If you want to contribute to this app, you're always welcome!
See [Contributing Guidelines](CONTRIBUTING.md).

## 📝 License
This project is released under the MIT license.
See [LICENSE](./LICENSE) for details.

```
MIT License

Copyright (c) 2020 Mbuodile Obiosio

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```