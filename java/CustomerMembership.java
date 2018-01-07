package apple.interview;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerMembership {
    private static Customer parentPremium1 = new Customer(1, "john", "tester",
            Customer.MembershipLevel.PREMIUM, -1);
    private static Customer xchildPremium1 = new Customer(11, "xbabyjohn", "tester",
            Customer.MembershipLevel.COMMUNITY, 1);
    private static Customer achildPremium1 = new Customer(12, "ababyjohn", "tester",
            Customer.MembershipLevel.PREMIUM, 1);

    private static Customer parentEnterprise1 = new Customer(2, "Michael", "manager",
            Customer.MembershipLevel.COMMUNITY,-1);
    private static Customer xchildEnterprise1 = new Customer(21, "xbabyMichael", "manager",
            Customer.MembershipLevel.ENTERPRISE,2);
    private static Customer achildEnterprise1 = new Customer(22, "ababyMichael", "manager",
            Customer.MembershipLevel.COMMUNITY, 2);

    private static Customer parentCommunity1 = new Customer(3, "Dave", "developer",
            Customer.MembershipLevel.COMMUNITY,-1);

    public static void main(String[] args) {
        List<Customer> input = new ArrayList<>();

        input.add(xchildEnterprise1);
        input.add(achildPremium1);
        input.add(parentCommunity1);
        input.add(achildEnterprise1);
        input.add(parentEnterprise1);

        input.add(parentPremium1);
        input.add(xchildPremium1);

        List<Customer> expected = new ArrayList<>();
        expected.add(parentPremium1);
        expected.add(achildPremium1);
        expected.add(xchildPremium1);

        expected.add(parentEnterprise1);
        expected.add(achildEnterprise1);
        expected.add(xchildEnterprise1);

        expected.add(parentCommunity1);
        assertEquals(expected, CustomerMembership.getSortedCustomers(input));
    }

    @Data
    public static class Customer {
        private int id;
        private String firstName;
        private String lastName;

        // Membership level of the customer
        public MembershipLevel membershipLevel;
        // indicates the parent Family member id
        // -1 represents this customer is parent
        public int parentFamilyMember;

        public Customer(int id, String firstName, String lastName, MembershipLevel membershipLevel,
                        int parentFamilyMember) {
            super();
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.membershipLevel = membershipLevel;
            this.parentFamilyMember = parentFamilyMember;
        }


        public String toString() {
            return id + " -\t" + firstName + " " + lastName + " - " + membershipLevel;
        }

        public enum MembershipLevel {
            PREMIUM, ENTERPRISE, COMMUNITY;
        }

    }

    /**
     * Sort the input Customers list in the order of
     * 1) sort in order membershipLevel where (PREMIUM > ENTERPRISE > COMMUNITY) -
     * 2) If a member has a parent, the parent and all other siblings are treated at highest membership level. -
     * 3) Also they are grouped together with parent being the first member. -
     * 4) Siblings are sorted alphabetically by first name followed by last name -
     * 5) If 2 parents have same membership level then they are sorted by first name followed by last name
     * 6) There can be duplicates of firstName and lastName however the id will be different -
     * <p>
     * Note: You are required to use Java 8 streams
     * Bonus if you can use parallel streams where ever possible
     *
     * @param inputCustomers
     * @return
     */

    public static List<Customer> getSortedCustomers(List<Customer> inputCustomers) {
        final List<Customer> EMPTY_LIST = new LinkedList<>();
        Map<Customer, List<Customer>> headSiblingsMap = new HashMap<>();

        Map<Integer, List<Customer>> siblingMap = inputCustomers.stream().filter(c -> c.parentFamilyMember != -1)
                .collect(Collectors.groupingBy(c -> c.parentFamilyMember));
        siblingMap.values().forEach(l -> l.sort(Comparator.comparing(Customer::getFirstName).thenComparing
                (Customer::getLastName).thenComparing(Customer::getId)));

        inputCustomers.stream().filter(c -> c.parentFamilyMember == -1)
                .forEach(c -> headSiblingsMap.put(c, siblingMap.getOrDefault(c.getId(), EMPTY_LIST)));

        List<Customer> result = headSiblingsMap.entrySet().stream().sorted(
                new MembershipLevelComparator().thenComparing(e -> e.getKey().getFirstName())
                        .thenComparing(e -> e.getKey().getLastName())
                        .thenComparing(e -> e.getKey().getId()))
                .map(e -> {
                    List<Customer> customerList = new LinkedList<>();
                    customerList.add(e.getKey());
                    customerList.addAll(siblingMap.getOrDefault(e.getKey().getId(), EMPTY_LIST));
                    return customerList;
                }).flatMap(List::stream).collect(Collectors.toList());

        return result;
    }

    private static class MembershipLevelComparator implements Comparator<Map.Entry<Customer, List<Customer>>> {

        @Override
        public int compare(Map.Entry<Customer, List<Customer>> o1, Map.Entry<Customer, List<Customer>> o2) {
            Customer.MembershipLevel m1 = o1.getKey().getMembershipLevel();
            Optional<Customer> temp = o1.getValue().stream().min(Comparator.comparing(Customer::getMembershipLevel));
            if (temp.isPresent()) {
                Customer c = temp.get();
                if (c.getMembershipLevel().compareTo(m1) < 0) {
                    m1 = c.getMembershipLevel();
                }
            }

            Customer.MembershipLevel m2 = o2.getKey().getMembershipLevel();
            temp = o2.getValue().stream().min(Comparator.comparing(Customer::getMembershipLevel));
            if (temp.isPresent()) {
                Customer c = temp.get();
                if (c.getMembershipLevel().compareTo(m2) < 0) {
                    m2 = c.getMembershipLevel();
                }
            }

            return m1.compareTo(m2);
        }
    }

}
