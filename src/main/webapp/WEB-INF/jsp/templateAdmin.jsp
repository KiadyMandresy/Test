<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<%@ page import="controller.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
   
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
                   

                    <!-- Layouts -->
                    <li class="sidenav-divider mb-1"></li>
                   
                   
                      <li class="sidenav-item">
                        <a  class="sidenav-link" href="${pageContext.request.contextPath}/listeSignalement?lim=1">
                             <i class="sidenav-icon feather icon-bold"></i>
                            <div>Liste des signalements</div>
                        </a>
                    
                      </li>
                    
                  
                    <li class="sidenav-header small font-weight-semibold">Crud</li>
                     <li class="sidenav-item">
                        <a href="${pageContext.request.contextPath}/insertionChefRegion" class="sidenav-link">
                             <i class="sidenav-icon feather icon-trending-up"></i>
                            <div>Chef de region</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a href="ligne?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-trending-up"></i>
                            <div>Region</div>
                        </a>
                    </li>
                    </li>
                    <li class="sidenav-header small font-weight-semibold">Statistiques</li>
                     <li class="sidenav-item">
                        <a href="${pageContext.request.contextPath}/stat_Probleme" class="sidenav-link">
                             <i class="sidenav-icon feather icon-trending-up"></i>
                            <div>Classement des regions par nombres de signalement</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a href="bus?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-bold"></i>
                            <div>Classement des regions par depense</div>
                        </a>
                    </li>
                    <li class="sidenav-item">
                        <a href="chauffeur?lim=1" class="sidenav-link">
                             <i class="sidenav-icon feather icon-user"></i>
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

                        <div class="navbar-nav align-items-lg-center">
                            <!-- Search -->
                            <label class="nav-item navbar-text navbar-search-box p-0 active">
                                <i class="feather icon-search navbar-icon align-middle"></i>
                                <span class="navbar-search-input pl-2">
                                  <input type="text" class="form-control navbar-text mx-2" placeholder="Search...">
                                </span>
                            </label>
                        </div>

                        <div class="navbar-nav align-items-lg-center ml-auto">
                            <div class="demo-navbar-notifications nav-item dropdown mr-lg-3">
                                <a class="nav-link dropdown-toggle hide-arrow" href="#" data-toggle="dropdown">
                                    <i class="feather icon-bell navbar-icon align-middle"></i>
                                    <span class="badge badge-danger badge-dot indicator"></span>
                                    <span class="d-lg-none align-middle">&nbsp; Notifications</span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <div class="bg-primary text-center text-white font-weight-bold p-3">
                                        4 New Notifications
                                    </div>
                                    <div class="list-group list-group-flush">
                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <div class="ui-icon ui-icon-sm feather icon-home bg-secondary border-0 text-white"></div>
                                            <div class="media-body line-height-condenced ml-3">
                                                <div class="text-dark">Login from 192.168.1.1</div>
                                                <div class="text-light small mt-1">
                                                    Aliquam ex eros, imperdiet vulputate hendrerit et.
                                                </div>
                                                <div class="text-light small mt-1">12h ago</div>
                                            </div>
                                        </a>

                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <div class="ui-icon ui-icon-sm feather icon-user-plus bg-info border-0 text-white"></div>
                                            <div class="media-body line-height-condenced ml-3">
                                                <div class="text-dark">You have
                                                    <strong>4</strong> new followers</div>
                                                <div class="text-light small mt-1">
                                                    Phasellus nunc nisl, posuere cursus pretium nec, dictum vehicula tellus.
                                                </div>
                                            </div>
                                        </a>

                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <div class="ui-icon ui-icon-sm feather icon-power bg-danger border-0 text-white"></div>
                                            <div class="media-body line-height-condenced ml-3">
                                                <div class="text-dark">Server restarted</div>
                                                <div class="text-light small mt-1">
                                                    19h ago
                                                </div>
                                            </div>
                                        </a>

                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <div class="ui-icon ui-icon-sm feather icon-alert-triangle bg-warning border-0 text-dark"></div>
                                            <div class="media-body line-height-condenced ml-3">
                                                <div class="text-dark">99% server load</div>
                                                <div class="text-light small mt-1">
                                                    Etiam nec fringilla magna. Donec mi metus.
                                                </div>
                                                <div class="text-light small mt-1">
                                                    20h ago
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <a href="javascript:" class="d-block text-center text-light small p-2 my-1">Show all notifications</a>
                                </div>
                            </div>

                            <div class="demo-navbar-messages nav-item dropdown mr-lg-3">
                                <a class="nav-link dropdown-toggle hide-arrow" href="#" data-toggle="dropdown">
                                    <i class="feather icon-mail navbar-icon align-middle"></i>
                                    <span class="badge badge-success badge-dot indicator"></span>
                                    <span class="d-lg-none align-middle">&nbsp; Messages</span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <div class="bg-primary text-center text-white font-weight-bold p-3">
                                        4 New Messages
                                    </div>
                                    <div class="list-group list-group-flush">
                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <img src="assets/img/avatars/6-small.png" class="d-block ui-w-40 rounded-circle" alt>
                                            <div class="media-body ml-3">
                                                <div class="text-dark line-height-condenced">Lorem ipsum dolor consectetuer elit.</div>
                                                <div class="text-light small mt-1">
                                                    Josephin Doe &nbsp;·&nbsp; 58m ago
                                                </div>
                                            </div>
                                        </a>

                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <img src="assets/img/avatars/4-small.png" class="d-block ui-w-40 rounded-circle" alt>
                                            <div class="media-body ml-3">
                                                <div class="text-dark line-height-condenced">Lorem ipsum dolor sit amet, consectetuer.</div>
                                                <div class="text-light small mt-1">
                                                    Lary Doe &nbsp;·&nbsp; 1h ago
                                                </div>
                                            </div>
                                        </a>

                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <img src="assets/img/avatars/5-small.png" class="d-block ui-w-40 rounded-circle" alt>
                                            <div class="media-body ml-3">
                                                <div class="text-dark line-height-condenced">Lorem ipsum dolor sit amet elit.</div>
                                                <div class="text-light small mt-1">
                                                    Alice &nbsp;·&nbsp; 2h ago
                                                </div>
                                            </div>
                                        </a>

                                        <a href="javascript:" class="list-group-item list-group-item-action media d-flex align-items-center">
                                            <img src="assets/img/avatars/11-small.png" class="d-block ui-w-40 rounded-circle" alt>
                                            <div class="media-body ml-3">
                                                <div class="text-dark line-height-condenced">Lorem ipsum dolor sit amet consectetuer amet elit dolor sit.</div>
                                                <div class="text-light small mt-1">
                                                    Suzen &nbsp;·&nbsp; 5h ago
                                                </div>
                                            </div>
                                        </a>
                                    </div>

                                    <a href="javascript:" class="d-block text-center text-light small p-2 my-1">Show all messages</a>
                                </div>
                            </div>

                            <!-- Divider -->
                            <div class="nav-item d-none d-lg-block text-big font-weight-light line-height-1 opacity-25 mr-3 ml-1">|</div>
                            <div class="demo-navbar-user nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                                    <span class="d-inline-flex flex-lg-row-reverse align-items-center align-middle">
                                        <img src="assets/img/avatars/1.png" alt class="d-block ui-w-30 rounded-circle">
                                        <span class="px-1 mr-lg-2 ml-2 ml-lg-0">Cindy Deitch</span>
                                    </span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a href="javascript:" class="dropdown-item">
                                        <i class="feather icon-user text-muted"></i> &nbsp; My profile</a>
                                    <a href="javascript:" class="dropdown-item">
                                        <i class="feather icon-mail text-muted"></i> &nbsp; Messages</a>
                                    <a href="javascript:" class="dropdown-item">
                                        <i class="feather icon-settings text-muted"></i> &nbsp; Account settings</a>
                                    <div class="dropdown-divider"></div>
                                    <a href="javascript:" class="dropdown-item">
                                        <i class="feather icon-power text-danger"></i> &nbsp; Log Out</a>
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
