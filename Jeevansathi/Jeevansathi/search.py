#!/usr/bin/python

# Import modules for CGI handling 
import MySQLdb
import cgi, cgitb 
print "Content-type:text/html\r\n\r\n"

db = MySQLdb.connect("localhost","root","redhat","jeevan" )

cursor = db.cursor()



# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields
gen = form.getvalue('txt1')
age = form.getvalue('txt2')
hei = form.getvalue('txt3')



try:
	cursor.execute( "select * from candi where gender='%s' and age = '%s' or height = '%s' "%(gen,age,hei))
        results = cursor.fetchall()
  	for row in results:
      		
		print "<html>"
		print "<head>"
		print "<title>Data Page</title>"
		print "</head>"
		print "<body bgcolor=#ba965h text=yellow>"
		print "<center><b>"
		print "<table width=60% cellpadding=2>"
		print "<tr>"
		print "<td>NAME : </td>"
		print "<td>%s </td>" %(row[3])
		print "</tr>"

		print "<tr>"
		print "<td>AGE: </td>"
		print "<td>%s </td>" %(row[4])
		print "</tr>"

		print "<tr>"
		print "<td>GENDER : </td>"
		print "<td>%s </td>" %(row[5])
		print "</tr>"

		print "<tr>"
		print "<td>HEIGHT : </td>"
		print "<td>%s </td>" %(row[6])
		print "</tr>"

		print "<tr>"
		print "<td>COMPLEXTION : </td>"
		print "<td>%s </td>" %(row[7])
		print "</tr>"

		print "<tr>"
		print "<td>EMAIL : </td>"
		print "<td>%s </td>" %(row[8])
		print "</tr>"

		print "<tr>"
		print "<td>MOB : </td>"
		print "<td>%s </td>" %(row[9])
		print "</tr>"


		print "</table>"
		print "<br><br><br><hr>"
		print "</b></center>"
		print "</body>"
		print "</html>"
      		


	db.commit()
	
		
except:
	print "DATA NOT FOUND"
	db.close()



