<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<!-- STYLESHEETS -->
	<!-- <link rel="css/stylesheet" href="css" title="roboto"> -->
	<link href="resources/css/default.css" rel="stylesheet" type="text/css">
	 <link rel="stylesheet" href="resources/css/normalize.css">
	<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/modal.css">
	<!-- <link rel="stylesheet" href="css/modal2.css"> -->

	
	<style type="text/css">main{margin-left:25vw;background-color:#f5f5f5;height:100vh;transition:width .3s ease-in-out,height .3s ease-in-out}main,main.opened{padding:10vh 10vw}main.opened{margin-left:15vw;padding-right:30vw}main .main-container{padding:5vmin;background-color:#fff;text-align:justify}main .main-container .rsc-ts-bubble{text-align:left}p{font-size:2vw;line-height:1.5}.docs .title{font-size:3vw}.docs .description{font-size:2.4vw}@media screen and (max-width:765px){main{margin:0;padding:24px}p{font-size:4vw}.docs .title{font-size:5vw}.docs .description{font-size:4.5vw}}</style>
	
</head>
   
   <body class="gc-documentation develop trainingcourse dac-nav-open" data-gr-c-s-loaded="true">
    <%--   <h2>${message}</h2> --%>
    
     <input class="google-analytics-id-json" type="hidden" value="{&quot;dimensions&quot;: {&quot;dimension6&quot;: &quot;en&quot;, &quot;dimension4&quot;: &quot;Training&quot;, &quot;dimension5&quot;: &quot;en&quot;, &quot;dimension3&quot;: false, &quot;dimension1&quot;: &quot;Signed out&quot;, &quot;dimension8&quot;: null}, &quot;gaid&quot;: &quot;UA-49880327-2&quot;}">  
    <input class="google-analytics-id-json" type="hidden" value="{&quot;dimensions&quot;: {&quot;dimension6&quot;: &quot;en&quot;, &quot;dimension4&quot;: &quot;Training&quot;, &quot;dimension5&quot;: &quot;en&quot;, &quot;dimension3&quot;: false, &quot;dimension1&quot;: &quot;Signed out&quot;, &quot;dimension8&quot;: null}, &quot;gaid&quot;: &quot;UA-5831155-1&quot;}">
  <header id="header-wrapper">
    <div class="dac-header" id="header">
    </div>

  </header>
  <nav class="dac-nav">
    <div class="dac-nav-dimmer" data-dac-toggle-nav=""></div>
    <div class="dac-nav-sidebar" data-swap="" data-dynamic="false" data-transition-speed="300" data-dac-nav="">
      <div data-swap-container="">
        
        <a class="dac-nav-back-button dac-swap-section dac-up dac-active" tabindex="0" data-swap-button="">
          
          
          <i class="dac-sprite dac-nav-back"></i> <span class="dac-nav-back-title">
            
            Cognitive Spider
 
            </span>
        </a>
	
        <div class="dac-nav-sub dac-swap-section dac-right dac-active" itemscope="" itemtype="http://schema.org/SiteNavigationElement">
          
            <ul id="nav">
            </ul>
        </div>
     
      </div>
    </div>
  </nav>
  <div class="wrap clearfix" id="body-content">
     
<div class="jd-descr " itemprop="articleBody">
      

<div class="wrap">
  <div class="cols">
    <div class="col-1of1">
<p>Various online video courses are also available if you'd prefer
an interactive video experience.</p>
<div id="wrapper">

  		<div id="videoContainer">
			in video testing
			<!-- Video -->
		     <video id="video" loop>
		     
		        <source src="resources/video/Junior Horlicks_TVC_30 sec English.mp4" type="video/mp4">
		        <!-- <source src="video/video.ogg" type="video/ogg">  -->     
		        <track label="English" kind="subtitles" srclang="en" src="resources/video/captions.vtt" default>
		        <p>
		          Your browser doesn't support HTML5 video.
		          <a href="resources/video/Junior Horlicks_TVC_30 sec English.mp4">Download</a> the video instead.
		        </p>
		      </video>

		    <!-- Video Controls -->
			<div id="videoControls">
				<input type="range" id="progressBar" value="0">
				<span id="progress"></span>	
					<div id="buttonControls">	
					    <button id="play"><img id="playImg" src="resources/icons/play-icon.png" alt="The play icon"></button>
					    <span id="duration">00:00 / 01:00</span> 
					    <button id="fastFwd">1x Speed</button>		
						
					    <!-- <button id="fullScreen"><img id="fullScreenImg" src="icons/fullscreen-icon.png" alt="The fullscreen icon"></button>
					    <input type="range" id="volumeSlider" min="0" max="1" step="0.01" value="1">  
					    <button id="mute"><img id="muteImg" src="icons/volume-on-icon.png" alt="The mute icon"></button>	
						-->
						<button id="mute"><img id="muteImg" src="resources/icons/volume-on-icon.png" alt="The mute icon"></button>
						<input type="range" id="volumeSlider" min="0" max="1" step="0.01" value="1">  
						<button id="fullScreen"><img id="fullScreenImg" src="resources/icons/fullscreen-icon.png" alt="The fullscreen icon"></button>
					    
					    <button id="AIChat" class="modal-open" onclick="pauseVid()"><img id="AIChatImg" src="resources/icons/AI-chat.png" alt="AI Chat" ></button>		
						
					</div>   	
			</div>

		</div>   

  	</div>

	
<!-- <button class="modal-open1">Open modal box</button> -->
<div class="modal-box draw">
    <div class="modal-box-content">
       
	   
	   <div class="rsc">
		<a class="rsc-float-button kZnNTH">
		 <!-- <svg height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
		<path d="M20 2H4c-1.1 0-2 .9-2 2v18l4-4h14c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2z"></path>
		<path d="M0 0h24v24H0z" fill="none"></path></svg> -->
	   </a>
	   <div class="rsc-container gvaiiE" style="float:right">
			<div class="rsc-header fhNxmV">
				<h2 class="rsc-header-title dQgEds">Chat</h2>
				<a class="rsc-header-close-button bDZnTJ">
					<!-- <svg height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
						<path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"></path>
						<path d="M0 0h24v24H0z" fill="none"></path>
					</svg> 
					-->
				</a>
			</div>
			
			
			<div id='mainContainer' class="rsc-content sc-gZMcBi bxslzG">
				<div class="rsc-ts sc-dnqmqq efROPc">
					<div class="rsc-ts-image-container sc-htoDjs vmYlS">
						<img class="rsc-ts-image sc-gzVnrw hLGSaN" src="resources/icons/robot.svg" alt="avatar">
						</div>
						<div class="rsc-ts-bubble sc-bZQynM fhAWVE">
						<!-- react-text: 1738 -->Welcome to chtabot<!-- /react-text -->
						</div>
				</div>
			<!-- 	<div class="rsc-ts sc-dnqmqq eBYsSN">
					<div class="rsc-ts-image-container sc-htoDjs fmWSyf">
						<img class="rsc-ts-image sc-gzVnrw fRGzTx" src="resources/icons/human.svg" alt="avatar">
					</div>
					<div class="rsc-ts-bubble sc-bZQynM kFPviT">
					Number 1
					</div>
				</div>
				<div class="rsc-ts sc-dnqmqq efROPc">
					<div class="rsc-ts-image-container sc-htoDjs vmYlS">
						<img class="rsc-ts-image sc-gzVnrw hLGSaN" src="resources/icons/robot.svg" alt="avatar">
				    </div>
					<div class="rsc-ts-bubble sc-bZQynM fhAWVE">
						Awesome! You are a telepath!
					</div>
				</div> -->
			</div>
			
			
			
				<div class="rsc-footer sc-jzJRlG byHcWR">
					<input type="textarea" class="rsc-input cXRGFk" placeholder="Enter your Question?" value="" >
					<button class="rsc-submit-button sc-kAzzGY hrUGXf" onclick="onSubmit()">
						<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 500 500">
							<g><g><polygon points="0,497.25 535.5,267.75 0,38.25 0,216.75 382.5,267.75 0,318.75"></polygon></g></g>
						</svg>
					</button>
				</div>
			</div>
		</div>
	   
		
    </div>
    <button class="modal-close" onclick="unmuteVid()"><span class="visuallyhidden">Close modal box</span></button>
</div>


<!--
<button id="modal-trigger" data-buttonTitle="Open Modal">Open Modal</button>
<div id="modal">
  <div id="content">I'm a modal. Drag me around.</div>
  <div id="background"></div>
</div>
-->


    </div>
  </div>
</div>
</div>

</div>

<!-- <audio id="botAudioPlayer" controls="controls" style="display:none">
         <source id="ogg_src" src="" type="audio/ogg" />
          <source id="mp3_src" src="lib/audio/barger01.mp3" type="audio/mp3" /> 
         
          Your browser does not support the audio element.
    </audio> -->


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="resources/js/app.js" type="text/javascript" charset="utf-8"></script>
	<script src="resources/js/modal.js"></script>
	<!-- <script src="js/modal2.js"></script> -->
    
    
    
   </body>
</html>