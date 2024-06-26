let url = serverurl;
//let usuario = user;
let colegio = "";

$(document).ready(function () {
    $("#publiform").submit(function (e) {
        e.preventDefault();

        guardar();
    });

    cargar();

});

function getId() {
    let url = new URL(window.location);

    let searchParams = url.searchParams;

    return searchParams.get('id'); // 'node'

}

function cargar() {

    let idu = getId();

    //let idurl = new URLSearchParams({
    //    id: idu,
    //});

    let loadurl = url + 'universidad/' + idu;

    let init = makeinitnodat();

    fetch(loadurl, init)
            .then((resp) => resp.json())
            .then(function (data) {
                colegio = data;
                console.log(data);
                
                $("#nombre").val(data.nombre);
                $("#direccion").val(data.direccion);
                $("#telefono").val(data.telContacto);

            });

}

function guardar() {

    let idu = getId();

    let loadurl = url + 'universidad/'+ idu;

    let nom = $("#nombre").val();
    let dir = $("#direccion").val();
    let tel = $("#telefono").val();


    let data = {
      
    	nombre: nom,
        direccion: dir,
        telContacto: tel,
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
                alert("se ha actualizado la universidad");
                location.href = "./universidad.html";

            });


}

function makeinit(data) {
    let heads = new Headers();
    heads.append("Accept", "application/json");
    heads.append("Content-Type", "application/json");
    //heads.append("Authorization", authToken);
    heads.append("Access-Control-Allow-Origin", '*');
    let init = {
        method: 'PUT',
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