package Testing;

import DAO.DAOempleado;
import Modelo.Empleado;

import java.math.BigDecimal;
import java.time.LocalTime;

public class TestEmpleados {

    public static void main(String[] args) {
        DAOempleado daoEmpleado = new DAOempleado();

        // Prueba de inserción
        Empleado emp = new Empleado();
        emp.setDni("72782490");
        emp.setNombre("Orlando");
        emp.setApellidos("Salazar");
        emp.setCorreo("orlando.salazar@gmail.com");
        emp.setTelefono("97330362");
        emp.setSueldo(BigDecimal.valueOf(1500));
        emp.setIdFarm(1);
        emp.setHorarioE(LocalTime.of(9, 0));
        emp.setHorarioS(LocalTime.of(17, 0));

        boolean insertSuccess = daoEmpleado.Insert(emp);
        System.out.println("Inserción exitosa: " + insertSuccess);

        // Prueba de obtener empleado por DNI
        Empleado fetchedEmp = daoEmpleado.obtenerEmpleadoPorDNI("72782490");
        System.out.println("Empleado obtenido: " + fetchedEmp.getNombre());

        // Prueba de listar empleados
        System.out.println("Lista de empleados:");
        daoEmpleado.ListarEmpleado().forEach(e -> System.out.println(e.getNombre()));

        // Prueba de actualización
        fetchedEmp.setNombre("Orlando Actualizado");
        boolean updateSuccess = daoEmpleado.Update(fetchedEmp);
        System.out.println("Actualización exitosa: " + updateSuccess);

        Empleado updatedEmp = daoEmpleado.ObtenerEmpleado("72782490");
        System.out.println("Empleado actualizado: " + updatedEmp.getNombre());

        // Prueba de eliminación del empleado
        boolean deleteSuccess = daoEmpleado.Delete("72782490");
        System.out.println("Eliminación exitosa: " + deleteSuccess);

        Empleado deletedEmp = daoEmpleado.ObtenerEmpleado("72782490");
        System.out.println("Empleado después de eliminar: " + (deletedEmp == null ? "No encontrado" : deletedEmp.getNombre()));
    }
}

