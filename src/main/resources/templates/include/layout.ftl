<!DOCTYPE html>
<#assign contextPath = request.contextPath>
<#assign animated = "animated fadeIn">
<html>
    <head>
        <title>${title}</title>
	    <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link href="${contextPath}/css/bootstrap/bootstrap.min.css?v=3.3.7" rel="stylesheet">
		<link href="${contextPath}/css/font-awesome/font-awesome.min.css?v=4.7.0" rel="stylesheet">
		<link href="${contextPath}/css/animate/animate.css?v=3.5.2" rel="stylesheet">
		<link href="${contextPath}/css/AdminLTE.min.css" rel="stylesheet">
		<link href="${contextPath}/css/skins/_all-skins.min.css" rel="stylesheet">
		<link href="${contextPath}/js/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
		<link href="${contextPath}/js/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">

		<script src="${contextPath}/js/jquery.min.js?v=3.1.1"></script>
		<script src="${contextPath}/js/bootstrap/bootstrap.min.js?v=3.3.7"></script>
		<script src="${contextPath}/js/bootstrap-table/bootstrap-table.js?v=1.11.1"></script>
		<script src="${contextPath}/js/bootstrap-select/bootstrap-select.min.js"></script>
		<script src="${contextPath}/js/validate/jquery.validate.min.js"></script>
		<script src="${contextPath}/js/validate/additional-methods.js"></script>
		<script src="${contextPath}/js/validate/messages_zh.js"></script>
		<script src="${contextPath}/js/layer/layer.js?v=3.1.1"></script>
		<script src="${contextPath}/js/common/jquery.form.js?v=4.2.1"></script>
		<script src="${contextPath}/js/common/common.js"></script>
        <@head></@head>
    </head>
   	<body class="hold-transition skin-blue sidebar-mini" data-contentPath="${contextPath}" style="background-color: #ecf0f5;">
	    <@body>
	   	
		</@body>
   	</body>
</html>