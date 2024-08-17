#!/usr/bin/python

# Import modules for CGI handling 
import MySQLdb
import cgi, cgitb 

db = MySQLdb.connect("localhost","root","redhat","event" )

cursor = db.cursor()



# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields


name = form.getvalue('cname')
program = form.getvalue('event')
ticket= form.getvalue('ticket')
mob= form.getvalue('mob')
add= form.getvalue('address')


try:
	cursor.execute( "insert into eventmgt (cname,eprogram,nticket,mob,address)values('%s','%s','%s','%s','%s')"%(name,program,ticket,mob,add))
	
	db.commit()
	print "Content-type:text/html\r\n\r\n"
	print "<html>"
	print "<head>"
	print "<title>Data Page</title>"
	print "</head>"
	print "<body>"
	print "<h2 align=center> DATA INSERTED</h2>"
	print "<script>alert('Booking Successfull');location.href='/event/login/showrid.html';</script>"
	print "<script></script>"
	print "</body>"
	print "</html>"

		
except:
	db.rollback()
	db.close()


