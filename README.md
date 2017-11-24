# Shutdown

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## A library that handles the closing of your app interactively.
<img src=https://raw.githubusercontent.com/emmanuelkehinde/shutdown/master/screenshots/shutdown.gif alt="Shutdown in action" width=360 height=640 />

### Overview of Shutdown library
* Shutdown library handles the closing of your app interactively, 
providing a user the chance to revisit his plan of closing the app.
* It can also be used to close just an activity and not necessarily the whole app
* Lightweight
* Has no dependencies
* Survives configuration change
* NO special initialization is required.
* A single line of code does it all!


## Using Shutdown Library in your Android application

Add this in your build.gradle
```groovy
compile 'com.emmanuelkehinde:shutdown:1.0.0'
```

Place this in your activity `onBackPressed()` method
```java
Shutdown.now(this); 
```
* This Displays the default message `Press back again to close`.
* A user is expected to press back button again within the next 3 seconds, after which it resets.
* You can also specify the timeout in milliseconds.

Calling it from a fragment
```java
Shutdown.now(getActivity());
```

### To specify a different Toast message
```java
Shutdown.now(this,"Hey! You are about to leave");
```

### To specify a different Timeout (in milliseconds)
```java
Shutdown.now(this,5000);
```

### To specify a different Toast message and a different Timeout (in milliseconds)
```java
Shutdown.now(this,"Hey! You are about to leave",5000);
```

## If this library helps you in anyway, show your love :heart: by putting a :star: on this project :v:


### License
```
   Copyright (C) 2017 Emmanuel Kehinde

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

### Contributing to Shutdown
All pull requests are welcome, make sure to follow the [contribution guidelines](CONTRIBUTING.md)
when you submit pull request.
