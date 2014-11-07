$(window).ready(function () {
    $("#registro").click(function () {
        registrar();
    });
});

function registrar() {

//    datos = {
//        title: $("#title").val(),
//        description: $("#description").val(),
//        url: $("#url").val()
//    }
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/WebSiteLab2/webresources/WebService/SetFeeds",
        headers: {
            'title': $("#title").val(),
            'description': $("#description").val(),
            'url': $("#url").val()
        },
        contentType: "application/json",
        // dataType: "json",
        // data: JSON.stringify(datos),
        success: function (respuesta, b, c) {
            console.log(respuesta);
            console.log(b);
            console.log(c);
            if (respuesta) {
                alert(respuesta.mensaje);
            }
            else {
                console.log("Failed: " + respuesta.mensaje);
                alert("Ha ocurrido un error guardando la Pagina. Intente más tarde.");
            }
        },
        error: function (json, b, c) {
            console.log(json);
            console.log(b);
            console.log(c);
            alert("Ha ocurrido un error enviando el formulario de registro. Intente más tarde.");
        }
        //complete: function (a, b, c) {
            // windows.location="http://localhost:8080/WebSiteLab2/ObtenerInfoPaginas";
            //     console.log(a);
            //     console.log(b);
            //     console.log(c);
       // }
    });
}