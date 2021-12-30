<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Fiche Signalement</h4>   
    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4" id="btn-dropdown-demo">
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
                        <c:if test="${valide==0}">
                            <p>
                                <div class="demo-inline-spacing mt-3">
                                    
                                    <div class="btn-group">
                                        <a href="${pageContext.request.contextPath}/deleteSignalamentConf?id=${serv.getId()}"><button  class="btn btn-primary" ><i class="feather icon-x"></i>Invalider</button></a>
                                        <button style="margin-left: 225px;" type="button" class="btn btn-primary dropdown-toggle hide-arrow" data-toggle="dropdown"><i class="feather icon-check"></i>Valider</button>
                                        <div class="dropdown-menu">
                                            <span class="dropdown-item">Choix de region</span>
                                            <div class="dropdown-divider"></div>
                                            <c:forEach items="${reg}" var ="rg">
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/signalementValide?id=${serv.getId()}&&region=${rg.getId()}">${rg.getNom()}</a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </p>
                        </c:if>
                        <c:if test="${valide==1}">
                            <dt>Region:</dt>
                            <dd>${serv.getRegion()}</dd>
                        </c:if>
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
                    <nav>
                        <ul class="pagination">
                            <c:forEach  var="i" begin="1" end="${countPhoto}">
                            <li class="page-item ">
                                <a class="page-link" href="${pageContext.request.contextPath}/signalement?nb=${i}&&id=${serv.getId()}">${i}</a>
                            </li>
                             </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>