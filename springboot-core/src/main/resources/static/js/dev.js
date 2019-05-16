
var DevMods = {
	ajax : function(action, verb, ajaxParams){
		var apiPath = ".".replace(/\?$/,'');
		var url ='/' + action + '/' + verb + '.do';			
		return new Promise(function(resolve,reject){
			var data = null;
			if(ajaxParams){
				if($.type(ajaxParamms) === "string"){
					data = {
					    'ajaxParams' : ajaxParams
					};					
				} else {
					data = {
						'ajaxParams' : JSON.stringify(ajaxParams)
					};
				}
			}
			$.ajax({
				type : 'post',
				url  : url ,
				data : data ,
				cache : false,
				dataType : 'json',
				success : function (data, textStatus , jqXHR){
					if (data.success == false && data.message.indexOf('重新登录') > -1){
						if(window.location.hash){
							DevBox.alert(data.message,function(){
								window.location.href = apiPath + '/login.html' + location.hash;
							});
						} else {
							window.location.href = apiPath + '/login.html';
							
						}
						return;				
					}
					resolve(data);			
				},
				error : function(XMLHttpRequest ,textStatus , errorThrown){
					reject(XMLHttpRequest);
				}			
		    });			
		})				
	},
	asyncAjax : function(action ,verb,ajaxParams,callback){
			var apiPath = Config.apiPath.replace(/\?$/,'');
			var url = apiPath + '/commMods/ajax?action=' + action + '&verb=' + verb;
			var data = null;
			if(ajaxParams){
				if($.type(ajaxParamms) === "string"){
					data = {
					    'ajaxParams' : ajaxParams
					};					
				} else {
					data = {
						'ajaxParams' : JSON.stringify(ajaxParams)
					};
				}
			}
			$.ajax({
				type : 'post',
				url  : url ,
				data : data ,
				cache : false,
				async : false, 
				dataType : 'json',
				success : function (data, textStatus , jqXHR){
					if (data.success == false && data.message.indexOf('重新登录') > -1){
						if(window.location.hash){
							DevBox.alert(data.message,function(){
								window.location.href = apiPath + '/login.html' + location.hash;
							});
						} else {
							window.location.href = apiPath + '/login.html';
							
						}
						return;				
					}
					if(callback)
						callback(data);						
		    },
		    error : function(XMLHttpRequest , textStatus,errorThrown){
		    	 alert("请求出错!");
		    }
		 });   
     },
        get : function (url ,success,error){
        	$.ajax({
        		type : 'get',
        		url :url,
        		cache : false ,
        		dataType : 'json',
        		success : function (data, textStatus , jqXHR){
        			if(success)
        				success(data)
        		},
        		  error : function(XMLHttpRequest , textStatus,errorThrown){
        			  if(error)
        				  error(XMLHttpRequest);
        		  }
        	})       	
        },
        post : function (url ,success,error){
        	$.ajax({
        		type : 'post',
        		url :url,
        		cache : false ,
        		data : data,
        		dataType : 'json',
        		success : function (data, textStatus , jqXHR){
        			if(success)
        				success(data)
        		},
        		  error : function(XMLHttpRequest , textStatus,errorThrown){
        			  if(error)
        				  error(XMLHttpRequest);
        		  }
        	})       	
        },
                                     
 }









