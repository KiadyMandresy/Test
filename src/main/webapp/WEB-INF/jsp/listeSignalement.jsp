<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid flex-grow-1 container-p-y">

    <form action="${pageContext.request.contextPath}/signalementRecherche" class="form-inline mb-4">
       <input id="input1" type="hidden" value="" name="token">
       <script>
        document.getElementById('input1').value=localStorage["token"];
   </script> 
        <label class="sr-only">Date_1</label>
        <input type="text" class="form-control mr-sm-2 mb-2 mb-sm-0" placeholder="date 1" name="d1">

        <label class="sr-only">Date_2</label>
        <div class="input-group mr-sm-2 mb-2 mb-sm-0">
            <input type="text" class="form-control" placeholder="date 2" name="d2">
            <div class="clearfix"></div>
        </div>
        <button type="submit" class="btn btn-primary">Rechercher</button>
    </form>

    
    <h4 class="font-weight-bold py-3 mb-0">Liste des signalements</h4>

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
            <td><a id="${liste.getId()}" href="${pageContext.request.contextPath}/signalement?nb=1&&id=${liste.getId()}">Fiche</a></td>
            <script>
                document.getElementById('${liste.getId()}').href= document.getElementById('${liste.getId()}').href+"&&token="+localStorage["token"];
           </script> 
        </tr>
        </c:forEach>
           
        </tbody>
    </table>

    <div class="card-body">

        <nav>
            <ul class="pagination">
            <c:forEach  var="i" begin="1" end="${lim}">
                
            <c:set var="page" value="page+${i}"></c:set>
                <li class="page-item ">
                    <a id="${page}" class="page-link" href="${pageContext.request.contextPath}/listeSignalement?lim=${i}">${i}</a>
                    <script>
                        document.getElementById('${page}').href= document.getElementById('${page}').href+"&&token="+localStorage["token"];
                   </script> 
                </li>
            </c:forEach>
        </ul>
        </nav>
    </div>
        
        
    
</div>

