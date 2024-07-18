async function FindAllPedidos() {
    try {
        const response = await fetch('http://localhost:8080/TodoPor1Sol/SvPedidos');
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
    data = await FindAllPedidos();
    const table = document.getElementById('Table-Pedidos').getElementsByTagName('tbody')[0];
    table.innerHTML = '';

    data.forEach(pedido => {
        const row = table.insertRow();

        const cellID = row.insertCell();
        cellID.textContent = pedido.id;
        
        const cellFH = row.insertCell();
        cellFH.textContent = pedido.fechaHora;
        
        const cellprecioT = row.insertCell();
        cellprecioT.textContent = pedido.PrecioTotal;
        
        const cell_IGV = row.insertCell();
        cell_IGV.textContent = pedido.IGV;
        
        const cellPrecioFinal = row.insertCell();
        cellPrecioFinal.textContent = pedido.PrecioFinal;

        const cellBtns = row.insertCell();
        cellBtns.innerHTML = '<button type="button" class="btn btn-success" \n\
                            data-bs-toggle="modal" data-bs-target="#ProveedorModal">\n\
                            <i class="fa-solid fa-file-excel"></i></button>\n\
                            <button type="button" class="btn btn-danger">\n\
                            <i class="fa-solid fa-file-pdf"></i></button>';
    });
}

// se espera a que el DOM este cargado(Loaded ) para construir recien la tabla
document.addEventListener('DOMContentLoaded', buildTable);

(function SearchItems(){
    // Añadir el event listener para los botones dentro de la tabla
    document.getElementById('Table-Pedidos').addEventListener('click', function(event) {
        if (event.target.tagName === 'BUTTON' || event.target.tagName === 'I') {
            // Encuentra el botón que se ha clickeado
            let button = event.target;
            if (button.tagName === 'I') {
                button = button.parentElement;
            }
            
            const row = button.closest('tr');
            const PedidoId = row.cells[0].textContent;
            
            // Definimos la ruta del Servlet al que se hace la peticion
            const url = 'http://localhost:8080/TodoPor1Sol/SvPedidos';
            //definimos los datos a enviar
            const data = {id:PedidoId};

            //Funcion realizar la peticion con los datos en JSON
            fetch(url, {
                method: 'POST',
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
            });  
           
        }
    });
})();