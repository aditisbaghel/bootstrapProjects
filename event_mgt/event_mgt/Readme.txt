EventMGT in python .

OS :- Linux redhat Clan( redhad,fedora,centos )


Step1  : install the following packages


#yum install python python-devel mysql mysql-server mysql-devel redhat-rpm-config gcc MySQL-python


Step2 :- Configure Mysql Server

#service mysqld restart
#chkconfig mysqld on

#mysql_secure_installation

enter root password : redhat  then enter enter enter.

#mysql -u root -p
passwod:redhat

#create database event;

#use event;

copy and paste all data of event.sql file and execute

#show tables;

and check userid table is created or not.



Step3:  apache  configuration

copy book.py,showrid.py, login.py and reg.py file to  /var/www/cgi-bin

#chmod -R 755 /var/www/cgi-bin/*

copy event dir to  /var/www/html/

#chmod -R 755 /var/www/html/*

#service httpd restart
#chkconfig httpd on
#service iptables stop
#setenforce 0

To access website

on web browser

http://<ip>/event




















