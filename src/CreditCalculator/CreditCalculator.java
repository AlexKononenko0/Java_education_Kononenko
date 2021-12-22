package CreditCalculator;

    public class CreditCalculator {
        public static void main(String[] args) {
            double loanInterest;
            double loanPrincipal;
            double monthPayment;
            double numberOfMonth;
        String type = System.getProperty("type");
        String principal = System.getProperty("principal");
        String payment = System.getProperty("payment");
        String interest = System.getProperty("interest");
        String periods = System.getProperty("periods");
        if (type != null) {
            if (type.equals("diff")) {
                if (principal == null || periods == null || interest == null) {
                    System.out.println("Incorrect parameters.");
                    System.exit(0);
                }
                numberOfMonth = Double.parseDouble(periods);
                loanPrincipal = Double.parseDouble(principal);
                loanInterest = Double.parseDouble(interest);
                diff(numberOfMonth, loanPrincipal, loanInterest);
            }
            if (type.equals("annuity")) {
                if (principal != null && payment != null && interest != null) {
                    monthPayment = Double.parseDouble(payment);
                    loanPrincipal = Double.parseDouble(principal);
                    loanInterest = Double.parseDouble(interest);
                    periodspayment(monthPayment, loanPrincipal, loanInterest);
                }
                if (periods != null && payment != null && interest != null) {
                    numberOfMonth = Double.parseDouble(periods);
                    monthPayment = Double.parseDouble(payment);
                    loanInterest = Double.parseDouble(interest);
                    loanprincipal(numberOfMonth, monthPayment, loanInterest);
                }
                if (principal != null && periods != null && interest != null) {
                    loanPrincipal = Double.parseDouble(principal);
                    numberOfMonth = Double.parseDouble(periods);
                    loanInterest = Double.parseDouble(interest);
                    monthypayment(loanPrincipal, numberOfMonth, loanInterest);
                }
            }
        } else {
            System.out.println("Incorrect parameters.");
            System.exit(0);
        }
    }

    public static void diff(double numberOfMonth, double loanPrincipal, double loanInterest) {
        double i = (loanInterest / (12 * 100));
        double g = 0;
        for (int j = 1; j <= numberOfMonth; j++) {
            double D = (loanPrincipal / numberOfMonth) + i * (loanPrincipal - ((loanPrincipal * (j - 1)) / numberOfMonth));
            System.out.println("Month " + j + " : payment is " + Math.ceil(D));
            g += D;
        }
        System.out.println("Overpayment = " + Math.ceil(g - loanPrincipal));
    }

    public static void periodspayment(double monthPayment, double loanPrincipal, double loanInterest) {
        double i = (loanInterest / (12 * 100));
        double numberofMonth = Math.log(monthPayment / (monthPayment - (i * loanPrincipal))) / Math.log(1 + i);
        long year = Math.round(numberofMonth / 12);
        long month = Math.round(numberofMonth % 12);
        if (year > 0 & month > 0) {
            System.out.println("It will take " + year + " years and " + month + " month to repay this loan");
        } else if (year == 0) {
            System.out.println("It will take " + month + " month to repay this loan");
        } else {
            System.out.println("It will take " + year + " years to repay this loan");
        }
    }

    public static void loanprincipal(double numberOfMonth, double monthPayment, double loanInterest) {
        double i = (loanInterest / (12 * 100));
        double loanPrincipal = monthPayment / ((i * Math.pow((1 + i), numberOfMonth)) / (Math.pow((1 + i), numberOfMonth) - 1));
        System.out.printf("Your loan principal = %.0f", loanPrincipal);
    }

    public static void monthypayment(double loanPrincipal, double numberOfMonth, double loanInterest) {
        double i = (loanInterest / (12 * 100));
        double monthPayment = loanPrincipal * ((i * Math.pow((1 + i), numberOfMonth)) / (Math.pow((1 + i), numberOfMonth) - 1));
        System.out.printf("Your monthly payment = %.0f", monthPayment);
    }
}
