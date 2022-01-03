<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Listes des Regions</h4>
    <div class="text-muted small mt-0 mb-4 d-block breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/insertRegion1"><i class="feather icon-plus-square"></i></li>
            <li class="breadcrumb-item">Ajouter</li></a>
        </ol>
    </div>
    <div class="card">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Nom</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listeRegion}" var ="liste">
                <tr>
                    <td>${liste.getNom()}</td> 
                    <form action="${pageContext.request.contextPath}/modificationRegion" method="get">
                        <input type="hidden" value="${liste.getNom()}" name="nom">
                        <input type="hidden" value="${liste.getId()}" name="id">
                        <input type="hidden" value="${lim}" name="lim">
                    <td><button type="submit"  class="btn btn-primary" ><i class="feather icon-edit-1"></i>Modifier</button></a></td>
    
                    </form>
                   
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">
                <c:forEach  var="i" begin="1" end="${lim}">
                <li class="page-item ">
                    <a class="page-link" href="${pageContext.request.contextPath}/listeRegion?lim=${i}">${i}</a>
                </li>
                 </c:forEach>
            </ul>
        </nav>
    </div>
</div>