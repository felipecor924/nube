let url = serverurl;
 persona= null;

$(document).ready(function () {
    $("#registroForm").submit(function (e) {
        e.preventDefault();

        registrar()
    });

    cargarpoblacion();
    cargarcurso();
    cargarcolegio();

});

function registrar() {
   
   let loadurl = url + 'steam';

    // Obtener los valores de los campos del formulario
    let fecha = new Date().toISOString().split('T')[0]; // Capturar la fecha actual en formato YYYY-MM-DD
    let idColegio = document.getElementById('idColegio').value;
    let idCursos = document.getElementById('idCurso').value;
    let nombre = document.getElementById('nombre').value;
    let sexo = document.getElementById('sexo').value;
    let semestre = document.getElementById('semestre').value;
    let idPoblacionEspecial = document.getElementById('idPoblacionEspecial').value;

    // Crear objeto con los datos del formulario
    let data = {
        fecha: fecha,
        idColegio: idColegio,
        idCursos: idCursos,
        nombre: nombre,
        sexo: sexo,
        semestre: semestre,
        idPoblacionEspecial: idPoblacionEspecial
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