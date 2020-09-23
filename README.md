<br>
[![](https://jitpack.io/v/mbobiosio/LifecycleConnectivity.svg)](https://jitpack.io/#mbobiosio/LifecycleConnectivity)

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
implementation 'com.github.mbobiosio:lifecycleconnectivity:1.0.1'
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

LICENCE
-----

LifecycleConnectivity by [Mbuodile Obiosio]<cazewonder@gmail.com> is licensed under a [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
