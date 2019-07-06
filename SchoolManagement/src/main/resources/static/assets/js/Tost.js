 function sucMsg(data) {
			   $.toast({
			            heading: 'Successful',
			            text: data,
			            position: 'top-right',
			            loaderBg:'#ff6849',
			            icon: 'success',
			            hideAfter: 3500, 
			            stack: 6
			          });
		
 }
 function errorMsg(data)
 {
			  $.toast({
			            heading: 'Error',
			            text: data,
			            position: 'top-right',
			            loaderBg:'#ff6849',
			            icon: 'error',
			            hideAfter: 3500
			            
			          });
}
 
 $(function(){
		$('#msgID').trigger('onload');
	});