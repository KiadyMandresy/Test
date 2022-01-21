<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Chef Regions</h4>
    <div class="text-muted small mt-0 mb-4 d-block breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a id="href6" href="${pageContext.request.contextPath}/insertionChefRegion"><i class="feather icon-plus-square">
            Ajouter</i></a>
            <script>
                document.getElementById('href6').href= document.getElementById('href6').href+"?token="+localStorage["token"];
            </script> 
        </ol>
    </div>
    <div class="card">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Nom</th>
                    <th>E-mail</th>
                    <th>Region</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listes}" var ="liste">
                <tr>
                    <td>${liste.getNom()}</td>
                    <td>${liste.getMail()}</td>
                    <td>${liste.getRegion()}</td>
                    <td><a id="${liste.getId()}" href="${pageContext.request.contextPath}/confirmationDeleteChefRegion?id=${liste.getId()}&&lim=${lim}"><button class="btn btn-primary" ><i class="feather icon-x"></i>Supprimer</button></a></td>
                    <script>
                        document.getElementById('${liste.getId()}').href= document.getElementById('${liste.getId()}').href+"&&token="+localStorage["token"];
                    </script> 
                    <c:set var="id" value="input+${liste.getId()}"></c:set>
                    <form action="${pageContext.request.contextPath}/updatePageChefRegion" method="get">
                        <input type="hidden" value="${liste.getNom()}" name="nom">
                        <input id="${id}" type="hidden" value="" name="token">
                        <script>
                            document.getElementById('${id}').value=localStorage["token"];
                        </script> 
                        <input type="hidden" value="${liste.getMail()}" name="mail">
                        <input type="hidden" value="${liste.getId()}" name="id">
                        <input type="hidden" value="${liste.getMdp()}" name="mdp">
                        <input type="hidden" value="${liste.getIdReg()}" name="region">
                        <input type="hidden" value="${lim}" name="lim">
                    <td><button type="submit"  class="btn btn-primary" ><i class="feather icon-edit-1"></i>Modifier</button></a></td>
                    </form>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">
                <c:forEach  var="i" begin="1" end="${pagination}">
                    <c:set var="page" value="page+${i}"></c:set>
                <li class="page-item ">
                    <a class="page-link" id="${page}" href="${pageContext.request.contextPath}/ChefRegions?lim=${i}">${i}</a>
                    <script>
                        document.getElementById('${page}').href= document.getElementById('${page}').href+"&&token="+localStorage["token"];
                    </script> 
                </li>
                 </c:forEach>
            </ul>
        </nav>
    </div>
</div>