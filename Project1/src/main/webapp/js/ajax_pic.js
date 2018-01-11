/**
 *  for passing pictures to page
 */

window.onload = function(){
	$('.table').DataTable();
	alert("styled");
}

$(document).ready(function() {
    $('#example').DataTable();
} );

document.addEventListener("DOMContentLoaded", function(event) {
	    $('#example').DataTable();
  });


// getImg does not work properly when placed in another function
function w(){
		
		alert("JUnit testing is required");
		getImg();
	}

function getImg(reb_id){
	//alert("in AJAX function");
	
	//alert(reb_id);
	
	var parameter = "reb_id=" + reb_id;
	
	var xhr = new XMLHttpRequest();
	
	//alert("made a requset");
	xhr.onreadystatechange = function(){
		
		
		
		if(xhr.readyState == 4 && xhr.status == 200){
			//Response is good lets update our DOM (or w/e you want to do) 
			
			document.getElementById("receipt").innerHTML = xhr.responseText; 	
			//alert("request went through");
		}
		
	}
	
	//alert("opening");
	xhr.open("POST", "getImage", true);
	//alert("opening");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Content-length", parameter.length);
	//xhr.setRequestHeader("Connection", "close");
	
	//alert("sending");
	xhr.send(parameter);
	
	
	
	/*
	$.ajax({
	     type: 'GET',
	     url: 'localhost:8080/favoris',
	     data: {"frameID": frameID}
	});
	*/
	
	
	
	
	
}