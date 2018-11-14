
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#usertable").edatagrid({
            fitColumns:true,
            height:'100%',
            url:'${pageContext.request.contextPath}/user/showall',
            saveUrl:'${pageContext.request.contextPath}/user/adduser',
            updateUrl:'${pageContext.request.contextPath}/user/updateuser',
            destroyUrl:'${pageContext.request.contextPath}/user/deleteuser',
            autoSave:true,
        columns:[[
                {field:'id',title:'编号',width:70,align:'center'},
                {field:'phone',title:'手机号',width:70,align:'center',editor:{type:'text'}},
                {field:'username',title:'用户名',width:70,align:'center',editor:{type:'text'}},
                {field:'province',title:'省份',width:70,align:'center',editor:{type:'text'}},
                {field:'city',title:'城市',width:70,align:'center',editor:{type:'text'}},
                {field:'nickName',title:'昵称',width:70,align:'center',editor:{type:'text'}},
                {field:'sex',title:'性别',width:70,align:'center',editor:{type:'text'}},
                {field:'sign',title:'个性签名',width:100,align:'center',editor:{type:'text'}},
                {field:'headPic',title:'头像',width:150,align:'center',editor:{type:'text'}},
                {field:'status',title:'状态',width:70,align:'center',editor:{type:'text'}},
                {field:'options',title:'操作',width:70,align:'center',
                    formatter:function (value, row, index) {
                          return "<a href='javascript:;' class='options' onclick=\"deleteRow('"+row.id+"')\" data-options=\"iconCls:'icon-delete'\">删除</a>&nbsp"
                 }
            }
            ]],
            view:detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src=\"${pageContext.request.contextPath}'+rowData.headPic+'\" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>CreateDate: ' + rowData.nickName + '</p>' +
                    '<p>Status: ' + rowData.sex + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
        });
    });
    function deleteRow(id) {
        $.post("${pageContext.request.contextPath}/user/deleteuser",{"id":id},function (result) {
            $("#usertable").datagrid('reload');
        });
    }
</script>
<table  id="usertable"></table>

