<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<script>
        $(function () {
            $("#updateform").form('load','${pageContext.request.contextPath}/user/qoeryoneuser?id='+${sessionScope.admin.id});
        });
</script>
<div style="text-align: center;font-size: 18px">
    <form id="updateform" class="easyui-form">
        <input type="hidden" name="id" value="${sessionScope.admin.id}"><br>
        <div style="margin-top: 50px">
            账　号:<input class="easyui-textbox"   name="name" value="${sessionScope.admin.name}" style="width: 200px;height: 25px"><br>
        </div>
        <div style="margin-top: 20px">
            原密码:<input class="easyui-passwordbox" data-options="showEye:true"  name="password" style="width: 200px;height: 25px"><br>
        </div>
        <div style="margin-top: 20px">
            新密码:<input type="text" name="newpassword" class="easyui-passwordbox" data-options="prompt:'请输入新密码',showEye:true" style="width: 200px;height: 25px">
        </div>
    </form>
</div>