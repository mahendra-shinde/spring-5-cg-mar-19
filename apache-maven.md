## Creating new Spring Project using Apache Maven


 Apache Maven (Just like NPM but older than NPM) to manage dependencies for java project. Maven can do a lot more than
 just managing dependencies.

 Maven could be downloaded from [Apache Maven](https://maven.apache.org)  

### Steps
 1.	Open eclipse and Press CTRL+N ( File > New )
 	Search for "Maven" > select "Maven Project" > OK

 2.	Check option "Create Simple Project"

 3.	Provide details:
 		groupId		package name or reverse domain

    if your domain is "mahendra.com" then groupId is "com.mahendra"

 		artefactId:	name of project / unique id for project eg. spring-demo1

 		version: 	Project version eg 1.0.0.GA

 		packaging: 	Packaging strategy for project, could be jar,war or pom (POM for multi-module project).
    
 	4.	Click Finish

### Project File Structure

 	/src/main/java			Main Source directory for all .java files
 	/src/main/resources		All non .java files
 							eg. properties files, XML files, images etc
 							Maven skip this directory at compilation phase!!!

 	/src/test/java			All JUnit Test cases, compiled only for Test Execution
 	/src/test/resources		All non .java files (same as /src/main/resources)
 							But only used by Test Cases.

 	/pom.xml 				Project Object Model.
 							Defines meta-data which includes project group-id, artefact-id, version
 							and list of dependencies and plugins. A custom maven "goals" could be places here.

 	/target					All build artefacts (.class, .jar, .war files)
 							Directory is created after project is "built"

 ### Maven commands [ Only for Standalone Maven installation ]
 	mvn compile 			Compile all JAVA files from /src/main/java
 	mvn test 				Compile and execute all test cases
 	mvn clean				Delete contents of /target directory
 	mvn package				Compile all JAVA files, execute all Test cases and then create "war", "jar" or "ear" file
