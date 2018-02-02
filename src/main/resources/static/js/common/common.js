$(function() {
	// 弹出层默认配置
	layer.config({
		shade : [ 0.3, '#000' ],
		offset : '150px'
	});

	// 加载效果
	$(document).ajaxStart(function() {
		layer.load(0, {
			shade : false
		});
	}).ajaxStop(function() {
		layer.closeAll('loading');
	});

	// 后退
	$(".back").click(function() {
		history.back();
		return;
	})

	// 重置表单
	$("#reset,[id^='reset']").click(function() {
		var form = $(this).parents("form");
		form.find(".form-group").removeClass('has-error'); // 移除错误样式
		form.find("label.error").remove(); // 移除错误提示
		form.resetForm(); // 重置表单
		return;
	})

	// 删除 form 表单提交
	$("#del").click(function() {
		var checkCount = $("#deleteForm [name=checkedid]:checked").length;
		if (checkCount == 0) {
			layer.msg("请选择要删除的记录!", {
				icon : 0
			});
		} else {
			layer.confirm('你确定要删除所选记录？', function() {
				var options = {
					success : showResponse
				};
				$("#deleteForm").ajaxSubmit(options);
			});
		}
		return;
	})

	// 保存 form 表单提交
	$("#submit").click(function() {
		if (validateForm()) {
			var options = {
				success : showResponse
			}
			$("#saveForm").ajaxSubmit(options);
		}
		return;
	})

	// 文本框前后去空格
	$("form input").blur(function() {
		$(this).val($.trim($(this).val()));
		return;
	})
	
	//表格重新布局
	$(window).resize(function() {
		$('[data-toggle="table"]').bootstrapTable('resetView');
	});

	// 表单回车不自动提交
	$("form").keydown(function() {
		if (event.keyCode == 13)
			return false;
	})
})

// 表单查询条件
function queryParams(params) {
	var query = $("#searchForm").serializeJSON();
	query["pageNumber"] = params.pageNumber;
	query["pageSize"] = params.pageSize;
	if (params.sortName) {
		query["order"] = params.sortName + " " + params.sortOrder;
	}
	return query;
}

//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);    // 匹配目标参数
	if (r != null)
		return decodeURIComponent(r[2]);
	return null; // 返回参数值
}

// 状态显示
// 柔和灰（text-muted）、主要蓝（text-primary）、成功绿（text-success）、信息蓝（text-info）、警告黄（text-warning）、危险红（text-danger）
function statusFormatter(value) {
	if (value == "0") {
		return "<span class='text-danger'>禁用</span>";
	}
	if (value == "1") {
		return "<span>启用</span>";
	}
}

// 时间格式化,默认时间参数yyyy-MM-dd HH:mm
function dateFormatter(value, row, index) {
	return new Date(parseInt(value)).Format("yyyy-MM-dd HH:mm");
}

/**
 * 时间格式化
 * format 时间格式
 */ 
Date.prototype.Format = function (format) {
	var map = {  
	     "y": this.getFullYear(),  // 年
		 "M": this.getMonth() + 1, // 月
	     "d": this.getDate(), 	   // 日
	     "H": this.getHours(),     // 时
	     "m": this.getMinutes(),   // 分
	     "s": this.getSeconds(),   // 秒
	     "q": Math.floor((this.getMonth() + 3) / 3), // 季度
	     "S": this.getMilliseconds() // 毫秒
	};  
	format = format.replace(/([yMdHms])+/g, function(all, t) {
		var v = map[t];
		if (v !== undefined) {
			if (v < 10) {
				return "0" + v;
			}
			return v
		}
		return all
	});
	return format;
}

var util = {
	
	/**
	 * 字符串转json对象
	 * @param str 字符串
	 * @returns
	 */
	toJson : function(str) {
		return JSON.parse(str || "{}");
	},
	
	/**
	 * json对象转字符串
	 * @param obj
	 * @returns
	 */
	toString : function(obj) {
		return JSON.stringify(obj || "");
	},
	
	/**
	 * 占位符输出 用法:util.strFormat("123%s5%s",4,6),输出123456
	 * @param str
	 * @returns
	 */
	strFormat : function(str) {
		var args = arguments, flag = true, i = 1;

		str = str.replace(/%s/g, function() {
			var arg = args[i++];

			if (typeof arg === 'undefined') {
				flag = false;
				return '';
			}
			return arg;
		});
		return flag ? str : '';
	}
}
 

// 修改 Validation 配置
$.validator.setDefaults({
	highlight : function(element) {
		$(element).closest('.form-group').addClass('has-error');
	},
	success : function(element) {
		element.closest('.form-group').removeClass('has-error');
		$(element).remove();
	},
	errorPlacement : function(error, element) {
		if (element.is(":radio") || element.is(":checkbox")) {
			error.appendTo(element.parent().parent().parent());
		} else {
			error.appendTo(element.parent());
		}
	},
	errorClass : "error",
	validClass : "valid"
});

/**
 * 表单属性转json
 * <p>
 * 去除空字段
 */
$.fn.serializeJSON = function() {
	var json = {};
	var form = this.serializeArray();
	$.each(form, function() {
		if (this.value) {
			if (json[this.name]) {
				if (!json[this.name].push) {
					json[this.name] = [ json[this.name] ];
				}
				json[this.name].push(this.value);
			} else {
				json[this.name] = this.value;
			}
		}
	});
	return json;
}
