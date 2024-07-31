<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Product</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="my-4">Delete Product</h1>
    <p>
        <a href="/products" class="btn btn-secondary mb-4">Back to products list</a>
    </p>
    <form method="post">
        <div class="alert alert-warning" role="alert">
            <h4 class="alert-heading">Are you sure?</h4>
            <p>You are about to delete the following product:</p>
        </div>
        <fieldset>
            <legend>Delete Information</legend>
            <table class="table table-bordered">
                <tr>
                    <th scope="row">Id:</th>
                    <td>${requestScope["product"].getId()}</td>
                </tr>
                <tr>
                    <th scope="row">Name:</th>
                    <td>${requestScope["product"].getName()}</td>
                </tr>
                <tr>
                    <th scope="row">Company:</th>
                    <td>${requestScope["product"].getCompany()}</td>
                </tr>
                <tr>
                    <th scope="row">Description:</th>
                    <td>${requestScope["product"].getDescription()}</td>
                </tr>
                <tr>
                    <th scope="row">Price:</th>
                    <td>${requestScope["product"].getPrice()}</td>
                </tr>
            </table>
        </fieldset>
        <div class="form-group">
            <button type="submit" class="btn btn-danger">Delete Product</button>
            <a href="/products" class="btn btn-primary">Cancel</a>
        </div>
    </form>
</div>


</body>
</html>
