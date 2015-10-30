package AtCoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-30
 * @url http://indeednow-finala-open.contest.atcoder.jp/tasks/
 *      indeednow_2015_finala_b
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();

		ArrayList<Company> companies = new ArrayList<Company>();
		ArrayList<Person> persons = new ArrayList<Person>();

		int a, b, c, salary;
		// Informations about company
		for (int i = 0; i < N; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			salary = scanner.nextInt();

			Company company = new Company(a, b, c, salary);
			companies.add(company);
		}

		for (int i = 0; i < M; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();

			Person person = new Person(a, b, c);
			persons.add(person);
		}

		// Sort companies by required points by asc
		Collections.sort(companies);

		for (int i = 0; i < persons.size(); i++) {
			findBestCompany(companies, persons.get(i));
		}
	}

	private void findBestCompany(ArrayList<Company> companies, Person person) {
		int salary = 0;
		for (int i = 0; i < companies.size(); i++) {
			Company company = companies.get(i);
			if (person.a < company.a || person.b < company.b
					|| person.c < company.c) {
				break;
			}
			salary = company.salary;
		}
		System.out.println(salary);
	}

	class Company implements Comparable<Company> {
		public int a, b, c;
		public int salary;

		public Company(int a, int b, int c, int salary) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.salary = salary;
		}

		@Override
		public int compareTo(Company company) {
			if (a > company.a) {
				return 1;
			} else if (a < company.a) {
				return -1;
			}

			if (b > company.b) {
				return 1;
			} else if (b < company.b) {
				return -1;
			}

			if (c > company.c) {
				return 1;
			} else if (c < company.c) {
				return -1;
			}

			return 0;
		}

		public String toString() {
			return a + " " + b + "  " + c + " " + salary;
		}
	}

	class Person {
		public int a, b, c;

		public Person(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}