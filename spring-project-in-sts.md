## Creating new Spring Web Application using STS

1.	New --> Spring Legacy Project
	
	1.1 Name of Project:	mvc-demo1
	1.2 Select Type:		Simple Spring Web Maven
	1.3 Click "Finish" button

2.	To Resolve the ERROR
	
	Right click on project name "mvc-demo1"
	Select "tageted runtimes" and check "Pival tc..."

3.	Open "pom.xml" for current project and make few changes
	
	3.1 Change java.version to 1.8 from 1.6
		<java.version>1.8</java.version>
	3.2	Change servlet.version from 2.5 to 3.0
		<servlet.version>3.0</servlet.version>

	3.3	**Remove** dependency for "servlet-api"
		The code looked like this:
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>${servlet.version}</version>
			<scope>provided</scope>
		</dependency>

4.	Run Maven update
	Right click on project -> maven -> Update Project -> OK

5.	Explore the project
	5.1 Open /src/main/webapp/WEB-INF/web.xml
	5.2 Open /src/main/resources/spring/application-config.xml
	5.3	Open /src/main/webapp/WEB-INF/mvc-config.xml
	5.4	Open /src/main/webapp/WEB-INF/views/

6.	Test Run
	Right click on project -> Run As -> Run on server