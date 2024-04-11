<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product List</title>
</head>
<body>
<h1>Product List</h1>

<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${productList}">
    <tr>
      <td>${product.productId}</td>
      <td>${product.productName}</td>
      <td>${product.productPrice}</td>
      <td>
        <form action="edit" method="get">
          <input type="hidden" name="productId" value="${product.productId}">
          <button type="submit">Edit</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<br>
<form action="add" method="get">
  <button type="submit">Add Product</button>
</form>
</body>
</html>
