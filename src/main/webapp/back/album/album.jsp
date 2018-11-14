<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"  language="java" %>
<script>
$(function () {
    $("#albumtable").treegrid({
        height:'100%',
        url:'${pageContext.request.contextPath}/album/queryallalbum',
        idField:'id',
        treeField:'title',
        columns:[[
            {field:'id',title:'编号',width:200,align:'center'},
            {field:'title',title:'标题',width:200,align:'center'},
            {field:'size',title:'大小',width:70,align:'center'},
            {field:'duration',title:'时长',width:70,align:'center'},
            {field:'uploadTime',title:'上传日期',width:150,align:'center'},
        ]],
        toolbar:[{
            text:'专辑详情',
            iconCls:'icon-help',
            handler:function(){
                    $("#albumdesc").dialog({
                        title:'专辑详情',
                        href:'${pageContext.request.contextPath}/back/album/albumdesc.jsp',
                        width:900,
                        height:450,
                    });
                }
        },{
            text:'添加专辑',
            iconCls:'icon-add',
            handler:function(){
                $("#albumdialog").dialog({
                    title:'添加专辑',
                    href:'${pageContext.request.contextPath}/back/album/addalbum.jsp',
                    width:500,
                    height:400,
                    buttons:[{
                        text:'保存',
                        handler:function(){
                            $("#addalbum").form('submit',{
                                url:'${pageContext.request.contextPath}/album/addalbum',
                                success: function(){
                                    $("#albumdialog").dialog('close');
                                    $("#albumtable").treegrid('reload');
                                }
                            });
                        }
                    },{
                        text:'关闭',
                        handler:function(){
                            $("#albumdialog").dialog('close');
                            $("#albumtable").dialog('reload');
                        }
                    }]
                });
            }
        },{
            text:'添加章节',
            iconCls:'icon-add',
            handler:function(){
                var album = $("#albumtable").treegrid('getSelected');
                if(album==null){
                    alert("请选择一张专辑");
                }else{
                    $("#chapterdialog").dialog({
                        title:'添加专辑',
                        href:'${pageContext.request.contextPath}/back/album/addchapter.jsp?parent_id='+album.id,
                        width:500,
                        height:400,
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $("#addchapter").form('submit',{
                                    url:'${pageContext.request.contextPath}/chapter/addchapter',
                                    success: function(){
                                    $("#chapterdialog").dialog('close');
                                    $("#albumtable").treegrid('reload');
                                }
                                })
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#chapterdialog").dialog('close');
                            }
                        }]
                    });
                }
            }
        },{
            text:'下载音频',
            iconCls:'icon-download',
            handler:function(){
                $("#downloadchapter").dialog({
                    width:600,
                    height:450,
                    href:'${pageContext.request.contextPath}/back/album/chapterdownload.jsp'
                })
            }
    }]
    });
});
</script>
<table id="albumtable"></table>
<div id="albumdialog"></div>
<div id="onealbum"></div>
<div id="chapterdialog"></div>
<div id="albumdesc"></div>
<div id="downloadchapter"></div>