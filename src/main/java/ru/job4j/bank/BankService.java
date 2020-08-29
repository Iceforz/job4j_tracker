package ru.job4j.bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
       users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User success = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                success = user;
                break;
            }
        }
        return success;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User success = findByPassport(passport);
        if (success != null) {
            List<Account> req = users.get(success);
            for (Account accounts : req) {
                if (requisite.equals(accounts.getRequisite())) {
                    account = accounts;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account tf = findByRequisite(srcPassport, srcRequisite);
        Account sl = findByRequisite(destPassport, destRequisite);
        if (amount <= tf.getBalance() && tf != null && sl != null) {
            tf.setBalance(tf.getBalance() - amount);
            sl.setBalance(sl.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
