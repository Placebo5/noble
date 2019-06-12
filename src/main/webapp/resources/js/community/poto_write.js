CKEDITOR.replace('comm_contents',{
	filebrowserUploadUrl:'./potofileup?pgfrm=poto'
	,height : '500px'  // 입력창의 높이
	,startupFocus : false
});

$(document).ready(function() {
	$(".button").click(function() {
		if($.trim($("#comm_title").val()) == ""){
			alert("제목을 확인하세요");
			$("#comm_title").focus();
			return;
		}
		var cnts = CKEDITOR.instances.comm_contents;
		if(cnts.getData() ==""){
			alert("내용을 확인하세요");
			cnts.focus();
			return;
		}
		
		var goYN = confirm("글을 입력하시겠습니까?");
		if(goYN == false){
			return;
		}
		
		var form = new FormData(document.getElementById("fileForm"));
		form.append('user_no',$("#user_no").val());
		form.append('comm_contents',cnts.getData());
		$.ajax({
			url:"./potoins"
			, data:form
			, dataType:'json'
			, processData:false
			, contentType:false
			, type:'POST'
			, success:function(result){
				if(result > 0){
					alert("글이 저장되었습니다.");
					location.href="./potolist"					
				}else{
					alert("잠시후, 다시 시도해 주세요.");
				}
			}
			, error:function(xhr){
				alert("시스템 관리자에게 문의 바랍니다.");
			}
		});//ajax			
	});//click
});//ready