<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<%@ page import="controller.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<c:if test="${local==1}">
    <script>
        localStorage.setItem("token","${token}");
        console.log(localStorage["token"]);
    </script>
</c:if>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Admin.com</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="Empire Bootstrap admin template made using Bootstrap 4, it has tons of ready made feature, UI components, pages which completely fulfills any dashboard needs." />
    <meta name="keywords" content="Empire, bootstrap admin template, bootstrap admin panel, bootstrap 4 admin template, admin template">
    <meta name="author" content="Srthemesvilla" />
    <link rel="icon" type="image/x-icon" href="/assets/img/favicon.ico">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel = "stylesheet" href = "https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <script src = "https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
    <link rel="stylesheet" href="assets/fonts/fontawesome.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.css">
    <link rel="stylesheet" href="assets/fonts/linearicons.css">
    <link rel="stylesheet" href="assets/fonts/open-iconic.css">
    <link rel="stylesheet" href="assets/fonts/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="assets/fonts/feather.css">

    
    
    <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <!-- Vendor CSS Files -->
  <link href="front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    
    
    
    <!-- Core stylesheets -->
    <link rel="stylesheet" href="css/bootstrap-material.css">
    <link rel="stylesheet" href="css/shreerang-material.css">
    <link rel="stylesheet" href="css/uikit.css">

    <!-- Libs -->
    <link rel="stylesheet" href="assets/libs/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="assets/libs/flot/flot.css">

</head>

