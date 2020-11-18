package schoolrecords;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SchoolRecordsController {
    private static final String MENU = "1. Diákok nevének listázása\n2. Diák név alapján keresése\n3. Diák létrehozása\n4. Diák név alapján törlése\n5. Diák feleltetése\n6. Osztályátlag kiszámolása\n7. Tantárgyi átlag kiszámolása\n8. Diákok átlagának megjelenítése\n9. Diák átlagának kiírása\n10. Diák tantárgyhoz tartozó átlagának kiírása\n11. Kilépés";
    private ClassRecords classRecords;

    private Tutor tutor = new Tutor("Nagy Csilla",
            Arrays.asList(new Subject("földrajz"),
                    new Subject("matematika"),
                    new Subject("biológia"),
                    new Subject("zene"),
                    new Subject("fizika"),
                    new Subject("kémia")));

    private void initSchool() {
        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        firstStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("fizika"), tutor));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), tutor));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }

    public static void main(String[] args) {
        SchoolRecordsController src = new SchoolRecordsController();
        Scanner scanner = new Scanner(System.in);
        src.initSchool();
        boolean exit = false;
        do {
            System.out.println(MENU);
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println(src.classRecords.listStudentNames());
                    break;
                case "2":
                    System.out.println("Név?");
                    System.out.println(src.classRecords.findStudentByName(scanner.nextLine()));
                    break;
                case "3":
                    System.out.println("Név?");
                    src.classRecords.addStudent(new Student(scanner.nextLine()));
                    break;
                case "4":
                    System.out.println("Név?");
                    src.classRecords.removeStudent(new Student(scanner.nextLine()));
                    break;
                case "5":
                    Student student = src.classRecords.repetition();
                    System.out.println("Felel: " + student.getName() + " osztályzat:");
                    System.out.println("Osztályzás nem lehetséges őn nem tanár.");
                    break;
                case "6":
                    System.out.println("osztályátlag: " + src.classRecords.calculateClassAverage());
                    break;
                case "7":
                    System.out.println("Tantárgy?");
                    System.out.println("osztályátlag: " + src.classRecords.calculateClassAverageBySubject(new Subject(scanner.nextLine())));
                    break;
                case "8":
                    for (StudyResultByName item : src.classRecords.listStudyResults()) {
                        System.out.println("Név: " + item.getStudentName() + " Átlag: " + item.getStudyAverage());
                    }
                    break;
                case "9":
                    System.out.println("Név?");
                    System.out.println(src.classRecords.findStudentByName(scanner.nextLine()).calculateAverage());
                    break;
                case "10":
                    System.out.println("Név?");
                    String name = scanner.nextLine();
                    System.out.println("Tantárgy?");
                    System.out.println(src.classRecords.findStudentByName((name)).calculateSubjectAverage(new Subject(scanner.nextLine())));
                    break;
                case "11":
                    System.out.println("Good Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Nincs ilyen menü!");
                    break;
            }
        } while (!exit);

    }
}
