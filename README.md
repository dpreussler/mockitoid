[![Build Status](https://travis-ci.org/dpreussler/mockitoid.svg?branch=master)](https://travis-ci.org/dpreussler/mockitoid)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.jodamob.android/mockitoid/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.jodamob.android/mockitoid

mockitoid
==========
Android specific assertions and mocks for mockito for cleaner test code


Gradle
======

```groovy
testCompile 'de.jodamob.android:mockitoid:0.2'
 
```

Asserts
=======
write 
`anyActivity()` instead of `any(Activity.class)`
in mockito verification.

example:
```java
verify(myInteractor).showWizard(anyActivity());
```

Same with:
```java
anyFragment()
anyFragmentManager()
anyIntent()
anyContext()
anyView()
anyButton()
...
```

more to be come


Mocks
=====
write mockActivity() instead of mock(Activity.class)
Same with:
```java
mockFragment()
mockResources()
mockContext()
mockIntent()
mockBundle()
...
```

some mocks can have small behavior:
`mockTextView("test")` given a Textview that will return an Editable that has string "test"

`mockFragmentManager(FragmentTransaction)` will return this fragmenttransaction for every transaction started

`mockMenuItem(id)` where id will be the itemId that will return a MenuItem mock for
..



Licensed under MIT license
(c) 2015 Danny Preussler