<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="all" method="post">
    <table border="1">
        <tr>
            <th style="border: 2px;padding: 0px 0px 0px 100px">帖子列表</th>
        </tr>
        <tr>
            <td style="border: 2px;padding: 0px 0px 0px 100px">帖子标题:
                <input type="text" name="title"
                       <c:if test="${title!=null}">value="${title}"</c:if> >
                <input type="submit" value="搜索">
            </td>
        </tr>
        <tr bgcolor="aqua">
            <td>标题</td>
            <td>内容摘要</td>
            <td>作者</td>
            <td>发布时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${all}" var="i">
            <tr>
                <td>${i.title}</td>
                <td>${i.summary}</td>
                <td>${i.author}</td>
                <td><fmt:formatDate value="${i.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                <td><a href="show?invid=${i.id}">查看回复</a>||<a href="javascript:dele(${i.id});">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <span>${result}</span>
    第${page.pageNo}/${page.pageCount}页
    <a href="javascript:doPage(1);">首页</a>
    <a href="javascript:doPage(${page.pageNo-1});">上一页</a>
    <a href="javascript:doPage(${page.pageNo+1});">下一页</a>
    <a href="javascript:doPage(${page.pageCount});">末页</a>
    <input name="pageNo" type="hidden">
</form>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(document).ready(color());

    function color() {
        $("tr:gt(2):even").css("background", "orange");
    }

    function doPage(i) {
        $("[name=pageNo]").val(i);
        $("form").submit();
    }

    function dele(s) {
        var i = confirm("确认删除该条发帖及相关回复?");
        if (i)
            location.href = "dele?id=" + s;
    }
</script>

</body>
</html>
