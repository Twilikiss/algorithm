package 数据结构与算法.哈希表;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 简易实现HashTable的底层逻辑
 * @author mlp52
 *
 */
public class HashTable {
	public static void main(String[] args) {
		hashtables hash = new hashtables(7);
		// 写一个简单的菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add:添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("find: 查找雇员");
			System.out.println("exit: 退出系统");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("输入 id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				// 创建 雇员
				Employee emp = new Employee(id, name);
				hash.add(emp);
				break;
			case "list":
				hash.showAllLinkedList();
				break;
			case "find":
				System.out.println("请输入要查找的 id");
				id = scanner.nextInt();
				hash.findEmpById(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
	}
}
//构建hashtable
class hashtables{
	private EmployeeLinkedList[] employeeLinkedLists;
	private int size;

	//构建数组
	public hashtables(int size) {
		this.size = size;
		employeeLinkedLists = new EmployeeLinkedList[size];
		//这样做对吗？不对，我们还要初始化数组中的每一个链表
		for(int i = 0;i < size;i++) {
			employeeLinkedLists[i] = new EmployeeLinkedList();
		}
	}
	
	//添加成员
	public void add(Employee employee) {
		//根据员工id来决定应该分到哪一个链表
		int employeeLinkedID = getPlace(employee);	
		
		//将员工放入到对应链表中
		employeeLinkedLists[employeeLinkedID].add(employee);
	}
	
	//编写散列函数
	//id取模返回结果
	public int getPlace(Employee employee) {
		int data = employee.getId() % employeeLinkedLists.length;
		return data;
	}
	
	//遍历所有链表
	public void showAllLinkedList() {
		for(int i = 0;i < employeeLinkedLists.length;i++) {
			
			employeeLinkedLists[i].showAll(i + 1);
		}
	}
	//查找功能的实现
	public void findEmpById(int id) {
		int index = id % size;
		ArrayList<Employee> employees = employeeLinkedLists[index].findEmployees(id);
		if (employees.isEmpty()) {
			System.out.println("未能找到员工信息");
		}
		for(Employee outEmployee : employees) {
			System.out.println(outEmployee);
		}
	}
}
//雇员bean
class Employee{
	private int id;
	private String name;
	private String address;
	private Employee next;
	
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Employee getNext() {
		return next;
	}
	public void setNext(Employee next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
//创建一条链表
class EmployeeLinkedList{
	//头指针，指向第一个雇员
	private Employee head; // 默认为null
	
	//假定添加雇员的id是自增的，因此从小到大排列来看，将新添加的雇员加到最后一位就行
	public void add(Employee employee) {
		//如果是第一个雇员
		if (head == null) {
			head = employee;
			return;
		}
		Employee curEmployee = head;
		while(true) {
			if(curEmployee.getNext() == null) {
				break;
			}
			curEmployee = curEmployee.getNext();
		}
		//找到对应的节点后，将雇员消息添加到链表的最后
		curEmployee.setNext(employee);
	}
	
	//遍历该链表的雇员信息
	public void showAll(int employeeLinkedListId) {
		if (head == null) { // 当前链表为空
			System.out.println("第" + employeeLinkedListId + "条链表为空！！！");
			return;
		}
		System.out.print("第" + employeeLinkedListId + "条的链表为: ");
		Employee curEmployee = head;
		while(true) {
			System.out.print("==>" + curEmployee.toString());
			
			if (curEmployee.getNext() == null) {
				break;
			}
			curEmployee = curEmployee.getNext();
		}
		System.out.println();
	}
	//查找对应id的员工的信息
	public ArrayList<Employee> findEmployees(int id) {
		ArrayList<Employee> outArrayList = new ArrayList<>();
		Employee curEmployee = head;
		while(true) {
			if (curEmployee == null) {
				break;
			}
			if (curEmployee.getId() == id) {
				outArrayList.add(curEmployee);
			}
			curEmployee = curEmployee.getNext();
		}
		return outArrayList;
	}
}