$(function(){
				//左边餐单点击显示
				$(".xiala-images").click(function(){
					var index=$(".xiala-images").index(this);
					
					var element = $(".two-ul-mune").eq(index);/*点击的li的下标*/
					var elli =$("#left>ul>li").eq(index);/*点击的li*/
					$(".xiala-images").eq(index).hide();
					elli.css("height","400px");
					element.show();
					
					var litit=$(".li-mune-div").eq(index);
					litit.css("border-bottom","2px solid black")
					
					for (i=0;i<$(".xiala-images").length;i++){
						if (i!=index){
							$(".xiala-images").eq(i).show();
							$(".two-ul-mune").eq(i).hide();
							$("#left>ul>li").eq(i).css("height","30.5px");
							$(".li-mune-div").eq(i).css("border-bottom","0px")
						}
					}
				});
				//首页时间显示
				setInterval(function() {
				var wek=['日','一','二','三','四','五','六']
				var mytime=new Date();
				var year =mytime.getFullYear();
				var mon=mytime.getMonth()+1;
				var day=mytime.getDate();
				var hour=mytime.getHours();
				var min=mytime.getMinutes();
				var sec=mytime.getSeconds();
				var week = wek[mytime.getDay()];
				var ss="现在时间："+year+" 年 "+mon+" 月 "+day+" 日 "+hour+" 时 "+min+" 分 "+sec+" 秒 "+" 星期"+week;
				$("#time-now span").text(ss);
				},1000);
				
				
				//全选按钮
				var temp=0;/*点击计数变量*/
				$("#fullsel").click(function(){
					
					if(temp%2==0){
						$("#myifram").contents().find(".checkbox").attr("checked",true);
						temp++;
						
					}
					else{
						$("#myifram").contents().find(".checkbox").attr("checked",false);
						temp++;
						
					}
				});
				
});