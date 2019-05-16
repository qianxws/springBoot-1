
var  vm = new Vue ({
	 el :'#body_div',
	 data :{
		 menusdatas :[],
	 },
	 //初始化页面函数
	 mounted(){
		 this.getData();
		 $(window).on('hashchange',function(){
			 vm.checkURL();
		 })
	 },
	 //方法函数
	 methods:{
		/* getData : function(){
			$.ajax({
				type :'post',
				url  : "/menu/getUserMenus.do",
				cache:false,
				dataType :'json',
				success:function (data){					
	               	 vm.menusdatas = data.menuList;
	               	 var menusdata = data.menuList;
	               	 var menu_data = {};
	    
	               	 for(var i = 0; i < menusdata.length; ++i ){	               		
	               		 if(menusdata[i].pid == '0'){
	               			menu_data[ menusdata[i].menuid] = {
	               				name : menusdata[i].name,
	               				child_menu : []
	               			};
	               		 }	
	               	 }
	               	 for(var j = 0; j < menusdata.length; ++j){
	               		if (menusdata[j].pid != '0' && menu_data[menusdata[j].pid]){
	               			menu_data[menusdata[j].pid].child_menu.push({
	               				name : menusdata[j].name,
	               				url : menusdata[j].url
	               			});
	               		}
	               	 }
	               	 console.log(menu_data);
	               	 vm.menusdatas = menu_data;
	           	               		               	 	               	 
				},
				error :function(data){
                   alert("请求出错!");
                }
			})							 
		 }*/
		 getData : function(){
			 DevMods.ajax('menu','getUserMenus').then(function(data){
				 if(data){
					 //vm.menusdatas = data.menuList;
	               	 var menusdata = data.menuList;
	               	 var menu_data = {};
	               	 for(var i = 0; i < menusdata.length; ++i ){	               		
	               		 if(menusdata[i].pid == '0'){
	               			menu_data[ menusdata[i].menuid] = {
	               				name : menusdata[i].name,
	               				child_menu : []
	               			};
	               		 }	
	               	 }
	               	 for(var j = 0; j < menusdata.length; ++j){
	               		if (menusdata[j].pid != '0' && menu_data[menusdata[j].pid]){
	               			menu_data[menusdata[j].pid].child_menu.push({
	               				name : menusdata[j].name,
	               				url : menusdata[j].url
	               			});
	               		}
	               	 }
	               	 console.log(menu_data);
	               	 vm.menusdatas = menu_data; 
				 } else {
					 alert("获取菜单异常");
				 }
				 
			 })		 
		 } ,	
	    checkURL : function (){
	    	var url = location.hash.replace(/^#/,'');
	    	debugger
	    	param = {};
	    	
	    	if(url){
	    		url =  url.replace(/^\//,'');
	    	/*	var urls = url.split('?');*/
	    		debugger
	    		vm.loadURL(url,$('#content'),function(){
	    			
	    		},function(){
	    			
	    		});
	    		           
	    	}
	    },
	    loadURL : function (url,container,successCallback,
	    		errorCallback){	    	
	    	$.ajax({
	    		type : 'GET',
	    		url  : url,
	    		dataType : 'html',
	    		cache : false,
	    		beforeSend : function (){
	    			container.html('<h1>Loading...</h1>');
	    		},
	    		success : function (data){
	    			container.css({
	    				opacity : '0.0'
	    			})
	    			  .html(data)
	    			  .delay(100)
	    			  .animate({
	    				  opacity : '1.0'
	    		    },300);
	    		   if (successCallback) successCallback();
	    		},
	    		error : function (xhr ,ajaxOptions ,thrownError){
	    			container.html(
	    				'<h4 style = "margin-top:10px; display : block; text-align:left " > Error 404! Page not found </h4>'	
	    		    );
	    			if(errorCallback) errorCallback();
	    		},
	    		async : false
	    		
	    	});	    	
	    }	 
	 }
})

