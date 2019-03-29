Project Setup

1. Download hibernate jars into
	**C:\hibernate-jars\**   folder

2. Launch eclipse and start new workspace
	change name of workspace directory to
		c:\jpa-hibernate

3.	Create New Java Project

		**name**: _JpaDemo1_

	Library:

		Add external JARs > Choose ALL jars from **C:\hibernate-jars**
	Finish

4.	Expand **Reference Libraries** under project explorer to validate
	project creation.

5.	Create new folder (NOT Source folder) **META-INF** (_case sensitive_)
6.	Create new "XML File" inside "META-INF" folder
	name:	"persistence.xml" (!!Case Sensitive!!)
	Choose:  Create Xml file from an XML Schema
	locate "persistence_2.0.xsd"
