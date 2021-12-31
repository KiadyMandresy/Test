<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">

    <h4 class="font-weight-bold py-3 mb-0">Statistiques par nombres des problemes par region</h4>

    <form action="${pageContext.request.contextPath}/stat_ProblemeRecherche" class="form-inline mb-4">
        <label class="sr-only">Date_1</label>
        <input type="text" class="form-control mr-sm-2 mb-2 mb-sm-0" placeholder="date 1" name="d1">

        <label class="sr-only">Date_2</label>
        <div class="input-group mr-sm-2 mb-2 mb-sm-0">
            <input type="text" class="form-control" placeholder="date 2" name="d2">
            <div class="clearfix"></div>
        </div>
        <button type="submit" class="btn btn-primary">Rechercher</button>
    </form>

<div class="card mb-4">   
    <canvas id="myChart" ></canvas>
  
</div>
</div>
<script>
    var labels=["${stat}"];
    const data = {
      labels: labels,
      datasets: [{
        label: 'Statistic nombres de promblemes par region',
        backgroundColor: 'rgb(255, 106, 34)',
        borderColor: 'rgb(255, 109, 132)',
        data: ["${stat2}"],
      }]
    };
  
    const config = {
      type: 'bar',
      data: data,
      options: {}
    };
    const myChart = new Chart(
      document.getElementById('myChart'),
      config
    );
  </script>

 <script>
</script>  