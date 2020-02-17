<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="show" method="post">
    <table border="1">
        <tr>
            <td style="border: 2px;padding: 0px 0px 0px 100px"><h1>回复信息列表</h1></td>
        </tr>
        <tr>
            <td style="border: 2px;padding: 0px 0px 0px 300px"><a href="add">添加回复</a><a href="all">返回帖子列表</a>
            </td>
        </tr>
        <tr bgcolor="aqua">
            <td>回复内容</td>
            <td>回复昵称</td>
            <td>发布时间</td>
        </tr>
        <c:forEach items="${replyList}" var="i">
            <tr>
                <td>
                        ${i.content}
                </td>
                <td>
                        ${i.author}
                </td>
                <td>
                    <fmt:formatDate value="${i.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
            </tr>
        </c:forEach>
    </table>
    第${page1.pageNo}/${page1.pageCount}页
    <a href="javascript:doPage(1);">首页</a>
    <a href="javascript:doPage(${page1.pageNo-1});">上一页</a>
    <a href="javascript:doPage(${page1.pageNo+1});">下一页</a>
    <a href="javascript:doPage(${page1.pageCount});">末页</a>
    <input type="hidden" name="pageNo">
    <input type="hidden" name="invid" value="${invid}">
    <script src="js/jquery-1.12.4.js"></script>
    <script>
        function doPage(i) {
            $("[name=pageNo]").val(i);
            $("form").submit();
        }
    </script>
</form>
</body>
</html>
