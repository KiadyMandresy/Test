<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Fiche Signalement</h4>   
    <div class="row">
        <div class="col-sm-12">
            <div class="card mb-4">
                <div class="card-header">
                    <h6 class="card-header-title mb-0" style="color:rgb(255, 106, 34);">Localisation</h6>
                </div>
                <div class="card-body">
                    <div id = "map" style = "width:900px; height:200px;">
      	
                    </div>
                    <script type="text/javascript">
                        var mapOptions = {
                         center: ["${serv.getX()}", "${serv.getY()}"],
                         zoom: 18
                      };
                      var map = new L.map('map', mapOptions);
                      var layer = new L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');
                      map.addLayer(layer);
                      new L.Marker(["${serv.getX()}", "${serv.getY()}"]).addTo(map);
                    </script>
               </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4" id="btn-dropdown-demo">
                <div class="card-body">
                    <dl>
                        <dt style="color:rgb(255, 106, 34);">Type de signalement:</dt>
                        <dd>${serv.getType()}</dd>
                        <dt style="color:rgb(255, 106, 34);">Description :</dt>
                        <dd>${serv.getCommentaire()}</dd>
                        <dt style="color:rgb(255, 106, 34);">Nom de l'annonceur</dt>
                        <dd >${serv.getIdUtilisateur()}</dd>
                        <dt style="color:rgb(255, 106, 34);">date:</dt>
                        <dd>${serv.getDateS()}</dd>
                        <c:if test="${valide==0}">
                            <dt style="color:rgb(255, 106, 34);">Statut:</dt>
                            <dd>Pas encore Valide</dd>
                            <p>
                                <div class="demo-inline-spacing mt-3">
                                    
                                    <div class="btn-group">
                                        <a id="href9" href="${pageContext.request.contextPath}/deleteSignalamentConf?id=${serv.getId()}"><button  class="btn btn-primary" ><i class="feather icon-x"></i>Invalider</button></a>
                                        <script>
                                            document.getElementById('href9').href= document.getElementById('href9').href+"&&token="+localStorage["token"];
                                       </script> 
                                        <button style="margin-left:225px;" type="button" class="btn btn-primary dropdown-toggle hide-arrow" data-toggle="dropdown"><i class="feather icon-check"></i>Valider</button>
                                        <div class="dropdown-menu">
                                            <span class="dropdown-item">Choix de region</span>
                                            <div class="dropdown-divider"></div>
                                            <c:forEach items="${reg}" var ="rg">
                                            <a id="href10" class="dropdown-item" href="${pageContext.request.contextPath}/signalementValide?id=${serv.getId()}&&region=${rg.getId()}">${rg.getNom()}</a>
                                            <script>
                                                document.getElementById('href10').href= document.getElementById('href10').href+"&&token="+localStorage["token"];
                                           </script> 
                                        </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </p>
                        </c:if>
                        <c:if test="${valide==1}">
                            <dt style="color:rgb(255, 106, 34);">Region:</dt>
                            <dd>${serv.getRegion()}</dd>
                            <dt style="color:rgb(255, 106, 34);">Statut:</dt>
                            <dd>Pas encore Resolu</dd>
                        </c:if>
                        <c:if test="${valide==2}">
                            <dt style="color:rgb(255, 106, 34);">Region:</dt>
                            <dd>${serv.getRegion()}</dd>
                            <dt style="color:rgb(255, 106, 34);">Budget:</dt>
                            <dd >${serv.getBudget()}</dd>
                            <dt style="color:rgb(255, 106, 34);">Statut:</dt>
                            <dd >Probleme resolu le ${serv.getTermine()}</dd>
                        </c:if>
                    </dl>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-header">
                    <h6 class="card-header-title mb-0" style="color:rgb(255, 106, 34);">Photos</h6>
                </div>
                <div class="card-body">
                    <figure class="figure" style="max-width: 25rem">
                        <img src="img/${photo}" class="figure-img img-fluid" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption">${serv.getType()}</figcaption>
                    </figure>
                    <nav>
                        <ul class="pagination">
                            <c:forEach  var="i" begin="1" end="${countPhoto}">
                            <li class="page-item ">
                                <a id="href8" class="page-link" href="${pageContext.request.contextPath}/signalement?nb=${i}&&id=${serv.getId()}">${i}</a>
                                <script>
                                    document.getElementById('href8').href= document.getElementById('href8').href+"&&token="+localStorage["token"];
                               </script> 
                            </li>
                             </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
       
    </div>
</div>