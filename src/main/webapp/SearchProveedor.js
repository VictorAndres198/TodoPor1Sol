
async function FindAllProveedor() {
    try {
        const response = await fetch('http://localhost:8080/TodoPor1Sol/SvProveedor', {
                method: 'GET',
                headers: {
                    'Accept': 'application/json; charset=UTF-8'
                }
            });
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
        cellRUC.textContent = prov.ruc;

        const cellNombre = row.insertCell();
        cellNombre.textContent = prov.nombre;

        const cellPais = row.insertCell();
        cellPais.textContent = prov.pais;

        const cellTelefono = row.insertCell();
        cellTelefono.textContent = prov.telefono;

        const cellCorreo = row.insertCell();
        cellCorreo.textContent = prov.correo;
        
        const cellBtns = row.insertCell();
        cellBtns.innerHTML = '<button type="button" class="btn btn-success" \n\
                            data-bs-toggle="modal" data-bs-target="#ProveedorModal">\n\
                            <i class="fas fa-edit"></i></button>\n\
                            <button type="button" class="btn btn-danger">\n\
                            <i class="fas fa-trash-alt"></i></button>';
    });
}

// se espera a que el DOM este cargado(Loaded ) para construir recien la tabla
document.addEventListener('DOMContentLoaded', buildTable);
    

