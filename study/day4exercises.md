![Alt text](../img/lotussm.png)
#Day 4 Tomcat exercises

###Task 1 - Install web server
Follow the instructions here: [Tomcat On Your Server](TomcatOnYourServer.pdf)
###Task 2 - Deploy a simple webapp
Create a small maven web project in netbeans. 
The project should have one html page.
Build the project and find the .war file
Deploy the .war file to tomcat using the tomcat manager

###Task 3 - Deploy webapp with database
Extend your web app to show a list of items comming from at database table  
Create the table on your mysql server on digital ocean.  
Insert data in the table  
Run your web application first locally and then deploy it to your digital ocean server and test it from a browser.


###Task 4 - Try deploying directly on tomcat  
1. Create a folder named "tomcat8-myapp" in /usr/share.
2. Create a folder "myapp" under /usr/share/tomcat8-myapp.
3. Copy the HTML file to /usr/share/tomcat8-myapp/myapp. It must be named index.html.
4. Go to /etc/tomcat8/Catalina/localhost  
5. Create an xml file "myapp.xml" (i guess it must have the same name as the name of the folder in step 2) with the following contents:
`< Context path="/myapp" docBase="/usr/share/tomcat8-myapp/myapp"/>`  
6. This xml is called the 'Deployment Descriptor' which Tomcat reads and automatically deploys your app named "myapp".  
7. Now go to http://localhost:8080/myapp in your browser- the index.html gets picked up by tomcat and is shown.

