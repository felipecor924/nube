let url = serverurl;
 persona= null;


    function mostrarCampoExtra(opcionSeleccionada) {
        // Limpiar campos extras al inicio
        document.getElementById('idSemillero').value = '';
        document.getElementById('externo').value = '';

        // Ocultar todos los campos extra al inicio
        document.getElementById('campoSemillero').style.display = 'none';
        document.getElementById('campoExterno').style.display = 'none';

        // Mostrar el campo extra correspondiente según la opción seleccionada
        if (opcionSeleccionada === 'semillero') {
            document.getElementById('campoSemillero').style.display = 'block';
        } else if (opcionSeleccionada === 'externo') {
            document.getElementById('campoExterno').style.display = 'block';
        }
    }

function mostrarCampoOtroPrograma(opcionSeleccionada) {
        const campoOtroPrograma = document.getElementById('campoOtroPrograma');
        if (opcionSeleccionada === 'otro') {
            campoOtroPrograma.style.display = 'block';
        } else {
            campoOtroPrograma.style.display = 'none';
            document.getElementById('otroPrograma').value = '';
        }
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

                            fill += '<option value="otro">Otro</option>';

                            $('#idProgramaAcademico').append(fill);



                        });
}

function cargaraula(){

    $('#idAula').empty();

       let loadurl = url + 'aula';

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

                            $('#idAula').append(fill);



                        });
}

function cargarcolegio(){

    $('#idColegio').empty();

       let loadurl = url + 'colegio';

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

                            $('#idColegio').append(fill);



                        });
}

 function cargarsemillero(){

    $('#idSemillero').empty();

       let loadurl = url + 'semillero';

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

                            $('#idSemillero').append(fill);



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