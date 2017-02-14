![Alt text](img/lotussm.png)
#week 1 Linux, Webserver og MySQL in the cloud

##Day 1: Github and Linux on Digital Ocean
###Github 
First you will get an introduction to how we are usinge [github](github.com) as a learning management system.  
* Clone a repository  
* Create a repository on github  
* Clone your repository locally  
* Add, Commit, Push

##Linux
We will look at how to set up a linux server on digitalocean, how to manage users on the machine, and how to navigate the server from the command prompt. When settin up the server for the first time we will use this [tutorial](study/Getting Started with Digital Ocean.pdf)  
###The tutorial contains these commands:
```
ssh root@SERVER_IP_ADDRESS  
adduser <user>  
usermod -aG sudo <user>  
su <user>  
cd ~/  
mkdir ~/.ssh  
chmod 700 ~/.ssh  
nano ~/.ssh/authorized_keys  
```
Insert your ssh public key here.  

Check this file: `sudo nano /etc/ssh/sshd_config` to see if `PasswordAuthentication no` is there  
```
chmod 600 ~/.ssh/authorized_keys  
exit  
sudo systemctl reload sshd  
```  
Now check if you can log in with `<user>` from a terminal 
Install java:  
```
sudo apt-get install default-jdk
java -version
```

* [Slides](slides/Day_1.pdf)
* [Exercises](study/day1exercises.md)

**Readings**:

* <http://ryanstutorials.net/linuxtutorial/commandline.php>
* Nano: <http://www.howtogeek.com/howto/42980/the-beginners-guide-to-nano-the-linux-command-line-text-editor>
* Nano: <http://www.tutorialspoint.com/unix_commands/nano.htm>



##Day 2: SSH & bash scripting
Using passwords to secure a server is considered insecure. Instead one use ssh-keys.
Also, we will take a look at bash-scripting to automate things on linux. In particular we will automate setting up a linux server with users for your group.

* [Slides](slides/Day_2.pdf)
* [Exercises](study/day2exercises.md)

**Readings and videos**:

* Scripting: <http://ryanstutorials.net/linuxtutorial/scripting.php>
* Bash on Lynda.com: <https://www.lynda.com/Bash-tutorials/Up-Running-Bash-Scripting/142989-2.html>
* SSH on Lynda.com: <https://www.lynda.com/Developer-Network-Administration-tutorials/Welcome/189066/365610-4.html>
* SSH: <https://www.youtube.com/watch?v=svRWcx7dT8g>
* SSH: http://blakesmith.me/2010/02/08/understanding-public-key-private-key-concepts.html
* SSH & connecting to ubuntu: <https://www.digitalocean.com/community/tutorials/understanding-the-ssh-encryption-and-connection-process>

##Day 3: MySQL in the cloud
We will setup MySQL on the ubuntu server, set up users on MySQL with different rights, and work with SQL from the sql prompt. Also, we will connect to the server from MySQL Workbench and from our java program:
### The commands needed for this are
```
sudo apt-get update
sudo apt-get install mysql-server
sudo mysql_secure_installation
mysql -u root -p
CREATE DATABASE test;
```
Then change this file:  
“/etc/mysql/mysql.conf.d/mysqld.cnf”
by commenting out the bind-address line like this:
 #bind-address = localhost
 ```
mysql -u root –p 
CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'password123'; 
CREATE USER 'testuser'@'%' IDENTIFIED BY 'password123'; 
GRANT ALL ON test.* TO 'testuser'@'localhost'; 
GRANT ALL ON test.* TO 'testuser'@'%';
exit
service mysql restart
```


* [Exercises](study/day3exercises.md)

**Readings**:  
  * Installing MySQL: <https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-14-04>  
  * Use ssh tunneling to access mysql server from outside: <https://dev.mysql.com/doc/workbench/en/wb-mysql-connections-methods-ssh.html>  
  
##Day 4 - Tomcat exercise
We will setup Tomcat server on the ubuntu server. We will then deploy a small web application using both tomcat and mysql. We will use the following commands:
```
apt-get install tomcat8 tomcat8-admin
apt-get install haveged 
nano /etc/tomcat8/tomcat-users.xml
```
Insert: `<role rolename="manager-gui"/><user name="admin" password="XXX" roles="manager-gui, manager-script"/>` and save
```
service tomcat8 restart
sudo nano /etc/tomcat8/server.xml
```
Replace `Connector port="8080"` with `Connector port="80"` in line 71
```
sudo nano /etc/default/tomcat8
```
Change `#AUTHBIND=no` to `AUTHBIND=yes` (remember to remove the #-sign)
``` 
service tomcat8 restart
```  
     
- Now open a browser from your laptop and go to: `<your ubuntu ip>/manager`
- Deploy a web application from here  

* [Exercises](study/day4exercises.md)  
* Readings: 
  * [Tomcat on Digital Ocean](https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04)
  * [General about tomcat](https://www.ntu.edu.sg/home/ehchua/programming/howto/tomcat_more.html)  
    
##Day 5 - Studypoint exercise  

* Full assignment - see [study/studypointExercise.md](study/day5studypointExercise.md)

