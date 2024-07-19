
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Registro de Proveedores</title>
    <link href="../../resources/css/GestionarProveedor.css" rel="stylesheet" type="text/css"/>
    <script src="../../resources/js/BuscadorProveedores.js" type="text/javascript"></script>
    <link href="../../resources/css/admin.css" rel="stylesheet" type="text/css"/>
    <link href="../../resources/css/admin-display.css" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->

</head>  
    <body class="parent-container">
        <!-- Para traer el layout(menu lateral) del admin -->
        <jsp:include page="../../admin_layout.jsp" />  
        <div class="box-Content">
            <div class="Frm-Header">
                <span class="Frm-Title">Gestionar Proveedor</span>
                <div class="search-box">
                    <input id="searchTerm" type="text" class="search-bar" onkeyup="doSearch()" placeholder="Buscar proveedores..."></<input>
                    <button type="submit" class="search-btn">
                        <img class="search-icon" src="../../resources/img/icons/search-symbol.png" alt=""/>
                    </button> 
                </div>
            </div>
            
            <div class="Frm-Table table-responsive">
                <table class="table table-striped table-sm align-middle" id="Table-Proveedores">
                    <thead class="align-middle table-header">
                        <tr class="table-primary">
                            <th>RUC</th>
                            <th>Nombre</th>
                            <th>País</th>
                            <th>Teléfono</th>
                            <th>Correo</th>
                            <th>Botones</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        
        
                    </tbody >
                </table>
            </div>
            <div class="Frm-Btns-Report">
                <button class="Btn_PDF" onclick="sendReportData()">Generar Reporte</button>
            </div>
        </div>
        
        <!-- Modal -->
        <div class="modal fade" id="ProveedorModal" tabindex="-1" aria-labelledby="ProveedorModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content" id="modalProv">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Proveedor</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <!-- Campo DNI -->
                <div class="mb-3 form-group">
                    <label for="ruc" class="form-label"><i class="fas fa-id-card"></i> RUC</label>
                    <input class="form-control" type="text" id="ruc">
                </div>
                <!-- Campo Nombre -->
                <div class="mb-3 form-group">
                    <label for="nombre" class="form-label"><i class="fas fa-user"></i> Nombre</label>
                    <input class="form-control" type="text" id="nombre">
                </div>
                <!-- Campo Pais -->
                <div class="mb-3 form-group">
                    <label for="pais" class="form-label"><i class="fa-solid fa-earth-americas"></i> Pais</label>
                    <input class="form-control" type="text" id="pais">
                </div>
                <!-- Campo Teléfono -->
                <div class="mb-3 form-group">
                    <label for="telefono" class="form-label"><i class="fas fa-phone"></i> Teléfono</label>
                    <input class="form-control" type="text" id="telefono">
                <!-- Campo Correo -->
                <div class="mb-3 form-group">
                    <label for="correo" class="form-label"><i class="fas fa-envelope"></i> Correo</label>
                    <input class="form-control" type="email" id="correo">
                </div>
                </div>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-primary" onclick="updateProveedor()">Actualizar</button>
              </div>
            </div>
          </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
        
                
        <!-- SCRIPT PARA CARGAR IMAGENES-->
        <script src="../../loadImages.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA CARGAR TODOS LOS PROVEEDORES -->
        <script src="../../SearchProveedor.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA ACTUALIZAR Y ELIMINAR PROVEEDORES -->
        <script src="../../resources/js/scriptsProveedor/Modal_update_delete.js" type="text/javascript"></script>
        
        <!-- SCRIPT PARA MANEJAR LOS DATOS ENVIADOS PARA GENERAR REPORTE -->
        <script src="../../resources/generateReports/reportProveedor.js" type="text/javascript"></script>
        
    </body>
</html>
