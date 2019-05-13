package model;

public class Student implements Comparable<Student> {

	private int code;
	private String name;
	private Student left;
	private Student right;

	public Student(int c, String n) {
		code = c;
		name = n;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Student getLeft() {
		return left;
	}

	public void setLeft(Student left) {
		this.left = left;
	}

	public Student getRight() {
		return right;
	}

	public void setRight(Student right) {
		this.right = right;
	}

	@Override
	public int compareTo(Student otherStudent) {
		int jairitoxxx = 0;
		if (code < otherStudent.getCode()) {
			jairitoxxx = -1;
		} else if (code > otherStudent.getCode()) {
			jairitoxxx = 1;
		}
		return jairitoxxx;
	}
}
