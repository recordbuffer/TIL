$(function(){
	getJson();
});

//json 데이터 읽어오는 함수
function getJson(){
	//lib.json에서 데이터 가져옴 -> function(data)로 처리 -> data에 저장
	$.getJSON("json/lib.json", function(data){
		$.each(data, function(key, val){		//data 가져와서 key, val 나눠서 저장
			if(key=="DESCRIPTION"){				//키값 DESCRIPTION일때 
				$("table").attr("border","1");
				
				$("thead").append(
					"<tr>"+
						"<th>"+val.GU_CODE+"</th>"+
						"<th>"+val.LBRRY_SEQ_NO+"</th>"+
						"<th>"+val.LBRRY_NAME+"</th>"+
						"<th>"+val.ADRES+"</th>"+
						"<th>"+val.TEL_NO+"</th>"+
						"<th>"+val.HMPG_URL+"</th>"+
					"</tr>"
				);
			} else{
				var list = val; 	//list 변수 : 배열로 정의
				for(var i=0; i<list.length; i++){
					var str = list[i];		//str 변수 : list 배열 안에 있는 하나의 json 데이터
					$("tbody").append(
						"<tr>"+
							"<td>"+str.gu_code+"</td>"+
							"<td>"+str.lbrry_seq_no+"</td>"+
							"<td>"+str.lbrry_name+"</td>"+
							"<td>"+str.adres+"</td>"+
							"<td>"+str.tel_no+"</td>"+
							"<td>"+str.hmpg_url+"</td>"+
						"</tr>"
					);
				}
			}
		});
	});
	
}