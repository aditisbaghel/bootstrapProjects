#!/usr/bin/python

# Import modules for CGI handling 
import MySQLdb
import cgi, cgitb 

db = MySQLdb.connect("localhost","root","redhat","event" )

cursor = db.cursor()



# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields
name = form.getvalue('uname')
pass1 = form.getvalue('upass')

try:
	cursor.execute( "select upass from userid where uname='%s'"%(name))
        results = cursor.fetchone()
	
  	if (results[0]==pass1):
		print "Content-type:text/html\r\n\r\n"
		print "<script>alert('Login Successful');location.href='/event/login/book.html';</script>"
	else:
		print "Content-type:text/html\r\n\r\n"
		print "<script>alert('Login Failed');location.href='/event/login';</script>"
		

	db.commit()
	
		
except:
	print "Content-type:text/html\r\n\r\n"
	print "<script>alert('User Not Found');location.href='/event/login';</script>"
	db.close()


