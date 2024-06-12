

function clearInputs() {
    // Obtiene el Form por su ID
    const formulario = document.getElementById('form-validation');
    formulario.reset(); // Limpia los inputs del Frm
}

//Funcion para capturar el contenido de cada input del Frm
function getFormData(){
  const rucValue = document.querySelector("[name='ruc']").value;
  const nombreValue = document.querySelector("[name='nombre']").value;
  const paisValue = document.querySelector("[name='pais']").value;
  const telefonoValue = document.querySelector("[name='telefono']").value;
  const correoValue = document.querySelector("[name='correo']").value;
  
  // creamos el objetivo data que contendra toda la info del Proveedor a registrar
  const data = {ruC:rucValue,
                nombre:nombreValue,
                pais:paisValue,
                telefono:telefonoValue,
                correo:correoValue};
  //Returnamos el objeto
  return data; 
}

function sendData(){
    // Definimos la ruta del Servlet al que se hace la peticion
    const url = 'http://localhost:8080/TodoPor1Sol/SvProveedor';
    //definimos los datos a enviar
    const data = getFormData();
    
    //Funcion realizar la peticion con los datos en JSON
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json()) 
    .then(data => console.log('Success:', data))
    .catch(error => console.error('Error:', error));
    //funciones console log es para tener una traza del resultado  
}




