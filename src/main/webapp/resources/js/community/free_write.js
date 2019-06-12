CKEDITOR.replace('comm_contents',{
			filebrowserUploadUrl:'./writeupload?pgfrm=free'
			,height : '500px'  // 입력창의 높이
			,startupFocus : false
		});
		
		$(document).ready(function() {
			$("#writeBtn").click(function() {
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
				
				$.post(
						"./insfree"	
 						,{comm_title:$("#comm_title").val()
 							,user_no:$("#user_no").val()
							,writer:$("#writer").val()
 							,comm_contents:cnts.getData()
						}
						,function(data,status){
							if(status == "success"){
								if(data > 0){
									alert("글이 저장되었습니다.");	
									location.href="./freelist";
								}else{
									alert("잠시후 다시 시도해주세요");
								}
							} else{
								alert("시스템 관리자에게 문의 바랍니다.");
							}
						}
				);//post
			});//click
		});//ready