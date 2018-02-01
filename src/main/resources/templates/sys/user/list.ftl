<#assign title ="用户列表">
<#include "/include/layout.ftl">
<#macro head>
</#macro>
<#macro body>
	<section class="content-header">
		<h1>
			${title}
			<div class="pull-right">
				<a class="btn btn-info"  href="${contextPath}/sys/user/create.html"><i class="fa fa-plus"></i> 添加</a>
				<a class="btn btn-danger" href="javascript:;" id="del" ><i class="fa fa-trash"></i> 删除</a>
			</div>
		</h1>
	</section>
    <section class="content ${animated}">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-info">
					<div class="box-body">
						<div id="toolbar">
							<form id="searchForm">
								<div class="form-inline">
									<div class="form-group input-group">
	                                    <input name="username" class="form-control" placeholder="用户名" autocomplete="off">
	                                    <div class="input-group-btn">
	                                        <a id="search" class="btn btn-info"><i class="fa fa-search"></i></a>
	                                    </div>
                                	</div>
								</div>
							</form>
						</div>
						<form action="${contextPath}/sys/user/delete" id="deleteForm" method="post" >
							<table id="table" data-toggle="table" data-url="${contextPath}/sys/user/getTableData" data-query-params="queryParams"
								  data-show-refresh = "true" data-show-toggle = "true" data-show-columns = "true"
								  <#--  
								  data-classes = "table table-hover table-no-bordered table-striped";
								  data-sort-name="username" data-sort-order="desc"
								  style="width:4000px;table-layout: fixed;"
								  -->
								 >
								<thead>
									<tr>
										<th data-checkbox="true"></th>
							    		<th data-field="username" data-sortable="true">用户名</th>
							    		<th data-field="phone">手机号</th>
							    		<th data-field="gmtCreate">创建时间</th>
							    		<th data-field="gmtModified">修改时间</th>
										<th data-field="id" data-formatter="operateFormatter">操作</th>
									</tr>
								</thead>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		
		$(function(){
		
			// 查询
			$("#search").click(function(){
				$("#table").bootstrapTable('refresh', {'pageNumber':1});
				return;
			})
			
			//回车查询
			$("form").keydown(function() {
                 if (event.keyCode == "13") {
                    $("#search").click();
                 }
            });
			
		})
		
		
		// 操作
		function operateFormatter(value, row, index) {
			var str =  "<a href='${contextPath}/sys/user/create.html?id=%s'><i class='fa fa-edit'></i> 修改</a>  ";
			return util.strFormat(str, value);
		}
	    
	    //ajax 返回
		function showResponse(responseText, statusText) {
			var code = responseText.code;
			var msg = responseText.msg;
			if (code == "1") {
				  layer.alert(msg,{icon: 1}, function(index){
					  $("#table").bootstrapTable('refresh');
				 	  layer.close(index);
				});  
			} else {
				layer.msg(msg, {icon: 2});
			}
		}
	</script>
</#macro>