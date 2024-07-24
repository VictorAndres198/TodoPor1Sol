
$(document).ready(function() {
    function loadPage(page) {
        console.log("Loading page:", page);
        $('#employee-display').load(`../TodoPor1Sol/${page}`, function(response, status, xhr) {
            if (status == "error") {
                $('#employee-display').html(`<p>Error loading page: ${xhr.status} ${xhr.statusText}</p>`);
            } else {
                if (page === 'pages/employee/register.jsp') {
                    // Vincular evento de clic al botón de "Registrar Entrada"
                    $('#registrar-entrada').click(function() {
                        registrarEntrada();
                        console.log("REGISTRANDO ENTRADA");
                    });
                    $('#registrar-salida').click(function() {
                        registrarSalida();
                        console.log("REGISTRANDO SALIDA");
                    });
                    loadEmployeeData();
                    // Inicializar el gráfico después de cargar register.jsp
                    initializeChart();
                    loadSemanaActual();
                } else if (page === 'pages/employee/historialdeventas.jsp') {
                    initializeChartdashboard();
                }
            }
        });
    }

// Función para inicializar el gráfico usando Chart.js
function initializeChart() {
    var graficoLinea = document.getElementById('grafico-linea');

    if (graficoLinea) {
        var ctx = graficoLinea.getContext('2d');

        // Datos de ejemplo (reemplaza esto con tus datos reales)
        var data = {
            labels: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes'],
            datasets: [{
                label: 'Hora de Salida',
                data: ['17:00', '17:30', '18:00', '17:15', '18:30'].map(function(time) {
                    return moment.duration(time).asHours(); // Convertir 'HH:mm' a horas como número
                }),
                borderColor: 'rgba(19, 132, 150, 1)',
                borderWidth: 1,
                fill: false
            },{
                label: 'Hora de Entrada',
                data: ['08:00', '08:30', '09:00', '08:15', '09:30'].map(function(time) {
                    return moment.duration(time).asHours(); // Convertir 'HH:mm' a horas como número
                }),
                borderColor: 'rgba(33, 136, 56, 1)',
                borderWidth: 1,
                fill: false
            }]
        };

        var options = {
            responsive: true,
            maintainAspectRatio: false,
            plugins:{                
                legend: {
                    position: 'right', // Posiciona la leyenda a la derecha del gráfico
                    align: 'center', // Alinea la leyenda al centro verticalmente
                    labels: {
                        boxWidth: 15 // Ancho del cuadro de la leyenda
                    }
                }
            }
        };

        var myChart = new Chart(ctx, {
            type: 'line',
            data: data,
            options: options
        });
    }
}

    // Función para inicializar el gráfico usando Chart.js
    function initializeChartdashboard() {
        var ctx = document.getElementById('ventasChart').getContext('2d');

        // Datos de ejemplo (reemplaza esto con tus datos reales)
        var data = {
            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio'],
            datasets: [{
                label: 'Ventas Mensuales',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                data: [65, 59, 80, 81, 56, 55],
            }]
        };

        var options = {
            responsive: true,
            scales: {
                x: {
                    display: true,
                    title: {
                        display: true,
                        text: 'Meses'
                    }
                },
                y: {
                    display: true,
                    title: {
                        display: true,
                        text: 'Cantidad de Ventas'
                    }
                }
            }
        };

        var myChart = new Chart(ctx, {
            type: 'line',
            data: data,
            options: options
        });
    }


    // Página por defecto
    loadPage('pages/employee/register.jsp');

    // Asignar eventos de clic para los ítems del menú
    $('#nav-register').click(function() {
        loadPage('pages/employee/register.jsp');
    });

    $('#nav-inventory').click(function() {
        loadPage('pages/employee/inventario.jsp');
    });

    $('#nav-realizarventa').click(function() {
        loadPage('pages/employee/realizarventa.jsp');
    });

    $('#nav-realizarventa').click(function() {
        loadPage('pages/employee/realizarventa.jsp');
    });

    $('#nav-historialventas').click(function() {
        loadPage('pages/employee/historialdeventas.jsp');
    });
    
});

function rotateCheuron() {
    const cheuron = document.getElementById("cheuron");
    cheuron.classList.toggle("rotated");
    cheuron.classList.toggle("transition");

    const expandedElements = document.querySelectorAll('.expanded');
    expandedElements.forEach(function(element) {
        element.classList.toggle('hide');
    });

    setTimeout(function() {
        cheuron.classList.remove("transition");
    }, 400);
}
