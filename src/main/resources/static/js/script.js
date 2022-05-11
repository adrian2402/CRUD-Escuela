$(document).ready(function () {
    listar();
});

function listar() {
    $.ajax({
        url: "/esc/all",
        type: 'GET',
        success: function (x) {
            $("#tablita tbody tr").remove();
            for (var i = 0; i < x.length; i++) {
                $("#tablita").append(
                        "<tr><td>" + (i + 1) + "</td><td>" + x[i].idescuela + "</td><td>" + x[i].nombre
                        + "</td><td><a href='#' onclick='editar("
                        + x[i].idescuela + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idescuela + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
            }
        }
    });
}

function editar (id){
    $.ajax({
        url: "/esc/" + id,
        type: 'GET',
        success: function (w) {
            $("#editar_nombre").val(w.nombre);
            $("#idpost").val(w.idescuela);
        }
    });
    $("#modalEditar").modal('show');
}

function eliminar(id) {

    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/esc/" + id,
                    type: 'DELETE',
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro eliminado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        listar();
                    }
                });
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
}

function limpiar() {
    $("#nombre").val("");
}

$("#guardar").click(function () {
    var nombre = $("#nombre").val();
    $.ajax({
        url: "/esc/add",
        type: 'Post',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({'nombre': nombre}),
        cache: false,
        success: function (w) {
            bootbox.alert({
                message: "Registro guardado correctamente...!",
                callback: function () {
                    console.log('This was logged in the callback!');
                }
            });
            limpiar();
            listar();
        }
    });
    $("#modalGuardar").modal('hide');
});


$("#modificar").click(function () {
    var nombre = $("#editar_nombre").val();
    var id = $("#idpost").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.ajax({
                    url: "/esc/edit",
                    type: 'PUT',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({'idescuela': id, 'nombre': nombre}),
                    cache: false,
                    success: function (w) {
                        bootbox.alert({
                            message: "Registro Modificado correctamente...!",
                            callback: function () {
                                console.log('This was logged in the callback!');
                            }
                        });
                        limpiar();
                        listar();
                    }
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});