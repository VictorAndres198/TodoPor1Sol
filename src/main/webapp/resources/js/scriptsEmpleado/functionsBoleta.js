function searchClient(){
    //defifinimos la ruta base del servlet
    const baseUrl = 'http://localhost:8080/TodoPor1Sol/SvBoleta';
    
    // obtenemos el id del cliente
    const idCliente=document.getElementById('dniCliente').value.trim();
    
    //obtiene el id del empleado
    //const idempleado = document.getElementById('idEmpleado').innerText.split(': ')[1];
    
    if(idCliente===''){
       alert("El dni del cliente no puede estar vacio");
    }else{
        //construimos el url con parametros
        const url = `${baseUrl}?idCliente=${encodeURIComponent(idCliente)}`;

        //Funcion realizar la peticion con los datos en JSON
        fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            if(data.status==="Error"){
                alert(data.message);
                cleanClientInfo();
            }else{
                console.log(data);
                showClientInfo(data);
            }
        })
        .catch(error => console.error('Error:', error));
    }
}


function showClientInfo(data){
    document.getElementById('nombres').value=data.nombres;
    document.getElementById('apellidos').value=data.apellidos;
    document.getElementById('telefono').value=data.telefono;
    document.getElementById('correo').value=data.correo;
}

function cleanClientInfo(){
    document.getElementById('nombres').value='';
    document.getElementById('apellidos').value='';
    document.getElementById('telefono').value='';
    document.getElementById('correo').value='';
}

