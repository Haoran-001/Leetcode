package top.zhouhaoran.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public static void main(String[] args) {
        NumUniqueEmails numUniqueEmails = new NumUniqueEmails();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String filteredEmail = filter(email);
            set.add(filteredEmail);
        }

        return set.size();
    }

    private String filter(String email) {
        String[] emailArray = email.split("@");
        String localName = emailArray[0];
        String domainName = emailArray[1];
        StringBuilder filteredEmail = new StringBuilder();

        for (char c : localName.toCharArray()) {
            if (c == '.') {
                continue;
            } else if (c == '+') {
                break;
            } else {
                filteredEmail.append(c);
            }
        }

        filteredEmail.append("@");
        filteredEmail.append(domainName);

        return filteredEmail.toString();
    }
}
