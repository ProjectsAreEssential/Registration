import java.util.Arrays;

public class Student {
   
   // Instance variables
   private int studentId;
   private String name;
   private int[] registeredCourses = new int[5]; // Max of 5 courses per student
   private int courseCount; // Number of courses registered
   
   // Constructor
   public Student(int studentId, String name) {
      this.studentId = studentId;
      this.name = name;
   }
   
   // Gets the students id
   public int getStudentId() {
      return studentId;
   }
   
   // Gets the students name
   public String getName() {
      return name;
   }
   
   // Gets the registered courses
   public int[] getRegisteredCourses() {
      return registeredCourses;
   }
   
   // Gets the course count
   public int getCourseCount() {
      return courseCount;
   }
   
   // Sets the students id
   public void setStudentId(int newStudentId) {
      studentId = newStudentId;
   }
   
   // Sets the students name
   public void setStudentName(String newName) {
      name = newName;
   }
   
   // Sets the registered courses
   public void setRegisteredCourses(int[] newRegisteredCourses) {
      registeredCourses = newRegisteredCourses;
   }
   
   // Sets the course count
   public void setCourseCount(int newCourseCount) {
      courseCount = newCourseCount;
   }
   
   // Adds a course id to the registered array
   public boolean registerCourse(int courseId) {
      if (courseCount >= 5) return false; // Checks to see if the student has 5 courses or more registered      
      
      for (int i = 0; i < registeredCourses.length; i++) {
         if (registeredCourses[i] == courseId) return false; // Checks to see if the course is already registered      
      }
      
      for (int i = 0; i < registeredCourses.length; i++) {
         if (registeredCourses[i] == 0) { // Finds the first element in the array with a value of 0, if any
            registeredCourses[i] = courseId; // After finding the element, assign the course id to that element
            courseCount++; // Increment the amount of courses the student registered for
            return true; // Leave the method to avoid populating other elements
         }
      } 
      
      return false; // Here for safety and compilation
   }
   
   // Removes a course id from the registered array
   public boolean dropCourse(int courseId) {
      for (int i = 0; i < registeredCourses.length; i++) {
         if (registeredCourses[i] == courseId) { // Finds the first element in the array with the course id
            registeredCourses[i] = 0; // Reassigns the value to 0, meaning slot is empty
            courseCount--; // Decrement the amount of courses the student registered for
            return true; // Leave the method to avoid populating other elements
         }
      }
      return false; // Course not found in the registered array
   }
   
   // Prints a string representation
   public String toString() {
      String temp = "";
      for (int i = 0; i < registeredCourses.length; i++) { // Checks to see which elements arent 0
         if (registeredCourses[i] != 0) { // If the element isnt 0, append it to the String variable "temp"
            temp += registeredCourses[i] + " ";
         }
      }
      
      return "Student Id: " + studentId + "\n"
           + "Student Name: " + name + "\n"
           + "Registered Course Ids: " + temp.trim() + "\n"
           + "Course Count: " + courseCount;
   }
}