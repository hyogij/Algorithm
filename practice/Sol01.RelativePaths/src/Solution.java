import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.01.25
 Question Number : 01
 Link : http://www.careercup.com/question?id=6209523802963968
 ==========================================================
 */

public class Solution {
	/*
	 * Given a current absolute path, e.g., "/usr/bin/mail", and a relative one,
	 * e.g, "../../../etc/xyz/../abc" return the absolute path created from the
	 * combination of the first two paths. In the example strings, the answer
	 * should be "/etc/abc".
	 */
	private static final String UP = "..";

	public static void main(String[] args) {
		System.out.println(pwd("../../../etc/xyz/../abc", "/usr/bin/mail"));
		System.out.println(pwd("../../etc/xyz/../abc", "/usr/bin/mail"));
		System.out.println(pwd("../../../../etc/xyz/../abc", "/usr/bin/mail"));

		System.out
				.println(absolute("../../../etc/xyz/../abc", "/usr/bin/mail"));
		System.out.println(absolute("../../etc/xyz/../abc", "/usr/bin/mail"));
		System.out.println(absolute("../../../../etc/xyz/../abc",
				"/usr/bin/mail"));

	}

	public static String pwd(String relativePath, String absolutePath) {
		StringBuffer sb = new StringBuffer();

		// I will use stack to calculate relative path
		// If we meet the "." operation, we stay current path,
		// If we meet the ".." operation, we move to parent directory
		Stack<String> stack = new Stack<String>();

		String[] paths = absolutePath.split("/");
		for (String path : paths) {
			if (path.length() != 0) {
				stack.push(path);
			}
		}

		paths = relativePath.split("/");
		for (String path : paths) {
			if (path.equals("..")) {
				// if no element in second stack - there is no such path
				if (stack.isEmpty() == true) {
					System.out
							.println(String
									.format("No matching absolute path for current [%s] and relative: [%s]",
											absolutePath, relativePath));
					return "";
				}
				stack.pop();
			} else {
				stack.push(path);
			}
		}

		// Make new absolute path using stack
		for (int i = 0; i < stack.size(); i++) {
			if (i < stack.size()) {
				sb.append("/");
			}
			sb.append(stack.get(i));
		}

		return sb.toString();
	}

	/**
	 * Calculates absolute path by its relative
	 *
	 * @param relative
	 *            relative path to calculate
	 * @param current
	 *            current absolute path
	 * @return absolute path correspondent to relative
	 */
	public static String absolute(String relative, String current) {
		if (relative == null)
			throw new IllegalArgumentException(
					"Null relative path is not allowed");
		relative = relative.trim();
		if ("".equals(relative))
			throw new IllegalArgumentException(
					"Empty relative path is not allowed");

		LinkedList<String> relativeStack = pathStack(relative);
		LinkedList<String> absoluteStack = pathStack(current);

		while (!relativeStack.isEmpty()) {
			String token = relativeStack.removeLast();
			if (UP.equals(token)) {
				boolean mismatch = false;
				try {
					// just remove from second stack
					String el = absoluteStack.removeFirst();
					mismatch = "".equals(el);
				} catch (NoSuchElementException no) {
					mismatch = true;
				}
				if (mismatch) {
					// if no element in second stack - there is no such path
					System.out
							.println(String
									.format("No matching absolute path for current [%s] and relative: [%s]",
											current, relative));
					return "";
				}
			} else {
				absoluteStack.addFirst(token);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!absoluteStack.isEmpty()) {
			sb.append(absoluteStack.removeLast()).append("/");
		}
		String path = sb.toString();
		return path.substring(0, path.length() - 1);
	}

	private static LinkedList<String> pathStack(String path) {
		if (path == null)
			throw new IllegalArgumentException("Null path is not allowed");
		path = path.trim();
		if ("".equals(path))
			throw new IllegalArgumentException("Empty path is not allowed");

		String[] tokens = path.split("/");
		LinkedList<String> stack = new LinkedList<String>();
		for (String t : tokens) {
			stack.addFirst(t);
		}
		return stack;
	}
}
