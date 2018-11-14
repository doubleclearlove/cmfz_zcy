<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#gurutable").edatagrid({
            fitColumns:true,
            url:'${pageContext.request.contextPath}/guru/queryallguru',
            saveUrl:'${pageContext.request.contextPath}/guru/addguru',
            updateUrl:'${pageContext.request.contextPath}/guru/updateguru',
            height:'100%',
            autoSave:true,
            toolbar: [{
                iconCls: 'icon-add',
                text:'添加',
                handler: function(){
                    $("#gurutable").edatagrid('addRow');
                }
            }],
        columns:[[
                {field:'id',title:'编号',width:70,align:'center'},
                {field:'name',title:'称呼',width:70,align:'center',editor:{type:'text'}},
                {field:'headPic',title:'头像',width:70,align:'center',editor:{type:'text'}},
                {field:'sex',title:'性别',width:70,align:'center',editor:{type:'text'}},
                {field:'options',title:'操作',width:70,align:'center',
                    formatter:function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"deleteRow('"+row.id+"')\" data-options=\"iconCls:'icon-delete'\">删除</a>&nbsp"

                    }
                }
            ]] ,
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
            view:detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src=\"${pageContext.request.contextPath}'+rowData.headPic+'\" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>CreateDate: ' + rowData.name + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

        });
    });
    function deleteRow(id) {
        $.post("${pageContext.request.contextPath}/guru/deleteguru",{"id":id},function (result) {
            $("#gurutable").datagrid('reload');
        });
    }
</script>
<table id="gurutable"></table>