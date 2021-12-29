<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">
    <h4 class="font-weight-bold py-3 mb-0">Chef Regions</h4>
    <div class="card">
        <div class="card-header">Table within card</div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>Nom</th>
                    <th>E-mail</th>
                    <th>Mot de passe</th>
                    <th>Region</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:foreach items="${listes}" var ="liste">
                <tr>
                    <td>${liste.getNom()}</td>
                    <td>${liste.getMail()}</td>
                    <td>${liste.getMdp()}</td>
                    <td>${liste.getRegion()}</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">
                <li class="page-item disabled">
                    <a class="page-link" href="javascript:void(0)">«</a>
                </li>
                <li class="page-item active">
                    <a class="page-link" href="javascript:void(0)">1</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="javascript:void(0)">2</a>
                </li>
            </ul>
        </nav>
    </div>
</div>