import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class RegistrationManagerModule {
   
   // Prints the menu to the console while giving funtionality
   public static void showMenu(Course[] courses, Student[] students) {
      Scanner console = new Scanner(System.in);

      boolean exit = false; // Boolean to see if the user wants to exit the program

      while (!exit) {
          System.out.println("1. View all courses");
          System.out.println("2. Search for a course by name");
          System.out.println("3. Register a student for a course");
          System.out.println("4. Drop a course for a student");
          System.out.println("5. View all students and their registered courses");
          System.out.println("6. Add a new student");
          System.out.println("7. Add a new course");
          System.out.println("8. Save and exit");
          
          System.out.println(); // For readability
         
          System.out.print("Enter your choice: ");
          int choice = console.nextInt();
          console.nextLine(); // clear newline

       switch (choice) {
            case 1: // View all courses
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] != null) {
                        System.out.println(courses[i]);
                        System.out.println();
                    }
                }
                break;

            case 2: // Search for a course by name
                System.out.print("Enter course name to search: ");
                String searchName = console.nextLine().trim();

                boolean found = false;
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] != null &&
                        courses[i].getCourseName().toLowerCase().contains(searchName.toLowerCase())) {
                        System.out.println(courses[i]);
                        System.out.println();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No course found with that name.");
                }
                break;

            case 3: // Register a student for a course
                System.out.print("Enter your student Id: ");
                int studentId3 = console.nextInt();

                System.out.print("Enter course Id: ");
                int courseId3 = console.nextInt();
                console.nextLine();

                Student selectedStudent3 = null;
                for (int i = 0; i < students.length; i++) {
                    if (students[i] != null && students[i].getStudentId() == studentId3) {
                        selectedStudent3 = students[i];
                        break;
                    }
                }
                if (selectedStudent3 == null) {
                    System.out.println("Student with Id " + studentId3 + " not found.");
                    break;
                }

                Course selectedCourse3 = null;
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] != null && courses[i].getCourseId() == courseId3) {
                        selectedCourse3 = courses[i];
                        break;
                    }
                }
                if (selectedCourse3 == null) {
                    System.out.println("Course with Id " + courseId3 + " not found.");
                    break;
                }
                if (selectedCourse3.isFull()) {
                    System.out.println("Course " + selectedCourse3.getCourseName() + " is already full.");
                    break;
                }

                boolean registered = selectedStudent3.registerCourse(courseId3);
                if (registered) {
                    selectedCourse3.setEnrolledStudents(selectedCourse3.getEnrolledStudents() + 1);
                    System.out.println("Student " + selectedStudent3.getName() + " successfully registered for " + selectedCourse3.getCourseName() + ".");
                } else {
                    System.out.println("Registration failed. Student may already be registered or reached max courses.");
                }
                break;

            case 4: // Drop a course for a student
                System.out.print("Enter your student Id: ");
                int studentId4 = console.nextInt();

                Student selectedStudent4 = null;
                for (int i = 0; i < students.length; i++) {
                    if (students[i] != null && students[i].getStudentId() == studentId4) {
                        selectedStudent4 = students[i];
                        break;
                    }
                }
                if (selectedStudent4 == null) {
                    System.out.println("Student with Id " + studentId4 + " not found.");
                    break;
                }

                System.out.print("Enter course Id to drop: ");
                int courseId4 = console.nextInt();
                console.nextLine();

                Course selectedCourse4 = null;
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] != null && courses[i].getCourseId() == courseId4) {
                        selectedCourse4 = courses[i];
                        break;
                    }
                }
                if (selectedCourse4 == null) {
                    System.out.println("Course with Id " + courseId4 + " not found.");
                    break;
                }

                boolean dropped = selectedStudent4.dropCourse(courseId4);
                if (dropped) {
                    selectedCourse4.setEnrolledStudents(selectedCourse4.getEnrolledStudents() - 1);
                    System.out.println("Course " + selectedCourse4.getCourseName() + " dropped for " + selectedStudent4.getName() + ".");
                } else {
                    System.out.println("Drop failed. Student was not registered in the course.");
                }
                break;

            case 5: // View all students and their registered courses
                for (int i = 0; i < students.length; i++) {
                    if (students[i] != null) {
                        System.out.println(students[i]);
                        System.out.println();
                    }
                }
                break;

            case 6: // Add a new student
                System.out.print("Enter new student ID: ");
                int newId = console.nextInt();
                console.nextLine();

                boolean exists = false;
                for (int i = 0; i < students.length; i++) {
                    if (students[i] != null && students[i].getStudentId() == newId) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("A student with this ID already exists.");
                    break;
                }

                System.out.print("Enter full name: ");
                String fullName = console.nextLine();

                int insertIndex = -1;
                for (int i = 0; i < students.length; i++) {
                    if (students[i] == null) {
                        insertIndex = i;
                        break;
                    }
                }
                if (insertIndex == -1) {
                    System.out.println("Student array is full. Cannot add more students.");
                    break;
                }

                students[insertIndex] = new Student(newId, fullName);
                System.out.println("Student added successfully.");
                break;

            case 7: // Add a new course
                System.out.print("Enter new course ID: ");
                int newCourseId = console.nextInt();
                console.nextLine();

                boolean idExists = false;
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] != null && courses[i].getCourseId() == newCourseId) {
                        idExists = true;
                        break;
                    }
                }
                if (idExists) {
                    System.out.println("A course with this ID already exists.");
                    break;
                }

                System.out.print("Enter course name: ");
                String newCourseName = console.nextLine();

                System.out.print("Enter max capacity: ");
                int maxCap = console.nextInt();
                console.nextLine();

                int courseIndex = -1;
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] == null) {
                        courseIndex = i;
                        break;
                    }
                }
                if (courseIndex == -1) {
                    System.out.println("Course array is full. Cannot add more courses.");
                    break;
                }

                courses[courseIndex] = new Course(newCourseId, newCourseName, maxCap, 0);
                System.out.println("Course added successfully.");
                break;

            case 8: // Save and exit (print and exit)
                System.out.println("----- Current Courses -----");
                for (int i = 0; i < courses.length; i++) {
                    if (courses[i] != null) {
                        System.out.println(courses[i]);
                        System.out.println();
                    }
                }

                System.out.println("----- Current Students -----");
                for (int i = 0; i < students.length; i++) {
                    if (students[i] != null) {
                        System.out.println(students[i]);
                        System.out.println();
                    }
                }

                System.out.println("Changes saved internally. Exiting program.");
                exit = true;
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                break;
        }
    }
    console.close();
}
   
   // Counts how many lines are in the file to determine how many courses or students there are
   public static int countLines(String filename) throws FileNotFoundException {
      int count = 0;
      Scanner lineCounter = new Scanner(new File(filename));

      while (lineCounter.hasNextLine()) {
         lineCounter.nextLine();
         count++;
      }

      lineCounter.close();
      return count;
   }

   // Reads data from the given file and returns an array of course objects
   public static Course[] readCourses(String filename) throws FileNotFoundException {
      Scanner input = new Scanner(new File(filename));
      Course[] courses = new Course[countLines(filename)]; // Initializes the courses array to how many lines there are, assuming each line has a new course on it
      
      int count = 0;
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner lineScanner = new Scanner(line);
         lineScanner.useDelimiter(","); // This splits the tokens at a comma now instead of a space
      
         int courseId = lineScanner.nextInt();
         String courseName = lineScanner.next().trim(); // Trim trailing whitespaces
         int maxCapacity = lineScanner.nextInt();
         int enrolledStudents = lineScanner.nextInt();
         
         lineScanner.close(); // Close the line scanner
         
         // With each course create a new course object while assinging it at index count while iterating
         courses[count++] = new Course(courseId, courseName, maxCapacity, enrolledStudents);
      }
      
      input.close(); // Close the input scanner
      return courses; // Return the array with all the course objects
   }
    
   // Reads data from the given file and returns an array of student objects
   public static Student[] readStudents(String filename) throws FileNotFoundException {
      Scanner input = new Scanner(new File(filename));
      Student[] students = new Student[countLines(filename)]; // Initializes the students array to how many lines there are assuming each line has a new course on it
      
      int count = 0;
      while (input.hasNextLine()) {
         String line = input.nextLine();
         Scanner lineScanner = new Scanner(line);
         lineScanner.useDelimiter(","); // This splits the tokens at a comma now instead of a space
      
         int studentId = lineScanner.nextInt();
         String studentName = lineScanner.next().trim(); // Trim trailing whitespaces
         
         // Initialize a new student object
         Student student = new Student(studentId, studentName);
         
         // Read remaining tokens as courss Ids and register them
         while (lineScanner.hasNextInt()) {
            int courseId = lineScanner.nextInt();
            student.registerCourse(courseId); // Store the course id into the registered array from the student class
         }
         
         // With each student create a new student object while assinging it at index count while iterating
         students[count++] = student;
         lineScanner.close(); // Close the line scanner
      }
      
      input.close(); // Close the input scanner
      return students; // Return the array with all the students objects
   }
}