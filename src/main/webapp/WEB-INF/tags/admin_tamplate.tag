<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ attribute name="title" required="true"  rtexprvalue="true" %>
<%@ attribute name="content" fragment="true" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>${title}</title>

  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/bower_components/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/bower_components/Ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/bower_components/jvectormap/jquery-jvectormap.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <a href="${pageContext.request.contextPath}/admin/dashboard" class="logo">
      <span class="logo-mini"><b></b>Med</span>
      <span class="logo-lg"><b></b>ConsulteMed</span>
    </a>
    <nav class="navbar navbar-static-top">
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
      
        <ul class="nav navbar-nav">

          <li>
          	<a href="${pageContext.request.contextPath}/logout">Sair</a>
          </li>
          
          <li>
            <a href="#" data-toggle="control-sidebar">Temas</a>
          </li>
          
        </ul>
      </div>
    </nav>
  </header>

  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
      	 <div align="left">
          <strong> ${user}, Online</strong> <i class="fa fa-circle text-success"></i>
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="active treeview">
          <a href="${pageContext.request.contextPath}/admin/dashboard">
            <i class="fa fa-dashboard"></i> 
            <span >Menu</span>
          </a>
        </li>
        
        <li><a href="${pageContext.request.contextPath}/admin/contatos?action=list"><i class="fa fa-circle-o text-aqua"></i> <span>Contatos</span></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/usuarios?action=list"><i class="fa fa-circle-o text-aqua"></i> <span>Usuários</span></a></li>
<!--         <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Solicitações</span></a></li> -->
      </ul>
    </section>

  </aside>


  <div class="content-wrapper">
  
  
  <jsp:invoke fragment="content"></jsp:invoke>
  
  
  </div>

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2018-2019 <a href="https://github.com/CarlosBarbosaFilho">Carlos Barbosa G. Filho</a>.</strong> Todos os direitos reservsados
  </footer>


  <aside class="control-sidebar control-sidebar-dark">
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>

    <div class="tab-content">
      <div class="tab-pane" id="control-sidebar-home-tab"/>
         
      </div>
    </div>
  </aside>
</div>


<script src="${pageContext.request.contextPath}/assets/admin/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/jquery-ui/jquery-ui.min.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>

<script src="${pageContext.request.contextPath}/assets/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/raphael/raphael.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/bower_components/fastclick/lib/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/dist/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/admin/dist/js/demo.js"></script>
</body>
</html>
 