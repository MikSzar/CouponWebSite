<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Details of coupon with ID <%=request.getParameter("couponId")%></title>
</head>
<body>

<div align="center">
    <h4>Value: ${coupon.value}</h4>
    <h4>Remain: ${coupon.remaintimes}</h4>
</div>

</body>
</html>