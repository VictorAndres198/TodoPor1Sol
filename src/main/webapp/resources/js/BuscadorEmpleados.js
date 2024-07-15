 //SCRIPT PARA EL BUSCADOR EMPLEADOS-->

function doSearch() {
    const searchTerm = document.getElementById('searchTerm').value.toLowerCase();
    const table = document.getElementById('Table-Empleados');
    const rows = table.getElementsByTagName('tr');

    for (let i = 1; i < rows.length; i++) { // Empezando desde 1 para omitir la fila del encabezado
        const cells = rows[i].getElementsByTagName('td');
        let match = false;

        for (let j = 0; j < cells.length; j++) {
            if (cells[j].innerText.toLowerCase().includes(searchTerm)) {
                match = true;
                break;
            }
        }

        if (match) {
            rows[i].style.display = '';
        } else {
            rows[i].style.display = 'none';
        }
    }
}
