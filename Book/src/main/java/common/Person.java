package common;			 // 기본 패키지 이외의 패키지(규약 1번)
/*
 * 날짜 : 2022/11/03
 * 이름 : 라성준
 * 내용 : Person 클래스 ,P116
 */
public class Person {
	
	private String name; // private 멤버 변수(규약 2번)
	private int age;	 // private 멤버 변수(규약 2번)
	
	public Person () {}	 // 기본 생성자(규약 3번)
	
	// public 게터/세터 메서드들(규약 4번, 5번)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
