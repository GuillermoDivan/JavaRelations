package Services;
import Entities.Installments;
import Entities.InsurancePolicy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*About CRUD: No Update needed. A client can pay before the due dates but nothing should be modified
about the installments. No Delete needed, each array of installments is only associated to a policy,
so if the conditions are prone to cancel the policy, the installments (as their attribute), are set off too.*/
public class InstallmentsService {
    public static Scanner input = new Scanner(System.in).useDelimiter("\n");
    LocalDate today = LocalDate.now();

    /*To create an installment array is needed to have a policy associated. CreateInstallments should
    only be summoned on addInsurancePolicy method. Most of the data on the individual installments
    are the same, it only varies its actual number and the dueDate, regarding 30 days between each date.*/
    public static ArrayList<Installments> createInstallments(int policyNumber, int policyDuration) {
        ArrayList<Installments> list = new ArrayList<Installments>();
        Installments installment = new Installments();
        LocalDate date = LocalDate.now();

        System.out.println("Ingrese el valor unitario de la cuota.");
        int installmentAmount = input.nextInt();

        for (int i = 0; i < policyDuration; i++) {
            installment.setAssociatedPolicy(policyNumber);
            installment.setTotalInstallmentNumber(policyDuration);
            installment.setActualInstallmentNumber(i + 1);
            installment.setInstallmentAmount(installmentAmount);
            installment.setPaid(false);
            installment.setDueDate(date.plusDays(30 * i));
            list.add(installment);
        }
        return list;
    }

    /*ShowInstallmentData method should be active to both client and salesman. policyNumber is needed.*/
    public static void showInstallmentsData(int policyNumber) {
        ArrayList<Installments> list =
                InsurancePolicyService.PolicyList.get(policyNumber).getInstallmentsList();
        System.out.println(list.toString());
    }

    /*installmentPayment should show the installments unpaid previous to the actual date and the following
    one (that one that is less than 31 days after). If money is deposited, it's necessary to pay starting for
    the oldest one in chronological order.*/
    public void installmentPayment(double money, int policyNumber) {
        ArrayList<Installments> list =
                InsurancePolicyService.PolicyList.get(policyNumber).getInstallmentsList();
        for (Installments i : list) {
            if (i.isPaid() == false && today.plusDays(31).isAfter(i.getDueDate())) {
                System.out.println(i.getDueDate() + " -> $" + i.getInstallmentAmount());
                if (money >= i.getInstallmentAmount()) {
                    System.out.println("Se ha pagado la cuota " + i.getActualInstallmentNumber() +
                            "de " + list.size());
                    i.setPaid(true);
                }
            } else {
                System.out.println("No posee deuda a la fecha.");
            }
        }
    }

    /*allowFinishPolicy must check that there's no unpaid installments (including the next one if the dueDate
    is sooner than 31 days until today) and that the installmentList has at least 30 days more to finish. */
    public boolean allowFinishPolicy(int policyNumber) {
        boolean flag1 = false;
        boolean flag2 = false;
        InsurancePolicy policy = InsurancePolicyService.PolicyList.get(policyNumber);
        ArrayList<Installments> list = policy.getInstallmentsList();
        if (!policy.getEndDate().isBefore(today.plusDays(30))) { flag1 = true; }
        else { System.out.println("El tiempo para finalizar la póliza no puede ser inferior a 30 días."); }
        for (Installments i : list) {
            if (i.isPaid() == true && today.plusDays(31).isAfter(i.getDueDate())) {
                flag2 = true; } else { System.out.println("Aún quedan pagos pendientes."); }
        }
        if (flag1 && flag2) {
            return true;
        } else {
            return false;
        }
    }
}
