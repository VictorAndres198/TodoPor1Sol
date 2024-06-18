function getTableData(){
    const table = document.getElementById('Table-Proveedores');
    const rows = table.querySelector('tbody').querySelectorAll('tr');
    const data = [];

    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        const rowData = {
            ruc: cells[0].textContent,
            nombre: cells[1].textContent,
            pais: cells[2].textContent,
            telefono: cells[3].textContent,
            correo: cells[4].textContent
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
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            return response.blob();  // Obtener la respuesta como Blob
        } else {
            throw new Error('Error en la respuesta del servidor');
        }
    })
    .then(blob => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'ReporteProveedores.pdf';  // Nombre del archivo a descargar
        document.body.appendChild(a);  // Necesario para Firefox
        a.click();
        a.remove();
        window.URL.revokeObjectURL(url);
    })
    .catch(error => console.error('Error:', error));  
}



