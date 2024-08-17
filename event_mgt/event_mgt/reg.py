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
pass1= form.getvalue('upass')
mob= form.getvalue('mob')


try:
	cursor.execute( "insert into userid (uname,upass,mob)values('%s','%s','%s')"%(name,pass1,mob))
	
	db.commit()
	print "Content-type:text/html\r\n\r\n"
	print "<html>"
	print "<head>"
	print "<title>Data Page</title>"
	print "</head>"
	print "<body>"
	print "<h2 align=center> DATA INSERTED</h2>"
	print "<script>alert('Registration Successfull');location.href='/event/login';</script>"
	print "<script></script>"
	print "</body>"
	print "</html>"

		
except:
	db.rollback()
	db.close()


