# Drawer
-----------

Drawer is an application for drawing geometric objects on command line 

Supported commands
* Available commands are:
* C w h - draws Canvas
* L x1 y1 x2 y2  - draws Line
* R x1 y1 x2 y2 - draws Rectangle
* B x y c - draws BucketFill
* Q - Quits program
* H - prints Help

Implementation details
-----------

* Regex is used for parsing and validating input commands
* Two types of commands are supported 
    * Actions for printing help or exiting the app
    * DrawCommand for drawing geometric objects
    


Technology stack
-----------

* Scala
* Scalatest

Build and Run
-----------

To build and run jar file

`./gradlew build`

`java -jar build/libs/drawer-1.0.jar `

Can Be improved 
-----------
For BucketFill command is used recursion which can be replaced with non-recursive implementation using stack  
