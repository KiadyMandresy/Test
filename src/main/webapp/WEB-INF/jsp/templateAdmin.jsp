<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<%@ page import="controller.*" %>

<!DOCTYPE html>

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
                    <span class="app-brand-logo demo">
                        <img src="assets/img/bus.png" alt="Brand Logo" class="img-fluid">
                    </span>
                    <p class="app-brand-text demo sidenav-text font-weight-normal ml-2">Admin.com</p>
            
                    </a>
                </div>
                <div class="sidenav-divider mt-0"></div>

                <!-- Links -->
                <ul class="sidenav-inner py-1">

                    <!-- Dashboards -->
                    <li class="sidenav-item active">
                        <a href="accueil" class="sidenav-link">
                            <i class="sidenav-icon feather icon-home"></i>
                            <div>Accueil</div>
                        </a>
                    </li>

                    <!-- Layouts -->
                    <li class="sidenav-divider mb-1"></li>
                     <li class="sidenav-header small font-weight-semibold">Filtre</li>
                     <form method="post" action="filtre">
                    <li class="sidenav-item">
                       <a  class="sidenav-link">
                             <i class="sidenav-icon feather icon-trending-up"></i>
                            <div>Ligne</div>
                        </a>
                         <center>
                             <span style="margin-left:30px"><input type="radio" name="ligne" value=""> pp </span>
                            </center>
                       <!--</div>-->
                    </li>
                      <li class="sidenav-item">
                        <a  class="sidenav-link">
                             <i class="sidenav-icon feather icon-bold"></i>
                            <div>Bus</div>
                        </a>
                     <div class="input-group">
                            <select class="custom-select" style="margin-left:80px" name="bus">
                               
                                    <option value="aa">aa</option>
                                 
                            </select>
                         </center>
                                   
                     </div>
                      </li>
                      <li class="sidenav-item">
                          <input type="text" class="form-control" placeholder="jj-mm-aa" name="d1" style="margin-left:80px;width:80px">
                          <input type="text" class="form-control" placeholder="jj-mm-aa" name="d2" style="margin-left:80px;width:80px">
                      </li>
                    <li class="sidenav-item">
                    <br>   <button type="submit" class="btn btn-round btn-dark" style="margin-left:60px">Rechercher</button>   </br>
                     </form>
                    </li>
                   
                    <li class="sidenav-header small font-weight-semibold">Liste</li>
                     <li class="sidenav-item">
                        <a href="ligne?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-trending-up"></i>
                            <div>Ligne</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a href="bus?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-bold"></i>
                            <div>Bussssss</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a href="chauffeur?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-user"></i>
                            <div>Chauffeur</div>
                        </a>
                    </li>
                      <li class="sidenav-item">
                        <a href="pointage?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-book"></i>
                            <div>Versement</div>
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
                  <!--   <a href="index.html" class="navbar-brand app-brand demo d-lg-none py-0 mr-4">
                        <span class="app-brand-logo demo">
                            <img src="assets/img/logo-dark.png" alt="Brand Logo" class="img-fluid">
                        </span>
                        <span class="app-brand-text demo font-weight-normal ml-2">Empire</span>
                    </a> -->

                    <!-- Sidenav toggle (see assets/css/demo/demo.css) -->
                <!--     <div class="layout-sidenav-toggle navbar-nav d-lg-none align-items-lg-center mr-auto">
                        <a class="nav-item nav-link px-0 mr-lg-4" href="javascript:">
                            <i class="ion ion-md-menu text-large align-middle"></i>
                        </a>
                    </div>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#layout-navbar-collapse">
                        <span class="navbar-toggler-icon"></span>
                    </button> -->

                    <div class="navbar-collapse collapse" id="layout-navbar-collapse">
                        <!-- Divider -->
                        <hr class="d-lg-none w-100 my-2">

                        <div class="navbar-nav align-items-lg-center">
                            <!-- Search -->
                            <label class="nav-item navbar-text navbar-search-box p-0 active">
                                <form method="post" action="simple?lim=1">
                                
                                <span class="navbar-search-input pl-2">
                                    <input type="text" class="form-control navbar-text mx-2" placeholder="Rechercher..." name="Nom">
                               
                                <button  class="btn btn-dark"><i class="feather icon-search navbar-icon align-middle"></i></button> </span>
                                </form>
                            </label>
                        </div>

                        <div class="navbar-nav align-items-lg-center ml-auto">
                            <div class="demo-navbar-notifications nav-item dropdown mr-lg-3">
                               
                              
                            </div>

                            <div class="demo-navbar-messages nav-item dropdown mr-lg-3">
                              
                               
                            </div>

                            <!-- Divider -->
                            <div class="nav-item d-none d-lg-block text-big font-weight-light line-height-1 opacity-25 mr-3 ml-1">|</div>
                            <div class="demo-navbar-user nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                                    <span class="d-inline-flex flex-lg-row-reverse align-items-center align-middle">
                                          <i class="feather icon-user d-block ui-w-30 rounded-circle"></i>
                                        <span class="px-1 mr-lg-2 ml-2 ml-lg-0">lol</span>
                                    </span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a href="profil" class="dropdown-item">
                                        <i class="feather icon-user text-muted"></i> &nbsp; Mon Profil</a>
                                    
                                    <div class="dropdown-divider"></div>
                                    <a href="deconnexion" class="dropdown-item">
                                        <i class="feather icon-power text-danger"></i> &nbsp; Se deconnecter</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
               
              <div class="layout-content">

                  
		</div> 
                   
                    <nav class="layout-footer footer bg-white">
                        <div class="container-fluid d-flex flex-wrap justify-content-between text-center container-p-x pb-3">
                            <div class="pt-3">
                                <span class="footer-text font-weight-semibold">&copy; ETU 1165_1168 /span>
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
