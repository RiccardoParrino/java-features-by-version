import javax.accessibility.AccessibleAction;

public class PatternMatchingSwitch {

    public static void main(String[] args) {
        System.out.println(
                WhenKeywordCase.example(new String("Yes")));

        System.out.println(
                Example.getBalanceWithSwitchPattern(
                        new Example.SavingsAccount()));
    }

}

class Example {

    static class Account {
        double getBalance() {
            return 0;
        }
    }

    static class SavingsAccount extends Account {
        double getSavings() {
            return 100;
        }
    }

    static class TermAccount extends Account {
        double getTermAccount() {
            return 1000;
        }
    }

    static class CurrentAccount extends Account {
        double getCurrentAccount() {
            return 10_000;
        }
    }

    // before java 21
    static double getBalanceWithoutSwitchPattern(Account account) {
        double balance = 0;
        if (account instanceof SavingsAccount sa) {
            balance = sa.getSavings();
        } else if (account instanceof TermAccount ta) {
            balance = ta.getTermAccount();
        } else if (account instanceof CurrentAccount ca) {
            balance = ca.getCurrentAccount();
        }
        return balance;
    }

    // after java 21
    static double getBalanceWithSwitchPattern(Account account) {
        double result = 0;
        switch (account) {
            case null -> throw new RuntimeException("account is null");
            case SavingsAccount sa -> result = sa.getSavings();
            case TermAccount ta -> result = ta.getTermAccount();
            case CurrentAccount ca -> result = ca.getCurrentAccount();
            default -> result = account.getBalance();
        }
        return result;
    }

}

class WhenKeywordCase {

    public static String example(String input) {
        String output = null;
        switch (input) {
            case null -> output = "Oops, null";
            case String s when "yes".equalsIgnoreCase(s) -> output = "It's yes";
            case String s when "no".equalsIgnoreCase(s) -> output = "It's no";
            case String s -> output = "Try again";
        }
        return output;
    }

}
