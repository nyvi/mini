/**
 * 后台主页js
 */
$(function() {
	'use strict'

	$('[data-toggle="control-sidebar"]').controlSidebar();
	
	$('[data-toggle="push-menu"]').pushMenu();

	var $pushMenu = $('[data-toggle="push-menu"]').data('lte.pushmenu');
	
	var $controlSidebar = $('[data-toggle="control-sidebar"]').data('lte.controlsidebar');
	
	var $layout = $('body').data('lte.layout');
	
	var $sidebar = $('.control-sidebar');
	/**
	 * 所有主题皮肤
	 */
	var mySkins = [ 'skin-blue', 'skin-black', 'skin-red', 'skin-yellow',
			'skin-purple', 'skin-green', 'skin-blue-light', 'skin-black-light',
			'skin-red-light', 'skin-yellow-light', 'skin-purple-light',
			'skin-green-light' ]

	/**
	 * 从localStorage获取配置信息
	 */
	function get(name) {
		if (typeof (Storage) !== 'undefined') {
			return localStorage.getItem(name);
		} else {
			window.alert('Please use a modern browser to properly view this template!');
		}
	}

	/**
	 * 存放localStorage的值
	 */
	function store(name, val) {
		if (typeof (Storage) !== 'undefined') {
			localStorage.setItem(name, val);
		} else {
			window.alert('Please use a modern browser to properly view this template!');
		}
	}

	/**
	 * 切换布局
	 * @returns void
	 */
	function changeLayout(cls) {
		$('body').toggleClass(cls);
		if($layout){
			$layout.fixSidebar()
		}
		if($('body').hasClass(cls)){
			store('layout', cls)
		} else {
			store('layout', "")
		}
		$controlSidebar.fix();
		
	}

	/**
	 * 换肤
	 */
	function changeSkin(cls) {
		$.each(mySkins, function(i) {
			$('body').removeClass(mySkins[i])
		})
		$('body').addClass(cls);
		if(cls.indexOf("light") > -1){
			$sidebar.removeClass('control-sidebar-dark')
			$sidebar.addClass('control-sidebar-light')
		} else {
			$sidebar.removeClass('control-sidebar-light')
			$sidebar.addClass('control-sidebar-dark')
		}
		store('skin', cls)
		return false;
	}

	/**
	 * 加载默认配置
	 * @returns void
	 */
	function setup() {
		
		var skin = get('skin')
		if (skin && $.inArray(skin, mySkins)){
			//皮肤
			changeSkin(skin);
		}
		var layout = get('layout')
		if (layout){
			changeLayout(layout);
		}
		
		// Add the change skin listener
		$('[data-skin]').on('click', function(e) {
			if ($(this).hasClass('knob')) {
				return
			}
			e.preventDefault()
			changeSkin($(this).data('skin'));
		})
		
		$('[data-layout]').on('click', function () {
			changeLayout($(this).data('layout'))
	    })
		
		if ($('body').hasClass('layout-boxed')) {
			$('[data-layout="layout-boxed"]').attr('checked', 'checked')
	    }
	}

	setup()

	$('[data-toggle="tooltip"]').tooltip();
})
