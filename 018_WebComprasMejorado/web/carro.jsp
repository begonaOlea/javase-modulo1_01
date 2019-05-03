
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="WEB-INF/vistas/cabecera.jspf" %>
<hr>
<h1>Carro: </h1>

<c:if test="${ sessionScope.carro == null or 
               sessionScope.carro.size() ==0 }">
      <div class='alert alert-warning' role='alert'>
          EL carro está vacio 
      </div>
</c:if>



<ul class='list-group'>

    <c:forEach items="${sessionScope.carro}" var="entry"> 
        <li class='list-group-item d-flex justify-content-between align-items-center'>

            ${entry.key.descripcion}    
            <span class='badge badge-primary badge-pill'>${entry.value}</span>
        </li>
    </c:forEach>
</ul>

</body>
</html>
