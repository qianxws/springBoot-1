
var  vm = new Vue ({
	 el :'#body_div',
	 data :{
		 menusdatas :[],
	 },
	 //初始化页面函数
	 mounted(){
		 this.getData();
	 },
	 //方法函数
	 methods:{
		 getData : function(){
			$.ajax({
				type :'post',
				url  : "/menu/getUserMenus.do",
				cache:false,
				dataType :'json',
				success:function (data){					
	               	/* vm.menusdatas = data.menuList;*/
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
		 }
	 }
})

