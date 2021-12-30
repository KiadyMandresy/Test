<div class="row">
    <div class="col-md-6">
            <div class="card-header">
                <h6 class="card-header-title mb-0">Voulez-vous vraiment supprimer ce Chef de Region?</h6>
              <p>
                    <a href="${pageContext.request.contextPath}/ChefRegions?lim=${lim}"><button style="margin-left: 50px;" class="btn btn-primary" ><i class="feather icon-x-square"></i>Annuler</button></a>
                    <a href="${pageContext.request.contextPath}/deleteChefRegion?id=${id}&&lim=${lim}"><button style="margin-left: 100px;" class="btn btn-primary" ><i class="feather icon-check-square"></i>Confirmer</button></a>
                </p>
            </div>
    </div>
</div>