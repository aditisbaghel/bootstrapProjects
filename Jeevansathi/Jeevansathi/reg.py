#!/usr/bin/python

# Import modules for CGI handling 
import MySQLdb
import cgi, cgitb 

db = MySQLdb.connect("localhost","root","redhat","jeevan" )

cursor = db.cursor()



# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields


uname = form.getvalue('txt2')
pass1= form.getvalue('pass1')
cname = form.getvalue('txt1')
age = form.getvalue('txt3')
gen = form.getvalue('txt4')
hei= form.getvalue('txt5')
comp = form.getvalue('txt6')
email= form.getvalue('txt7')
mob = form.getvalue('txt8')



try:
	cursor.execute( "insert into candi (uname,upass,cname,age,gender,height,complex,email,mob) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')"%(uname,pass1,cname,age,gen,hei,comp,email,mob))
	
	db.commit()
	print "Content-type:text/html\r\n\r\n"
	print "<html>"
	print "<head>"
	print "<title>Data Page</title>"
	print "</head>"
	print "<body>"
	print "<h2 align=center> DATA INSERTED</h2>"
	print "<script>alert('Registration Successfull');location.href='/jeevan/login.html';</script>"
	print "<script></script>"
	print "</body>"
	print "</html>"

		
except:
	db.rollback()
	db.close()



