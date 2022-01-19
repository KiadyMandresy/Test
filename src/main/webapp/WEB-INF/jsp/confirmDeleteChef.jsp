<div class="container-fluid flex-grow-1 container-p-y">
<div class="row">
    <div class="col-md-6">
            <div class="card-header">
                <center><h6 class="card-header-title mb-0">Voulez-vous vraiment supprimer ce Chef de Region?</h6></center>
              <p>
                    <a id="href8" href="${pageContext.request.contextPath}/ChefRegions?lim=${lim}"><button style="margin-left: 100px;" class="btn btn-primary" ><i class="feather icon-x-square"></i>Annuler</button></a>
                    <a id="href9" href="${pageContext.request.contextPath}/deleteChefRegion?id=${id}&&lim=${lim}"><button style="margin-left: 100px;" class="btn btn-primary" ><i class="feather icon-check-square"></i>Confirmer</button></a>
                    <script>
                        document.getElementById('href8').href= document.getElementById('href8').href+"&&token="+localStorage["token"];
                        document.getElementById('href9').href= document.getElementById('href9').href+"&&token="+localStorage["token"];
                    </script> 
                </p>
            </div>
    </div>
</div>
</div>