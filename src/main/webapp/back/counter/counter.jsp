
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#countertable").datagrid({
            fitColumns:true,
            height:'100%',
            url:'${pageContext.request.contextPath}/counter/queryallcounter',
            saveUrl:'${pageContext.request.contextPath}/counter/addcounter',
            updateUrl:'${pageContext.request.contextPath}/counter/updatecounter',
            destroyUrl:'${pageContext.request.contextPath}/counter/deletecounter',
            autoSave:true,
            columns:[[
                {field:'id',title:'编号',width:70,align:'center'},
                {field:'title',title:'计数器名称',width:70,align:'center'},
                {field:'counter',title:'总计',width:70,align:'center'},
                {field:'recordDate',title:'创建时间',width:70,align:'center'},
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
        $.post("${pageContext.request.contextPath}/counter/deletecounter",{"id":id},function (result) {
            $("#countertable").datagrid('reload');
        });
    }
</script>
<table id="countertable"></table>
