OVERVIEW
========
This project is sample demonstration of MVVM with Clean Architecture using the Github public api.
It uses
paging 3 library with kotlin flow for infinite scrolling [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
hilt for dependency injection [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
kotlin DSL, [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html).
mockito kotlin for creating test doubles [Mockito Kotlin](https://github.com/mockito/mockito-kotlin)
barista for ui assertions [Barista](https://github.com/AdevintaSpain/Barista)

Other libraries used can be found in the buildSrc module


TODO
====
1. Fix tests and increase test coverage
1. add leak canary - https://github.com/square/leakcanary
3. Use SonarLint 