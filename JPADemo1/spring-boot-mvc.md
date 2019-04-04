# Spring Boot 2.x for Web MVC Applications

Spring boot has made building MVC Application easier by using "Convention over Configuration".
You need not define "dispatcher servlet" and "application context loader". You also do not need any
XML file as it uses "Java Configuration" (ie. Java Class with @Configuration annotation in place of "XML" files).

## Steps / How to DO it?

1.  From STS, use Option File -> New -> Spring Starter Project
    
    Provide following details

        Project Name:   webdemo1
        Packaging:      WAR
        Group:          com.cg
        Package:        com.cg
        Click "Finish" button

2.  Open **pom.xml** file and add new dependency _for supporting JSP pages_.

    	<dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <scope>provided</scope>
        </dependency>

3.  Goto **src/main/resources/application.properties** add these two lines:

        server.port=5000
        spring.mvc.view.prefix=/WEB-INF/views/
        spring.mvc.view.suffix=.jsp

4.  Create new Class **HomeController** 

        @Controller
        public class HomeController {
	        @RequestMapping("/")
               public String hello(Model map) {
	           map.addAttribute("msg","Welcome to Spring Boot!");
               return "hello";
	        }
        }

5.  Create new JSP page inside folder **/src/main/webapp/WEB-INF/views/** with name 'hello.jsp'.
    Add following code inside JSP page. 

        <body>
            <h2>${msg}</h2>
        </body>

6.  Run Application As **_Java Application_**.
    Visit URL:  http://localhost:5000

    NOTE: A Browser window should pop up automatically, If not open a browser and visit above URL.