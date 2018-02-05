<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:directive.page import="com.tengxh.entity.User"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SSM���-����Դ�б�</title>
    <!-- css�ļ� -->
    <link rel="stylesheet" href="${path}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${path}/resources/css/bootstrap-theme.min.css">
    <!-- js�ļ� -->
    <script type="text/javascript" src="${path}/resources/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript">
        function MemAdd() {
            window.location.href = "addUserView";
        }

        function deleteUser(id) {
            if (confirm('ȷ��ɾ��?')) {
                $.ajax({
                    type: 'post',
                    url: 'deleteUser?Id=' + id,
                    async: false,
                    dataType: 'json',
                    success: function (data) {
                        if (data > 0) {
                            alert("�ɹ�");
                        } else {
                            alert("ʧ��")
                        }
                        window.location.reload();
                    }
                });
            }
        }
    </script>
</head>
<body>
<form>
    <br>
    <div class="row">
        <div class="col-lg-8 col-xs-offset-1">
            <table class="table table-bordered">
                <tr>
                    <th>����</th>
                    <th>����</th>
                    <th>����&nbsp;&nbsp;
                        <button type="button" class="btn btn-default btn-sm" onclick="MemAdd()">����</button>
                    </th>
                </tr>
                <c:choose>
                    <c:when test="${not empty requestScope.list }">
                        <c:forEach items="${requestScope.list}" var="item">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.age}</td>
                                <td><a href="updateUserView?Id=${item.id}">�༭</a>&nbsp;&nbsp;
                                    <a href='javascript:void(0)' onclick="deleteUser(${item.id})">ɾ��</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>

                        û���������
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</form>
</body>