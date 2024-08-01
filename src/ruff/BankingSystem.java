package ruff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystem {
    private static final Map<String, Double> accounts = new HashMap<>();
    private static final Map<String, Double> transactionTotals = new HashMap<>();

    public static String[] solution(String[][] queries) {
        List<String> results = new ArrayList<>();

        for (String[] query : queries) {
            String operation = query[0].trim();
            String accountId = query[2].trim(); // accountId is the third element for CREATE_ACCOUNT, DEPOSIT, PAY

            switch (operation) {
                case "CREATE_ACCOUNT":
                    if (accounts.containsKey(accountId)) {
                        results.add("account already exists");
                    } else {
                        accounts.put(accountId, 0.0);
                        transactionTotals.put(accountId, 0.0); // Initialize transaction total for new accounts
                        results.add("true");
                    }
                    break;

                case "DEPOSIT":
                    Double depositAmount = Double.parseDouble(query[3].trim()); // deposit amount is the fourth element
                    if (!accounts.containsKey(accountId)) {
                        results.add("false");
                    } else if (depositAmount <= 0) {
                        results.add("false");
                    } else {
                        Double newBalance = accounts.get(accountId) + depositAmount;
                        accounts.put(accountId, newBalance);
                        updateTransactionTotal(accountId, depositAmount);
                        results.add(formatDouble(newBalance));
                    }
                    break;

                case "PAY":
                    Double payAmount = Double.parseDouble(query[3].trim()); // pay amount is the fourth element
                    if (!accounts.containsKey(accountId)) {
                        results.add("Account not found");
                    } else if (payAmount <= 0) {
                        results.add("Invalid withdrawal amount");
                    } else if (accounts.get(accountId) < payAmount) {
                        results.add("Insufficient funds");
                    } else {
                        Double newBalance = accounts.get(accountId) - payAmount;
                        accounts.put(accountId, newBalance);
                        updateTransactionTotal(accountId, -payAmount);
                        results.add(formatDouble(newBalance));
                    }
                    break;

                case "TOP_ACTIVITY":
                    int topN = Integer.parseInt(query[2].trim());
                    List<Map.Entry<String, Double>> sortedAccounts = new ArrayList<>(transactionTotals.entrySet());
                    sortedAccounts.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // Sort in descending order

                    StringBuilder topAccounts = new StringBuilder();
                    for (int i = 0; i < topN && i < sortedAccounts.size(); i++) {
                        Map.Entry<String, Double> entry = sortedAccounts.get(i);
                        if (i > 0) topAccounts.append(", ");
                        topAccounts.append(entry.getKey()).append("(").append(formatDouble(entry.getValue())).append(")");
                    }
                    results.add(topAccounts.toString());
                    break;

                default:
                    results.add("Invalid operation");
                    break;
            }
        }

        return results.toArray(new String[0]);
    }

    private static void updateTransactionTotal(String accountId, Double amount) {
        transactionTotals.put(accountId, transactionTotals.getOrDefault(accountId, 0.0) + amount);
    }

    private static String formatDouble(Double value) {
        // If the value is a whole number, return it without decimal places
        if (value % 1 == 0) {
            return String.format("%d", value.intValue());
        }
        // Otherwise, return it with no decimal places
        return String.format("%.0f", value);
    }

    public static void main(String[] args) {
        String[][] queries = {
                {"CREATE_ACCOUNT", "1", "account1"},
                {"CREATE_ACCOUNT", "2", "account2"},
                {"CREATE_ACCOUNT", "3", "account3"},
                {"DEPOSIT", "4", "account1", "1000"},
                {"DEPOSIT", "5", "account2", "1000"},
                {"DEPOSIT", "6", "account3", "1000"},
                {"PAY", "7", "account2", "100"},
                {"PAY", "8", "account2", "100"},
                {"PAY", "9", "account3", "100"},
                {"TOP_ACTIVITY", "10", "3"}
        };

        String[] results = solution(queries);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
