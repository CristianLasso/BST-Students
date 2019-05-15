package model;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Student> preOrder(){
		return preOrder(root);
	}
	
	private List<Student> preOrder(Student currentNode){
		List<Student> l = new ArrayList<>();
		if(currentNode != null) {
			l.add(currentNode);
			List<Student> emilioLeft = preOrder(currentNode.getLeft());
			List<Student> emilioRight = preOrder(currentNode.getRight());
			l.addAll(emilioLeft);
			l.addAll(emilioRight);
		}
		return l;
	}
	
	public List<Student> indOrder(){
		return inOrder(root);
	}
	
	public List<Student> inOrder(Student s){
		List<Student> l = new ArrayList<Student>();
		if(s!= null) {
			List<Student> lr = inOrder(s.getRight());
			List<Student> lf = inOrder(s.getLeft());
			l.addAll(lr);
			l.add(root);
			l.addAll(lf);
		}
		return l;
	}
}
