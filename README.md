Lab 3
=====

Instructions
------------

The file Lab3.pdf contains questions for the written part of the assignment, and details for the coding part of the assignment.  To finish the assignment, finish the code template in the file /src/main/scala/Lab3.scala.  You will need to modify the *eval*, *step* and *substitute* functions.  There should be no need to alter the remaining part of the assignment.  Note that this lab explicity converts types, so your interpreter may behave slightly different from the previous lab.

You are expected to write at least one javascripty test case.  Include this file in the directory *jsy_testcases*.  This test case should test for behavior more complex than the **sbt** test cases; very simple test cases (e.g., 1+2) will not receive a very high grade.  Included in *jsy_testcases* is an example test case.  Sample javascripty files are also available in the *example_jsy* folder.  Test cases which are just copies of these files will receive no credit.  You will also need to submit your test case to the autotester.  Details on how to do this will be posted on Piazza.

For the written part of the assignment, please create a document called Lab2.md.  Include your name and identikey in the document!  Images for parse trees and judgements can be included in any image format (.jpg, .png, etc.) as separate files, and refered to in the writeup.

### Deliverables

Your submission should have the following items included to be considered complete:

1.  Your interpreter should be implemented as *Lab3.scala* (simply modify the given template file in */src/main/scala/*.

2.  Your written portion should be included as *Lab3.md*.  Figures and illustrations can be included as image files and refered to in your writeup.  Parts 3c, 4 and 5 of the handout require a written answer.

3.  The *koans/* directory should contain the requested koans (see below) completed and passing all tests.

4.  The *jsy_testcases* directory should contain your javasripty test case(s).

5.  Fill out answers to the questions in *survey.md*.

6.  Submit your lab and test case to the autograder.	

### sbt

For your convenience, an sbt script (build.sbt is included).  You can issue the following commands to compile, run and test your code:

    $ sbt compile 

compile your program

    $ sbt clean

delete the previous compilation

    $ sbt "run --debug file.jsy"

runs the interpreter in debug mode with file.jsy as input.  The optional --debug flag provides informative messages throughout interpretation of the input file.

    $ sbt test

executes the test suite.  Note that the test suite is designed to test the function of individual terms, and not necessarily the interaction between.  The online autotester will contain more complex test cases. 

sbt is available at http://www.scala-sbt.org.

### Readings

Suggested readings for this assignment are below.  Dr. Chang's notes are the most relevant for this assignment.  The Friedman and Wand chapters discuss scoping and binding of variables, if you are interested in more details.

+  Dr. Chang's Course Notes - through (and including) Chapter 3.3.2.  (Chapter 3.3.3 covers type checking, which will be part of the next lab).

+  Odersky, Spoon and Venners, *Programming in Scala*, Chapter 15.6  (Covers the Option class).

+  Friedman and Wand, *Essentials of Programming Languages*, Chapters 3.3 - 3.5

Further readings, if found, will be posted on Piazza.

### Koans

For this lab, finish the following koans:

+  AboutMaps
+  AboutOptions
+  AboutEmptyValues

Place completed koans in the directory *koans*.

### node.js

In this lab, we are varying slightly from javascript's behavior.  While node.js is useful for running your javascripty programs, you should not match its behavior.  Correctly running interpreters implement the behavior described in the operational semantics.

### jsy.js

The *jsy.js* file is a wrapper for *.jsy* files to run in node.js.  To run a javascripty file in node.js, use the following command

    $ nodejs jsy.js file.jsy

### survey.md

Please fill out the survey prior to submitting the assignment.  Make sure to write your solution between the square brackets (to make parsing easy for us).


### Github repository

Once you are finished with the assignment, push your local copy to your github account, and issue a pull request.


### Autotester

The online autotester for lab 3 will be available in a few days.  An anouncement will be made on Piazza when this tester is available.  As with Labs 1 and 2, you'll need to submit your assignment to the autotester at least one time.


### Hints

Here's some common issues related to this lab:

1.  You will only need to edit Lab3.scala.  You do not need to include your identikey in the object or file name.

2.  Like the eval function (big-step interpreter), the step function (small-step interpreter) returns an Expr object.  The difference is that the step function does not necessarily return a value.

3.  The operational semantics (big-step and small-step) for javasripty are given in the handout.  This representation is somewhat unfamiliar, however, *they fully describe how to implement your interpreter!*  Spend some time understanding what these semantics are saying, and how they translate into code.  Links to helpful sites / notes will be posted in Piazza.

4.  As before, the file ast.scala (in *src/main/scala/jsy/lab3/*) contains a list of all possible terms in the abstract syntax tree. 

5.  The **sbt** test cases only test individual operations, and doesn't fully test every requirement for the language.  However, getting your code to pass all the **sbt** test cases is helpful prior to attempting to pass all test cases in the autotester.

6.  Make sure your submit your final program to the autotester.  The autotester can take several minutes to run all the tests, depending on load.  The autotester will return a test report.  **Do not close the the browser or hit stop / back until you receive this report.**  Otherwise, your code will not have properly been submitted to the tester.
