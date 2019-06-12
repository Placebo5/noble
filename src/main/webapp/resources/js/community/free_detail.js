//댓글
$(document).ready(function() {
	$("#commbtn").click(function() {
		if($.trim($("#hidUser_no_comments").val()) == ""){
			alert("로그인 후 이용가능합니다.");
			return;
		}
		if($.trim($("#come_contents").val()) == ""){
			alert("내용을 확인하세요");
			$("#come_contents").focus();
			return;
		}
		$.post(
				"./insfreecomm"
				,{
					comm_no:$("#hidNo").val()
					,come_contents:$("#come_contents").val()
					,user_no:$("#hidUser_no_comments").val()
					,come_no:$("come_no").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("잠시 후, 다시 시도해 주세요");
						}else if(data == -1){
							alert("로그인 해 주세요");
						}else {
							$.each(data,function(index,vo){
								$("#replyTable").append("<tr>");
								$("#replyTable").append("<td style='padding-left: 10px;'>"+vo.user_id+"</td>");
								$("#replyTable").append("<td>"+vo.come_contents+"</td>");
								$("#replyTable").append("<td style='text-align: center;'>"+vo.come_date+"</td>");
								$("#replyTable").append("<tr>");
								$("#replyTable").append("<td colspan=3><hr width=100%></td>");
								$("#replyTable").append("</tr>");
								$("#replyTable").append("</tr>");
							});
						}
					}else{
						alert("시스템 관리자에게 문의 바랍니다");
					}
				}
				,"json"
		)//post
	});//click
});//ready


//삭제
$(document).ready(function() {
	$("#delfree").click(function() {
		var goYN = confirm("글을 삭제하시겠습니까?");
		if(goYN == false){
			return;
		}
		$.post(
				"./delfree"
				,{
					comm_no:$("#hidNo").val()
					,user_no:$("#user_no").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("게시글을 삭제 하였습니다.");
							location.href="./freelist";
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


//좋아요
$(document).ready(function() {
	$("#freeLike").click(function() {
		$.post(
			"./freelikecnt"
			,{comm_no:$("#hidNo").val()}
			,function(data,status){
				$("#freeLikeCnt").text(data);
			}
		);
	});
});