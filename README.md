Sunshine
========

Sunshine is the companion Android app for the Udacity course [Developing Android Apps: Android Fundamentals](https://www.udacity.com/course/ud853).

Take the course to find out how to build this app a step at a time, and eventually create your own Android App!

This is the second version of the Sunshine code. The repository has been updated on:

* **February 13th, 2015** - Major update
* February 25, 2015 - Minor bug fixes
* March 4th, 2015 - Minor bug fixes

For the original version, please go [here](https://github.com/udacity/Sunshine).

A changelog for the course can be found [here](https://docs.google.com/a/knowlabs.com/document/d/193xJb_OpcNCqgquMhxPrMh05IEYFXQqt0S6-6YK8gBw/pub).

*[duqueGZ]* **NOTE:** Since Place Picker widget functionality for establish location preference has been included, is needed to edit *AndroidManifest.xml* and put a correct Android API key (Google Developers Console credentials) in order to get this functionality correctly working. *'YOUR_API_KEY'* placeholder must be replaced by a correct value.

app/src/main/AndroidManifest.xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.android.sunshine.app" >
    ...
    <!-- YOUR_API_KEY -->
    <meta-data
        android:name="com.google.android.geo.API_KEY"
        android:value="YOUR_API_KEY"/>
    ...
</manifest>
```
