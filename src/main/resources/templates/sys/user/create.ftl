<#assign title ="创建用户">
<#include "/include/layout.ftl">
<#macro head>
</#macro>
<#macro body>
	<section class="content-header">
		<h1>
			${title}
			<a class="btn btn-default pull-right back" href="javascript:;"><i class="fa fa-reply"></i> 返回</a>
		</h1>
	</section>
    <section class="content ${animated}">
		<div class="box box-info">
 			<div class="row">
				<div class="col-sm-12">
					<form action="${contextPath}/sys/user/save" method="post" id="saveForm" class="form-horizontal">
						<input type="hidden" name="id" value="${data.id}" />
						<div class="box-body">
							<div class="form-group">
								<label class="col-sm-4 control-label">用户名称:</label>
								<div class="col-sm-4">
									<input name="username" value="${data.username}" class="form-control"  placeholder="用户名称" required minlength=2 maxlength=20  />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">手机号码:</label>
								<div class="col-sm-4">
									<input name="phone" value="${data.phone}" class="form-control"  placeholder="手机号码" required phone=true maxlength=11  />
								</div>
							</div>
		                </div>
						<div class="box-footer">
		              	 	<div class="col-sm-12 text-center">
		              	 		<a class="btn btn-default" id="reset" ><i class="fa fa-rotate-left"></i> 重置</a>
		              	 		<a class="btn btn-info" id="submit"><i class="fa fa-save"></i> 确定</a>
			             	</div>
						</div>
		              	<br/>
					</form>
		         </div>
            </div>
        </div>
    </section>
	<script type="text/javascript">
		
		//ajax 返回
		function showResponse(responseText, statusText) {
			var code = responseText.code;
			var msg = responseText.msg;
			if (code == "200") {
				layer.alert(msg,{icon: 1}, function(index){
					location.href="${contextPath}/sys/user/list.html";
				 	layer.close(index);
				});  
			} else {
				layer.msg(msg, {icon: 2});
			}
		}	
		
		//表单验证
		function validateForm(){
		   return $("#saveForm").validate().form();
		}
	</script>
</#macro>