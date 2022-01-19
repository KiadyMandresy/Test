<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Modification a propos : Chef de Region</h4>
   
<div class="card mb-4">
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/updateChefRegion" method="get">
            <div class="form-group">
                <input id="input1" type="hidden" value="" name="token">
                <script>
                 document.getElementById('input1').value=localStorage["token"];
                </script> 
                <label class="form-label">Nom</label>
                <input type="hidden" class="form-control" value="${chef.getId()}" name="id">
                <input type="hidden" class="form-control" value="${lim}" name="lim">
                <input type="text" class="form-control" value="${chef.getNom()}" name="nom">
                <div class="clearfix"></div>
            </div>
            <div class="form-group">
                <label class="form-label">E-mail</label>
                <input type="text" class="form-control" value="${chef.getMail()}" name="mail">
                <div class="clearfix"></div>
            </div>
            <div class="form-group">
                <label class="form-label">Mot de passe</label>
                <input type="password" class="form-control" value="${chef.getMdp()}" name="mdp">
                <div class="clearfix"></div>
            </div>
            <div class="form-group">
                    <label class="form-label">Region</label>
                    <select class="custom-select" name="region">
                        <c:forEach  items="${regions}" var ="liste">
                        <option value="${liste.getId()}">${liste.getNom()}</option>
                        </c:forEach>
                    </select>
                </div>
           <center> <button type="submit" class="btn btn-primary" >Modifier</button></center>
        </form>
    </div>
</div>
</div>