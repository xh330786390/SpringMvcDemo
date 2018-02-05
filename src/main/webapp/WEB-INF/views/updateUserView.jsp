<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="/resources/js/jquery-1.7.1.min.js"></script>
</head>
<body>
<form id="thisForm" action="">
    <br>
    <div class="row">
        <div class="col-lg-8 col-xs-offset-1">
            <h3>修改用户</h3>
            <table class="table table-bordered">

                <tr>
                    <td align="right">姓名：</td>
                    <td><input type="text" name="name" value="${User.name}"></td>
                </tr>
                <tr>
                    <td align="right">
                        年龄：
                    </td>
                    <td>
                        <input type="text" name="age" value="${User.age}">
                        <input type="hidden" name="id" value="${User.id}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><button id="submit1" type="button" class="btn btn-default">修改</button></td>
                </tr>
            </table>
        </div>
    </div>
</form>
</body>
<script type="text/javascript">
    $("#submit1").click(function() {
        $.ajax({
            type : 'post',
            url : 'updateUser',
            data : $('#thisForm').serialize(),
            dataType : 'json',
            success : function(data) {
                if (data > 0) {
                    alert("成功");
                } else {
                    alert("失败")
                }
                location.href = "selectUser";
            }
        })
    })
</script>
</html>