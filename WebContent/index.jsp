<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button {
	background-color: blue;
	border-radius: 6px;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 12px;
	padding: 3px 11px;
	text-decoration: none;
	text-shadow: 0px 0px 0px #0d00ff;
}

.RED {
	height: 25px;
	width: 25px;
	background-color: red;
	border-radius: 50%;
	display: inline-block;
}

.RED {
	height: 25px;
	width: 25px;
	background-color: red;
	border-radius: 50%;
	display: inline-block;
}

.GREEN {
	height: 25px;
	width: 25px;
	background-color: green;
	border-radius: 50%;
	display: inline-block;
}

.BLUE {
	height: 25px;
	width: 25px;
	background-color: blue;
	border-radius: 50%;
	display: inline-block;
}

.PURPLE {
	height: 25px;
	width: 25px;
	background-color: purple;
	border-radius: 50%;
	display: inline-block;
}

.YELLOW {
	height: 25px;
	width: 25px;
	background-color: yellow;
	border-radius: 50%;
	display: inline-block;
}

.ORANGE {
	height: 25px;
	width: 25px;
	background-color: orange;
	border-radius: 50%;
	display: inline-block;
}

.0 {
	height: 25px;
	width: 25px;
	background-color: black;
	border-radius: 50%;
	display: inline-block;
}

.1 {
	height: 5px;
	width: 5px;
	background-color: white;
	border-style: solid;
	border-radius: 50%;
	display: inline-block;
}

td {
	width: 100px;
}


</style>
<title>Mastermind</title>
</head>
<body style="background-color: cornsilk;">
<h1 style="color: red">MASTERMIND</h1>
	<span class="RED"></span>
	<span class="GREEN"></span>
	<span class="BLUE"></span>
	<span class="YELLOW"></span> 
	<span class="ORANGE"></span>
	<span class="PURPLE"></span>
	<h3>Mastermind is a code breaking game. The object of this game is to guess a four color  master code within 12 turns. <br><br>
		You have six color options. You will choose a combination of 4 of these colors for each guess.<br><br>
	    After each turn, there will be 2 sets of "hints" ranging in value from 0 to 4. <br><br>
	    The first hint number represents how many pegs are the correct color in the correct spot. <br><br>
	    The second hint number represents if there are correct colors but in an incorrect spot. <br><br>
	    Good Luck!
	</h3>
		<form action="resetGame" method="post">
		<input class="button" id="reset" type="submit" value="Start Game"
					id="mastermind"> <br>

		</form>
</body>

</html>