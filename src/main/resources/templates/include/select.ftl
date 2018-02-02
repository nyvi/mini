<#macro select id list label="" key="" text="" value=""  headkey="" headvalue="" class="form-group" rule="" search="false">
	<#if key == "" >
		<#local key = "id" />
	</#if>
	<#if text == "" >
		<#local text = "status" />
	</#if>
   <#if label != "">
       <label class="control-label">${label}</label>
   </#if>
    <div class="${class}">
       <select id="${id}" name="${id}" class="form-control selectpicker" ${rule} data-live-search="${search}" data-size="10">
	    <#if headvalue != "">
	      <option data-tokens="${headvalue}" value="${headkey}">${headvalue}</option>
	    </#if>
		<#if list?? && list?size gt 0 >
	       	<#list list as data>
	        	<option data-tokens="${data[text]}" value="${data[key]}" <#if value == data[key]?string>selected</#if> >${data[text]}</option>
	      	</#list>
		</#if>
      </select>
   </div>
</#macro>
<#macro radio name list  key="" text="" value="" class="form-group"  >
	<#if key == "" >
		<#local key = "id" />
	</#if>
	<#if text == "" >
		<#local text = "status" />
	</#if>
	<div class="${class}">
		<div class="radio">
			<#if list?? && list?size gt 0 >
				<#list list as data>
			    <label>
			      <input type="radio" id="iradio_${name}_${data[key]}" class="iradio" name="${name}"  value="${data[key]}" <#if value == data[key]?string>checked="checked"</#if> >
			      <label for="iradio_${name}_${data[key]}"></label> ${data[text]}
			    </label>
			    </#list>
			</#if>
		 </div>
	</div>
</#macro>
<#macro checkbox name list  key="" text="" value="" label="" data_name="" data_key="" class="form-group">
	<#if key == "" >
		<#local key = "id" />
	</#if>
	<#if text == "" >
		<#local text = "status" />
	</#if>
	<#local val = ""/>
	  <div class="${class}">
          <div class="checkbox">
          	<#if label != "">
	           <label>${label}</label>
	        </#if>
          	<#if list?? && list?size gt 0 >
				<#list list as data>
				<#list value?split(",") as v>
		          <#if v == data[key]?string>
		             <#local val = v/>
		          </#if>
		        </#list>
                   <label>
    			      <input type="checkbox" id="icheck_${name}_${data[key]}" class="icheck" name="${name}"  value="${data[key]}" <#if data_name!="">data-${data_name}=${data[data_key]}</#if> <#if val == data[key]?string>checked="checked"</#if> >
    			      <label for="icheck_${name}_${data[key]}"></label> ${data[text]}
                   </label>
			    </#list>
			</#if>
          </div>
      </div>
</#macro>