
async function FindAllProveedor() {
    try {
        const response = await fetch('http://localhost:8080/TodoPor1Sol/SvProveedor');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        console.log(data); //para verificar el resultado
        return data;
    } catch (error) {
        console.error('Error:', error);
        return [];
    }
}


async function buildTable() {
    data = await FindAllProveedor();
    const table = document.getElementById('Table-Proveedores').getElementsByTagName('tbody')[0];
    table.innerHTML = '';

    data.forEach(prov => {
        const row = table.insertRow();

        const cellRUC = row.insertCell();
        cellRUC.textContent = prov.RUC;

        const cellNombre = row.insertCell();
        cellNombre.textContent = prov.Nombre;

        const cellPais = row.insertCell();
        cellPais.textContent = prov.Pais;

        const cellTelefono = row.insertCell();
        cellTelefono.textContent = prov.Telefono;

        const cellCorreo = row.insertCell();
        cellCorreo.textContent = prov.Correo;
    });
}

// se espera a que el DOM este cargado(Loaded ) para construir recien la tabla
document.addEventListener('DOMContentLoaded', buildTable);
    

