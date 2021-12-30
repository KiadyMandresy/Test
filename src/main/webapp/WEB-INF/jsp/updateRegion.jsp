<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Modification a propos : Region</h4>
   
<div class="card mb-4">
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/modificationRegionVrai" method="get">
            <div class="form-group">
                <label class="form-label">Nom</label>
                <input type="hidden" class="form-control" value="${region1.getId()}" name="id">
                <input type="text" class="form-control" value="${region1.getNom()}" name="nom">
                <input type="hidden" class="form-control" value="${lim}" name="lim">
                <div class="clearfix"></div>
            </div>
           <center> <button type="submit" class="btn btn-primary" >Modifier</button></center>
        </form>
    </div>
</div>
</div>