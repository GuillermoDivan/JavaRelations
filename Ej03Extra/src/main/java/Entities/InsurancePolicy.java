package Entities;

import java.time.LocalDate;

public class InsurancePolicy {
    //@OneToOne ? En qué momento vimos sql?
    private Client client;
    //@OneToOne
    private Vehicle vehicle;
    private int policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private int installmentsAmount;
    private String paymentMode;
    private double totalAssuredAmount;
    private boolean includesHail;
    private double totalAssuredHail;
    private String insuranceCoverageType;
    private boolean active;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getInstallmentsAmount() {
        return installmentsAmount;
    }

    public void setInstallmentsAmount(int installmentsAmount) {
        this.installmentsAmount = installmentsAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public double getTotalAssuredAmount() {
        return totalAssuredAmount;
    }

    public void setTotalAssuredAmount(double totalAssuredAmount) {
        this.totalAssuredAmount = totalAssuredAmount;
    }

    public boolean isIncludesHail() {
        return includesHail;
    }

    public void setIncludesHail(boolean includesHail) {
        this.includesHail = includesHail;
    }

    public double getTotalAssuredHail() {
        return totalAssuredHail;
    }

    public void setTotalAssuredHail(double totalAssuredHail) {
        this.totalAssuredHail = totalAssuredHail;
    }

    public String getInsuranceCoverageType() {
        return insuranceCoverageType;
    }

    public void setInsuranceCoverageType(String insuranceCoverageType) {
        this.insuranceCoverageType = insuranceCoverageType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "client=" + client +
                ", vehicle=" + vehicle +
                ", policyNumber=" + policyNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", installmentsAmount=" + installmentsAmount +
                ", paymentMode='" + paymentMode + '\'' +
                ", totalAssuredAmount=" + totalAssuredAmount +
                ", includesHail=" + includesHail +
                ", totalAssuredHail=" + totalAssuredHail +
                ", insuranceCoverageType='" + insuranceCoverageType + '\'' +
                '}';
    }
}

/*c. Gestión de Pólizas: Se registrará una póliza, donde se guardará los datos tanto de un
vehículo, como los datos de un solo cliente. Los datos incluidos en ella son: número de
póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, forma de pago, monto total
asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra
terceros, etc.). Nota: prestar atención al principio de este enunciado y pensar en las
relaciones entre clases. Recuerden que pueden ser de uno a uno, de uno a muchos, de
muchos a uno o de muchos a muchos.*/