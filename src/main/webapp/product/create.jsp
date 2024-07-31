<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Product</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="my-4">Create New Product</h1>
    <div class="mb-3">
        <c:if test='${requestScope["message"] != null}'>
            <div class="alert alert-success" role="alert">
                    ${requestScope["message"]}
            </div>
        </c:if>
    </div>
    <a href="/products" class="btn btn-secondary mb-4">Back to products list</a>
    <form method="post">
        <fieldset>
            <legend>Product Information</legend>
            <div class="form-group">
                <label for="id">Id:</label>
                <input type="text" class="form-control" name="id" id="id">
            </div>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" name="name" id="name">
            </div>
            <div class="form-group">
                <label for="company">Company:</label>
                <input type="text" class="form-control" name="company" id="company">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" name="description" id="description">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" class="form-control" name="price" id="price">
            </div>
            <button type="submit" class="btn btn-primary">Create Product</button>
        </fieldset>
    </form>
</div>


</body>
</html>
