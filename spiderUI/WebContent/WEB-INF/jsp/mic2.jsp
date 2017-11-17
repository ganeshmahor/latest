<!DOCTYPE html>
<html>
<head>
	<title>Speech Recognition</title>
	<meta charset="UTF-8">
	<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
  <script type="text/javascript" src="../resources/js/speechRecognition.js"></script>
  <script type="text/javascript" src="../resources/js/controller.js"></script>
</head>
<body>
  <p>
   <button id="capture" value="true">Start</button>
   <span>Status: </span>
   <span id="status">Idle</span>
   <br><br>
   <textarea id="output" rows=10 placeholder="result"></textarea>
 </p>
</body>
</html>
