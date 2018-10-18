
Using Java 8 and Gradle

To Build and Run Tests
-----------------------
`gradle clean build
`


`gradle test
`

Run Main
----------
`java -jar railroad-1.0-SNAPSHOT.jar `
This will execute the example provided in the problem statement

**To run against a specific file (fileToRun.txt) :**
`java -jar railroad-1.0-SNAPSHOT.jar fileToRun.txt`


Format to form **fileToRun.txt** :
* Graph: Input Directed graph in format {Origin}{Dest}{n}
* Distance: To calculate distance of route (nodes separated by -)
* Trips: BELOW_OPTION, n, Origin-Dest
    * MAX_STOPS: number of trips with maximum of n stops between Origin and Dest
    * EXACT_STOPS: number of trips between Origin and Dest with exactly n stops
    * MAX_DISTANCE: number of trips between Origin and Dest with a distance of less than n
* Shortest: length of shortest distance between Origin-Dest
* Duration: To calculate duration to travel on route (nodes separated by -) (+1 for each step call "-")


or

Run main class in `RailRoadService.java`


Test Input
----------
Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7 <br/>
Distance: A-B-C <br/>
Distance: A-D <br/>
Distance: A-D-C <br/>
Distance: A-E-B-C-D <br/>
Distance: A-E-D <br/>
Trips: MAX_STOPS,3,C-C <br/>
Trips: EXACT_STOPS,4,A-C <br/>
Shortest: A-C <br/>
Shortest: B-B <br/>
Trips: MAX_DISTANCE,30,C-C <br/>

Expected Output
---------------
* Output #1: 9
* Output #2: 5
* Output #3: 13
* Output #4: 22
* Output #5: NO SUCH ROUTE
* Output #6: 2
* Output #7: 3
* Output #8: 9
* Output #9: 9
* Output #10: 7
