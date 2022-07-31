# iress-toyrobot-cc

### Toy Robot Code Challenge ###


#### Description and Requirements ####

The application is a simulation of a toy robot moving on a square table top of dimension 5 units x 5 units. There are no other obstructions on the table surface. 
The robot is free to roam around the surface of the table, but must be prevented from fallingto destruction. Any movement that would result in the robot falling from
the table must be prevented however further valid movement commands myst still be allowed.


#### Acceptable Commands ####

###### * PLACE X,Y,F ######
###### * MOVE ######
###### * LEFT ######
###### * RIGHT ######
###### * REPORT ######

 PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. It is required that the first command to the robot is a PLACE
 command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the 
 sequence until a valid PLACE command has been executed. MOVE will move the toy robot one unit forward in the direction it is currently facing. LEFT will rotate 
 the robot 90 degrees to the left without changing its position. RIGHT will rotate the robot 90 degrees to the right without changing its position. REPORT will 
 announce the X,Y and F of the robot.
 
 
 #### Constraints ####
 
 A robot that is not on a table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands. The toy robot must not fall off the table during movement.
 This also includes the initial placement of the toy robot. Any move that would cause the robot to fall must be ignored.


#### Instructions on how to run this app ####

1. Clone the application from github. See link below.<br/> 
   ###### https://github.com/shee064/iress-toyrobot-cc.git ######
2. Navigate to the directory of the cloned project and execute the mvn install command to build the project and generate the jar file. <br> 
   For Windows: 
   ###### mvnw install ######
   For Linux: 
   ###### ./mvnw install ######
3. Once successfully built, navigate to the target directory of the project and look for the generated jar file 
   ###### iress-toyrobot-0.0.1-SNAPSHOT.jar ######
4. Prepare a list of commands in a text file. Kindly refer on acceptable list of commands. You can also refer to some of the test data already available
   in the project directory 
   ###### src\test\java\com\si\iress\toyrobot\iresstoyrobot ######
5. Open a terminal and go to the target folder of the project. Execute java command to run the application. Note that it's expecting a filepath argument. See sample command below.
   ###### java -jar iress-toyrobot-0.0.1-SNAPSHOT.jar "C:\Users\sheenai\Documents\Project\iress-toyrobot\iress-toyrobot\src\test\java\com\si\iress\toyrobot\iresstoyrobot\test_A.txt" ######
