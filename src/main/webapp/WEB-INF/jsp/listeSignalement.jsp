<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid flex-grow-1 container-p-y">

    

    <hr class="border-light container-m--x my-4">
    <h6 class="text-muted small font-weight-bold py-3 my-4">Liste des signalements</h6>

    <table class="table card-table">
        <thead class="thead-light">
            <tr>
                
                <th>Personne</th>
                <th>Type Signalement</th>
                <th>Date Signalement</th>
                <th></th>
            </tr>
        </thead>
        <tbody>

            <c:forEach  items="${listeGlobale}" var ="liste">
            <tr>
            <td>${liste.getIdUtilisateur()}</td>
            <td>${liste.getNom()}</td>
            <td>${liste.getDateS()}</td>
            <td>Fiche</td>
            </tr>
        </c:forEach>
           
        </tbody>
    </table>

    <div class="card-body">

        <nav>
            <ul class="pagination">
            <c:forEach  var="i" begin="1" end="${lim}">
                <li class="page-item ">
                    <a class="page-link" href="${pageContext.request.contextPath}/listeSignalement?lim=${i}">${i}</a>
                </li> 
            </c:forEach>
        </ul>
        </nav>
    </div>
        
        
    
</div>

