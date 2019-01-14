<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>进销存系统</title>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>

<body>
	<div id="top">
		<div class="top-title">
			<h1>&nbsp;web&nbsp;进&nbsp;销&nbsp;存&nbsp;系&nbsp;统</h1>
		</div>
		<div class="top-nav">
			<div class="nav">
				<img src="images/男.png" width="25px" height="25px" /><span>当前用户:&nbsp;&nbsp;</span><span><a
					href="login.jsp" target="myiframe"><% if(session.getAttribute("uname")==null){%>登陆
					<% }else{ %> <%=session.getAttribute("uname") %> <%} %> </a></span>
			</div>
			<div class="nav">
				<img src="images/女.png" width="25px" height="25px" /><span>角色:&nbsp;&nbsp;</span><span>管理员</span>
			</div>
			<div class="nav" id="time-now">
				<span style="font-size: 24px;"></span>
			</div>
			<div class="nav">
				<img src="images/电脑申请.png" width="25px" height="25px" /> <a
					href="ShouYe.jsp" target="myiframe">首页</a>
			</div>
			<div class="nav">
				<img src="images/邮箱密码更改.png" width="25px" height="25px" /> <a
					href="XiuGaiMiMa.jsp" target="myiframe">修改密码</a>
			</div>
			<div class="nav">
				<img src="images/服务派工.png" width="25px" height="25px" /> <a
					href="Help.jsp" target="myiframe">帮助</a>
			</div>
			<div class="nav">
				<img src="images/icon_blacklist .png" width="25px" height="25px" />
				<a href="Exit.jsp" target="myiframe">退出</a>
			</div>
		</div>

	</div>
	<div style="clear: both;"></div>
	<div id="midd">
		<div id="left" class="mid">
			<ul>
				<li class="li-mune">
					<div class="li-mune-div">
						<img src="images/个人信息.png" width="25px" height="25px" alt="##" /><span>基本信息</span><img
							class="xiala-images" src="images/下拉.png" width="25px"
							height="25px" alt="##" />
					</div>
					<div class="two-ul-mune">
						<ul class="two-ul">
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="xitongjichuxinxishezhi.jsp" target="myiframe">系统基础信息设置</a>
							</li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="leibieshezhi.jsp" target="myiframe">类别设置</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="kucunshujuchushihuashezhi.jsp" target="myiframe">库存数据初始化设置</a>
							</li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jiesuanzhanghhushezhi.jsp" target="myiframe">结算账户设置</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="li-mune">
					<div class="li-mune-div">
						<img src="images/汉堡.png" width="25px" height="25px" alt="##" /><span>库存管理</span><img
							id="xiala-images-id" class="xiala-images" src="images/下拉.png"
							width="25px" height="25px" alt="##" />
					</div>
					<div class="two-ul-mune" id="two-ul-mune-id">
						<ul class="two-ul">
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="InvInforQue.jsp" target="myiframe">库存信息查询</a>
							</li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="kucunjiaoyan.jsp" target="myiframe">库存检验</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="kucunbaobiao.jsp" target="myiframe">库存报表</a></li>
						</ul>
					</div>
				</li>
				<li class="li-mune">
					<div class="li-mune-div">
						<img src="images/行李箱.png" width="25px" height="25px" alt="##" /><span>采购管理</span><img
							class="xiala-images" src="images/下拉.png" width="25px"
							height="25px" alt="##" />
					</div>
					<div class="two-ul-mune">
						<ul class="two-ul">
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuo.jsp" target="myiframe">进货 </a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuoxiugai.jsp" target="myiframe">进货修改 </a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuoshezhi.jsp" target="myiframe">进货设置</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuojilushezhi.jsp" target="myiframe">进货记录设置</a>
							</li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuolishi.jsp" target="myiframe">进货历史</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuojianyanshezhi.jsp" target="myiframe">进货检验设置</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="li-mune">
					<div class="li-mune-div">
						<img src="images/鼠标.png" width="25px" height="25px" alt="##" /><span>销售管理</span><img
							class="xiala-images" src="images/下拉.png" width="25px"
							height="25px" alt="##" />
					</div>
					<div class="two-ul-mune">
						<ul class="two-ul">
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="xiaoshoudingdan.jsp" target="myiframe">销售订单</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="xiaoshouchuku.jsp" target="myiframe">销售出库</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jiesuanguanli.jsp" target="myiframe">结算管理</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="baobiaofenxi.jsp" target="myiframe">报表分析</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="tuihuoguanli.jsp" target="myiframe">退货管理</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="xiaoshoujihuaguanli.jsp" target="myiframe">销售计划管理</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="li-mune">
					<div class="li-mune-div">
						<img src="images/钻石.png" width="25px" height="25px" alt="##" /><span>财务管理</span><img
							class="xiala-images" src="images/下拉.png" width="25px"
							height="25px" alt="##" />

					</div>
					<div class="two-ul-mune">
						<ul class="two-ul">
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="kuaijizongzhangguanli.jsp" target="myiframe">会计总账管理</a>
							</li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="yinkuibiaoguanli.jsp" target="myiframe">盈亏表管理</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="zidongfenluguanli.jsp" target="myiframe">自动分录管理</a>
							</li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="piaojuzijinguanli.jsp" target="myiframe">票据资金管理</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="li-mune">
					<div class="li-mune-div">
						<img src="images/设置.png" width="25px" height="25px" alt="##" /><span>系统管理</span><img
							class="xiala-images" src="images/下拉.png" width="25px"
							height="25px" alt="##" />
					</div>
					<div class="two-ul-mune">
						<ul class="two-ul">
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="xiaoshouyuanguanli.jsp" target="myiframe">销售员管理</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="cangkuyuanguanli.jsp" target="myiframe">仓库员管理</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="jinhuoyuanguanli.jsp" target="myiframe">进货员管理</a></li>
							<li><img src="images/音响.png" width="25px" height="25px"
								alt="##" /> <a href="xitongguanli.jsp" target="myiframe">系统管理员设置</a>
							</li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
		<div id="right" class="mid">
			<div class="m-tab-div">
				<ul class="m-tab">
					<li id="fullsel"><img src="images/项目管理.png" width="20px"
						height="20px" alt="##" />全选</li>
					<li><img src="images/添加.png" width="20px" height="20px"
						alt="##" />新增</li>
					<li><img src="images/编辑.png" width="20px" height="20px"
						alt="##" />修改</li>
					<li><img src="images/删除.png" width="20px" height="20px"
						alt="##" />删除</li>
					<li><img src="images/密码-不看.png" width="20px" height="20px"
						alt="##" />查询</li>
					<li><img src="images/历史.png" width="20px" height="20px"
						alt="##" />恢复</li>
				</ul>
			</div>
			<!--<div style="clear: both;"></div>-->
			<div class="ifram-div">
				<iframe id="myifram" name="myiframe" noresize="noresize"
					src="ShouYe.jsp"></iframe>
			</div>
		</div>
	</div>
	<div style="clear: both;"></div>
	<div id="foot">
		<div>&copy;星星企业web进销存系统</div>
	</div>
</body>

</html>