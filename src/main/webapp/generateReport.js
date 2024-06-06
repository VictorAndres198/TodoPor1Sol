function getTableData(){
    const table = document.getElementById('Table-Proveedores');
    const rows = table.querySelector('tbody').querySelectorAll('tr');
    const data = [];

    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        const rowData = {
            RUC: cells[0].textContent,
            Nombre: cells[1].textContent,
            Pais: cells[2].textContent,
            Telefono: cells[3].textContent,
            Correo: cells[4].textContent
        };
        data.push(rowData);
    });
    return data;
}

function sendReportData(){
    // Definimos la ruta del Servlet al que se hace la peticion
    const url = 'http://localhost:8080/TodoPor1Sol/SvReporteProveedor';
    //definimos los datos a enviar
    const data = getTableData();
    
    //Funcion realizar la peticion con los datos en JSON
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json()) 
    .then(result => console.log(result))
    .catch(error => console.error('Error:', error));
    //funciones console log es para tener una traza del resultado  
}



