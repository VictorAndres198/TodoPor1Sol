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


async function buildTablePedidos() {
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
        cellBtns.innerHTML = '<button type="button" class="btn btn-dark">\n\
                             <i class="fa-solid fa-circle-info"></i></button>\n\
                             <button type="button" class="btn btn-danger">\n\
                             <i class="fa-solid fa-file-pdf"></i></button>';
    });
}

// se espera a que el DOM este cargado(Loaded ) para construir recien la tabla
document.addEventListener('DOMContentLoaded', buildTablePedidos);



//Esta funcion va en el Boton Actualizar del Modal
function FindDetallePedido(idPedido){
    const url = 'http://localhost:8080/TodoPor1Sol/SvPedidos';
    
    // creamos el objeto data de los items a buscar
    const data = {id:idPedido};
 
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
            buildTableDetallePedido(data);
        }
    })
    .catch(error => console.error('Error:', error));
}


(function getInfoPedido(){
    // Añadir el event listener para los botones dentro de la tabla
    document.getElementById('Table-Pedidos').addEventListener('click', function(event) {
              
    if (event.target.tagName === 'BUTTON' || event.target.tagName === 'I') {
    // Encuentra el botón que se ha clickeado
    let button = event.target;
    if (button.tagName === 'I') {
        button = button.parentElement;
    }
    const row = button.closest('tr');
    const idPedido = row.cells[0].textContent;
            
            if (button.classList.contains('btn-dark')) {
                FindDetallePedido(idPedido);
            }
        }  
    });
})();

function buildTableDetallePedido(dataItems) {
    data = dataItems;
    const table = document.getElementById('Table-DetallePedidos').getElementsByTagName('tbody')[0];
    table.innerHTML = '';

    data.forEach(item => {
        const row = table.insertRow();

        const cell_ID_Pedido = row.insertCell();
        cell_ID_Pedido.textContent = item.id;
        
        const cell_ID_Producto = row.insertCell();
        cell_ID_Producto.textContent = item.producto.ID_Prod;
        
        const cell_nombre_prod = row.insertCell();
        cell_nombre_prod.textContent = item.producto.Nombre;
        
        const cell_cant = row.insertCell();
        cell_cant.textContent = item.cantidad;
        
        const cellSubT = row.insertCell();
        cellSubT.textContent = item.subtotal;

    });
}


