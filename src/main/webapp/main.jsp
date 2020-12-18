<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>My super project!</title>
</head>
<body>
<!-- header -->
<div>
    <h1>Archive</h1>
</div>
<c:url value="/main" var="url"/>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <table class="table">
                <thead class="table-sub-heading-color">
                    <tr>
                        Архив
                    </tr>
                    <tr>
                        <td>
                            имя
                        </td>
                    </tr>
                <tr>
                    <form id="addArchive" action="${url}" method="post">
                        <td>
                            <input type="text" name="name">
                        </td>
                        <td>
                            <button type="submit" name="action" value="addArchive" form="addArchive"> add</button>
                        </td>
                    </form>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="archive" items="${applicationScope['archives']}">
                    <tr>
                        <td>
                            ${archive.name}
                        </td>
                        <td>
                            <form action="${url}" method="post">
                                <input type="hidden" name="id" value="${archive.id}">
                                <button type="submit" name="action" value="chooseArchive">choose</button>
                            </form>
                        </td>
                        <td>
                            <form action="${url}" method="post">
                                <input type="hidden" name="id" value="${archive.id}">
                                <button type="submit" name="action" value="deleteArchive">delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-sm">
            <table class="table">
                <thead class="table-sub-heading-color">
                <tr>
                    Файлы
                </tr>
                <tr>
                    <td>имя</td>
                    <td>тип</td>
                    <td>место</td>
                </tr>
                <tr>
                    <form id="addFile" action="${url}" method="post">
                        <td>
                            <input type="text" name="name">
                        </td>
                        <td>
                            <select name="type" >
                                <c:forEach var="type" items="${applicationScope['types']}">
                                    <option>${type}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="text" name="place">
                        </td>
                        <td>
                            <button type="submit" name="action" value="addFile" form="addFile"> add</button>
                        </td>
                    </form>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="file" items="${applicationScope['files']}">
                    <tr>
                        <form id="updateFile${file.id}" action="${url}" method="post">
                            <input type="hidden" name="id" value="${file.id}">
                            <td>
                                <input type="text" name="name" value="${file.name}">
                            </td>
                            <td>
                                <select name="type" >
                                    <option>${file.type}</option>
                                    <c:forEach var="type" items="${applicationScope['types']}">
                                        <option>${type}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="text" name="place" value="${file.place}">
                            </td>
                            <input type="hidden" name="action" value="updateFile">
                        </form>
                        <td>
                            <form action="${url}" method="post">
                                <input type="hidden" name="id" value="${file.id}">
                                <button type="submit" name="action" value="deleteFile">delete</button>
                            </form>
                            <button type="submit" form="updateFile${file.id}">edit</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>