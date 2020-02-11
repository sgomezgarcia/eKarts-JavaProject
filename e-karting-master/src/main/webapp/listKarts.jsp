<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es-ES" variant="euro"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Karts</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Tipo</th>
                            <th>Precio por minuto</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="kart" items="${karts}" varStatus="status" >
                            <tr>
                                <td>${status.count}</td>
                                <td>${kart.name}</td>
                                <td>${kart.type}</td>
                                <td> <fmt:formatNumber value="${kart.pricePerMinute}" type="currency" currencySymbol="€"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/kart?action=edit&idKart=${kart.id}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</section>
