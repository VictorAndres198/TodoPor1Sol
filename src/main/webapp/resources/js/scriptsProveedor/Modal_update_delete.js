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
            const rucProveedor = row.cells[0].textContent;
            
            if (button.classList.contains('btn-success')) {
                /* rellenamos cada uno de los campos de la ventana modal
                 con los valores de la fila seleccionada*/
                document.getElementById('ruc').value = rucProveedor;
                document.getElementById('nombre').value = row.cells[1].textContent;
                document.getElementById('pais').value = row.cells[2].textContent;
                document.getElementById('telefono').value = row.cells[3].textContent;
                document.getElementById('correo').value = row.cells[4].textContent;
                
            } else if (button.classList.contains('btn-danger')) {
                deleteProveedor(row);
                buildTable();
                alert("Proveedor con ruc "+rucProveedor+" satisfactoriamente");
            }
        }
    });
})();

//Esta funcion va en el Boton Actualizar del Modal
function updateProveedor(){
    // Falta implementar
    
    //Hacer un PUT al SvProoveedor ...
        //Hacer un DELETE al SvProoveedor ...
        // Definimos la ruta del Servlet al que se hace la peticion
    const url = 'http://localhost:8080/TodoPor1Sol/SvProveedor';
    //definimos los datos a actualizar
    const rucValue =  document.getElementById('ruc').value;
    const nombreValue =  document.getElementById('nombre').value;
    const paisValue =  document.getElementById('pais').value;
    const telefonoValue =  document.getElementById('telefono').value;
    const correoValue =  document.getElementById('correo').value;
    
    // creamos el objeto data que tene al roveedor a actualizar
      const data = {ruc:rucValue,
                nombre:nombreValue,
                pais:paisValue,
                telefono:telefonoValue,
                correo:correoValue};
 
    //Funcion realizar la peticion con los datos en JSON
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if(data.status==="Error"){
            alert(data.message);
        }else{
            console.log(data);
        }
    })
    .catch(error => console.error('Error:', error));
    
    //Mostrar un mensaje de quese actualizaron los datos
    var updateInfo = document.createElement("p");
    updateInfo.textContent = "Datos actualizados correctamente";
    updateInfo.style.border = "2px solid darkgreen";
    updateInfo.style.backgroundColor = "#d3ffba";
    updateInfo.style.padding = "10px"; // 
    document.getElementById('modalProv').appendChild(updateInfo);;
    
    //borrar el mensaje despues de 3 seg.
    setTimeout(function() {
        document.getElementById("modalProv").removeChild(updateInfo);
        buildTable();
        }, 3000);
    
}

function deleteProveedor(row){
    //Hacer un DELETE al SvProoveedor ...
        // Definimos la ruta del Servlet al que se hace la peticion
    const url = 'http://localhost:8080/TodoPor1Sol/SvProveedor';
    //definimos los datos a enviar
    const idProveedor =  row.cells[0].textContent;
    
    // creamos el objeto data que tene el id del proveedor a eliminar
    const data = {ruc:idProveedor};
 
    
    //Funcion realizar la peticion con los datos en JSON
    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if(data.status==="Error"){
            alert(data.message);
        }else{
            console.log(data);
        }
    })
    .catch(error => console.error('Error:', error));
    
}


