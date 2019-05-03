
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="WEB-INF/vistas/cabecera.jspf" %>
<%@page import="compras.domain.Producto" %>
<hr>
<h1>Lista Productos: </h1>

<c:if test="${sessionScope.mensaje != null 
              and sessionScope.mensaje.length() > 0  }">
      <div class='alert alert-warning' role='alert'>
          ${sessionScope.mensaje }
      </div>
</c:if>

<ul class="list-group">

    <c:forEach items="${ applicationScope.productos }"
               var="p" >
        <li class="list-group-item d-flex justify-content-between align-items-center">
            ${ p.descripcion }  - ${ p.precio  } euros 
            <a class="btn btn-primary" 
               href="compras?id=${ p.id  }"
               role="button">Compar</a>
        </li>

    </c:forEach>   
</ul>


</body>
</html>
