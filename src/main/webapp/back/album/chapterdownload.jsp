
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $("#chapterload").datagrid({
            url:'${pageContext.request.contextPath}/chapter/queryallchapter',
            columns:[[
                {field:'id',title:'编号',width:50,align:'center'},
                {field:'title',title:'章节名称',width:70,align:'center'},
                {field:'size',title:'大小',width:70,align:'center'},
                {field:'duration',title:'时长',width:70,align:'center'},
                {field:'downPath',title:'下载路径',width:150,align:'center'},
                {field:'options',title:'操作',width:150,align:'center',
                    formatter:function (value,row,index) {
                        return "<a href=\"${pageContext.request.contextPath}/chapter/downloadchapter?filename="+row.downPath+"\" class='options' onclick=\"Row('"+row.downPath+"')\" data-options=\"iconCls:'icon-download'\">下载</a>&nbsp"
                    }
                }
            ]],
            onLoadSuccess: function () {
                $(".options").linkbutton();
            },
        })
    });
function Row(id) {
    
}
</script>
<table id="chapterload"></table>
