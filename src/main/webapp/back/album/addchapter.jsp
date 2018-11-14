
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"  language="java" %>
<form  id="addchapter" class="easyui-form" enctype="multipart/form-data" method="post">
    <input  type="hidden" name="album_id" value="${param.parent_id}"/>
    <div style="margin-top: 50px;text-align: center;">
        标　　题:<input type="text" name="title" class="easyui-textbox"/>
    </div>
    <div style="margin-top: 20px;text-align: center;">
        选择文件:<input  name="file" class="easyui-filebox" data-options="buttonText: '请选择文件'"/>
    </div>
</form>

