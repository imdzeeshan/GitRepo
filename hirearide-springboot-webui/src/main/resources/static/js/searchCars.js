$(document).ready(function() {
	 var items = [];
	
    $.ajax({
    	type : "GET",
        url: "http://localhost:8080/hireARide1/getCars",
        	data : {
			},
		dataType : 'json',
		success : function(response) {

			if(!jQuery.isEmptyObject(response))
				{
				 
				 
				   $.each(response, function(i, item) {
					 
					   items.push(
						
							'<span id="silentField'+i+'" style="visibility:hidden;">'+item.id+'</span>'+
							   '<div class="col-md-3" style="margin: 20px;border: 1px solid #454545;"> <h1 id="ic'+i+'">'+item.company+' <br/><small id="im'+i+'"> '+item.model+'</small></h1>'+
							   '<p id="isc'+i+'"><span class="glyphicon glyphicon-user" title="seating capacity of car" ></span><span id="isc1'+i+'"> '+item.seating_capacity+
							   ' </span> &nbsp;&nbsp;&nbsp;&nbsp;    <span class="glyphicon glyphicon-briefcase" title="luggage capacity of car" ></span> <span id="isc2'+i+'">'+item.luggage_capacity+'</span></p>'+
							   '<p><!-- Trigger the modal with a button -->'+
							   '<button id="btnC'+i+'" class="btn btn-info btn-md btn-block" data-toggle="modal" data-backdrop="static" data-target="#myModal" onClick= "setValuesInModel('+i+')" title="Charges for single day. Click to Book Now"><span class="glyphicon glyphicon-usd"></span><span id="btnC1'+i+'">  '+
							   item.trip_charge_perday+'</span></button> '+
							   '</p> </div>'+
							  
							 ''
							
							
							  
					);

									
				   });  // close each()

				   $('#cardiv').empty().append( items.join('') );	
				}
			else
				{

				 $('#cardiv').empty().append(
						 '<li>'+
							
							'<span class="details">'+
							'</span>Sorry there are no Cars Available!'+
						
							'</li>'


						  );	
				}
				
		},
		error : function() {
			toastMesswarn("Problem while sending request");	
		}

   
    });
    
	
});

