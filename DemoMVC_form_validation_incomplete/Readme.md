## Spring MVC 5 : Form Validation using JSR-303 Annotations

Example of Form Validation using Annotations (JSR-303).
This example uses "hibernate-validator-6.0.10" as framework for implementing Validation.

### How Is it Implemented?
1.  Maven Dependency:
	
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.0.10.Final</version>
        </dependency>

2.  Modified Controller class / Handler Method:
	
        @RequestMapping(value="checkRegister")
	    public String checkRegister(@Valid @ModelAttribute User user, BindingResult result, Model model)
	    {
		    if(result.hasErrors()) {
			    return "register";
            }else {
            model.addAttribute("user",user);  		  
            return "registerSuccess";
            }
        }

3.  Modified Model class:
    
        public class User {
            @NotEmpty(message="Firstname is required")
            @Size(max=50, min=5, message="First name must contain 5 to 50 characters")
            private String firstName;

            @Size(max=50, min=5, message="Last name must contain 5 to 50 characters")
            @NotEmpty(message="Lastname is required")
            private String lastName;
        
            private char gender ;
        
            @Email(message="Invalid email address")
            @NotEmpty(message="EMail required")
            private String email;
        
            //No Validation
            private String[] skillSet;
            //No Validation
            private String city;

            //Getters/Setters & Constructutors ...
        }

4.  Modified "register.jsp" page (Partial)
    
        <form:form method="post" modelAttribute="user" action="${myAction}">
        Enter First Name:<form:input path="firstName"/>
        <form:errors path="firstName"/>
        <br/>
        Enter Last Name:<form:input path="lastName"/><br/>
        Gender:
            <form:radiobutton path="gender" value="M" label="M" />
            <form:radiobutton path="gender" value="F" label="F" /><br/>
        Enter eMail:<form:input path="email"/>

5.  TODO:
    Add "form:error" tag for other fields in "register.jsp" page