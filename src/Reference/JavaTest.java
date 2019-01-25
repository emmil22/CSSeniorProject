package Reference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import IA.User;

public class JavaTest {

    public static void main(String[] args) throws IOException
    {
        String greeting = "Hello";
        String username;
        String password;

        // Used to hold the instance of a user who successfully logged in
        User loggedInUser = null;

        // Create an empty list to hold users
        List<User> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new User("user1","password1"));
        listOfUsers.add(new User("user2","password2"));
        listOfUsers.add(new User("user3","password3"));

        // Get user input
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        System.out.println("*** Welcome to the program ***\n");
        System.out.println(greeting);

        System.out.println("Please type your username :");
        username = br.readLine();   
        System.out.println("Please type your password :");
        password = br.readLine();

        // Iterate through list of users to see if we have a match
        for (User user : listOfUsers)
        {
            if (user.getuName().equals(username))
            {
                if (user.getPassword().equals(password))
                {
                    loggedInUser = user;

                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }

        // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null)
        {
            System.out.println("User successfully logged in: "+loggedInUser.getuName());
        }
        else
        {
            System.out.println("Invalid username/password combination");
        }
    }
}