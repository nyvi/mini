jQuery.validator.addMethod("phone", function (value, element) {
    var length = value.length;
    var mobile = /^0?(13|15|18|14|17)[0-9]{9}$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "手机号码格式错误");

jQuery.validator.addMethod("postcode", function (value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的邮政编码");

jQuery.validator.addMethod("ip", function (value, element) {
    return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);
}, "请填写正确的IP地址。"); 

jQuery.validator.addMethod("notEqualTo", function(value, element, param) {
	 if(value == "" || $(param).val() == ""){
	 	return true;
	 }
     return value!=$(param).val();       
}, "请不要输入相同的值！");

/**
 * 大小比较
 * gt="#xx"
 */
jQuery.validator.addMethod("gt", function(value, element, param) {
	if (parseFloat(value) > parseFloat($(param).val())) {
		return true;
	}
	return false;
}, "要大于第一个数");

//保留 2位有效数字（校验小数）
jQuery.validator.addMethod("decimal2", function(value, element, param) {
   
  return this.optional(element) || /^\d+(\.\d{1,2})?$/.test(value);  
  
}, $.validator.format("只能输入2位小数！"));

//保留 2位有效数字（校验小数）
jQuery.validator.addMethod("decimal1", function(value, element, param) {
   
  return this.optional(element) || /^\d+(\.\d{1})?$/.test(value);  
  
}, $.validator.format("只能输入1位小数！"));