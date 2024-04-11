<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>

<form action="update" method="get">
    <input type="hidden" name="id" value="${product.productId}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${product.productName}">
    <br>
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="${product.productPrice}">
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
