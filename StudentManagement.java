import java.util.*;
public class StudentManagement {
	public static Scanner sr = new Scanner(System.in);
	
	
	
	public static boolean sameGroup(Student s1,Student s2) {
		if (s1.getGroup().equals(s2.getGroup())) return true;
		return false;
	}
	public static boolean StudentByGroup(Student tuan,String s)
	{
		if (tuan.getGroup().equals(s)) return true;
		return false;
	}
	public static void PrintByGroup(Student[] s,int n) {
		int temp=0;
		HashSet<String> hs = new HashSet<String>();
		//s = new Student[n];
		for (int i=0;i<n;i++)
		{
			hs.add(s[i].getGroup());
			temp++;
		}
		String[] hss = new String[temp-1];
		hs.toArray(hss);
		for (int i=0;i<temp;i++)
		{
			int k = 1;
			System.out.println("DANH SACH SINH VIEN LOP" + hss[i]);
			for (int j=0;j<n;j++) {
				if (s[j].getGroup().equals(hss[i])) {
					System.out.println(k + " > "+s[i].getName());
					k++;
				}
			}
		}
	}
	public static int removeStudent(Student[] student,String id,int n) {
		for (int i =0;i<n;i++)
		{
			if (student[i].getId().equals(id)) {
				for (int j = i;j<n;j++) {
					student[j] = student[i+1];
				}
				n--;
				student[n] =  null;
			}
		}
		return n;
	}
	public static  void main(String[] args) {
		
		System.out.print("nhap so sinh vien : ");
		int n = sr.nextInt();
		sr.nextLine();
		
		Student[] student = new Student[n];
		
		
		for (int i =0 ;i<n;i++)
		{
			student[i] = new Student();
			student[i].setInfo();
		}
		System.out.println("=======DANH SACH HOC SINH VUA NHAP=======");
		for (int i = 0;i<n;i++)
		{
			student[i].getInfo();
		}
		System.out.print("Nhap ID sinh vien ban muon xoa : ");
		String delete = sr.nextLine();
		n = removeStudent(student, delete, n);
		PrintByGroup(student,n);
		sr.close();
	}
		
}
