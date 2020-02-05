<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<!-- Some css gotten from: https://www.filamentgroup.com/lab/select-css.html! -->
<head>
<style type="text/css">
.button {
	background-color: blue;
	border-radius: 6px;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 12px;
	padding: 8px 18px;
	text-decoration: none;
	text-shadow: 0px 0px 0px #0d00ff;
}

.resetbutton {
	background-color: red;
	text-align: center;
	border-radius: 6px;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 12px;
	padding: 2px 8px;
	text-decoration: none;
	text-shadow: 0px 0px 0px #0d00ff;
}

.RED {
	height: 20px;
	width: 20px;
	background-color: red;
	border-radius: 50%;
	display: inline-block;
	margin-right: 90px;
}

.GREEN {
	height: 20px;
	width: 20px;
	background-color: green;
	border-radius: 50%;
	display: inline-block;
	margin-right: 90px;
}

.BLUE {
	height: 20px;
	width: 20px;
	background-color: blue;
	border-radius: 50%;
	display: inline-block;
	margin-right: 90px;
}

.PURPLE {
	height: 20px;
	width: 20px;
	background-color: purple;
	border-radius: 50%;
	display: inline-block;
	margin-right: 90px;
}

.YELLOW {
	height: 20px;
	width: 20px;
	background-color: yellow;
	border-radius: 50%;
	display: inline-block;
	margin-right: 90px;
}

.ORANGE {
	height: 20px;
	width: 20px;
	background-color: orange;
	border-radius: 50%;
	display: inline-block;
	margin-right: 90px;
}

td {
	width: 100px;
}

.select-css {
	display: block;
	font-size: 14px;
	font-family: sans-serif;
	font-weight: 700;
	color: #444;
	line-height: 1.3;
	padding: .6em 1.4em .5em .8em;
	width: 100%;
	max-width: 100%;
	box-sizing: border-box;
	margin: 0;
	border: 1px solid #aaa;
	box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04);
	border-radius: .5em;
	-moz-appearance: none;
	-webkit-appearance: none;
	appearance: none;
	background-color: #fff;
	background-image:
		url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),
		linear-gradient(to bottom, #ffffff 0%, #e5e5e5 100%);
	background-repeat: no-repeat, repeat;
	background-position: right .7em top 50%, 0 0;
	background-size: .65em auto, 100%;
}

.select-css::-ms-expand {
	display: none;
}

.select-css:hover {
	border-color: #888;
}

.select-css:focus {
	border-color: #aaa;
	box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
	box-shadow: 0 0 0 3px -moz-mac-focusring;
	color: #222;
	outline: none;
}

.select-css option {
	font-weight: normal;
}

form{
	text-align: center;	
}
</style>
<title>Mastermind</title>
</head>
<body style="background-color: cornsilk;">
	<h2 style="color: red; text-align: center">MASTERMIND</h2>
	<form style="text-align: center;" action="resetGame" method="post">
		<input class="resetbutton" id="reset" type="submit"
			value="Restart Game" id="mastermind"> <br>
	</form>
	<h3>Select 4 colors:</h3>
	<form action="checkGuess" method="post">
		<c:choose>
			<c:when test="${game.over}">
				<h1>GAME OVER</h1>
				<c:choose>
					<c:when test="${game.winner}">
						<h2>YOU WIN!!</h2>
					</c:when>
					<c:otherwise>
						<h2>YOU LOSE</h2>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>

		<table>
			<tr>
				<c:forEach varStatus="stat" begin="1" end="4">
					<c:set var="selected"
						value="${stat.count == 1 ? param.color1 : stat.count == 2 ?  param.color2 : stat.count == 3 ? param.color3 : param.color4 }" />
					<td><select class="select-css" name="color${stat.count}">
							<c:forEach items="${game.colors}" var="color">
								<option value="${color}" ${selected == color ? 'selected' : '' }>${color}</option>
							</c:forEach>
					</select></td>
				</c:forEach>
			</tr>
		</table>
		<table style="width: 300px;">
			<tr>
				<td><input class="button" type="submit" value="Enter Guess"
					id="checkGuess"></td>
				<td><h3 style="color: blue;">Guesses left:
						${game.maxGuesses - game.numGuesses}</h3></td>
			</tr>
		</table>
		<table>
			<c:forEach items="${game.guesses}" var="guess" varStatus="stat">
				<tr style="border-style: solid; border-width: 1px">
					<c:forEach items="${guess}" var="peg">
						<td class="${peg}">&nbsp;</td>
					</c:forEach>
					<th>Hints(right spot, right color):&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<td>${game.hints[stat.index][0]}</td>
					<td>${game.hints[stat.index][1]}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>

</html>