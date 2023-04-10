# Welcome to CalTrack! A fitness application that allows users to calculate their BMI and track their calorie intake.

Table of Contents
=================

1. [Product Requirements](#product-requirements)
2. [How To Use Application](#how-to-use-application)
3. [Description](#description)
4. [Manual and Automated Tests](#manual-and-automated-tests) 
5. [Current Features and Work in Progress](#current-features-and-work-in-progress)
6. [Status Report](#Status Report)

## Product Requirements
 - User Authentication: The login screen must have a mechanism to authenticate users' identy to ensure only authorized users can access the application. After a successful login, a welcome screen will appear with additional content.
 - User Feedback: If the user fails their login attempt, the login screen should provide feedback to the user on the status of their login attempt. 
 - User Experience: The login screen should be designed to provide a positive user experience with clear and intuitive interface elements that make the login process simple and efficient. 
 - Welcome Page: Upon a successful login, a new window will pop up that welcomes the user to the welcome page. The welcome page should have clear navigation that allows users to quickly and easily access the app's main features. 
 - Welcome Page Visual Design: The welcome page should have a visually appealing design that reflects the app's aesthetic.
 - BMI Calculator: The "BMI Calculator" button should lead to a screen where users can input their height and weight to calculate their body mass index (BMI).
 - Calculation Method: The BMI Calculator should use a widely accepted formula to calculate the user's BMI. The calculator should allow users to input their height and weight. The input fields should be clearly labeled and easy to use.
 - BMI Calculator Additional Information: The BMI Calculator should provide additional information to the user about their health status and potential health risks. It should also include a disclaimer stating that this calculator is used for educational purposes only and is not an accurate representation of the user's health. 
 - Calorie Tracker: The "Calorie Tracker" button should lead to a screen where users can input their meals and track their daily calorie intake.
 - Calorie Tracker User Input: The calorie tracker should allow users to input information about the foods they eat and the quantity of each item. 
 - Calorie Tracker Table View: The calorie tracker should display the user's food and calorie data in a table view that shouws the name and calorie count for each item. The table should be easy to read and navigate and allow the users to sort the data as necessary.
 - Calorie Tracker Add and Remove Functionality: The calorie tracker should provide an "Add" and "Remove" button that allows users to control their food and calorie information from the table. This functionality should also update the total calorie count displayed on the screen.
 - Calorie Tracker Error Handling: The calorie tracker should validate all user input and provide clear error messages if there are any issues with the input. For example, if the user inputs an invalid calorie count, the app should display an error message explaining the issue and prompt the user to correct it.
 - Logout Session Termination: The log out functionality should terminate the user's session. Upon a successful logout, users are taken back to the login screen where they are required to input their credentials.
 
 
 ## How To Use Application
  1. Clone the GitHub Repository. (https://github.com/calvinlieu/CalTrack.git).
  2. If you do not have Eclipse IDE installed, you can download Eclipse from the official website at https://www.eclipse.org/downloads/.
  3. Once Eclipse is installed, import the project via File > Import > General > Existing Projects into Workspace > Copy projects into workspace > Finish.
  4. Check for missing dependencies by adding any required libraries to the project's classpath.
  5. Run the application via Eclipse's Package Explorer view by selecting "Run As > Java Application > Main - (default package)". This will launch the application in a new window.
  
  ## Description 
  - Once the application is open, users are greeted with a Login page. In order to login, users must enter a Username of "Demo" and a Password of "password".
  
    ![image](https://cdn.discordapp.com/attachments/967128927065735218/1094817404464402472/image.png)
    
  - Upon a successful login, a new window will open with a welcome page as well as the main features of the GUI. From here, users are given the option to either select on the BMI Calculator or the Calorie Tracker.
  
    ![image](https://cdn.discordapp.com/attachments/967128927065735218/1094818362464419941/image.png)
    
  - If the user selects on the BMI Calculator, a new window will open where they are greeted with a place where they can input their height and weight and in return, will calculate their BMI and post it in the results label. 
  
    ![image](https://cdn.discordapp.com/attachments/967128927065735218/1094819073738682529/image.png)
    
  - If the user selects on the Calorie Tracker, a new window will open where they are able to input the food that they have ate along with the amount of calories. From here, users are able to see the total amount of calories at the bottom of the application.
  
    ![image](https://cdn.discordapp.com/attachments/967128927065735218/1094819906127679609/image.png)
    
  - Once users are finished with the application, they are able to log out by navigating to the menu bar at the top > file > log out.
  
    ![image](https://cdn.discordapp.com/attachments/967128927065735218/1094820300169953422/image.png)
  
  
  ## Manual and Automated Tests
  
CalTrack includes comprehensive error validations and unit tests written in JUnit. The tests cover a variety of scenarios and ensure the proper functioning of the code.

The error validations include checks for invalid input values, such as non-numeric inputs, and ensure that appropriate error messages are displayed to the user. Additionally, the tests cover edge cases, such as when the input values are at the minimum or maximum allowed values.

The unit tests cover all major functions of the code, including input validation, data processing, and output display. Each test is designed to test a specific feature or scenario, ensuring that the code functions correctly in all possible situations.

To run the tests, simply navigate to the test directory and run any Test.java file. All tests should pass without error, indicating that the code is functioning correctly.

Overall, these error validations and unit tests provide peace of mind that the code is functioning as intended and will help ensure that future updates or changes do not introduce unintended bugs or errors.
   
  ## Current Features and Work in Progress
  
Currently, CalTrack offers 2 features within the application. Later on, I plan to implement the ability to import and export local data files in order to save your data.

  ## Status Report

As of version 1.0.0, everything is currently fully functional and online. However, there is a major bug with running CalTrack as a runnable JAR file and is currently being looked into. So as of right now, I am asking users to run the application using the steps listed in the "How To Use Application" section.


  

