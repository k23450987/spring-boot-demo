<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<form action="${request.contextPath}/person/update" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>
                <input type="hidden" name="id" value="${person.id}">
                姓名<input name="name" type="text" title="name" value="${person.name}"/>
            </td>
        </tr>
        <tr>
            <td>
                性别<input name="sex" type="text" title="sex" value="${person.sex}"/>
            </td>
        </tr>
        <tr>
            <td>
                年龄<input name="age" type="text" title="age" value="${person.age}"/>
            </td>
        </tr>
        <tr>
            <td>
                电话<input name="phone" type="text" title="phone" value="${person.phone}"/>
            </td>
        </tr>
        <tr>
            <td>
                地址<input name="address" type="text" title="address" value="${person.address}"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>