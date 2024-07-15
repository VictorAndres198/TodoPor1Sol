
$(document).ready(function() {
    function loadPage(page) {
        console.log("Loading page:", page); // Agregar este console.log
        $('#employee-display').load(`../TodoPor1Sol/pages/employee/${page}.jsp`, function(response, status, xhr) {
            if (status == "error") {
                $('#employee-display').html(`<p>Error loading page: ${xhr.status} ${xhr.statusText}</p>`);
            }
        });
    }

    // Página por defecto
    loadPage('register');

    // Asignar eventos de clic para los ítems del menú
    $('#nav-register').click(function() {
        loadPage('register');
    });

    $('#nav-inventory').click(function() {
        loadPage('inventario');
    });

    $('#nav-realizarventa').click(function() {
        loadPage('realizarventa');
    });

    $('#nav-realizarventa').click(function() {
        loadPage('realizarventa');
    });

    $('#nav-historialventas').click(function() {
        loadPage('historialdeventas');
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
