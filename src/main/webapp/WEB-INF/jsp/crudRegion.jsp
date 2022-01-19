<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Listes des Regions</h4>
    <div class="text-muted small mt-0 mb-4 d-block breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a id="href8" href="${pageContext.request.contextPath}/insertRegion1"><i class="feather icon-plus-square"></i></li>
            <li class="breadcrumb-item">Ajouter</li></a>
            <script>
                document.getElementById('href8').href= document.getElementById('href8').href+"?token="+localStorage["token"];
           </script> 
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
                        <input id="${liste.getId()}" type="hidden" value="" name="token">
                        <script>
                            document.getElementById('${liste.getId()}').value= localStorage["token"];
                       </script> 
                    <td><button type="submit"  class="btn btn-primary" ><i class="feather icon-edit-1"></i>Modifier</button></a></td>
    
                    </form>
                   
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">
                <c:forEach  var="i" begin="1" end="${lim}">
                    <c:set var="page" value="page+${i}"></c:set>
                <li class="page-item ">
                    <a class="page-link" id="${page}" href="${pageContext.request.contextPath}/listeRegion?lim=${i}">${i}</a>
                    <script>
                        console.log("${page}")
                        document.getElementById('${page}').href= document.getElementById('${page}').href+"&&token="+localStorage["token"];
                   </script> 
                </li>
                 </c:forEach>
            </ul>
        </nav>
    </div>
</div>