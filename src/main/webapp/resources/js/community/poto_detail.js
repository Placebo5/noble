$(document).ready(function() {
	$("#commbtn").click(function() {
		if($.trim($("#come_contents").val()) == ""){
				alert("내용을 확인하세요");
				$("#come_contents").focus();
				return;
		}
		$.post(
				"./inspotocomm"
				,{
					comm_no:$("#hidCommNo").val()
					,come_contents:$("#come_contents").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("잠시 후, 다시 시도해 주세요");
						}else if(data == -1){
							alert("로그인 해 주세요");
						}else {
							var vo = data.jsonStr;
							$("#replyTable").append("<tr>");
							$("#replyTable").append("<td style='padding-left: 10px;'>"+vo.user_id+"</td>");
							$("#replyTable").append("<td>"+vo.come_contents+"</td>");
							$("#replyTable").append("<td style='text-align: center;'>"+vo.come_date+"</td>");
							$("#replyTable").append("<tr>");
							$("#replyTable").append("<td colspan=3><hr width=100%></td>");
							$("#replyTable").append("</tr>");
							$("#replyTable").append("</tr>");
							$("#come_contents").val("");
						}
					}else{
						alert("시스템 관리자에게 문의 바랍니다");
					}
				}
				,"json"
		)//post
	});//click
	$("#potoLike").click(function() {
		$.post(
			"./potolikecnt"
			,{comm_no:$("#hidCommNo").val()}
			,function(data,status){
				$("#potoLikeCnt").text(data);
			}
		);//post
	});//click
});//ready


$(document).ready(function() {
	$("#delpoto").click(function() {
		var goYN = confirm("글을 삭제하시겠습니까?");
		if(goYN == false){
			return;
		}
		$.post(
				"./delpoto"
				,{
					comm_no:$("#hidCommNo").val()
					,user_no:$("#hidNo").val()
				 	,comm_contents:$("#hidComm_contents").val()
				 	,fileat:$("#hidFileNm").val()
				}
				,function(data,status){
					if(status == "success"){
						if(data > 0){
							alert("게시글을 삭제 하였습니다.");
							location.href="./potolist";
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