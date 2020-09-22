package ru.job4j.bank;
import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
       users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            users.get(user.get()).add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
         User result = users.keySet().stream().filter(user -> user.getPassport().
                 equals(passport)).findFirst().orElse(null);
        if (result != null) {
            rsl = Optional.of(result);
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
            Optional<Account> rsl = Optional.empty();
            Optional<User> user = findByPassport(passport);
            Account find = null;
        if (user.isPresent()) {
            find = users.get(user.get()).stream().filter(account -> account.getRequisite()
                    .equals(requisite)).findFirst().orElse(null);
        }
        if (find != null) {
            rsl = Optional.of(find);
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
       Optional<Account> tf = findByRequisite(srcPassport, srcRequisite);
       Optional<Account> sl = findByRequisite(destPassport, destRequisite);
        if (tf.isPresent() && sl.isPresent() && tf.get().getBalance() >= amount) {
            tf.get().setBalance(tf.get().getBalance() - amount);
            sl.get().setBalance(sl.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
