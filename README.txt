CS442 Design Patterns
Fall 2016
PROJECT 2 README FILE

Due Date: Friday, September 30, 2016
Submission Date: Friday, September 30, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Thomas Mathew, Omowumi L Ademola
e-mail(s): tmathew4@binghamton.edu, oademol1@binghamton.edu 


PURPOSE:

[
  A multi-threaded Java program that creates course schedule for students based on their priority
]

PERCENT COMPLETE:

[
 We believe we have completed 100% of this project
]

PARTS THAT ARE NOT COMPLETE:

[
 None
]

BUGS:

[
 None
]

FILES:

[

  Scheduler.java, the file that contains logic to assign students courses 
  Driver.java, the file associated with the program that contains main
  Course.java, the file that represents each course offered to students
  FileDisplayInterface.java, the interface file to write output to text file
  Results.java, the file that stores schedule of all students and write to the output
  StdoutDisplayInterface.java, the interface file to write output to standard output
  Student.java, the file that maintain details of a student
  CreateWorkers.java, the file creates the amount of threads passed to it
  WorkerThread.java, the file contains the run method that contains logic
    read file, assign classes, and store to Results
  CourseObjectPool.java, the file contains functions to grab courses
  FileProcessor.java, the file that reads from input file
  Logger.java, the file that prints debug messages based on the debug
    level 
  ObjectPool.java, the interface that contains basic methods for the
    classes that implement it
  StudentObjectPool.java, the file contains functions to grab students 
  README, the text file you are presently reading	 
]

SAMPLE OUTPUT:

[
  g7-36:~/cs442/proj2/cs442_assign02/registrationScheduler> ant -buildfile src/build.xml run -Darg0=data.txt -Darg1=output.txt -Darg2=3 -Darg3=0
  Buildfile: /import/linux/home/tmathew4/cs442/proj2/cs442_assign02/registrationScheduler/src/build.xml

  jar:

  run:
       [java] Student_2  A F B D E
       [java] Student_1  A G D F E
       [java] Student_3  B C F A G
       ...
       [java] Student_78  G E A F C
       [java] Student_80  E F B C D
       [java] The average preference value is 3.975

  BUILD SUCCESSFUL
  Total time: 1 second
  g7-36:~/cs442/proj2/cs442_assign02/registrationScheduler> 


]

TO COMPILE:

[
  - Just extract the files and enter the command "ant -buildfile src/build.xml all"
  - The current directory should be Omowumi_Ademola_Thomas_Mathew_assign2/registrationScheduler
]

TO RUN:

[
  Please run as: ant -buildfile src/build.xml run -Darg0=<inputfile> -Darg1=<outputfile> -Darg2=<numberOfThreads> -Darg3=<DEBUG_VALUE>

  For example:   ant -buildfile src/build.xml run -Darg0=data.txt -Darg1=output.txt -Darg2=3 -Darg3=0

]

TIME COMPLEXITY:

[
 Implemented a 2d-array of type String to store schedule of each student. Assume there are m number of students and n number of courses. It takes O(n) to insert a schedule of a student. Since there is a variable that keeps track of last entry's index, the value of m does not matter for inserting a student's schedule. It takes O(m) to retrive a specific student's schedule. Since all the courses of each student is stored in a single string, the value of n doesnot matter. It takes O(m) to print the schedule of all students.

  We chose 2d-array to work with because we were able to reduce the time complexity from exponential to linear for basic operations such as insertion and iteration by keeping track of last entry's index and storing the scheduled classes as one single string. In addition to that 2d-arrays are easy to work with.
]

EXTRA CREDIT

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

[
  N/A
]

ACKNOWLEDGEMENT:

[
 N/A

]
