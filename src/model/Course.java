package model;

public class Course {
	
	private Student root;
	
	public Course() {
		
	}
	
	public void addStudent(int c, String n) {
		Student toAdd = new Student(c, n);
		if (root == null) {
			root = toAdd;
		} else {
			Student current = root;
			boolean stoped = true;
			while (stoped) {
				if (toAdd.compareTo(current) < 0) {
					if (current.getLeft() == null) {
						current.setLeft(toAdd);
						stoped=false;
					} else {
						current = current.getLeft();
					}
				}else {
					if (current.getRight() == null) {
						current.setRight(toAdd);
						stoped=false;
					} else {
						current = current.getRight();
					}
				}
			}
		}
	}
	
	public Student searchStudent(int c) {
		boolean stoped = true;
		Student current = root;
		while (stoped) {
			if (c == current.getCode()) {
				stoped = false;
			} else if (c < current.getCode()) {
				current = current.getLeft();
			} else if (c > current.getCode()) {
				current = current.getRight();
			}
		}
		return current;
	}

	public Student getRoot() {
		return root;
	}

	public void setRoot(Student root) {
		this.root = root;
	}
}
