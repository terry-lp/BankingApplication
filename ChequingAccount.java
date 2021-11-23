package BankingApplication;

import java.math.BigDecimal;

public class ChequingAccount extends BankAccount {

    public ChequingAccount(BigDecimal currentBalance, double interestRate) {
        super(currentBalance, interestRate);
    }

    public void withdraw() {
        BigDecimal withdrawalAmount = new BigDecimal("0.00");

        if (this.getAccountStatus() == 'A') {
            super.withdrawal(new BigDecimal("0.00"), new BigDecimal("0.00"), new BigDecimal("0.00"), 5);
        }

        if (this.getCurrentBalance().compareTo(new BigDecimal("0.00")) < 0) {
            this.setAccountStatus('I');
            System.out.println("Cannot make withdrawal if account balance is below $0.00");

            BigDecimal serviceCharge = new BigDecimal("15.00");
            this.setServiceCharge(this.getServiceCharge().add(serviceCharge));
            System.out.println("Since balance is below $0.00 a service charge has been added to your account");
        }
    }

    public void generateMonthlyReport() {
        BigDecimal monthlyCharge = this.getServiceCharge().add(new BigDecimal("5.00").add(new BigDecimal("0.1").multiply(new BigDecimal(this.getNumWithdrawals()))));
        monthlyCharge = monthlyCharge.multiply(new BigDecimal(this.getNumWithdrawals()));
        this.setServiceCharge(this.getServiceCharge().add(monthlyCharge));

        System.out.println("Additional service charge for this month: " + monthlyCharge);
        System.out.println("Current chequing account balance: " + getCurrentBalance());
        System.out.println("Number of deposits: " + this.getNumDeposits());
        System.out.println("Number of withdrawals: " + this.getNumWithdrawals());
        System.out.println("Current account status is: " + this.getAccountStatus());
    }

    @Override
    protected void calculateInterest(BigDecimal currentBalance) {

    }
}
