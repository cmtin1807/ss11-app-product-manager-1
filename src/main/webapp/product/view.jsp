<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Product</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="my-4">View Product</h1>
    <p>
        <a href="/products" class="btn btn-secondary mb-3">Back to product list</a>
    </p>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Product Information</h5>
            <p class="card-text"><strong>Id:</strong> ${requestScope["product"].getId()}</p>
            <p class="card-text"><strong>Name:</strong> ${requestScope["product"].getName()}</p>
            <p class="card-text"><strong>Company:</strong> ${requestScope["product"].getCompany()}</p>
            <p class="card-text"><strong>Description:</strong> ${requestScope["product"].getDescription()}</p>
            <p class="card-text"><strong>Price:</strong> ${requestScope["product"].getPrice()}</p>
            <a href="/products" class="btn btn-primary">Back To Product List</a>
        </div>
    </div>
</div>


</body>
</html>
