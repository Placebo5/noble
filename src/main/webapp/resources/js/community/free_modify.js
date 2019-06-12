CKEDITOR.replace('comm_contents',{
	filebrowserUploadUrl:'./writeupload'
	,height : '500px'  // 입력창의 높이
	,startupFocus : false
});

$(document).ready(function(){
	$("#modifyFree").click(function() {
		if($.trim($("#comm_title").val()) == ""){
			alert("제목을 확인하세요");
			$("#comm_title").focus();
			return;
		}
		var cnts=CKEDITOR.instances.comm_contents;
		if(cnts.getData() ==""){
			alert("내용을 확인하세요");
			cnts.focus();
			return;
		}
		$.post(
				"./modifyfree"
				,{
					comm_no:$("#hidNo").val()
					,comm_title:$("#comm_title").val()
					,comm_contents:cnts.getData()
					
				}
				,function(data,status){
					if(status == "success"){
						if(data>0){
							alert("게시글이 수정되었습니다.");
							location.href="./freedetail?comm_no="+$("#hidNo").val();
						}else{
							alert("잠시 후, 다시 시도하세요");
						}
					}else{
						alert("관리자에게 문의하세요");
					}
				}
		);
	});//click	
});//ready