<body>
  
    <!-- [ Preloader ] Start -->
    <div class="page-loader">
        <div class="bg-primary"></div>
    </div>
    <!-- [ Preloader ] End -->
   
    <!-- [ Layout wrapper ] Start -->
    <div class="layout-wrapper layout-2">
        <div class="layout-inner">
            <!-- [ Layout sidenav ] Start -->
            <div id="layout-sidenav" class="layout-sidenav sidenav sidenav-vertical bg-white logo-dark">
                <!-- Brand demo (see assets/css/demo/demo.css) -->
                <div class="app-brand demo">
                    <p style="font-size: 30px;font-style: italic;"class="app-brand-text demo sidenav-text font-weight-normal ml-2">Admin.com</p>
            
                    </a>
                </div>
                <div class="sidenav-divider mt-0"></div>

                <!-- Links -->
                <ul class="sidenav-inner py-1">

                    <!-- Dashboards -->
                   

                    <!-- Layouts -->
                    <li class="sidenav-divider mb-1"></li>
                   
                   
                      <li class="sidenav-item">
                        <a  class="sidenav-link" id="href1" href="${pageContext.request.contextPath}/listeSignalement?lim=1">
                            <script>
                                document.getElementById('href1').href= document.getElementById('href1').href+"&&token="+localStorage["token"];
                            </script> 
                            <i class="sidenav-icon feather icon-alert-triangle"></i>
                            <div>Liste des signalements</div>
                        </a>
                    
                      </li>
                    
                  
                    <li class="sidenav-header small font-weight-semibold">Crud</li>
                     <li class="sidenav-item">
                        <a href="${pageContext.request.contextPath}/ChefRegions?lim=1&&token=" id="ChefRegions" class="sidenav-link">
                            <script>
                                document.getElementById('ChefRegions').href= document.getElementById('ChefRegions').href+localStorage["token"];
                            </script>

                             <i class="sidenav-icon feather icon-user"></i>
                            <div>Chef de region</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a id="href2" href="${pageContext.request.contextPath}/listeRegion?lim=1" class="sidenav-link">
                            <script>
                                document.getElementById('href2').href= document.getElementById('href2').href+"&&token="+localStorage["token"];
                            </script>  
                            <i class="sidenav-icon feather icon-map-pin"></i>
                            <div>Region</div>
                        </a>
                    </li>
                    </li>
                    <li class="sidenav-header small font-weight-semibold">Statistiques</li>
                     <li class="sidenav-item">
                        <a id="href3" href="${pageContext.request.contextPath}/stat_Probleme" class="sidenav-link">
                            <script>
                                document.getElementById('href3').href= document.getElementById('href3').href+"?token="+localStorage["token"];
                            </script> 
                            <i class="sidenav-icon feather icon-bar-chart"></i>
                            <div>Classement des regions par nombres de signalement</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a id="href4" href="${pageContext.request.contextPath}/statDepense" class="sidenav-link">
                            <script>
                                document.getElementById('href4').href= document.getElementById('href4').href+"?token="+localStorage["token"];
                            </script>  
                            <i class="sidenav-icon feather icon-bar-chart-2"></i>
                            <div>Classement des regions par depense</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a id="href5" href="${pageContext.request.contextPath}/statPerformance" class="sidenav-link">
                            <script>
                                document.getElementById('href5').href= document.getElementById('href5').href+"?token="+localStorage["token"];
                            </script>  
                            <i class="sidenav-icon feather icon-bar-chart"></i>
                            <div>Classement des regions par performance (regler les problemes)</div>
                        </a>
                    </li>
                     
                    <!-- UI elements -->
                   
                       

                   
                   
                </ul>
            </div>
            <!-- [ Layout sidenav ] End -->
            <!-- [ Layout container ] Start -->
            <div class="layout-container">
                <!-- [ Layout navbar ( Header ) ] Start -->
                <nav class="layout-navbar navbar navbar-expand-lg align-items-lg-center bg-dark container-p-x" id="layout-navbar">

                    <!-- Brand demo (see assets/css/demo/demo.css) -->
                    <a href="index.html" class="navbar-brand app-brand demo d-lg-none py-0 mr-4">
                        <span class="app-brand-logo demo">
                            <img src="assets/img/logo-dark.png" alt="Brand Logo" class="img-fluid">
                        </span>
                        <span class="app-brand-text demo font-weight-normal ml-2">Empire</span>
                    </a>

                    <!-- Sidenav toggle (see assets/css/demo/demo.css) -->
                    <div class="layout-sidenav-toggle navbar-nav d-lg-none align-items-lg-center mr-auto">
                        <a class="nav-item nav-link px-0 mr-lg-4" href="javascript:">
                            <i class="ion ion-md-menu text-large align-middle"></i>
                        </a>
                    </div>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#layout-navbar-collapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="navbar-collapse collapse" id="layout-navbar-collapse">
                        <!-- Divider -->
                        <hr class="d-lg-none w-100 my-2">

                       

                        <div class="navbar-nav align-items-lg-center ml-auto" style="height:54px">
                            

                            <!-- Divider -->
                            <div class="nav-item d-none d-lg-block text-big font-weight-light line-height-1 opacity-25 mr-3 ml-1">|</div>
                            <div class="demo-navbar-user nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                                    <span class="d-inline-flex flex-lg-row-reverse align-items-center align-middle">
                                        <i class="feather icon-user d-block ui-w-30 rounded-circle"></i>
                                        <span class="px-1 mr-lg-2 ml-2 ml-lg-0">${admin.getNom()}</span>
                                    </span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <div class="dropdown-divider"></div>
                                    <a href="${pageContext.request.contextPath}/deconnection" id="deco" class="dropdown-item">
                                        <i class="feather icon-power text-danger"></i> &nbsp; Se deconnecter</a>
                                        <script>
                                            document.getElementById('deco').href= document.getElementById('deco').href+"?token="+localStorage["token"];
                                        </script> 
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
              <div class="layout-content">
                <jsp:include page="${page}" />
                
		    </div> 
                   
                    <nav class="layout-footer footer bg-white">
                        <div class="container-fluid d-flex flex-wrap justify-content-between text-center container-p-x pb-3">
                            <div class="pt-3">
                                <span class="footer-text font-weight-semibold">&copy; ETU 1165_1168_1213</span>
                            </div>
                           
                        </div>
                    </nav>
                    <!-- [ Layout footer ] End -->
                </div>
                <!-- [ Layout content ] Start -->
            </div>
            <!-- [ Layout container ] End -->
        </div>
        <!-- Overlay -->
        <!-- <div class="layout-overlay layout-sidenav-toggle"></div> -->
    </div>
    <!-- [ Layout wrapper] End -->

    <!-- Core scripts -->
    <script src="js/pace.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="libs/popper/popper.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/sidenav.js"></script>
    <script src="js/layout-helpers.js"></script>
    <script src="js/material-ripple.js"></script>

    <!-- Libs -->
    <script src="libs/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="libs/eve/eve.js"></script>
    <script src="libs/flot/flot.js"></script>
    <script src="libs/flot/curvedLines.js"></script>
    <script src="libs/chart-am4/core.js"></script>
    <script src="libs/chart-am4/charts.js"></script>
    <script src="libs/chart-am4/animated.js"></script>
    
    <!-- Demo -->
    <!-- <script src="assets/js/demo.js"></script><script src="assets/js/analytics.js"></script> -->
    <!-- <script src="assets/js/pages/dashboards_index.js"></script> -->
</body>
</html>