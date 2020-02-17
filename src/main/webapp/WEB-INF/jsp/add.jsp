<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add1" method="post">
    <table>
        <tr>
            <th>添加回复</th>
        </tr>
        <tr>
            <td><strong>回复内容</strong><textarea name="content"></textarea></td>
        </tr>
        <tr>
            <td><strong>回复昵称</strong><input type="text" name="author"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"><a href="javascript:history.back();"><input type="button"
                                                                                            value="返回"></a>
                <input type="hidden" name="invid" value="${invid}"></td>
        </tr>
    </table>
</form>
</body>
</html>
