# Spring Boot 2.x for Web REST Applications

Spring boot has made building Restful Service Application easier by using "Convention over Configuration".
You need not define "dispatcher servlet" and "application context loader". You also do not need any
XML file as it uses "Java Configuration" (ie. Java Class with @Configuration annotation in place of "XML" files).

## Steps / How to DO it?

1.  From STS, use Option File -> New -> Spring Starter Project
    
    Provide following details

        Project Name    webdemo1
        Packaging       JAR
        Group           com.cg
        Package         com.cg
    
    On Next page, choose dependency **web**

    Click "Finish" button

2.  Now, Project is ready! 
        (Use Maven-> Update Project to download any missing dependencies)

3.  Add new Class **HomeController** with following code:

        @RestController
        
        public class HomeController{
            @RequestMapping("/")        
            public String hello(){
                return "Hello World";
            }
        }
4.  Goto **src/main/resources/application.properties** file and add a line of text:

        server.port = 5000

5.  Goto **WebAppApplication.java** Right click and **_Run As Java Application_**.

6.  Create new Class **Product**

        public class Product{
            private String name;
            private String price;

            //TODO: Getters and Setters...
            //TODO: Default No-Arg Constructor
        }

7.  Goto **HomeController** and add new method:

        @RequestMapping("/product")
        public Product show(){
            Product p = new Product();
            p.setName("Kores Smoothline Marker");
            p.setPrice(46);
            return p;
        }

8.  Visit URL: 
        http://localhost:5000/product