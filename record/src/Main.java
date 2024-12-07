//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }


        StudentClass s1 = new StudentClass("101", "Abid", 3.58f);
        StudentRecord s2 = new StudentRecord("102", "Hasan", 3.52f);
//        StudentRecord s3 = new StudentRecord("201", "Rana", 4.52f); // Illegal cgpa
        StudentRecord s3 = new StudentRecord();

        System.out.println(s1.getName());
        System.out.println(s2.name());
        System.out.println(s2.name("Saimon"));
        System.out.println(s2.getEmail());

        System.out.println(s3.getEmail());

    }
}