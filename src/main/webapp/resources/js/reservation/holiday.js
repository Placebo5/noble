	var btn_no = 0;
	var dateArr = new Array();
	
		var newToday = new Date();
		var newTodayYear = newToday.getFullYear();
		var newTodayMonth = newToday.getMonth()+1;
		var newTodayDate = newToday.getDate();
		var noTime = $.fullCalendar.moment();
		
		  $('#calendar').fullCalendar({		  
			  
			  businessHours: true,//특정요일 시간 강조
			  selectable: true, //클릭 가능여부
			 
			  dayClick: function(date, jsEvent) {
			 	  dayClickYear = date.format().substring(0,date.format().indexOf("-"));
			 	  dayClickMonth = date.format().substring(date.format().indexOf("-")+1, date.format().lastIndexOf("-"));
			 	  dayClickDate = date.format().substring(date.format().lastIndexOf("-")+1);
			      if(dayClickYear >= newTodayYear
				 			 && (dayClickMonth >= newTodayMonth || dayClickDate > newTodayDate)
			    		  ){
			      	
			    	  $("#date_tb1").append("<tr id='"+btn_no+"'>"
			    			+"<td id='date_in'>"+date.format()+"</td>"
			    			+"<td>"
			    			+"<input type='text' name ='desc_in' size='37' maxlength='30' />"
			    			+"</td>"
			    			+"<input type='button' id='date_td"+btn_no+"' value=' x ' />"
			    			+"</td>"
			    			+"</tr>");
			    	
			    	  $("#date_td"+btn_no).bind("click", function(){
			    		  $("#"+$(this).parents("tr").attr("id")).remove();
			    	  });
			    	  btn_no++;
			      }else{
			    	  alert("수정할 수 없는 날짜입니다.");
			      }
			  }, 			   
			  
			    events : {
			    	url:'./holidaychklist?pro_no='+ $("#pro_no").val() +'&nowDate='+noTime.format(),
			    },
			    
				validRange: function(nowDate) {
				     return {
				   		start:nowDate,
				        end: nowDate.clone().add(1, 'months')
				      }
				  }
		  });//fullCalendar
		  
		  
		  $("#date_in_btn").click(function() {
			len = document.getElementsByName("desc_in").length;
			for(i=0; i<len; i++){
				if(document.getElementsByName("desc_in")[i].value.trim() == ""){
					alert("설명은 필수 입력 항목입니다.");
					document.getClementsByName("desc_in")[i],focus();
					return;
				}//if
			}//for
			for(i=0; i<len; i++){
				var tmpObj = {
						pro_no:$("#pro_no").val(),
						date_in:$("#date_tb1").children().eq(i).text(),
						desc_in:document.getElementsByName("desc_in")[i].value
				}
				dateArr.push(tmpObj);
			}//for
			var jArr = JSON.stringify(dateArr);
			
			$.post(
					"./insholiday"
					,{
						myJson:jArr
					}
					,function(data,status){
						if(status == "success"){
							if(data>0){
								console.log("data : ", data);
								location.reload();
							} else{
								alert("잠시 후 다시 시도해 주세요");
							}//if
						}else{
							alert("시스템 관리자에게 문의바랍니다.");
						}//if
					}
					,"json"
			);//post
		});//click
		  
 