<%-- 
    Document   : RegistrarPagina
    Created on : 4/11/2014, 10:12:53 PM
    Author     : Joaquin David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Formulario de Registro Paginas</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body style="margin-top: 0px;">
        <div class="container">

            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h3 class="text-center login-title">Registro de Paginas</h3>
                    <div class="account-wall">
                        <br>
                        <div name="formulario" class="form-signin" >
                            <input type="text" class="form-control" placeholder="Title" name="title" id="title" required autofocus>
                            <br>
                            <input type="text" class="form-control" placeholder="Description" name="description" id="description" required>
                            <br>
                            <input type="text" class="form-control" placeholder="Url" name="url" id="url" required>
                            <br>
                            <button class="btn btn-lg btn-primary btn-block" id="registro" name="registro">
                                Guardar Pagina</button>
                        </div>
                    </div>
                    <a href="index.html">Atras</a>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/GuardarPagina.js"></script>
    </body>
</html>
