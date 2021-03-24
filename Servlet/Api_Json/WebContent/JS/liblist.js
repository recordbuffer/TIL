$(function(){
	getJson();
});

//json 데이터 읽어오는 함수
function getJson(){
	//lib.json에서 데이터 가져옴   -> function(data)로 처리 -> data에 저장
	$.getJson("json/lib.json", function(data){
		//data 가져와서 key, val 나눠서 저장
		$.each(data, function(key,val){
			if(key=="DESCRIPTION"){
				$("t")
			} else{
				
				
			}
		});
	});
}