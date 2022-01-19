<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid flex-grow-1 container-p-y">

    <h4 class="font-weight-bold py-3 mb-0">Statistiques a propos des depenses de chaque region</h4>

    <form action="${pageContext.request.contextPath}/statDepenseDate" class="form-inline mb-4">
        <label class="sr-only">Date_1</label>
        <input type="text" class="form-control mr-sm-2 mb-2 mb-sm-0" placeholder="yy-mm-dd (date 1)" name="d1">
        <input id="input1" type="hidden" value="" name="token">
        <script>
         document.getElementById('input1').value=localStorage["token"];
    </script> 
        <label class="sr-only">Date_2</label>
        <div class="input-group mr-sm-2 mb-2 mb-sm-0">
            <input type="text" class="form-control" placeholder="yy-mm-dd (date 2)" name="d2">
            <div class="clearfix"></div>
        </div>
        <button style="margin-left: 50px;" type="submit" class="btn btn-primary">Rechercher</button>
    </form>

<div class="card mb-4">   
    <div class="chart-container" style="position: relative;height: 400px;width:800px">
   <center><canvas id="myChart" ></canvas></center> 
</div>
</div>
</div>
<script>
    var labels=["${x}"];
    const data = {
      labels: labels,
      datasets: [{
        label: 'Total depense',
        backgroundColor: 'rgb(255, 106, 34)',
        borderColor: 'rgb(255, 109, 132)',
        data: ["${y}"],
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