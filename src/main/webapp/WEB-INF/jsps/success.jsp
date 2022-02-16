<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>You can redeem your coupon with id <%=request.getParameter("couponId")%></title>
</head>
<body>
<form action="/success" method="post">
<div align="center">
    <input type="submit" value="Redeem"/>
    <input type="hidden" value="<%=request.getParameter("couponId")%>" name="couponId"/>

</div>
</form>

</body>
</html>