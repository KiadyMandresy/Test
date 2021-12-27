<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Insertion de chef de region</h4>
   
<div class="card mb-4">
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/ajoutChef" method="get">
            <div class="form-group">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" placeholder="Nom" name="nom">
                <div class="clearfix"></div>
            </div>
            <div class="form-group">
                <label class="form-label">E-mail</label>
                <input type="text" class="form-control" placeholder="email" name="mail">
                <div class="clearfix"></div>
            </div>
            <div class="form-group">
                <label class="form-label">Mot de passe</label>
                <input type="password" class="form-control" placeholder="mot de passe" name="mdp">
                <div class="clearfix"></div>
            </div>
            <div class="form-group">
                    <label class="form-label">Region</label>
                    <select class="custom-select" name="region">
                        <c:forEach  items="${regions}" var ="liste">
                        <option value="${liste.getNom()}">${liste.getNom()}</option>
                        </c:forEach>
                    </select>
                </div>
           <center> <button type="submit" class="btn btn-primary" style="background-color:grey">Inserer</button></center>
        </form>
    </div>
</div>
</div>