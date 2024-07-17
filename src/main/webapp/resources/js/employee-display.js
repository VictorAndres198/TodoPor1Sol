
$(document).ready(function() {
    function loadPage(page) {
        console.log("Loading page:", page);
        $('#employee-display').load(`../TodoPor1Sol/${page}`, function(response, status, xhr) {
            if (status == "error") {
                $('#employee-display').html(`<p>Error loading page: ${xhr.status} ${xhr.statusText}</p>`);
            } else {
                if (page === 'pages/employee/register.jsp') {
                    loadEmployeeData();
                }
            }
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
