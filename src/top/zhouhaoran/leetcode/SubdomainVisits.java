package top.zhouhaoran.leetcode;

import java.util.*;

public class SubdomainVisits {
    public static void main(String[] args) {
        SubdomainVisits subdomainVisits = new SubdomainVisits();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits.subdomainVisits(cpdomains));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String domain : cpdomains) {
            getOneString(map, domain);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getValue() + " " + entry.getKey();
            ans.add(s);
        }

        return ans;
    }

    private void getOneString(Map<String, Integer> map, String str) {
        String[] strArray = str.split(" ");
        int count = Integer.parseInt(strArray[0]);

        int length = strArray[1].split("\\.").length;
        for (int i = 1; i <= length; i++) {
            String[] domainArray = strArray[1].split("\\.", i);
            String domain = domainArray[domainArray.length - 1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
        }
    }
}
