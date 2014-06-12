/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*Dado el codigo ASCII determina si es una letra*/
function esLetra(code) {
    alert("aca letras");
    return (code >= 65 && code <= 90);
}

/*Dado el codigo ASCII determina si es un digito*/
function esDigito(code) {
    return (code >= 48 && code <= 57);
}

function cargarMedicamentos() {
    var idPanelMensajes = $("form").attr("id") + ":popupMedicamentos";
    RichFaces.$(idPanelMensajes).show();
}

function cargarImpresiones() {
    var idPanelMensajes = $("form").attr("id") + ":popupImpresiones";
    RichFaces.$(idPanelMensajes).show();
}


function cargarOrdenes() {
    var idPanelMensajes = $("form").attr("id") + ":popupOm";
    RichFaces.$(idPanelMensajes).show();
}

function cargarManejos() {
    var idPanelMensajes = $("form").attr("id") + ":popupMs";
    RichFaces.$(idPanelMensajes).show();

}


function cargarEpicrisis() {
    var idPanelMensajes = $("form").attr("id") + ":popupEpi";
    RichFaces.$(idPanelMensajes).show();

}

function cargarExamenes() {
    var idPanelMensajes = $("form").attr("id") + ":popupEf";
    RichFaces.$(idPanelMensajes).show();
}

function cargarEditarDatosPersonales() {
    var idPanelMensajes = $("form").attr("id") + ":popupEditarDp";
    RichFaces.$(idPanelMensajes).show();
}


function cargarCitas() {
    var idPanelMensajes = $("form").attr("id") + ":popupCitas";
    RichFaces.$(idPanelMensajes).show();
}

function  alerta(){
    alert('HOLA');
}


