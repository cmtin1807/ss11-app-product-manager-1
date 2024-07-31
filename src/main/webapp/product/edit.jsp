<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="my-4">Edit Product</h1>
    <p>
        <a href="/products" class="btn btn-secondary mb-3">Back to product list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Edit Information</legend>
            <div class="form-group">
                <label for="id">Id:</label>
                <input type="text" class="form-control" name="id" id="id" value="${requestScope["product"].getId()}" readonly>
            </div>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" name="name" id="name" value="${requestScope["product"].getName()}">
            </div>
            <div class="form-group">
                <label for="company">Company:</label>
                <input type="text" class="form-control" name="company" id="company" value="${requestScope["product"].getCompany()}">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" name="description" id="description" value="${requestScope["product"].getDescription()}">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" class="form-control" name="price" id="price" value="${requestScope["product"].getPrice()}">
            </div>
            <button type="submit" class="btn btn-primary">Edit Product</button>
            <a href="/products" class="btn btn-danger">Cancel</a>
        </fieldset>
    </form>
</div>

</body>
</html>
