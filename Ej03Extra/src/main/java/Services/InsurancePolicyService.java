package Services;
import Entities.*;

import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsurancePolicyService {
    public static ArrayList<InsurancePolicy> PolicyList = new ArrayList<InsurancePolicy>();
    DateTimeFormatter DMY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void addInsurancePolicy(Client client, Vehicle vehicle) {
        InsurancePolicy p1 = new InsurancePolicy();
        p1.setClient(client);
        p1.setVehicle(vehicle);
        p1.setPolicyNumber(PolicyList.size() + 1);

        LocalDate startDate = LocalDate.now();
        p1.setStartDate(startDate);
        System.out.println("Ingrese la fecha de fin de la póliza. (DD / MM / AAAA).");
        String inputEnd = input.next();
        LocalDate endDate = LocalDate.parse(inputEnd, DMY);
        p1.setEndDate(endDate);
        int policyDuration = calculateDuration(startDate, endDate);
        p1.setTotalInstallmentsNumber(policyDuration);
        ArrayList<Installments> installmentsList =
                InstallmentsService.createInstallments(p1.getPolicyNumber(), policyDuration);
        p1.setInstallmentsList(installmentsList);

        System.out.println("Ingrese el tipo de cobertura.");
        p1.setInsuranceCoverageType(input.next());
        System.out.println("Ingrese el modo de pago.");
        p1.setPaymentMode(input.next());
        System.out.println("Ingrese el monto total asegurado.");
        p1.setTotalAssuredAmount(input.nextDouble());
        System.out.println("¿El seguro cubre granizo? S/N");
        if (input.next().equalsIgnoreCase("s")) {
            p1.setIncludesHail(true);
            System.out.println("Ingrese el monto máximo de cobertura por granizo.");
            p1.setTotalAssuredHail(input.nextDouble());
        } else {
            p1.setIncludesHail(false);
            p1.setTotalAssuredHail(0.0);
        }
        p1.setActive(true);
        PolicyList.add(p1);
    }

    public void showPolicyList() {
        System.out.println(PolicyList.toString());
    }

    public void showPolicyData() {
        InsurancePolicy p1 = lookForPolicy();
        System.out.println(p1.toString());
    }
/*Keep attention on what attributes could be modified by salesman only and which ones are available
for the client too.*/
    public boolean updatePolicy() {
        InsurancePolicy p1 = lookForPolicy();
        System.out.println("¡Póliza " + p1.getPolicyNumber() + " hallada exitosamente! Elija el campo" +
                " que desea editar: 1) Modo de pago. 2) Total asegurado. 3) Cobertura contra granizo. " +
                "4) Monto cobertura granizo. 5) Tipo de cobertura. 6) Cantidad de cuotas.");
        int option = input.nextInt();
        switch (option) {
            case 1: System.out.println("Reingrese el modo de pago."); p1.setPaymentMode(input.next()); break;
            case 2: System.out.println("Reingrese el total asegurado."); p1.setTotalAssuredAmount(input.nextDouble()); break;
            case 3: System.out.println("Reingrese si habilita o no cobertura contra granizo: s/n ");
            if (input.next().equalsIgnoreCase("s")) {p1.setIncludesHail(true); }
            else { p1.setIncludesHail(false); }; break;
            case 4: System.out.println("Reingrese el monto de cobertura contra granizo."); p1.setTotalAssuredHail(input.nextDouble()); break;
            case 5: System.out.println("Reingrese el tipo de cobertura."); p1.setInsuranceCoverageType(input.next()); break;
            case 6: System.out.println("Reingrese la cantidad de cuotas a abonar."); p1.setTotalInstallmentsNumber(input.nextInt()); break;
            case 7: System.out.println();
            default:
                System.out.println("Ha seleccionado una opción no válida."); return false;
        }
        return true;
    }

    public boolean finishPolicy() {
        InsurancePolicy p1 = lookForPolicy();
        //boolean allowed = allowFinishPolicy(p1);
        //Buscar cuotas de la póliza, corroborar que queden más de una y que a la fecha
        // estén todas pagas.

        if (p1 != null && p1.isActive()) {
            p1.setActive(false);
            System.out.println("La póliza se ha cancelado exitosamente.");
            return true;
        } else if (!p1.isActive()) {
            System.out.println("La póliza ya ha sido cancelada anteriormente.");
        } else {
            System.out.println("No se ha podido cancelar la póliza seleccionada.");
        }
        return false;
    }

    public boolean reactivatePolicy() {
        InsurancePolicy p1 = lookForPolicy();
        if (p1 != null && !p1.isActive()) {
            p1.setActive(true);
            System.out.println("La póliza se ha reactivado exitosamente.");
        } else if (p1.isActive()) {
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

    private int calculateDuration(LocalDate startDate, LocalDate endDate) {
        Period durationPeriod = startDate.until(endDate);
        int duration = durationPeriod.getMonths();
        return duration;
    }
}