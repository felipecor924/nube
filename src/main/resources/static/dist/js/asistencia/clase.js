$(document).ready(function () {
    $("#registroForm").submit(function (e) {
        e.preventDefault();

        registrar()
    });

    cargarpoblacion();
    cargartipo();
    cargaraula();
    cargaruniversidad();
    cargarprograma();

});



function registrar() {
    let loadurl = url + 'clase';

      // Obtener los valores de los campos del formulario
    let nombre = $("#nombre").val();
    let apellido = $("#apellido").val();
    let documento = $("#documento").val();
    let telefono = $("#telefono").val();
    let codigo = $("#codigo").val();
    let fechaNacimiento = $("#fechaNacimiento").val();
    let sexo = $("#sexo").val();
    let idPoblacionEspecial = $("#idPoblacionEspecial").val();
    let idTipoUsuario = $("#idTipoUsuario").val();
    let fecha = $("#fecha").val();
    let otroPrograma = $("#otroPrograma").val();
    let otroUniversidad = $("#otroUniversidad").val();
    let codigoCarrera = $("#codigoCarrera").val();
    let nombreMateria = $("#nombreMateria").val();
    let nombreDocente = $("#nombreDocente").val();
    let idAula = $("#idAula").val();
    let idPersona = $("#idPersona").val();
    let idProgramaAcademico = $("#idProgramaAcademico").val();
    let idUniversidad = $("#idUniversidad").val();

    if (idProgramaAcademico === 'otro') {
        idProgramaAcademico = '';
    }

    // Crear objeto con los datos del formulario
    let data = {
        nombre: nombre,
        apellido: apellido,
        documento: documento,
        telefono: telefono,
        codigo: codigo,
        fechaNacimiento: fechaNacimiento,
        sexo: sexo,
        idPoblacionEspecial: idPoblacionEspecial,
        idTipoUsuario: idTipoUsuario,
        fecha: fecha,
        otroPrograma: otroPrograma,
        otroUniversidad: otroUniversidad,
        codigoCarrera: codigoCarrera,
        nombreMateria: nombreMateria,
        nombreDocente: nombreDocente,
        idAula: idAula,
        idPersona: idPersona,
        idProgramaAcademico: idProgramaAcademico,
        idUniversidad: idUniversidad
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