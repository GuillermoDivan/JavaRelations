package Services;

import Entities.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsurancePolicyService {
    ArrayList<InsurancePolicy> PolicyList = new ArrayList<InsurancePolicy>();
    DateTimeFormatter DMY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    private void addInsurancePolicy(Client client, Vehicle vehicle) {
        InsurancePolicy p1 = new InsurancePolicy();
        p1.setClient(client);
        p1.setVehicle(vehicle);
        p1.setPolicyNumber(PolicyList.size() + 1);
        System.out.println("Ingrese la fecha de inicio de la póliza (DD / MM / AAAA).");
        String inputStart = input.next();
        LocalDate startDate = LocalDate.parse(inputStart, DMY);
        p1.setStartDate(startDate);
        System.out.println("Ingrese la fecha de fin de la póliza. (DD / MM / AAAA).");
        String inputEnd = input.next();
        LocalDate endDate = LocalDate.parse(inputEnd, DMY);
        p1.setEndDate(endDate);
        System.out.println("Ingrese la cantidad de cuotas.");
        p1.setInstallmentsAmount(input.nextInt());
        System.out.println("Ingrese el modo de pago.");
        p1.setPaymentMode(input.next());
        System.out.println("Ingrese el monto total asegurado.");
        p1.setTotalAssuredAmount(input.nextDouble());
        System.out.println("¿El seguro cubre granizo? S/N");
        if (input.next().equalsIgnoreCase("s")) {
            p1.setIncludesHail(true);
        } else {
            p1.setIncludesHail(false);
        }
        System.out.println("Ingrese el monto máximo de cobertura por granizo.");
        p1.setTotalAssuredHail(input.nextDouble());
        System.out.println("Ingrese el tipo de cobertura.");
        p1.setInsuranceCoverageType(input.next());
        p1.setActive(true);
        PolicyList.add(p1);
    }

    public void showPolicyList() {
        System.out.println(PolicyList.toString());
    }

    public void showVehicleData() {
        InsurancePolicy p1 = lookForPolicy();
        System.out.println(p1.toString());
    }

    public boolean updateVehicle() {
        InsurancePolicy p1 = lookForPolicy();
        System.out.println("¡Póliza " + p1.getPolicyNumber() + " hallada exitosamente! Elija el campo que " +
                "desea editar: 1) Modo de pago. 2) Modelo. 3) Año. 4) N° de Motor. 5) Chasis. 6) Color. 7) Tipo.");
        int option = input.nextInt();
        switch (option) {
            case 1: System.out.println("Ingrese el modo de pago."); p1.setPaymentMode(input.next()); break;

                /*
        System.out.println("Ingrese la fecha de inicio de la póliza (DD / MM / AAAA).");
        String inputStart = input.next();
        LocalDate startDate = LocalDate.parse(inputStart, DMY);
        p1.setStartDate(startDate);
        System.out.println("Ingrese la fecha de fin de la póliza. (DD / MM / AAAA).");
        String inputEnd = input.next();
        LocalDate endDate = LocalDate.parse(inputEnd, DMY);
        p1.setEndDate(endDate);
        System.out.println("Ingrese la cantidad de cuotas.");
        p1.setInstallmentsAmount(input.nextInt());

        System.out.println("Ingrese el monto total asegurado.");
        p1.setTotalAssuredAmount(input.nextDouble());
        System.out.println("¿El seguro cubre granizo? S/N");
        if (input.next().equalsIgnoreCase("s")) {
            p1.setIncludesHail(true);
        } else {
            p1.setIncludesHail(false);
        }
        System.out.println("Ingrese el monto máximo de cobertura por granizo.");
        p1.setTotalAssuredHail(input.nextDouble());
        System.out.println("Ingrese el tipo de cobertura.");
        p1.setInsuranceCoverageType(input.next());
        p1.setActive(true);
        PolicyList.add(p1);
    }*/
            default:
                System.out.println("Ha seleccionado una opción no válida.");
                return false;
        }
        return true;
    }

    public boolean finishPolicy() {
        InsurancePolicy p1 = lookForPolicy();
        if (p1 != null && p1.isActive()) {
            p1.setActive(false);
            System.out.println("El vehículo se ha eliminado exitosamente.");
            return true;
        } else if (!v1.isActive()) {
            System.out.println("El vehículo ya ha sido eliminado anteriormente.");
        } else {
            System.out.println("No se ha podido eliminar el vehículo seleccionado.");
        }
        return false;
    }

    public boolean reactivateVehicle() {
        InsurancePolicy p1 = lookForPolicy();
        if (v1 != null && !v1.isActive()) {
            v1.setActive(true);
            System.out.println("El vehículo se ha reactivado exitosamente.");
        } else if (v1.isActive()) {
            System.out.println("El vehículo ya se encontraba activo.");
        } else {
            System.out.println("No se ha podido eliminar el vehículo seleccionado.");
            return false;
        }
        return true;
    }

    private InsurancePolicy lookForPolicy() {
        System.out.println("Ingrese el número de póliza que desea hallar.");
        int searchedPolicy = input.nextInt();
        for (InsurancePolicy policy : PolicyList) {
            if (policy.getPolicyNumber() == searchedPolicy) {
                return policy;
            } else {
                System.out.println("La póliza buscada no se encontró en la base de datos.");
            }
        } return null;
    }
}