<%@page import="org.javasavvy.product.service.ProductLocalServiceUtil"%>
<%@page import="org.javasavvy.product.model.Product"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<p>
	<b><liferay-ui:message key="product_Prodcut.caption"/></b>
</p>

<div class="container">
	<b>Add Product</b>
<portlet:actionURL name="addProduct" var="addProdUrl">
</portlet:actionURL>


<aui:form action="<%=addProdUrl %>">
	<aui:input name="name" type="text" style="width: 50%;" />
	<aui:button type="submit" value="submit"/>
</aui:form>
</div>


<%

 List<Product> prList = ProductLocalServiceUtil.getProducts(-1, -1);

%>
<h4>List of Products</h4>
<c:choose>
	<c:when test="<%=prList!=null && prList.size()>0 %>">
	    <table>
	    	<thead>
	    		<th><td>Name</td></th>
	    	</thead>
	    	<tbody>
		<c:forEach    items="<%=prList%>" var="product">
				<tr><td>${product.name }</td></tr>
		</c:forEach>
		</tbody>  </table>
	</c:when>
	<c:otherwise>
		Empty Products
	</c:otherwise>

</c:choose>
