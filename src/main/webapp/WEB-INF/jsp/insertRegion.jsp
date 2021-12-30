<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Insertion region</h4>
   
<div class="card mb-4">
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/insertRegion" method="get">
            <div class="form-group">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" placeholder="Nom" name="nom">
                <div class="clearfix"></div>
            </div>
           <center> <button type="submit" class="btn btn-primary" >Inserer</button></center>
        </form>
    </div>
</div>
</div>