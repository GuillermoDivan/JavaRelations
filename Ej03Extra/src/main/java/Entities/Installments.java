package Entities;

import java.time.LocalDate;

public class Installments {
    private int associatedPolicy;
    private int totalInstallmentNumber;
    private int actualInstallmentNumber; //"número de cuota" ej 11/200?
    private int installmentAmount;
    private boolean isPaid;
    private LocalDate dueDate;

    public int getAssociatedPolicy() {
        return associatedPolicy;
    }

    public void setAssociatedPolicy(int associatedPolicy) {
        this.associatedPolicy = associatedPolicy;
    }

    public int getTotalInstallmentNumber() {
        return totalInstallmentNumber;
    }

    public void setTotalInstallmentNumber(int totalInstallmentNumber) {
        this.totalInstallmentNumber = totalInstallmentNumber;
    }

    public int getActualInstallmentNumber() {
        return actualInstallmentNumber;
    }

    public void setActualInstallmentNumber(int actualInstallmentNumber) {
        this.actualInstallmentNumber = actualInstallmentNumber;
    }

    public int getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(int installmentAmount) {
        this.installmentAmount = installmentAmount;
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


    @Override
    public String toString() {
        return "Installments{" +
                "associatedPolicy=" + associatedPolicy +
                ", totalInstallmentNumber=" + totalInstallmentNumber +
                ", actualInstallmentNumber=" + actualInstallmentNumber +
                ", installmentAmount=" + installmentAmount +
                ", isPaid=" + isPaid +
                ", dueDate=" + dueDate +
                '}';
    }
}

/*d. Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza.
Esas cuotas van a contener la siguiente información: número de cuota, monto total de la
cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia,
etc.).*/