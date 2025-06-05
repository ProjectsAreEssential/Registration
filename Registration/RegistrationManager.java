import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class RegistrationManager {
  
   public static void main(String[] args) {
      try {
         Course[] courses = RegistrationManagerModule.readCourses("courses.txt"); // Initializing the courses array
         Student[] students = RegistrationManagerModule.readStudents("students.txt"); // Initializing the students array
         
         RegistrationManagerModule.showMenu(courses, students); // Prompt the menu in the console         
      } catch (FileNotFoundException e) {
         System.out.println("Error opening file " + e);
      }
   }   
}