<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
   $(function () {
       $("#chapter").datagrid({
           url:'${pageContext.request.contextPath}/album/queryallalbum',
           columns:[[
               {field:'id',title:'编号',width:50,align:'center'},
               {field:'title',title:'专辑名称',width:70,align:'center'},
               {field:'publishDate',title:'发布日期',width:70,align:'center'},
               {field:'count',title:'级数',width:70,align:'center'},
               {field:'coverImg',title:'封面',width:150,align:'center'},
               {field:'star',title:'星级',width:100,align:'center'},
               {field:'author',title:'作者',width:100,align:'center'},
               {field:'broadCast',title:'播音',width:100,align:'center'},
               {field:'brief',title:'简介',width:70,align:'center'}
           ]],
       });
   });
   function upload(id) {
       alert(id);
   }
</script>
<table id="chapter"></table>