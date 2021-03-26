$(function(){
	getJson();
});

function getJson(){
	$.getJSON("json/lib.json", function(data){
		$.each(data, function(key, val){
			if(key=="DESCRIPTION"){
				$("table").attr("border","1");
				
				$("thead").append(
					"<tr>"+
						"<th>"++"</th>"+
					"</tr>"
				);
			} else{
				var list = val; 
				for(var i=0; i<list.length; i++){
					var str = list[i];
					$("tbody").apppend(
							
					);
				}
			}
		})
	})
	
}