package BankingApplication;

import java.math.BigDecimal;

public abstract class BankAccount {

    // here are the variables
    private BigDecimal startingBalance = new BigDecimal("0.00");
    private BigDecimal currentBalance = new BigDecimal("0.00");
    private BigDecimal totDeposits = new BigDecimal("0.00");
    private int numDeposits = 0;
    private BigDecimal totWithdrawals = new BigDecimal("0.00");
    private int numWithdrawals = 0;
    private double interestRate = 0.00;
    private BigDecimal serviceCharge = new BigDecimal("0.00");

    private char accountStatus;
    private char active = 'A';
    private char inactive = 'I';

    // constructor for current balance and interest rate
    public BankAccount(BigDecimal currentBalance, double interestRate) {
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.accountStatus = active;
    }

    // space for getters and setters
    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getTotDeposits() {
        return totDeposits;
    }

    public void setTotDeposits(BigDecimal totDeposits) {
        this.totDeposits = totDeposits;
    }

    public int getNumDeposits() {
        return numDeposits;
    }

    public void setNumDeposits(int numDeposits) {
        this.numDeposits = numDeposits;
    }

    public BigDecimal getTotWithdrawals() {
        return totWithdrawals;
    }

    public void setTotWithdrawals(BigDecimal totWithdrawals) {
        this.totWithdrawals = totWithdrawals;
    }

    public int getNumWithdrawals() {
        return numWithdrawals;
    }

    public void setNumWithdrawals(int numWithdrawals) {
        this.numWithdrawals = numWithdrawals;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public char getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(char accountStatus) {
        this.accountStatus = accountStatus;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public char getInactive() {
        return inactive;
    }

    public void setInactive(char inactive) {
        this.inactive = inactive;
    }

    // methods
    public void deposit(BigDecimal depositAmount, BigDecimal startingBalance, BigDecimal currentBalance, int numDeposits) {
        depositAmount = new BigDecimal("0.00");
        currentBalance = startingBalance.add(depositAmount);
        this.numDeposits++;
    }

    public void withdrawal(BigDecimal withdrawalAmount, BigDecimal startingBalance, BigDecimal currentBalance, int numDeposits) {
        withdrawalAmount = new BigDecimal("0.00");
        currentBalance = startingBalance.subtract(withdrawalAmount);
        this.numWithdrawals++;
    }

    public void calculateInterest(BigDecimal startingBalance, BigDecimal currentBalance, double interestRate) {
        BigDecimal interestAmount = new BigDecimal("0.00");
        double monthlyInterestRate = interestRate / 12.0;
        BigDecimal monthlyInterest = new BigDecimal("0.00");
        monthlyInterest = startingBalance.multiply(new BigDecimal(monthlyInterestRate));
        currentBalance = currentBalance.add(monthlyInterest);
    }

    protected abstract void calculateInterest(BigDecimal currentBalance);
    public void generateMonthlyReport(BigDecimal serviceCharge) {
        this.currentBalance = this.currentBalance.subtract(serviceCharge);
        calculateInterest(currentBalance);
        this.numWithdrawals = 0;
        this.numDeposits = 0;
        this.serviceCharge = new BigDecimal("0.00");
    }
}
