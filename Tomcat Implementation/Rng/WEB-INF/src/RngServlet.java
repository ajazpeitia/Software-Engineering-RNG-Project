//package mypkg;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*; 
public class RngServlet extends HttpServlet {
   

   final static int FAIL_CASE = 250;
   final static int UPPER_BOUND = 1000000;
   final static int TESTS_TO_PASS = 10;

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Random Number</title></head>");
         out.println("<body>");
	 int rndNumber = generateRandomNumber();
         out.println("<h1>" + rndNumber +"</h1>");  // says Hello
         out.println("</body>");
         out.println("</html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }

   public int generateRandomNumber() {

    Random rand = new Random();

    int val = 0;
    int duplicateCount = 0;
    int currentTest = 0;
    int successCount = 0;

    // Repeat this process 10 times
    while(currentTest < TESTS_TO_PASS) {

        //Create a new hashset for the current test
        HashSet<Integer> uniqueValues = new HashSet<Integer>();

        //Generate 1000 values and track the count of dupe values
        for(int i = 0; i < 1000; ++i ) {
            val = rand.nextInt(UPPER_BOUND) + 1;
            //If hashset already counts the value, increment the duplicateCount
            if(!uniqueValues.add(val)) {
                ++duplicateCount;
            }
        }
       
        if(duplicateCount < 250) {

            //Reset the dupe count
            duplicateCount = 0;

            //Increment the success count
            ++successCount;
        }
        else {

        }

        ++currentTest;
    }

    return val;
}
}
