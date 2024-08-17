#!/usr/bin/python

# Import modules for CGI handling 
import MySQLdb
import cgi, cgitb 

db = MySQLdb.connect("localhost","root","redhat","jeevan" )

cursor = db.cursor()



# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields
uname = form.getvalue('txt1')
pass1 = form.getvalue('pass1')

try:
	cursor.execute( "select upass from candi where uname='%s'"%(uname))
        results = cursor.fetchone()
	
  	if (results[0]==pass1):
		print "Content-type:text/html\r\n\r\n"
		print "<script>alert ('login successfull');location.href='/jeevan/search.html';</script>"
	else:
		print "Content-type:text/html\r\n\r\n"
		print "<script>alert ('Please Enter Right UID AND PASS');location.href='/jeevan/login.html';</script>"
		

	db.commit()
	
		
except:
	print "Content-type:text/html\r\n\r\n"
	print "<script>alert ('Please Enter Values In UID AND PASS');location.href='/jeevan/login.html';</script>"
		
	db.close()
