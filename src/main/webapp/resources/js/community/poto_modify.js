CKEDITOR.replace('comm_contents',{
	filebrowserUploadUrl:'./potofileup?pgfrm=poto'
	,height : '500px'  // 입력창의 높이
	,startupFocus : false
});

$(document).ready(function() {
	$(".Btn").click(function() {
		var cnts = CKEDITOR.instances.comm_contents;
		
		var form = new FormData(document.getElementById("modifyform"));
		form.append('user_no',$("#user_no").val());
		form.append('comm_no',$("#comm_no").val());
		form.append('comm_contents',cnts.getData());
		$.ajax({
			url:"./modifypoto"
			, data:form
			, contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			, dataType:'json'
			, processData:false
			, contentType:false
			, type:'POST'
			, success:function(result){
				if(result > 0){
					alert("글이 수정되었습니다.");
					location.href="./potodetail?comm_no="+$("#comm_no").val();				
				}else{
					alert("잠시후, 다시 시도해 주세요.");
				}
			}
			, error:function(xhr){
				alert("시스템 관리자에게 문의 바랍니다.");
			}
		});//ajax		
	});
});