/*
	apple interview question
*/

package main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SortTest {

	public static class Customer {
		public int id;
		public String firstName;
		public String lastName;

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
			return firstName + " " + lastName;
		}

		public enum MembershipLevel {
			PREMIUM, ENTERPRISE, COMMUNITY;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + id;
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((membershipLevel == null) ? 0 : membershipLevel.hashCode());
			result = prime * result + parentFamilyMember;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (membershipLevel != other.membershipLevel)
				return false;
			if (parentFamilyMember != other.parentFamilyMember)
				return false;
			return true;
		}

	}

	/**
	 * Sort the input Customers list in the order of 1) sort in order
	 * membershipLevel where (PREMIUM > ENTERPRISE > COMMUNITY) - 2) If a member
	 * has a parent, the parent and all other siblings are treated at highest
	 * membership level. - 3) Also they are grouped together with parent being
	 * the first member. - 4) Siblings are sorted alphabetically by first name
	 * followed by last name - 5) If 2 parents have same membership level then
	 * they are sorted by first name followed by last name 6) There can be
	 * duplicates of firstName and lastName however the id will be different -
	 *
	 * Note: You are required to use Java 8 streams
	 *
	 * Bonus if you can use parallel streams where ever possible
	 *
	 * @param inputCustomers
	 * @return
	 */
	private Map<Integer, Integer> familyMembershipLevelMap;
	private Map<Integer, Customer> familyHead;

	List<Customer> getSortedCustomers(List<Customer> inputCustomers) {
		familyMembershipLevelMap = new HashMap<Integer, Integer>();
		familyHead = new HashMap<Integer, Customer>();

		inputCustomers.stream().forEach(c -> {
			int familyNum = c.parentFamilyMember == -1 ? c.id : c.parentFamilyMember;

			int value = Optional.ofNullable(familyMembershipLevelMap.get(familyNum)).orElse(Integer.MAX_VALUE);

			familyMembershipLevelMap.put(familyNum,
					value < c.membershipLevel.ordinal() ? value : c.membershipLevel.ordinal());

			if (c.parentFamilyMember == -1) {
				familyHead.put(c.id, c);
			}
		});
		return inputCustomers.parallelStream().sorted(customerComparator).collect(Collectors.toList());
	}

	private Comparator<Customer> customerComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer o1, Customer o2) {
			if (o1 == o2)
				return 0;
			int familyNum1 = o1.parentFamilyMember == -1 ? o1.id : o1.parentFamilyMember;
			int familyNum2 = o2.parentFamilyMember == -1 ? o2.id : o2.parentFamilyMember;

			int memberLever1 = familyMembershipLevelMap.get(familyNum1);
			int memberLever2 = familyMembershipLevelMap.get(familyNum2);

			Customer head1 = familyHead.get(familyNum1);
			Customer head2 = familyHead.get(familyNum2);

			if (memberLever1 != memberLever2)
				return memberLever1 - memberLever2;
			else if (familyNum1 != familyNum2)
				return head1.firstName.compareTo(head2.firstName) != 0 ? head1.firstName.compareTo(head2.firstName)
						: head1.lastName.compareTo(head2.lastName) != 0 ? head1.lastName.compareTo(head2.lastName)
								: head2.id - head1.id;
			else if (o1.parentFamilyMember == -1)
				return -1;
			else if (o2.parentFamilyMember == -1)
				return 1;
			else
				return o1.firstName.compareTo(o2.firstName) != 0 ? o1.firstName.compareTo(o2.firstName)
						: o1.lastName.compareTo(o2.lastName) != 0 ? o1.lastName.compareTo(o2.lastName) : o2.id - o1.id;

		}

	};

}

/*
public class SortedTestTester {

	Customer parentPremium1 = new Customer(1, "john", "tester", Customer.MembershipLevel.PREMIUM, -1);
	Customer xchildPremium1 = new Customer(11, "xbabyjohn", "tester", Customer.MembershipLevel.COMMUNITY, 1);
	Customer achildPremium1 = new Customer(12, "ababyjohn", "tester", Customer.MembershipLevel.PREMIUM, 1);

	Customer parentEnterprise1 = new Customer(2, "Michael", "manager", Customer.MembershipLevel.COMMUNITY, -1);
	Customer xchildEnterprise1 = new Customer(21, "xbabyMichael", "manager", Customer.MembershipLevel.ENTERPRISE, 2);
	Customer achildEnterprise1 = new Customer(22, "ababyMichael", "manager", Customer.MembershipLevel.COMMUNITY, 2);

	Customer parentCommunity1 = new Customer(3, "Dave", "developer", Customer.MembershipLevel.COMMUNITY, -1);

	@Test
	public void testSortingOrder() {
		List<SortTest.Customer> input = new ArrayList<>();

		input.add(xchildEnterprise1);
		input.add(achildPremium1);
		input.add(parentCommunity1);
		input.add(achildEnterprise1);
		input.add(parentEnterprise1);

		input.add(parentPremium1);
		input.add(xchildPremium1);

		List<SortTest.Customer> expected = new ArrayList<>();
		expected.add(parentPremium1);
		expected.add(achildPremium1);
		expected.add(xchildPremium1);

		expected.add(parentEnterprise1);
		expected.add(achildEnterprise1);
		expected.add(xchildEnterprise1);

		expected.add(parentCommunity1);
		assertEquals(expected, new SortTest().getSortedCustomers(input));
	}
}*/