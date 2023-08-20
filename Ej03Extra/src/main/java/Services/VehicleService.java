package Services;
import Entities.Client;
import Entities.Vehicle;
import java.util.HashMap;
import java.util.Scanner;

public class VehicleService {
    HashMap<String, Vehicle> VehicleList = new HashMap<String, Vehicle>();
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    /*addVehicle method charges all attributes to the object and puts it as a value of the hasmap
 ClientList. The key in each case is the DNI. Active attribute always sets active when a client is added.
 */
    public Vehicle addVehicle(){
        Vehicle v1 = new Vehicle();
        String dni = "";
        System.out.println("Ingrese la patente del vehículo.");
        String plate = input.next();
        v1.setLicensePlate(plate);
        System.out.println("Ingrese la marca del auto.");
        v1.setBrand(input.next());
        System.out.println("Ingrese el modelo.");
        v1.setModel(input.next());
        System.out.println("Ingrese el año de fabricación.");
        v1.setYear(input.nextInt());
        System.out.println("Ingrese el número de motor.");
        v1.setEngineNumber(input.next());
        System.out.println("Ingrese el modelo de chasis.");
        v1.setChassis(input.next());
        System.out.println("Ingrese el color.");
        v1.setColor(input.next());
        System.out.println("Ingrese el tipo de vehículo (camioneta, sedán, etc).");
        v1.setType(input.next());
        VehicleList.put(plate, v1);
        return v1;
    }

    /*Two show methods will be needed: one for the complete list and other for a punctual vehicle data.*/
    public void showVehicleList(){
        System.out.println(VehicleList.toString());
    }

    public void showVehicleData(){
        Vehicle v1 = lookForVehicle();
        System.out.println(v1.toString());
    }

    /*Update only available for salesman.*/
    public boolean updateVehicle(){
        Vehicle v1 = lookForVehicle();
        System.out.println("¡Vehículo " +v1.getLicensePlate() + " hallado exitosamente! Elija el campo que " +
                "desea editar: 1) Marca. 2) Modelo. 3) Año. 4) N° de Motor. 5) Chasis. 6) Color. 7) Tipo.");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Ingrese la marca."); v1.setBrand(input.next()); break;
            case 2: System.out.println("Ingrese el modelo."); v1.setModel(input.next()); break;
            case 3: System.out.println("Ingrese el año."); v1.setYear(input.nextInt()); break;
            case 4: System.out.println("Ingrese el N° de motor."); v1.setEngineNumber(input.next()); break;
            case 5: System.out.println("Ingrese el tipo de chasis."); v1.setChassis(input.next()); break;
            case 6: System.out.println("Ingrese el color del vehículo."); v1.setColor(input.next()); break;
            case 7: System.out.println("Ingrese el tipo de vehículo."); v1.setType(input.next()); break;
            default:
                System.out.println("Ha seleccionado una opción no válida."); return false;
        }
        return true;
    }

    /*Desprendido en cadena de borrar póliza.*/
    public boolean deleteVehicle() {
        Vehicle v1 = lookForVehicle();
        if (v1 != null && v1.isActive()) {
            v1.setActive(false);
            System.out.println("El vehículo se ha eliminado exitosamente.");
            return true;
        } else if (!v1.isActive()) {
            System.out.println("El vehículo ya ha sido eliminado anteriormente.");
        } else {
            System.out.println("No se ha podido eliminar el vehículo seleccionado.");
        }
        return false;
    }

    /*ReactivateVehicle is needed in order to ease the process if the same vehicle is loaded after
    its ensurance policy is turned off.*/
    public boolean reactivateVehicle(){
        Vehicle v1 = lookForVehicle();
        if (v1 != null && !v1.isActive()) {
            v1.setActive(true);
            System.out.println("El vehículo se ha reactivado exitosamente."); }
        else if (v1.isActive()) { System.out.println("El vehículo ya se encontraba activo."); }
        else { System.out.println("No se ha podido eliminar el vehículo seleccionado."); return false;}
        return true;
    }

    private Vehicle lookForVehicle(){
        System.out.println("Ingrese la patente del vehículo que desea hallar.");
        String searchedPlate = input.next();
        if (VehicleList.containsKey(searchedPlate)) {
            Vehicle v1 = VehicleList.get(searchedPlate);
            return v1;
        } else {
            System.out.println("El vehículo buscado no se encontró en la base de datos.");
            return null;
        }
    }
}
