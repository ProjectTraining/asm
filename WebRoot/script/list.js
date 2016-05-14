var MainGrid = null;
//从MainGrid中删除数据
function deleteObjFromMainGrid(pk,rowid,action){
	var keyName = $("#MainGrid").attr("keyname");
	 if(pk=="undefined"){
		 MainGrid.deleteRow(rowid);		 
     }else{
    	 var data =keyName+"="+pk;
		 var submit = function (v, h, f) {
		    if (v == 'ok'){
		        $.ajax({
			    	 url:action+pk,
			 
			    	 type:'POST',
			    	 contentType: "text/html;charset=UTF-8", 
			    	 dataType: 'json',
			    	 cache:false,
			    	 success:function(result){
						 if(result==true){
							 MainGrid.deleteRow(rowid);
							 $.jBox.tip('删除成功！');
					     }else{
					 
						 }
			    	 }
				 });
		    }
		    return true; //close
		};
		
		$.jBox.confirm("确定删除吗？", "提示", submit,{width:350,height:60}); 
	 } 
 }


function deleteObj(action){
	var submit = function (v, h, f) {
		    if (v == 'ok'){
		        $.ajax({
			    	 url:action,
			    	 type:'POST',
			    	 contentType: "text/html;charset=UTF-8", 
			    	 dataType: 'json',
			    	 cache:false,
			    	 success:function(result){
						 if(result==true){
							 window.location.reload();  
							 $.jBox.tip('删除成功！');
					     }else{
					 
						 }
			    	 }
				 });
		    }
		    return true; //close
		};
		
		$.jBox.confirm("确定删除吗？", "提示", submit,{width:350,height:60}); 
	 
 }

function changeState(pk,tip,action,state){
	var keyName = $("#MainGrid").attr("keyname");
	 if(pk=="undefined"){
		return; 
     }else{
    	 
		  $.ajax({
			    	 url:action+pk+'&state='+state,
			 
			    	 type:'POST',
			    	 contentType: "text/html;charset=UTF-8", 
			    	 dataType: 'json',
			    	 cache:false,
			    	 success:function(result){
						 if(result==true){
							 MainGrid.loadData(true);
							 $.jBox.tip(tip);
					     }else{
					    	
						 }
			    	 }
				 });
		
		    return true; //close
	 } 
 }
function resetPassword(pk,tip,action){
	 if(pk=="undefined"){
		return; 
     }else{
		  $.ajax({
			    	 url:action+pk,
			    	 type:'POST',
			    	 contentType: "text/html;charset=UTF-8", 
			    	 dataType: 'json',
			    	 cache:false,
			    	 success:function(result){
						 if(result==true){
							 $.jBox.tip(tip);
					     }else{
					    	
						 }
			    	 }
				 });
		
		    return true; //close
	 } 
 }

var showDialogIncludeButton = function(url,title,width,height){
	 width = width?width:$(window).width()*0.7;
	 width>=500?width:500;
	 height = height?height:$(window).height()-50;
	 height>=350?height:350;
	 var height2 = $(window).height();
	 var topHeight = (height2-height)/2;
	 $.jBox("iframe:"+url, {
	    title: title,
	    showScrolling:false,
	    width: width,
	    id:'id-jbox-dialog',
	    height: height,
	    top:topHeight,
	    zIndex:2000,
	    submit:function(v,h,f){
	    	if(v==1){
	    		if($.isFunction(window.frames["jbox-iframe"].submitForm)){
					window.frames["jbox-iframe"].submitForm();
				}
	    		return false;
	    	}
	    	return true;
	    },
	    buttons: { '关闭': "0" , '保存': "1" } 
	 });
};

var showDialog = function(url,title,width,height){
	 width = width?width:$(window).width()*0.7;
	 var height2 = $(window).height();
	 height = height?height:height2-50;
	 var topHeight = (height2-height)/2;
	 $.jBox("iframe:"+url, {
	    title: title,
	    width: width,
	    height: height,
	    top:topHeight
	 });
};
function AddNews(id,name,title) {
	var height = $(window).height()-60;
	var options = {
		title : title,
		width : 700,
		height : height,
		id : 'jbox-select-single-res',
		top : 25,
		buttons : {
			'确定选择' : true
		},
		submit : function(v, h, f) {
			var rows = h.find('iframe')[0].contentWindow.MainGrid
					.getSelectedRows();
			if (rows == null || rows.length == 0) {
				return false;
			} else if (rows.length == 1) {
				$("#"+id).val(rows[0].id);
				$("#"+name).text(" "+rows[0].province+" "+rows[0].city +" "+rows[0].county+" "+ rows[0].exact+" "+ rows[0].name+" "+ rows[0].phone);
				return true;
			} else {
				$.jBox.tip('添加失败！');
				return false;

			}
		}
	};
	showDialogWithOptions('addressAction_selectAddressPage.action', options);
}
var showDialogWithOptions = function(url,options){
	 $.jBox("iframe:"+url, options);
};

function selectProduct(id,name,title) {
	var height = $(window).height()-60;
	var options = {
		title : title,
		width : 600,
		height : height,
		id : 'jbox-select-single-res',
		top : 25,
		buttons : {
			'确定选择' : true
		},
		submit : function(v, h, f) {
			var rows = h.find('iframe')[0].contentWindow.MainGrid
					.getSelectedRows();
			if (rows == null || rows.length == 0) {
				return false;
			} else if (rows.length == 1) {
				$("#"+id).val(rows[0].Id);
				$("#"+name).text(rows[0].title);
				return true;
			} else {
				$.jBox.tip('添加失败！');
				return false;

			}
		}
	};
	showDialogWithOptions('productAction_selectProductPage.action', options);
}
function SubmitQuery(){
	var deptId= $("#deptId").val();
	var userName= $("#userName").val();
	var roleId= $("#roleId").val();
	var stateStr= $("#stateStr").val();
	MainGrid.set({url:'userAction_listUser.action?deptId='+deptId+'&userName='+userName+'&roleId=' +roleId+'&stateStr='+stateStr});
	MainGrid.loadData(true);

}


