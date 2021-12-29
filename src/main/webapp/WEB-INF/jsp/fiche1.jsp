<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Fiche Signalement</h4>   
    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">
                    <h6 class="card-header-title mb-0">Description</h6>
                </div>
                <div class="card-body">
                    <dl>
                        <dt>Description :</dt>
                        <dd>${serv.getCommentaire()}</dd>
                        <dt>Nom de l'annonceur</dt>
                        <dd>${serv.getIdUtilisateur()}</dd>
                        <dt>Localisation:</dt>
                        <dd>Anosibe</dd>
                        <dt>date:</dt>
                        <dd>${serv.getDateS()}</dd>
                    </dl>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">
                    <h6 class="card-header-title mb-0">Photos</h6>
                </div>
                <div class="card-body">
                    <figure class="figure" style="max-width: 25rem">
                        <img src="1.jpg" class="figure-img img-fluid" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption">A caption for the above image.</figcaption>
                    </figure>
                </div>
            </div>
        </div>
    </div>
</div>