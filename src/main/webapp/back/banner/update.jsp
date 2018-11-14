<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#updateform").form('load','${pageContext.request.contextPath}/banner/showonebanner?id=${param.id}');
    })

</script>
<div style="text-align: center;font-size: 18px">
    <form id="updateform" class="easyui-form">
        <input  type="hidden" name="id" value="${param.id}"><br>
        <div style="margin-top: 50px">
            标题:<input class="easyui-textbox" name="title" style="width: 200px;height: 25px"><br>
        </div>
        <div style="margin-top: 20px">
            描述:<input name="desc" class="easyui-textbox" style="width: 200px;height: 25px">
        </div>

        <div style="margin-top: 20px">
            状态:<input class="easyui-textbox" name="status" style="width: 200px;height: 25px">
        </div>
    </form>
</div>
