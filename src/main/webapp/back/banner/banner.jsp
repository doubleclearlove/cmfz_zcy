<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $("#bannertable").edatagrid({
            fitColumns:true,
            autoSave:true,
            height:'200',
            url:'${pageContext.request.contextPath}/banner/showallbanner',
            updateUrl:'${pageContext.request.contextPath}/banner/updatebanner',
            columns:[[
                {field:'id',title:'编号',width:100,align:'center'},
                {field:'title',title:'标题',width:100,align:'center',editor:{type:'text'}},
                {field:'imgPath',title:'路径',width:200,align:'center',editor:{type:'text'}},
                {field:'desc',title:'描述',width:100,align:'center',editor:{type:'text'}},
                {field:'status',title:'状态',width:100,align:'center',editor:{type:'text'}},
                {field:'createDate',title:'创建日期',width:100,align:'center',editor:{type:'datebox'}},
                {field:'options',title:'操作',width:150,align:'center',
                    formatter:function (value,row,index) {
                        return "<a href='javascript:;' class='options' onclick=\"deleteRow('"+row.id+"')\" data-options=\"iconCls:'icon-delete'\">删除</a>&nbsp"
                    }
                }
            ]],
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
            view:detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src=\"${pageContext.request.contextPath}'+rowData.imgPath+'\" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>CreateDate: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar: [{
                text:'添加',
                iconCls: 'icon-add',
                handler: function(){
                    $("#addbannerdialog").dialog({
                        title:"添加轮播图",
                        width:400,
                        height:300,
                        draggable:false,
                        href:'${pageContext.request.contextPath}/back/banner/add.jsp',
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                    $("#addform").form('submit',{
                                            url:'${pageContext.request.contextPath}/banner/addbanner',
                                            success: function(){
                                                $("#addbannerdialog").dialog('close');
                                                $("#bannertable").datagrid('reload');
                                        }

                                    });
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#addbannerdialog").dialog('close');
                                $("#bannertable").datagrid('reload');
                            }
                        }]
                    });
                }
            }]
        })
    });
    function deleteRow(id) {
        $.post("${pageContext.request.contextPath}/banner/deletebanner",{"id":id},function (result) {
            $("#bannertable").datagrid('reload');
        });
    }
    /*function updateRow(id) {
        $("#updatebannerdialog").dialog({
            title:'修改轮播图',
            width:450,
            height:350,
            href:'${pageContext.request.contextPath}/back/banner/update.jsp?id='+id,
            buttons:[{
                text:'保存',
                handler:function(){
                    $("#updateform").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/updatebanner',
                        success:function (result) {
                            $("#updatebannerdialog").dialog('close');
                            $("#bannertable").datagrid('reload');
                            $.messager.show({title:'提示',msg:"用户信息修改成功!!!"});
                        }
                    });
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#updatebannerdialog").dialog('close');
                }
            }]
        });
    }*/
</script>
<table  id="bannertable"></table>
<div id="addbannerdialog"></div>
<div id="updatebannerdialog"></div>



