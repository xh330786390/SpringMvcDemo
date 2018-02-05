<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加数据源</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="/resources/js/jquery-1.7.1.min.js"></script>
</head>
<body>
<form id="thisForm" action="">
    <br>
    <div class="row">
        <div class="col-lg-8 col-xs-offset-1">
            <h3>新增用户</h3>
            <table class="table table-bordered">

                <tr>
                    <td align="right">姓名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td align="right">
                        年龄：
                    </td>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button id="submit1" type="button" class="btn btn-default">新增</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
</body>
<script type="text/javascript">
    $("#submit1").click(function () {
        $.ajax({
            type: 'post',
            url: 'addUser',
            data: $('#thisForm').serialize(),
            dataType: 'json',
            success: function (data) {
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