<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/form.validator.rules.js"></script>
<script type="text/javascript">
	<!--修改密码处理-->
    function update() {
        $("#xgmm").dialog({
           width:500,
           height:400,
           title:"修改密码",
            href:'${pageContext.request.contextPath}/back/user/update.jsp',
            buttons:[{
                text:'保存',
                handler:function(){
                    $("#updateform").form('submit',{
                        url:'${pageContext.request.contextPath}/cmfz/updateadmin',
                        success: function(){
                            $("#xgmm").dialog('close');
                            location.href='${pageContext.request.contextPath}/cmfz/admingoout';
                        }
                    })
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#xgmm").dialog('close');
                }
            }]
        });
    }
    /*菜单*/
    $(function () {
        if(${sessionScope.admin==null}){
            location.href="${pageContext.request.contextPath}/back/login.jsp";
        }
        $.post("${pageContext.request.contextPath}/menu/queryallMenu",function (menu) {
            $.each(menu,function (index, m) {
                var context="<div style='text-align: center;'>";
                $.each(m.menus,function (idx, cmenu) {
                    context +="<a onclick=\"addtabls('"+cmenu.title+"','"+cmenu.iconCls+"','"+cmenu.href+"')\" style='width:95%;margin:10px 0px;border:2px #00ee00 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+cmenu.iconCls+"'\">"+cmenu.title+"</a><br>"
                });
                context +="</div>"
                $("#aa").accordion('add',{
                    title:m.title,
                    iconCls:m.iconCls,
                    content:context,
                })
            })
        });
    });
    function addtabls(title,iconCls,href){
        if(!$("#tt").tabs('exists',title)){
            $("#tt").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+href,
            });
        }else{
            $("#tt").tabs('select',title);
        }
    }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name} &nbsp;<a href="#" class="easyui-linkbutton" onclick="update()" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/cmfz/admingoout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
    <div id="xgmm" ></div>
</body> 
</html>