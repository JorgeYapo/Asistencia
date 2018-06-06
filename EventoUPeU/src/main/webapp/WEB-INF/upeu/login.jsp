<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 |UPeU</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/libs/bootstrap/css/bootstrap.min.css' />"  />
  <!-- Font Awesome -->
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/libs/iconos/css/font-awesome.css' />"  />
  <!-- Ionicons -->
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/libs/iconos/css/ionicons.css' />"  /> 
  <!-- Theme style -->
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/libs/dist/css/AdminLTE.min.css' />"  /> 
  <!-- iCheck -->  
  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/libs/dist/css/skins/skin-blue.min.css' />"  /> 

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
      <b>Admin</b>LTE - <b>UPeU</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Formulario de Ingreso al Sistema</p>

    <form action="${pageContext.request.contextPath}/validar" method="post">
      <div class="form-group has-feedback">
          <input type="text" class="form-control" name="usuario" placeholder="Usuario">
        <span class="glyphicon glyphicon-credit-card form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" class="form-control" name="clave" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
        </div>
        <!-- /.col -->
      </div>
    </form>




  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="<c:url value='/resources/libs/plugins/jQuery/jquery-2.2.3.min.js' />"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value='/resources/libs/bootstrap/js/bootstrap.min.js' />"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/resources/libs/dist/js/app.min.js' />"></script>

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
