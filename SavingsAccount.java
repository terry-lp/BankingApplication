package BankingApplication;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {


    public SavingsAccount(BigDecimal currentBalance, double interestRate) {
        super(currentBalance, interestRate);
    }

    public void withdraw() {
        BigDecimal withdrawalAmount = new BigDecimal("0.00");

        if (this.getAccountStatus() == 'A') {
            super.withdrawal(new BigDecimal("0.00"), new BigDecimal("0.00"), new BigDecimal("0.00"), 5);
        }
        if (this.getCurrentBalance().compareTo(new BigDecimal("25.00")) < 0) {
            this.setAccountStatus('I');
            System.out.println("Cannot make withdrawal if account balance is below $25.00");
        }
    }

    public void deposit() {
        BigDecimal depositAmount = new BigDecimal("0.00");

        System.out.println(this.getCurrentBalance());

        if (this.getAccountStatus() == 'I') {
            System.out.println("Account is currently inactive.");
        }
        if (this.getCurrentBalance().add(depositAmount).compareTo(new BigDecimal("25.00")) > 0) {
            this.setAccountStatus('A');
            }
        if (this.getAccountStatus() == 'A') {
            super.deposit(new BigDecimal("0.00"), new BigDecimal("0.00"), new BigDecimal("0.00"), 0);
        }
    }

    public void generateMonthlyReport() {
        BigDecimal serviceCharge = new BigDecimal("1.00");

        if (this.getNumWithdrawals() > 4) {
            serviceCharge = serviceCharge.multiply(new BigDecimal(this.getNumWithdrawals()));
            this.setServiceCharge(this.getServiceCharge().add(serviceCharge));
        }
        if (this.getAccountStatus() == 'I') {
            System.out.println("Account is currently inactive");
        }
        if (this.getAccountStatus() == 'A') {
            System.out.println("Account is currently active");
        }

        System.out.println("Additional service charge for this month: " + this.getServiceCharge());
        System.out.println("Current savings account balance: " + this.getCurrentBalance());
        System.out.println("Number of deposits: " + this.getNumDeposits());
        System.out.println("Number of withdrawals: " + this.getNumWithdrawals());
//        System.out.println("Current account status is: " + this.getAccountStatus());
    }

    @Override
    protected void calculateInterest(BigDecimal currentBalance) {

    }
}

