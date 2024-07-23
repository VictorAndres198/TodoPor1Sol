<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Conexion.ConectarBD"%>
<jsp:useBean id="usuario" class="Modelo.Usuario" scope="session" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->
    <title>Realizar Venta</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .header h1 {
            color: #333;
        }
        .details {
            margin-bottom: 20px;
        }
        .details label {
            display: inline-block;
            width: 70px;
        }
        .details input {
            width: 300px;
            margin-bottom: 10px;
        }
        #tablaVenta {
            width: 100%;
            margin-bottom: 20px;
            border-collapse: collapse;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        #tablaVenta th, #tablaVenta td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }
        #tablaVenta th {
            background-color: #f0f0f0;
            color: #333;
        }
        .input-cant {
            width: 60px;
            text-align: center;
            padding: 0.2rem 0 0.2rem 0;
        }
        .search-bar {
            width: calc(100% - 10px);
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .add-btn,.mail-btn,.report-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        .mail-btn{
            background-color: #4B4B4B;
        }

        .report-btn{
            background-color: #CC2121;
        }
        
        .add-btn:hover {
            background-color: #aed0f5;
        }
        
        .mail-btn:hover {
            background-color: #989898;
        }

        .report-btn:hover {
            background-color: #F98D8D;
        }

        .total {
            text-align: right;
        }
        .total label {
            font-weight: bold;
        }
        .total input[type="text"] {
            width: 100px;
            text-align: right;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        .searchBtn{
            padding: 0.15em 0.6em;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Todo Por 1 Sol</h1>
            <p>La botica más cerca de ti</p>
            <p>R.U.C. 10097777666</p>
            <p>BOLETA DE VENTA</p>
            <p id="numBoleta">003-0000001</p>
        </div>
        <div class="details">
            <!--BUSCAR CLIENTE-->
            <input type="text" placeholder="DNI del cliente..." id="dniCliente">
            <button type="button" class="searchBtn" onclick="searchClient()"><i class="fa-solid fa-magnifying-glass"></i></button>
            <br>
            <label for="nombres">Nombres</label>
            <input type="text" id="nombres" name="nombres" readonly="true"><br>
            
            <label for="apellidos">Apellidos</label>
            <input type="text" id="apellidos" name="apellidos" readonly="true"><br>
            
            <label for="telefono">Telefono</label>
            <input type="text" id="telefono" name="telefono" readonly="true"><br>
            
            <label for="correo">Correo</label>
            <input type="text" id="correo" name="correo" readonly="true"><br>
        </div>
        <table id="tablaVenta">
            <thead>
                <tr>
                    <th>CANT.</th>
                    <th>CATEGORIA</th>
                    <th>PRODUCTO</th>
                    <th>DESCRIPCIÓN</th>
                    <th>P.U.</th>
                    <th>SUBTOTAL</th>
                    <th>DEL</th>
                </tr>
            </thead>
            <tbody id="bodyTablaVenta">
                <!-- Fila inicial por defecto -->
                <tr>
                    <td><input type="number" class="input-cant" value="1" min="1"></td>
                    <td>
                        <select class="search-bar form-control select-category" data-target-cell="product-category">
                            <option value="0">---</option>
                        </select>
                    </td>
                    <td>
                        <select class="search-bar form-control select-product" data-target-cell="product-name">
                            <option value="0">---</option>
                        </select>
                    </td>
                    <td class="product-description">---</td>
                    <td class="product-price">0</td>
                    <td class="product-subtotal">0</td>
                </tr>
                
            </tbody>
        </table>
        <button type="button" class="add-btn" onclick=" buildRow()">Agregar Producto</button>
        <button type="button" class="add-btn" onclick="saveBoleta()" >Guardar</button>
        <button type="button" class="report-btn"><i class="fa-solid fa-file-pdf"></i></button>
        <button type="button" class="mail-btn">Enviar Correo</button>
        <div class="total">
            
            <label for="opGravada">OP GRAVADA S/.:</label>
            <input type="text" id="opGravada" name="opGravada" value="0.00" readonly="true"><br>
            
            <label for="igv">IGV S/.:</label>
            <input type="text" id="igv" name="igv" value="0.00" readonly="true"><br>
            
            <label for="total">IMPORTE TOTAL S/.:</label>
            <input type="text" id="total" name="total" value="0.00" readonly="true">
        </div>
    </div>

    <script>

        (function loadBoletaNumber(){
            const numBoleta = document.getElementById('numBoleta');
            const baseUrl = 'http://localhost:8080/TodoPor1Sol/SvBoleta';
            const url = `\${baseUrl}?numBoleta=0`;
            
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data =>{
                console.log(data);
                numBoleta.innerText=data;
            })
            .catch(error => console.error('Error:', error));
            
        })();
        
        (function searchCategories(){
            const table = document.getElementById('tablaVenta').getElementsByTagName('tbody')[0];
            const selectElement = table.querySelector('.select-category');
            const url = 'http://localhost:8080/TodoPor1Sol/SvBoleta';
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data =>{
                data.forEach(c=>{
                    const option = document.createElement('option');
                    option.value = c.ID_categoria;
                    option.textContent = c.Nombre;
                    selectElement.appendChild(option);
                });
            })
            .catch(error => console.error('Error:', error));
        })();
        
        
        function fillCategories(){
            const table = document.getElementById('tablaVenta').getElementsByTagName('tbody')[0];
            const listCategories = table.firstElementChild.querySelector('.select-category').outerHTML;
            return listCategories;
        }

        function buildRow(){
            const table = document.getElementById('tablaVenta').getElementsByTagName('tbody')[0];
            const row = table.insertRow();
            
            const cellCant = row.insertCell();
            cellCant.innerHTML = '<input type="number" class="input-cant" value="1" min="1">';
            
            const cellCantegory = row.insertCell();
            cellCantegory.innerHTML = fillCategories();
            
            const cellProduct = row.insertCell();
            cellProduct.innerHTML = '<select class="search-bar form-control select-product" \n\
                                        data-target-cell="product-name">\n\
                                        <option value="0">---</option></select>';
        
            const cellDescription = row.insertCell();
            cellDescription.classList.add('product-description');
            cellDescription.textContent = '---';
        
            const cellPrice = row.insertCell();
            cellPrice.classList.add('product-price');
            cellPrice.textContent = '0';
        
            const cellSubtotal = row.insertCell();
            cellSubtotal.classList.add('product-subtotal');
            cellSubtotal.textContent = '0';
            
            const cellCancel = row.insertCell();
            cellCancel.innerHTML = '<button type="button" class="remove-product"><i class="fa-solid fa-circle-xmark"></i></button>';
      
        }

        
        (function showProducts(){
            const table = document.getElementById('tablaVenta');
            table.addEventListener('change', (event)=> {
                const target = event.target;
                const row = target.closest('tr');
                if (target.tagName === 'SELECT') {
                    const selectedValue = target.value;
                    const selectedCell = target.getAttribute('data-target-cell');
                    
                    if(selectedCell==='product-category'){
                        const updateCell = row.querySelector('.select-product');
                        searchProducts(selectedValue,updateCell);
                    }else{
                        searchProductInfo(selectedValue,row);
                        //calcSubtotal(row);
                     
                    }
                }else{
                    calcSubtotal(row);
                }                
                
            });
        })();
        
        // Función para eliminar una fila en el evento click
        (function removeRow(){
            const table = document.getElementById('tablaVenta');
            table.addEventListener('click', function(event){
                if (event.target.tagName === 'BUTTON' || event.target.tagName === 'I') {
                    // Encuentra el botón que se ha clickeado
                    let button = event.target;
                    if (button.tagName === 'I') {
                        button = button.parentElement;
                    }
                    const row = button.closest('tr');
                    row.parentNode.removeChild(row);
                    calcTotal();
            
                }   
            });
        })();
        
       
        function searchProducts(idCategoria,cell){
            const baseUrl = 'http://localhost:8080/TodoPor1Sol/SvBoleta';
            const url = `\${baseUrl}?categoria=\${encodeURIComponent(idCategoria)}`;
            cell.innerHTML = '';
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data =>{
                
                const defaultOpt = document.createElement('option');
                defaultOpt.value = '0';
                defaultOpt.textContent = '---';
                cell.appendChild(defaultOpt);
                
                data.forEach(p=>{
                    const option = document.createElement('option');
                    option.value = p.ID_Prod;
                    option.textContent = p.Nombre;
                    cell.appendChild(option);
                });
            })
            .catch(error => console.error('Error:', error));
        }
        
        function searchProductInfo(idProducto,row){
            const description = row.querySelector('.product-description');
            const price = row.querySelector('.product-price');
            const baseUrl = 'http://localhost:8080/TodoPor1Sol/SvBoleta';
            const url = `\${baseUrl}?producto=\${encodeURIComponent(idProducto)}`;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data =>{
                description.textContent = data.Descripcion;
                price.textContent = data.precio;
                calcSubtotal(row);
                
            })
            .catch(error => console.error('Error:', error));
        }
        
        function calcSubtotal(row){
            const price = parseFloat(row.querySelector('.product-price').innerText);
            const cant = parseFloat(row.querySelector('.input-cant').value);
            const subtotal = (price * cant).toFixed(2);
            row.querySelector('.product-subtotal').innerText = subtotal;
            calcTotal();
            
        }
        
        function calcTotal(){
            const table = document.getElementById('tablaVenta').getElementsByTagName('tbody')[0];
            const rowCount = table.rows.length;
            let total=0;
            for (var i = 0; i < rowCount; i++) {
                const subtotal = parseFloat(table.rows[i].querySelector('.product-subtotal').innerText);
                total +=subtotal;
            }
            document.getElementById('total').value=total.toFixed(2);
            document.getElementById('igv').value=(0.18*total).toFixed(2);
            document.getElementById('opGravada').value=(0.82*total).toFixed(2);
            
        }
        
        function saveBoleta(){
            //hay que terminar de implmenetar
            console.log("Este boton guarda la boleta");

            // Definimos la ruta del Servlet al que se hace la peticion
            const url = 'http://localhost:8080/TodoPor1Sol/SvBoleta';
            
            //capturmos los datos del Frm
            
            //OBTENEMOS LOS ITEMS DEL PEDIDO
            const itemsValue = getTableItems();
            
            const opGravada = document.getElementById('opGravada').value;
            const igvValue = document.getElementById('igv').value;
            const TotalValue = document.getElementById('total').value;

            //OBTENEMOS EL PEDIDO COMPLETO
            const pedidoValue= {
                precioTotal:opGravada,
                igv:igvValue,
                precioFinal:TotalValue,
                items:itemsValue
            };
            
            //OBTENEMOS LA BOLETA COMPLETA
            const idCliente = document.getElementById('dniCliente').value;
            const nombresCliente = `\${document.getElementById('nombres').value} \${document.getElementById('apellidos').value}`;
            const clienteObj = {
                id: idCliente,
                nombres: nombresCliente
            };
        
            const idEmpleado = document.getElementById('idEmpleado').innerText.split(': ')[1];

            const boleta = {
                cliente: clienteObj,
                empleado: idEmpleado,
                pedido: pedidoValue,
                tipoComprobante:1 // 1 es para BOLETA
            };
            
            console.log(boleta);
            //Funcion realizar la peticion con los datos en JSON
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(boleta)
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
        
        
        function getTableItems(){
            const table = document.getElementById('tablaVenta').getElementsByTagName('tbody')[0];
            const rowCount = table.rows.length;
            let items=[];
            for (var i = 0; i < rowCount; i++) {
                const cantProd = table.rows[i].querySelector('.input-cant').value;
                const prodSelect = table.rows[i].querySelector('.select-product');
                const prodId = prodSelect.value;
                const prodName = prodSelect.options[prodSelect.selectedIndex].text;
                const descrip = table.rows[i].querySelector('.product-description').innerText;
                const precioUnit = table.rows[i].querySelector('.product-price').innerText;
                const subtotalProd = table.rows[i].querySelector('.product-subtotal').textContent;
                
                                // Crear un objeto para cada fila
                const item = {
                    cantidad: cantProd,
                    id: prodId,
                    name: prodName,
                    descripcion: descrip,
                    precioUnitario: precioUnit,
                    subtotal: subtotalProd
                };

                // Agregar el objeto al arreglo items
                items.push(item);
            }
            return items;
        }
        
    </script>

    
</body>
</html>
