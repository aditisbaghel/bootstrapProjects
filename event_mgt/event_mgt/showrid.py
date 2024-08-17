#!/usr/bin/python

# Import modules for CGI handling 
import MySQLdb
import cgi, cgitb 
print "Content-type:text/html\r\n\r\n"

db = MySQLdb.connect("localhost","root","redhat","event" )

cursor = db.cursor()



# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields
name = form.getvalue('cname')

try:
	cursor.execute( "select * from eventmgt where cname='%s'"%(name))
        results = cursor.fetchone()
      	print "<html>"
	print "<head>"
	print "<title>Data Page</title>"
	print "</head>"
	print "<body bgcolor=#ba965h text=yellow>"
	print "<center><b>"
	print "<table width=60% cellpadding=2>"
		
	print "<tr>"
	print "<td>Resevation ID : </td>"
	print "<td>%s </td>" %(results[0])
	print "</tr>"

	print "<tr>"
	print "<td>NAME : </td>"
	print "<td>%s </td>" %(results[1])
	print "</tr>"

	print "<tr>"
	print "<td>Event: </td>"
	print "<td>%s </td>" %(results[2])
	print "</tr>"

	print "<tr>"
	print "<td>Tickets: </td>"
	print "<td>%s </td>" %(results[3])
	print "</tr>"

	print "<tr>"
	print "<td>MOBILE: </td>"
	print "<td>%s </td>" %(results[4])
	print "</tr>"

	print "<tr>"
	print "<td>ADDRESS: </td>"
	print "<td>%s </td>" %(results[5])
	print "</tr>"
	

	print "</table>"
	print "<br><br><br><hr>"
	print "</b></center>"
	print "</body>"
	print "</html>"
		

	db.commit()
	
		
except:
	print "Content-type:text/html\r\n\r\n"
	print "<script>alert('Data Not Found');location.href='/event/login/showrid.html';</script>"
	db.close()
