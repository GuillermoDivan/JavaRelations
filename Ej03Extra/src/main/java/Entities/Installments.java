package Entities;

import java.time.LocalDate;

public class Installments {
    private InsurancePolicy associatedPolicy;
    private int policyNumber; //"número de cuota" ex 11/200?
    private int policyAmount;
    private boolean isPaid;
    private LocalDate dueDate;

    public InsurancePolicy getAssociatedPolicy() {
        return associatedPolicy;
    }

    public void setAssociatedPolicy(InsurancePolicy associatedPolicy) {
        this.associatedPolicy = associatedPolicy;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(int policyAmount) {
        this.policyAmount = policyAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

/*d. Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza.
Esas cuotas van a contener la siguiente información: número de cuota, monto total de la
cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia,
etc.).*/