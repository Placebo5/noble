$(document).ready(function() {
	$("#delpromo").click(function() {
		var delYN = confirm("글을 삭제하시겠습니까?");
		if(delYN == false){
			return;
		}
		$.post(
				"./delpromo"
				,{
					pro_no:$("#pro_no").val()
					,user_no:$("#user_no").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("게시글을 삭제 하였습니다.");
							location.href="./hoslist";
						}else if(data == -1){
							alert("삭제할 수 없는 게시글 입니다.");
					}else{
							alert("잠시 후, 다시 시도해 주세요");
						}
				}else{
						alert("관리자에게 문의 바랍니다.");
				}//if
					
			}
		);//post
	});//click
});//ready