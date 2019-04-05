## Building Spring MVC Application with Spring Boot

**Spring boot starter web** does not support JSP. you need an additional dependency in your POM.xml to support JSP pages.
Also, your project packaging must be "WAR" instead of "JAR".

### Steps
1.	From STS, use Option File -> New -> Spring Starter Project

    Provide following details

        Project Name:   webdemo1
        Packaging:      WAR
        Group:          com.cg
        Package:        com.cg
        Dependency:	Web
        Click "Finish" button
        
2.	Open **pom.xml** file and add following new dependencies:
		
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
	<dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>jstl</artifactId>
	</dependency>
	
3.	Goto "src/main/webapp" and create directory "WEB-INF/views"
	NOTE: Create first WEB-INF and then views inside WEB-INF
		  Folder names are Case Sensitive!!

4.	Goto **src/main/resources/application.properties** add these two lines:

        server.port=5000
        spring.mvc.view.prefix=/WEB-INF/views/
        spring.mvc.view.suffix=.jsp

5.	Create new Model Class **User**

	public class User {
	
		private String name;
		private String password;
		private String email;
		
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(String name, String password, String email) {
			super();
			this.name = name;
			this.password = password;
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
	}


6.	Create new Controller Class **UserRegistrationController** 

	@Controller
	@RequestMapping("/register")
	public class UserRegistrationController {
	
		@RequestMapping(method=RequestMethod.GET)
		public String showForm(Model model){
			User user = new User();
			model.addAttribute("user",user);
			System.out.println("Rendering a form");
			return "form";
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String doSubmit(@ModelAttribute("user") User user, Model model){
			System.out.println("Submitting Form");
			System.out.println("User :"+user.getName()+" "+user.getEmail());
			return "success";
		}
	}

6.	Create new JSP page inside folder **/src/main/webapp/WEB-INF/views/** with name 'form.jsp'.
    Add following code inside JSP page. 

		<%@ page language="java" contentType="text/html; charset=UTF-8"
		    pageEncoding="UTF-8"%>
		<!DOCTYPE html >
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User registration</title>
		</head>
		<body>
		<h2>User registartion page!</h2>
		<s:form action="register" method="post" modelAttribute="user">
		User name: <s:input path="name"/><br/>
		Email : <s:input path="email"/><br/>
		Password: <s:password path="password"/><br/>
		<input type="submit" value="Register"/>
		</s:form>
		</body>
		</html>     
	
7.	Create another JSP page in same directory with name "success.jsp"

		<%@ page language="java" contentType="text/html; charset=UTF-8"
		    pageEncoding="UTF-8"%>
		<!DOCTYPE html >
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registration Success!</title>
		</head>
		<body>
		<h2>Hello ${user.name} you are now member!</h2>
		</body>
		</html>   
 
 8.	create a startup html page "index.html" inside "src/main/webapp"
		
		<!DOCTYPE html>
		<html>
			<head>
				<meta charset="UTF-8">
				<title>Spring Boot MVC Demo</title>
			</head>
		<body>
			<h2>Welcome to Spring Boot MVC Project</h2>
			<a href="register">Sign up</a>
		</body>
		</html>
9.	Run Application as **Spring Boot Application** or **Java Application**

NOTE:	DO NOT Add Tomcat as targeted runtime. It would result in conflicts in JARS.