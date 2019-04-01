# Spring MVC Project components

## Front Controller
	Single servlet consuming ALL request!

	Servlet Class: 
	org.springframework.web.servlet.DispatcherServlet

	Servlet Name:
		Logical name for Above servlet class
		eg: appServlet, dispatcherServlet

	Location:
		/src/main/webapp/WEB-INF/web.xml

## ContextLoaderListener
	Initializes Spring's IOC Container and WebApplicationContext

	Context Class:
	org.springframework.web.context.ContextLoaderListener

	Location:
		/src/main/webapp/WEB-INF/web.xml

Spring XML Configuration files
1. mvc-config.xml or servlet-context.xml

	File used by "DispatcherServlet" to identify / locate
	all controllers, view-resolvers and other MVC components

	Location:
		Demos:	/WEB-INF/spring/appServlet/servlet-context.xml
		STS:	/WEB-INF/mvc-config.xml

2. application-config.xml or root-context.xml 
	File used by "ContextLoader" to locate and initialize shared
	resources like DataSources, DAO's and Services

	Location:
		Demos:	/WEB-INF/spring/root-context.xml
		STS:	/src/main/resources/spring/application-config.xml