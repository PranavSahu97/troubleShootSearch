# troubleShootSearch


-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleshootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile troubleshootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleshootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile troubleshootSearch/src/build.xml run -Darg0=<userInput.txt> -Darg1=<technicalDetail1.txt> -Darg2=<technicalDetail2.txt> -Darg3=<technicalDetail3.txt> -Darg4=<technicalDetail4.txt> -Darg5=<Synonyms_file.txt> -Darg6=<Output file> -Darg7=<Debug Level Int>

Note: Arguments accept only the absolute path of the files.


-----------------------------------------------------------------------
## Description

### Search based Customer Support for Trouble Shooting
The dSeaGate Portable Drive vendor wants to provide an online trouble shooter for customers. Your task is to design the engine for this purpose. The requirements are the following:
•	dSeaGate has four distinct products. For each product, it also has an ArrayList of strings. Each element of these ArrayLists is a string representing a sentence.
•	Users can enter text (one string or many strings) in a search box to describe their problem. Only keywords, or key phrases, are entered. For this assignment, accept keywords from an input file named, userInputs.txt. Each search should be in a different line.
•	dSeaGate does not want a sophisticated search algorithm, for now. Use the visitor pattern for the following:
o	Exact match: Find and print in output.txt all technical sentences that have an exact match for the entered keywords. So, if the user enters "problem detecting", a technical sentence that matches could be the following: "If Debian has a problem detecting the drive, it could be that the portable drive is not receiving enough power."
o	Naive Stemming match: Find and print in output.txt all technical sentences that have a word, whose substring is an exact match for the first entered keyword. So, if the user enters "detect error", the technical sentence that matches could be the following: "If Debian has a problem detecting the drive, it could be that the portable drive is not receiving enough power."
o	Semantic match: Find the synonym of the last entered keyword by the user and employ "Exact match." Use an input file synonym.txt to store key-value pairs of synonyms. Read the synonyms from the file, during startup, and store them in an appropriate data structure. So, if the user enters "comptabile CPU", the technical sentence that matches could be the following: "All products from AMD have a compatible processor as far as dSeaGate is concerned." The file synonym.txt should have the the following using a format of your choosing. NEW: note synonyms are bi-directional. So, in the above example "CPU" can substitute "processor" and "processor" can substitute "CPU".
CPU:processor
o	The file userInputs.txt should have 27 entries. 8 entries should work with "Exact match", 8 with "one-word match", and 8 with "semantic match." 3 should not match at all. The 24 matches should be spread across the 12 different dSeaGate prdocuts 4 products.
o	Technical sentences for each product should be read from a file (or multiple files, as per your design) and stored in the ArrayLists. Hardcode the names of these files in an appropriate way (design wise) in your code.
o	Searches should be case sensistive.
•	Data from the local file will be read by a single thread. So, do NOT design for a multi-threaded application. 
•	Use Debug in the following manner:
o	Here is a sample MyLogger file
o	0: No output should be printed. Only error messages should be printed (for example, message from a catch caluse before exiting).
o	1: Only the search results should be printed
o	2: Design on your own and mention in the README what is printed at this debug granularity
o	3: Design on your own and mention in the README what is printed at this debug granularity
o	4: Design on your own and mention in the README what is printed at this debug granularity
•  We will run your code using the following command:
TBA
Design Requirements
•	Same as Assignment-1
Code Organization
•	Your directory structure should be the following:
•	 -firstName_lastName_5
•	   ---troubleShootSearch
•	     ----- README.txt
•	     ----- src
•	          ----- build.xml
•	          ---troubleShootSearch
•	     	   ----------driver
•	           ----------util
•	           ----------other packages that you need



-----------------------------------------------------------------------

## Justification

technicalDetails1.txt contains the technical detail statements of Product1 and same things for all 4 products.

Driver reads the input file and contains the main method.
Each product works as a Vistorable and The Search classes are the visitors which visits the visit function of the search provided. 


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 08/06/2019
