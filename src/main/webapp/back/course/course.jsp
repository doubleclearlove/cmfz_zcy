
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#coursetable").edatagrid({
            fitColumns:true,
            height:'100%',
            url:'${pageContext.request.contextPath}/course/queryallcourse',
            saveUrl:'${pageContext.request.contextPath}/course/addcourse',
            updateUrl:'${pageContext.request.contextPath}/course/updatecourse',
            destroyUrl:'${pageContext.request.contextPath}/course/deletecourse',
            autoSave:true,
          /*  toolbar: [{
                iconCls: 'icon-add',
                text:'添加',
                handler: function(){
                    $("#usertable").edatagrid('addRow');
                }
            }],*/
            columns:[[
                {field:'id',title:'编号',width:70,align:'center'},
                {field:'title',title:'功课',width:70,align:'center'},
                {field:'marking',title:'标题',width:70,align:'center'},
                {field:'createTime',title:'创建时间',width:70,align:'center'},
                {field:'options',title:'操作',width:70,align:'center',
                    formatter:function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"deleteRow('"+row.id+"')\" data-options=\"iconCls:'icon-delete'\">删除</a>&nbsp"
                    }
                }
            ]],
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
        });
        });
    function deleteRow(id) {
        $.post("${pageContext.request.contextPath}/course/deletecourse",{"id":id},function (result) {
            $("#coursetable").datagrid('reload');
        });
    }
</script>
<table id="coursetable"></table>
