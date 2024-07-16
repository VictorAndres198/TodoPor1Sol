(function buildModal(){
    // Añadir el event listener para los botones dentro de la tabla
    document.getElementById('Table-Proveedores').addEventListener('click', function(event) {
        if (event.target.tagName === 'BUTTON' || event.target.tagName === 'I') {
            // Encuentra el botón que se ha clickeado
            let button = event.target;
            if (button.tagName === 'I') {
                button = button.parentElement;
            }
            const row = button.closest('tr');

            if (button.classList.contains('btn-success')) {
                /* rellenamos cada uno de los campos de la ventana modal
                 con los valores de la fila seleccionada*/
                document.getElementById('ruc').value = row.cells[0].textContent;
                document.getElementById('ruc').readOnly=true;
                document.getElementById('nombre').value = row.cells[1].textContent;
                document.getElementById('pais').value = row.cells[2].textContent;
                document.getElementById('telefono').value = row.cells[3].textContent;
                document.getElementById('correo').value = row.cells[4].textContent;
                
            } else if (button.classList.contains('btn-danger')) {
                deleteProveedor(row);
            }
        }
    });
})();

//Esta funcion va en el Boton Actualizar del Modal
function updateProveedor(){
    // Falta implementar
    const idProveedor =  document.getElementById('ruc').value;
    console.log('Se actualizara el registro con id',idProveedor);
    
    //Hacer un PUT al SvProoveedor ...
}

function deleteProveedor(row){
    // Falta implementar
    const idProveedor =  row.cells[0].textContent;
    console.log('Se eliminara el registro con id',idProveedor);
    
    //Hacer un DELETE al SvProoveedor ...
    
}


