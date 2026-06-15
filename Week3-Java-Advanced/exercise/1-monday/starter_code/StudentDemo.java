/** Lab 2 driver — run after Student is implemented. */
public class StudentDemo {
    public static void main(String[] args) {
        // TODO: create 3 Student instances, print enrollment count,
        // demonstrate equals vs == with two references to same id scenario if possible
        Student s1 = new Student("Audy", "Software Engineer");
        Student s2 = new Student("Emily", "Neuroscience");
        Student s3 = new Student("Tina", "Background Paint Designer");

        System.out.println("enrollment count: " + Student.getEnrollmentCount());
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));

        Student s1Alias = s1;
        System.out.println("s1 == s1Alias: " + (s1 == s1Alias));
        System.out.println("s1.equals(s1Alias): " + s1.equals(s1Alias));

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
