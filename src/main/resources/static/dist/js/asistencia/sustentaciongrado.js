let url = serverurl;
 persona= null;

$(document).ready(function () {
    $("#registroForm").submit(function (e) {
        e.preventDefault();

        registrar()
    });

    cargarpoblacion();
    cargartipo();
    cargarcurso();
    cargaruniversidad();
    cargarprograma();

});

function registrar() {
    let loadurl = url + 'cursoclase';

  // Obtener los valores de los campos del formulario
   
    let fechaVisita = $("#fechaVisita").val();
    let sesion = $("#sesion").val();
    let otroPrograma = $("#otroPrograma").val();
    let idCurso = $("#idCurso").val();
    let idPersona = $("#idPersona").val();
    let idProgramaAcademico = $("#idProgramaAcademico").val();
    let idUniversidad = $("#idUniversidad").val();
    let nombre = $("#nombre").val();
    let apellido = $("#apellido").val();
    let documento = $("#documento").val();
    let telefono = $("#telefono").val();
    let codigo = $("#codigo").val();
    let fechaNacimiento = $("#fechaNacimiento").val();
    let sexo = $("#sexo").val();
    let idPoblacionEspecial = $("#idPoblacionEspecial").val();
    let idTipoUsuario = $("#idTipoUsuario").val();

    // Crear objeto con los datos del formulario
    let data = {
        fecha: fechaVisita,
        otroPrograma: otroPrograma,
        idPersona: idPersona,
        idProgramaAcademico: idProgramaAcademico,
        idUniversidad: idUniversidad,
        nombre: nombre,
        apellido: apellido,
        documento: documento,
        telefono: telefono,
        codigo: codigo,
        fechaNacimiento: fechaNacimiento,
        sexo: sexo,
        idPoblacionEspecial: idPoblacionEspecial,
        idTipoUsuario: idTipoUsuario
    };

    console.log(data);
    let init = makeinit(data)

    fetch(loadurl, init)
            .then((resp) => resp.json())
            .then(function (data) {
                if (data.msg) {
                    console.log(data);
                    return;
                }
                console.log(data);

                console.log(data);
                alert("se ha registrado la asistencia");
                //location.href = "./colegio.html";

            });

}


 $(function() {
        $("#fechaNacimiento, #fecha , #fechaVisita").datepicker({
            dateFormat: "yy-mm-dd"
        });

        $("#documento").on("blur", function() {
            var documento = $(this).val();
            if (documento) {


                let loadurl = url + 'persona/doc/' + documento;

                let init = makeinitnodat();

                fetch(loadurl, init)
                        .then((resp) => resp.json())
                        .then(function (data) {
                            //curso = data;

                            console.log(data);

                            if (data){
                                if(!data.msg){
                                    persona = data;

                                $("#nombre").val(data.nombre);
                                $("#apellido").val(data.apellido);
                                $("#telefono").val(data.telefono);
                                $("#codigo").val(data.codigo);
                                $("#fechaNacimiento").val(data.fechaNacimiento);
                                $("#sexo").val(data.sexo);
                                $("#idPoblacionEspecial").val(data.idPoblacionEspecial);
                                $("#idTipoUsuario").val(data.idTipoUsuario);
                            } else {

                                persona = null;

                                $("#nombre").val('');
                                $("#apellido").val('');
                                $("#telefono").val('');
                                $("#codigo").val('');
                                $("#fechaNacimiento").val('');
                                $("#sexo").val('');
                                $("#idPoblacionEspecial").val('');
                                $("#idTipoUsuario").val('');
                            }

                            }

                        });
 
            }
        });
    });

function cargarpoblacion(){

    $('#idPoblacionEspecial').empty();

       let loadurl = url + 'poblacion';

                let init = makeinitnodat();

                fetch(loadurl, init)
                        .then((resp) => resp.json())
                        .then(function (data) {
                            //curso = data;

                           console.log(data);

                            let fill = ''

                            $.each(data, function (i, item) {
                                 fill += '<option value="'+ item.id +'">'+ item.nombre+'</option>';

                            });

                             $('#idPoblacionEspecial').append(fill);





                        });

               
 }

 function cargartipo(){

    $('#idTipoUsuario').empty();

       let loadurl = url + 'tipo';

                let init = makeinitnodat();

                fetch(loadurl, init)
                        .then((resp) => resp.json())
                        .then(function (data) {
                            //curso = data;

                           console.log(data);

                            let fill = ''

                            $.each(data, function (i, item) {
                                 fill += '<option value="'+ item.id +'">'+ item.tipo+'</option>';

                            });

                            $('#idTipoUsuario').append(fill);


                            $("#idTipoUsuario").val(4);

                        });

               
 }

 function cargarcurso(){

    $('#idCurso').empty();

       let loadurl = url + 'curso';

                let init = makeinitnodat();

                fetch(loadurl, init)
                        .then((resp) => resp.json())
                        .then(function (data) {
                            //curso = data;

                           console.log(data);

                            let fill = ''

                            $.each(data, function (i, item) {
                                 fill += '<option value="'+ item.id +'">'+ item.nombre+'</option>';

                            });

                            $('#idCurso').append(fill);



                        });

               
 }

 function cargaruniversidad(){

    $('#idUniversidad').empty();

       let loadurl = url + 'universidad';

                let init = makeinitnodat();

                fetch(loadurl, init)
                        .then((resp) => resp.json())
                        .then(function (data) {
                            //curso = data;

                           console.log(data);

                            let fill = ''

                            $.each(data, function (i, item) {
                                 fill += '<option value="'+ item.id +'">'+ item.nombre+'</option>';

                            });

                            $('#idUniversidad').append(fill);



                        });

               
 }

 function cargarprograma(){

    $('#idProgramaAcademico').empty();

       let loadurl = url + 'programa';

                let init = makeinitnodat();

                fetch(loadurl, init)
                        .then((resp) => resp.json())
                        .then(function (data) {
                            //curso = data;

                           console.log(data);

                            let fill = ''

                            $.each(data, function (i, item) {
                                 fill += '<option value="'+ item.id +'">'+ item.nombre+'</option>';

                            });

                            $('#idProgramaAcademico').append(fill);



                        });

               
 }

function mostrarParte1() {
    $("#parte2").hide();
    $("#parte1").show();
}

function mostrarParte2() {
    $("#parte1").hide();
    $("#parte2").show();
}


function makeinit(data) {
    let heads = new Headers();
    heads.append("Accept", "application/json");
    heads.append("Content-Type", "application/json");
    //heads.append("Authorization", authToken);
    heads.append("Access-Control-Allow-Origin", '*');
    let init = {
        method: 'POST',
        mode: 'cors',
        body: JSON.stringify(data),
        headers: heads
    };
    return init;
}

function makeinitDelete(data) {
    let heads = new Headers();
    heads.append("Accept", "application/json");
    heads.append("Content-Type", "application/json");
    //heads.append("Authorization", authToken);
    heads.append("Access-Control-Allow-Origin", '*');
    let init = {
        method: 'DELETE',
        mode: 'cors',
        body: JSON.stringify(data),
        headers: heads
    };
    return init;
}

function makeinitnodat() {
    let heads = new Headers();
    heads.append("Accept", "application/json");
    heads.append("Content-Type", "application/json");
    //heads.append("Authorization", authToken);
    heads.append("Access-Control-Allow-Origin", '*');
    let init = {
        method: 'GET',
        mode: 'cors',
        headers: heads
    };
    return init;
}