
<%@ include file="common/header.jspf"%>
<%@ include file="common/NavBar_index.jspf"%>
<%
	session.setAttribute("userId", "error");
%>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Lato", sans-serif;
}

body, html {
	height: 100%;
	color: #777;
	line-height: 1.8;
}

/* Create a Parallax Effect */
.bgimg-1, .bgimg-2, .bgimg-3 {
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

/* First image (Logo. Full height) */
.bgimg-1 {
	background-image: url('../images/b6.jpg');
	min-height: 100%;
}

/* Third image (Contact) */
.bgimg-3 {
	background-image: url("../images/b7.jpg");
	min-height: 400px;
}

.w3-wide {
	letter-spacing: 10px;
}

.w3-hover-opacity {
	cursor: pointer;
}

/* Turn off parallax scrolling for tablets and phones */
@media only screen and (max-device-width: 1600px) {
	.bgimg-1, .bgimg-2, .bgimg-3 {
		background-attachment: scroll;
		min-height: 400px;
	}
}
</style>
<body>



	<!-- First Parallax Image with Logo Text -->
	<div class="bgimg-1 w3-display-container w3-opacity-min" id="home">
		<div class="w3-display-middle" style="white-space: nowrap;">
			<span
				class="w3-center w3-padding-large w3-black w3-xlarge w3-wide w3-animate-opacity">EXPENSE
				TRACKER </span>
		</div>
	</div>

	<!-- Container (About Section) -->
	<div class="w3-content w3-container w3-padding-64" id="about">
		<h3 class="w3-center">ABOUT US</h3>
		
		<p>Expense tracker is a complete application to track your all the expenses bared by your pocket & manages your personal finance so that you can track where your money goes as well as from where money comes in, you can limit & plan accordingly. A feature rich tracking application with numerous powerful tools like, Income/Expense, Accounts Details, Reports etc. Also features incoming & outgoing flow of expenses and income. Over all a powerful personal finance tool that keeps on improving your productivity towards record keeping.</p>

		<!-- Third Parallax Image with Portfolio Text -->
		<div class="bgimg-3 w3-display-container w3-opacity-min">
			<div class="w3-display-middle">
				<span class="w3-xxlarge w3-text-white w3-wide">CONTACT</span>
			</div>
		</div>
		<!-- Container (Contact Section) -->
		<div class="w3-content w3-container w3-padding-64" id="contact">
			<h3 class="w3-center">WHERE I WORK</h3>
			

			<div class="w3-col m8 w3-panel container item-center">
				<div class="w3-large w3-margin-bottom">
					<i
						class="fa fa-map-marker fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
					Pune,India<br> <i
						class="fa fa-phone fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
					Phone: +91 1234567890<br> <i
						class="fa fa-envelope fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
					Email: mail@mail.com<br>
				</div>
			
				<form>
					<div class="w3-row-padding" style="margin: 0 -16px 8px -16px">
						<div class="w3-half">
							<input class="w3-input w3-border" type="text" placeholder="Name"
								required name="Name">
						</div>
						<div class="w3-half">
							<input class="w3-input w3-border" type="text" placeholder="Email"
								required name="Email">
						</div>
					</div>
					<input class="w3-input w3-border" type="text" placeholder="Message"
						required name="Message">
					<button class="w3-button w3-black w3-right w3-section">
						<i class="fa fa-paper-plane"></i> SEND MESSAGE
					</button>
				</form>
			</div>
		</div>
	</div>



	<script>
		// Change style of navbar on scroll
		window.onscroll = function() {
			myFunction()
		};
		function myFunction() {
			var navbar = document.getElementById("myNavbar");
			if (document.body.scrollTop > 100
					|| document.documentElement.scrollTop > 100) {
				navbar.className = "w3-bar" + " w3-card" + " w3-animate-top"
						+ " w3-white";
			} else {
				navbar.className = navbar.className.replace(
						" w3-card w3-animate-top w3-white", "");
			}
		}

		// Used to toggle the menu on small screens when clicking on the menu button
		function toggleFunction() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>

	<%@ include file="common/Footer.jspf"%>