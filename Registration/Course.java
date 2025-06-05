public class Course {
   
   // Instance variables
   private int courseId;
   private String courseName;
   private int maxCapacity;
   private int enrolledStudents;
   
   // Constructor
   public Course(int courseId, String courseName, int maxCapacity, int enrolledStudents) {
      this.courseId = courseId;
      this.courseName = courseName;
      this.maxCapacity = maxCapacity;
      this.enrolledStudents = enrolledStudents;
   }
   
   // Gets the course Id
   public int getCourseId() {
      return courseId;
   }
   
   // Gets the course name
   public String getCourseName() {
      return courseName;
   }
   
   // Gets the max capacity
   public int getMaxCapacity() {
      return maxCapacity;
   }
   
   // Gets the enrolled students
   public int getEnrolledStudents() {
      return enrolledStudents;
   }
   
   // Sets the course Id
   public void setCourseId(int newCourseId) {
      courseId = newCourseId;
   }
   
   // Sets the course name
   public void setCourseName(String newCourseName) {
      courseName = newCourseName;
   }
   
   // Sets the max capacity
   public void setMaxCapacity(int newMaxCapacity) {
      maxCapacity = newMaxCapacity;
   }
   
   // Sets the enrolled students
   public void setEnrolledStudents(int newEnrolledStudents) {
      enrolledStudents = newEnrolledStudents;
   }
   
   // Checks to see if course is full
   public boolean isFull() {
      return enrolledStudents >= maxCapacity;
   }
   
   // Prints a string representation
   public String toString() {
      return "Course Id: " + courseId + "\n"
           + "Course Name: " + courseName + "\n"
           + "Max Capacity: " + maxCapacity + "\n"
           + "Enrolled Students: " + enrolledStudents;
   }
}