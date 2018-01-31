<!DOCTYPE html>
<#assign contextPath=request.contextPath>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Mini</title>
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<#-- 
	<link rel="shortcut icon" href="${contextPath}/img/favicon.ico" type="image/x-icon" /> 
	 -->
	<link href="${contextPath}/css/bootstrap/bootstrap.min.css?v=3.3.7" rel="stylesheet" >
	<link href="${contextPath}/css/font-awesome/font-awesome.min.css?v=4.7.0" rel="stylesheet">
	<link href="${contextPath}/css/skins/_all-skins.min.css" rel="stylesheet">
	<link href="${contextPath}/css/AdminLTE.min.css" rel="stylesheet">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<#-- 头部  -->
		<header class="main-header">
			<#-- Logo -->
			<a href="${contextPath}/main.html" class="logo">
				<span class="logo-mini">Mini</span>
				<span class="logo-lg">Mini</span>
			</a>
			<#-- 头部导航栏 -->
			<nav class="navbar navbar-static-top" role="navigation">
				<#-- 侧边栏切换按钮-->
				<a class="sidebar-toggle" data-toggle="push-menu" role="button"> 
					<span class="sr-only">Toggle navigation</span>
				</a>
				<#-- 导航栏右键菜单 -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<#-- 账户信息 -->
						<li class="dropdown user user-menu">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
								<img src="https://dn-qiniu-avatar.qbox.me/avatar/0b2313d7a261e4556285e680e807f79c?qiniu-avatar" class="user-image" /> 
								<span class="hidden-xs">${user.username}</span>
							</a>
							<ul class="dropdown-menu">
								<li class="user-header">
									<img src="https://dn-qiniu-avatar.qbox.me/avatar/0b2313d7a261e4556285e680e807f79c?qiniu-avatar" class="img-circle" />
									<p>
										<small>${.now?string("yyyy-MM-dd")}</small>
									</p>
								</li>
								<#-- Menu Body -->
								<li class="user-body">
									<!-- <div class="row">
										<div class="col-xs-4 text-center">
											<a href="javascript:;">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="javascript:;">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="javascript:;">Friends</a>
										</div>
									</div> --> 
								</li>
								<#-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="${contextPath}/changepwd.html" class="btn btn-default btn-flat" target="main_iframe">修改密码</a>
									</div>
									<div class="pull-right">
										<a href="${contextPath}/loginout" class="btn btn-default btn-flat">退出</a>
									</div>
								</li>
							</ul>
						</li>
						<#-- Control Sidebar Toggle Button -->
						<li>
							<a href="javascript:;" data-toggle="control-sidebar">
								<i class="fa fa-gears"></i>
							</a>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		
		<#--左边菜单栏   -->
		<aside class="main-sidebar" >
				<section class="sidebar">
					<div class="user-panel">
						<div class="pull-left image">
							<img src="https://dn-qiniu-avatar.qbox.me/avatar/0b2313d7a261e4556285e680e807f79c?qiniu-avatar" class="img-circle" />
						</div>
						<div class="pull-left info">
							<p>${user.username}</p>
						</div>
					</div>
					<#-- 菜单栏 -->
					<ul class="sidebar-menu" data-widget="tree">
						
						<li class="treeview">
							<a href="${contextPath}/sys/user/list.html" target="main_iframe">
								<i class="fa fa-cogs"></i>
								<span>用户管理</span>
							</a>
						</li>
						<li class="treeview">
							<a href="${contextPath}/druid" target="_blank">
								<i class="fa fa-cogs"></i>
								<span>druid监控</span>
							</a>
						</li>
						<li class="treeview">
							<a href="javascript:;" target="main_iframe">
								<i class="fa fa-cogs"></i>
								<span>监控</span>
								<span class="pull-right-container">
					            	<i class="fa fa-angle-left pull-right"></i>
					            </span>
							</a>
							<ul class="treeview-menu">
								<li class="treeview">
									<a href="${contextPath}/health" target="_blank">
										<i class="fa"></i>
										<span>health</span>
									</a>
								</li>
								<li class="treeview">
									<a href="${contextPath}/env" target="_blank">
										<i class="fa"></i>
										<span>env</span>
									</a>
								</li>
								<li class="treeview">
									<a href="${contextPath}/metrics" target="_blank">
										<i class="fa"></i>
										<span>metrics</span>
									</a>
								</li>
								<li class="treeview">
									<a href="${contextPath}/dump" target="_blank">
										<i class="fa"></i>
										<span>dump</span>
									</a>
								</li>
								<li class="treeview">
									<a href="${contextPath}/trace" target="_blank">
										<i class="fa"></i>
										<span>trace</span>
									</a>
								</li>
								<li class="treeview">
									<a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready" target="_blank">
										<i class="fa"></i>
										<span>官方</span>
									</a>
								</li>
							</ul>
						</li>
						<#--
						<@getSubMenu list=menuList />
						-->
					</ul>
				</section>
 		</aside>
		<#-- 递归获取菜单 -->
    	<#macro getSubMenu list >
    		<#if list?? && menuList?size gt 0>
    			<#list list as data>
					<li class="treeview">
		 				 <a href="<#if data.menuUrl != 'javascript:;' && data.menuUrl != '#' && data.menuUrl?length gt 0>${contextPath}/${data.menuUrl}<#else>#</#if>" target="main_iframe">
				            <i class ="fa <#if data.icon?length gt 0>${data.icon}</#if>" ></i>
				            <span>${data.menuName}</span>
				            <#if data.hasSub>
					            <span class="pull-right-container">
					              <i class="fa fa-angle-left pull-right"></i>
					            </span>
				            </#if>
				          </a>
				          <#if data.hasSub>
				          <ul class="treeview-menu">
				          	<@getSubMenu list=data.subList />
				          </ul>
				          </#if>
					</li>
    			</#list>
    		</#if>
    	</#macro>
		<#-- 内容页 -->
		<div class="content-wrapper" style="height: calc(100% - 100px);overflow: hidden;" >
			<iframe id="main_iframe" name="main_iframe" width="100%" height="100%" src="${contextPath}/sys/user/list.html" frameborder="0"  seamless></iframe> 
		</div>
		<#-- end -->
		<#-- 版权信息 -->
		<footer class="main-footer">
			<#--
 				<div class="pull-right hidden-xs"><a href="javascript:;">深圳市小豆科技有限公司</a></div>
 			-->
			<strong>Copyright &copy; 2018 </strong>
			 All rights reserved.
		</footer>
		<#-- 设置  -->
		<aside class="control-sidebar control-sidebar-dark">
			<#-- tab栏 -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<#--
				<li class="active">
					<a href="#control-sidebar-theme-options-tab" data-toggle="tab">
						<i class="fa fa-wrench"></i>
					</a>
				</li>
				<li>
					<a href="#control-sidebar-home-tab" data-toggle="tab">
						<i class="fa fa-home"></i>
					</a>
				</li>
				<li>
					<a href="#control-sidebar-settings-tab" data-toggle="tab">
						<i class="fa fa-gears"></i>
					</a>
				</li>
				-->
			</ul>
			<#-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane active" id="control-sidebar-theme-options-tab">
					<div>
					    <h4 class="control-sidebar-heading">
                                                                  布局
                        </h4>
					    <div class="form-group">
					           <label class="control-sidebar-subheading">
					               <input type="checkbox" data-layout="layout-boxed" class="pull-right">盒子布局
					           </label>
					    </div>
						<h4 class="control-sidebar-heading">
							主题设置
						</h4>
						<ul class="list-unstyled clearfix">
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-blue" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9"></span>
										<span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin">Blue</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-black" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix">
										<span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe"></span>
										<span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin">Black</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-purple" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span>
										<span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin">Purple</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-green" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span>
										<span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin">Green</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-red" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span>
										<span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin">Red</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-yellow" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span>
										<span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222d32"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin">Yellow</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-blue-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9"></span>
										<span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin" style="font-size: 12px">Blue Light</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-black-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix">
										<span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe"></span>
										<span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin" style="font-size: 12px">Black Light</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-purple-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span>
										<span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin" style="font-size: 12px">Purple Light</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-green-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span>
										<span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin" style="font-size: 12px">Green Light</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-red-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span>
										<span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin" style="font-size: 12px">Red Light</p>
							</li>
							<li style="float:left; width: 33.33333%; padding: 5px;">
								<a href="javascript:void(0)" data-skin="skin-yellow-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
									<div>
										<span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span>
										<span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div>
								</a>
								<p class="text-center no-margin" style="font-size: 12px">Yellow Light</p>
							</li>
						</ul>
					</div>
				</div>
				<#-- control-sidebar-home-tab 
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">
						Recent Activity
					</h3>
					<ul class="control-sidebar-menu">
						<li>
							<a href="javascript:;"> 
								<i class="menu-icon fa fa-birthday-cake bg-red"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
					</ul>
					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li>
							<a href="javascript:;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design 
									<span class="pull-right-container">
										<span class="label label-danger pull-right">70%</span>
									</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger" style="width: 70%"></div>
								</div>
							</a>
						</li>
					</ul>
				</div>
				-->
				<#-- control-sidebar-settings-tab 
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>
						<div class="form-group">
							<label class="control-sidebar-subheading"> 
								Report panel usage 
								<input type="checkbox" class="pull-right" checked>
							</label>
							<p>Some information about this general settings option</p>
						</div>
					</form>
				</div>
				-->
			</div>
		</aside>
		<#-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<#-- ./wrapper -->
	<script src="${contextPath}/js/jquery.min.js?v=3.1.1"></script>
	<script src="${contextPath}/js/bootstrap/bootstrap.min.js?v=3.3.7"></script>
	<script src="${contextPath}/js/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="${contextPath}/js/common/adminlte.js"></script>
	<script src="${contextPath}/js/common/main.js"></script>
</body>
</html>