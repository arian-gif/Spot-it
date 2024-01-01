// Import utilities and time
import java.util.*;

class Main {//start class

  //method used for printing something in a different colour
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  // Scanner is made as a global variables so it is accessible in every method
  public static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {//Start main

    System.out.println(ANSI_PURPLE + title() + ANSI_RESET);//prints the title in purple
    menu();//goes to menu method

  }//end main
  //this method is after user plays the game and doesn't want to replay
  public static void after(){//Start after method
    int nextMove = 0;
    //asks user if they want to go back to the main method and play something else or exit the program
      System.out.println("What would you like to do now:");
      System.out.println("1.Return to menu");
      System.out.println("2. Exit");  
    do{//this  will check if user inputs valid info
      System.out.println("Please enter with the number beside the option");
      nextMove = in.nextInt();
      if(nextMove != 1 && nextMove != 2){
        System.out.println("You have an error, please try again");//lets the user know they have a mistake
      }
    } while (nextMove != 1 && nextMove != 2);

    if (nextMove == 1) {
      menu();//if the user wants to go back to main menu, this sends them back
    } 
    else if (nextMove == 2) {
      goodBye();//if user wants to leave it will display the goodbye method and end the program
    }
  }//end after method

  public static void menu() {//start menu method
    //declare variables
    int menuChoice = 0;
    String replay,enter;
    
      // Prints the main menu: gives a list of options to the user
      System.out.printf("%20s%n","Main Menu");
      System.out.println("\n1: Practice");
      System.out.println("2: Play infinite Spot it!");
      System.out.println("3: Play Spot it Speed!");
      System.out.println("4: Play Timed Spot it!");
      System.out.println("5: Multiplayer");
      System.out.println("6: Exit");

    do {// do while loop checks if the inputted option is valid to let the user know
      System.out.print("Input the number corresponding to what you want to do: ");
      menuChoice = in.nextInt();

      if (menuChoice < 1 || menuChoice > 6) {//if user inputs invalid values, it will let the user know
        System.out.println("Oops you have an error, please try again!");
      }
    } while (menuChoice < 1 || menuChoice > 6);

    in.nextLine();//this is neccassary to clear the buffer
    //if user wants single player mode
    if (menuChoice == 1) {// start if
      System.out.println(ANSI_CYAN+singlePlayerInstruction()+ANSI_RESET);//prints instructions

      do {//this do loop will allow the user to replay if they chose, its used for all modes except infinate
        System.out.println("Hit enter when you want to start:");//the user will have to hit enter to begin, this lets the user get ready
        do{
          enter = in.nextLine(); 
        }while(!enter.equals(""));
        delay();
        singlePlayer("single");

        do{//checks if user inputs the right options
          System.out.println("Would you like to play again? Reply with yes or no");//asks user if they want to replay
          replay = in.nextLine();
          replay = replay.toLowerCase();//To make sure the cases all match, the entire word is lowercased and then checked to see if it matches
          if (!replay.equals("yes")&&!replay.equals("no")){
            System.out.println("You have a mistake");//lets the user know if they inputted an invalid option
          }
        }while(!replay.equals("yes")&&!replay.equals("no"));
        if(replay.equals("yes")){
          System.out.println("Restarting................");
        }
      } while (replay.equals("yes"));//will restart game if replay is yes
      //after the user is done playing and  does not want to replay this method will run
      after();
    }//end if

    //if user wants infinite
    //Note this the only game playing mode that doesn't have a replay option, this is because the infinite mode keeps playing, if user leaves they probably don't want to play again
    else if (menuChoice == 2) {// start if
      System.out.println(ANSI_CYAN+infiniteInstruction()+ANSI_RESET);
        System.out.println("Hit enter when you want to start:");//the user will have to hit enter to begin, this lets the user get ready
        do{
          enter = in.nextLine(); 
        }while(!enter.equals(""));
        delay();
        
        infinite();
      //after the user is done playing and  does not want to replay this method will run
        after();
    } // end if

    //this mode sees how fast you can get 5 correct  
    else if (menuChoice == 3) {// start if
      System.out.println(ANSI_CYAN+timedInstructions()+ANSI_RESET);
      do{
        stopwatch();
        do{//checks if user inputs the right options
          System.out.println("Would you like to play again? Reply with yes or no");//asks user if they want to replay
          replay = in.nextLine();
          replay = replay.toLowerCase();//To make sure the cases all match, the entire word is lowercased and then checked to see if it matches
          if (!replay.equals("yes")&&!replay.equals("no")){
            System.out.println("You have a mistake");//lets the user know if they inputted an invalid option
          }
        }while(!replay.equals("yes")&&!replay.equals("no"));
        if(replay.equals("yes")){
          System.out.println("Restarting................");
        }
      } while (replay.equals("yes"));
      //after the user is done playing and  does not want to replay this method will run
      after();

    } // end if

    //this mode sees if user can finish in a given time  
    else if (menuChoice == 4) {// start if
      do {
        timer();
        do{//checks if user inputs the right options
          System.out.println("Would you like to play again? Reply with yes or no");//asks user if they want to replay
          replay = in.nextLine();
          replay = replay.toLowerCase();//To make sure the cases all match, the entire word is lowercased and then checked to see if it matches
          if (!replay.equals("yes")&&!replay.equals("no")){
            System.out.println("You have a mistake");//lets the user know if they inputted an invalid option
          }
        }while(!replay.equals("yes")&&!replay.equals("no"));
        if(replay.equals("yes")){
          System.out.println("Restarting................");
        }
      } while (replay.equals("yes"));
      //after the user is done playing and  does not want to replay this method will run
      after();
    } // end if

    //multiplayer mode
    else if (menuChoice == 5) {// start if
      System.out.println(ANSI_CYAN+multiInstructions()+ANSI_RESET);
      do {
        multiPlayer();
        do{//checks if user inputs the right options
          System.out.println("Would you like to play again? Reply with yes or no");//asks user if they want to replay
          replay = in.nextLine();
          replay = replay.toLowerCase();//To make sure the cases all match, the entire word is lowercased and then checked to see if it matches
          if (!replay.equals("yes")&&!replay.equals("no")){
            System.out.println("You have a mistake");//lets the user know if they inputted an invalid option
          }
        }while(!replay.equals("yes")&&!replay.equals("no"));
        if(replay.equals("yes")){
          System.out.println("Restarting................");
        }
      } while (replay.equals("yes"));
      //after the user is done playing and  does not want to replay this method will run
      after();
    } // end if

    //if user wants to leave
    else if (menuChoice == 6) {// start if
      goodBye();
    } // end if
  }//end menu 
  
  // method for single player,the user will play for 5 rounds and the program will end, that's the rule to this spot it game. this is mostly just a practice mode, so the user can get better at spot it 
  //there is a parameter inplace in this method because other game modes need it as well, this will help distinguish them
  public static void singlePlayer(String mode) {//start single player method
    //declare variables
    int score = 0,count =0,card1, card2, element1, element2;
    String guess = " ",userGuess;

    //here is a deck of animals, each card has exactly 4 elements on it and will match only once
    //this deck is only put in this method because most of the the other modes use this method and access the deck through this method, instead of writing it out in each method
    String[][] deck = { // begins deck
        { "donkey", "cat", "hippo", "elephant" },
        { "cat", "penguin", "lion", "spider" },
        { "hippo", "penguin", "frog", "scorpion" },
        { "elephant", "penguin", "lizard", "cow" },
        { "donkey", "penguin", "baboon", "tiger" },
        { "cat", "baboon", "frog", "cow" },
        { "hippo", "baboon", "lizard", "spider" },
        { "elephant", "baboon", "lion", "scorpion" },
        { "donkey", "lion", "frog", "lizard" },
        { "cat", "tiger", "lizard", "scorpion" },
        { "hippo", "tiger", "lion", "cow" },
        { "elephant", "tiger", "frog", "spider" },
        { "donkey", "spider", "cow", "scorpion" } // last card in deck
    };// end deck
    //when user gets 5 correct the program will stop
    while (count < 5) {//Start while loop

      card1 = (int) (Math.random() * 13);//used to get a random from the deck
      card2 = (int) (Math.random() * 13);//used to get a random from the deck
      // While loop is used to make sure both cards don't match
      while (card1 == card2) {
        card1 = (int) (Math.random() * 13);
        card2 = (int) (Math.random() * 13);
      }
      //will get a random number, which is the index of element in a coloumn, this code will help rearrange the order of the cards
      element1 = (int) (Math.random() * 4);
      element2 = (int) (Math.random() * 4);
    //this loop isn't mandatory but it will make the game harder, it would rearrange the order in a more confusing way if the value that they are being changed by isn't the same
      while(element1==element2){
        element1 = (int) (Math.random() * 4);
        element2 = (int) (Math.random() * 4);
      }
      System.out.println();//used to print a new line, making the game cleaner purposes

      // row--> value is a card1's value because it will give coloumn is the image given on the card
      for (int col = element1; col < deck[card1].length; col++) {//print the value of element 1, and after that
        System.out.print(deck[card1][col] + " "); //Note that print and not println is used, this will display this for loop and the next one in the same line because they are apart of the same card 

      }
      //integer i is used to print every element in the array before element1 but displays it on the screen after
      for (int i = 0; i < element1; i++) {// rearranges the order
        System.out.print(deck[card1][i] + " ");
      }
      System.out.println();
      
      // row--> value is a card2's value because it will give coloumn is the image given on the card
      for (int col = element2; col < deck[card2].length; col++) {
        System.out.print(deck[card2][col] + " ");
      }
      for (int i = 0; i < element2; i++) {// rearranges the order
        System.out.print(deck[card2][i] + " ");
      }
      System.out.println();

      // prompts the user to input their guess
      System.out.println("Now Spot it:");
      userGuess = in.nextLine();
      // turns the guess lowercase to make sure they match cases
      userGuess.toLowerCase();
      
      // runs through the two sets of cards
      for (int firstCard = 0; firstCard < deck[card1].length; firstCard++) {//uses elements on the first card
        for (int secondCard = 0; secondCard < deck[card2].length; secondCard++) {//goes through second card 
          if (deck[card1][firstCard] == deck[card2][secondCard]) {// checks for the matching element between the cards
            guess = deck[card1][firstCard];// the match becomes the guess
          }
        }
      }
      // checks if the user's guess is the same as the saved answer
      if (userGuess.equals(guess)) {//if user gets it correct
        System.out.println(ANSI_GREEN + "Congratulations you got it!!" + ANSI_RESET);
        score++;//increases their score
      } 
      else {//if user gets it wrong
        System.out.println(ANSI_RED + "It's ok, correct answer was " + guess + ANSI_RESET);
        }
      
       //if the mode that given is the timer mode, it's formating is a bit different
       if (mode.equals("timer")){
         if(score ==5){
           count+=5;//timer mode will run until the user gets 5 correct and then break 
         }
       }
        else{//if mode isn't timer then the count will increase and the user will play for 5 rounds
          count++;
        }
    }//end while loop
    //if mode is single, it will display the persons score out of 5
    if(mode.equals("single")){
      System.out.println(ANSI_GREEN +"\nCongrulations you got "+ score+"/5"+ ANSI_RESET);
    }
  }//end singlePlayer method

  // The INFINITE game mode, in this game mode after 5 rounds, they will have an option to leave, if they don't want to leave, they just have to type yes, if they do want to keep playing, just type yes. if they don't want to play anymore just type no. 
  public static void infinite() {//Start infinate method
    String keepPlaying;

    do {//this do loop will check if user wants to keep playing
        singlePlayer("infinite");
      
        do{// while loop is used to make sure user inputs given option
          System.out.println("\ndo you want to keep playing, reply with yes or no");
          keepPlaying = in.nextLine();
          keepPlaying= keepPlaying.toLowerCase();
          if (!keepPlaying.equals("no") && !keepPlaying.equals("yes")){
            System.out.println("You have an error, please try again");//lets user know if they have an error
          }
      }while (!keepPlaying.equals("no") && !keepPlaying.equals("yes")); 
    } while (keepPlaying.equals("yes"));//keeps running if user inputs yes

  }

  // a method that times the user to see how fast they are
  public static double stopwatch() {
    String enter;
    System.out.println("Hit enter when you want to start:");//the user will have to hit enter to begin, this lets the user get ready
      do{
        enter = in.nextLine(); 
      }while(!enter.equals(""));
    
    delay();
    long timer = System.currentTimeMillis();// takes the time when the user starts
    singlePlayer("timer");
    
    long endTime = System.currentTimeMillis();// takes the time when the user finishes
    
    // subtracts the start time from the end time and converts it into seconds
    double userTime = (double) (endTime - timer) / 1000;
    System.out.println(ANSI_GREEN+"\nCongrulations you finished in " + userTime + " s!!!"+ANSI_RESET);

    return userTime;//returns time, this is used for meltiplyplayer and timer 
  }
  //in this mode the user has to get 5 correct in a given amount of time. The time is based on different levels, in easy you have a minute to finish, medium you have 45 secs and hard is only 30 secs
  public static void timer() {
    String mode = "";

    do{//makes sure valid input is given
      System.out.println("\nEasy");
      System.out.println("Medium");
      System.out.println("Hard");
      System.out.println("Select one of the following modes:");
      mode = in.nextLine();//asks user which mode they want to play in
      mode = mode.toLowerCase();

      if (!mode.equals("easy")&&!mode.equals("medium")&&!mode.equals("hard")){
        System.out.println("You have an error");//displays an error if user doesn't input correct data
        }
      }while(!mode.equals("easy")&&!mode.equals("medium")&&!mode.equals("hard"));

    if(mode.equals("easy")){//if user wants easy mode
      easy();
    }
    else if(mode.equals("medium")){//if user wants medium mode
      medium();
    }
    else if(mode.equals("hard")){//if user wants hard mode
      hard();
    }

  }
  public static void easy(){//start easy method
    System.out.println(ANSI_CYAN+timerInstructions("easy")+ANSI_RESET);//displays instructions
  
    double timer = stopwatch();//goes to stopwatch method and sees their time in spot it
    int timeLeft = 45-((int)timer);//timeleft over is the time left after user is done, this will only be displayed if user wins 
    int timeOver =(int)(timer)-45;//displays how much time went over when user is done, will only display if user loses

    if (timer<=45){
      System.out.println(ANSI_GREEN+"Congrulations you won!!You had "+timeLeft +"s left\n"+ANSI_RESET);//if user finishes in 45 secs
    }
    else if(timer>45){
      System.out.println(ANSI_RED+"Its ok try again next time. You went "+timeOver +"s over\n"+ANSI_RESET);//if user exceeds the time limit
    }
  }//end easy method

  public static void medium(){//Start medium method
    
    System.out.println(ANSI_CYAN+timerInstructions("medium")+ANSI_RESET);//prints instructions
    
    double timer = stopwatch();//uses the stopwatch method and sees their time in spot it
    int timeLeft = 30-((int)timer);//timeleft over is the time left after user is done, this will only be displayed if user wins
    int timeOver = ((int)timer) -30;//displays how much time went over when user is done, will only display if user loses

    if(timer<=30){
      System.out.println(ANSI_GREEN+"Congrulations you won!! You had "+timeLeft +"s left\n"+ANSI_RESET);//if user finishes in 30 secs
    }
    else if(timer>30){
      System.out.println(ANSI_RED+ "Its ok try again next time. You went "+timeOver +"s over\n"+ANSI_RESET);//if user exceeds the time limit
    }
  }//end medium method
  public static void hard(){//start hard method
    System.out.println(ANSI_CYAN+timerInstructions("hard")+ANSI_RESET);//prints instructions
   
    double timer = stopwatch();//goes to stopwatch method and sees their time in spot it
    int timeLeft = 20-((int)timer);//timeleft over is the time left after user is done, this will only be displayed if user wins
    int timeOver = ((int)timer) -20;//displays how much time went over when user is done, will only display if user loses
    
    if(timer <=20){
      System.out.println(ANSI_GREEN+"Congrulations you won!! You had "+timeLeft +"s left\n"+ANSI_RESET);//if user finishes in 20 secs
    }
    else if(timer >20){
      System.out.println(ANSI_RED+"Its ok try again next time. You went "+timeOver +"s over\n"+ANSI_RESET);//if user exceeds the time limit
    }
  }

  // Method for multiplayer, this will take 2 players and compare there times, if one player gets 5 correct faster than the other, they win the round, whoever gets 5 rounds, wins
  public static void multiPlayer() {//start multiplayer method
    //declare variables
    int round = 1,player1Score = 0,player2Score =0;
    String name1, name2;

    //asks each of the players for their name
    System.out.println("Player 1 please enter your name:");
    name1 = in.nextLine();
    System.out.println("Player 2 please enter your name:");
    name2 = in.nextLine();

    //while loop will run until 
    while(player1Score <5&& player2Score <5){
      System.out.println("\nRound "+round+ " begin");//displays the round that the players are playing in
      System.out.println("It is "+name1+"'s turn\n");//player 1's turn
    

      double player1Time = stopwatch();//player 1's time is recorded

      System.out.println ("it is "+name2+"'s turn");//player 2's turn
    
      double player2Time = stopwatch();//player 2's time

      if (player1Time < player2Time){
        System.out.println(ANSI_GREEN+"Congrulations "+  name1+" you won by " +(int)(player2Time-player1Time)+ " s"+ANSI_RESET);//if player 1 has a lower time, it displays player 1 winning message 
        player1Score++;//increases player 1's score if they win the round
          }
      else if(player2Time<player1Time){//if player 2 completes the task faster they will win the round
        System.out.println(ANSI_GREEN+"Congrulations"+  name2+ " you won by " +  (int)(player1Time-player2Time)+"s"+ANSI_RESET);
        player2Score++;//increases player 2 score if they win the round
          }
      else if(player1Time==player2Time){//if both players complete the task at the same time, its a tie and neither player gets a point
        System.out.println(ANSI_YELLOW+"Looks like we have a tie!!!"+ANSI_RESET);
        }
        
      System.out.println("Score:");//displays the score
      //if the has one point, displays only point and not points, these 2 if statement are only for grammar purposes and nothing more
      if (player1Score==1){
        System.out.println(name1+": "+ player1Score+" point");
      }
      else{
        System.out.println(name1+": "+ player1Score+" points"); 
      }
      //This if statement is once again used only for grammar purposes
      if(player2Score==1){
        System.out.println(name2+": "+ player2Score+" point");
      }
      else{
        System.out.println(name2+": "+ player2Score+" points");
      }
       round++;//increases round when the for loop is over
      }
      round =round-1;//since the loop ends when one player hits 5, round is still incrimented 1 more time than we want, so must subtract 1 to get correct value
      if(player1Score>player2Score){
        System.out.println(ANSI_GREEN+"\nCongrulations "+  name1+" you won in "+round+" rounds!!! "+ANSI_RESET);//if player 1 wins 5 rounds first
        
      }
      else if(player2Score>player1Score){
        System.out.println(ANSI_GREEN+"\nCongrulations "+  name2+ " you won in "+round+" rounds!!!"+ANSI_RESET);//if player 2 wins 5 rounds first
      }
  }//end multiplayer method

  //this method will print on your marks get set go but with a delay so it looks more like a game
   public static void delay(){
     try {
      System.out.println("On your marks");
      Thread.sleep(1000); // waits one second before printing next line
      System.out.println("Get Set");
      Thread.sleep(1000);// waits one second again before printing next line
      System.out.println("Go!");
    } 
     catch (Exception e) {
    }
  }
 // The following methods are used for storing the instructions to each mode 
  public static String singlePlayerInstruction(){
    return "\nInstructions:\nPlay against yourself for 5 rounds to practice, see how many you can get correct and how good you are able to Spot it!!";//single player instructions
    }
  public static String infiniteInstruction(){
    return "\nInstructions:\nPlay against your self for as as many times as you want.\nOnce you play for 5 rounds you will have the option to leave, if you wish to end the game type no into the keep playing option";//infinite mode instructions

    }
  public static String timedInstructions(){
    return "\nInstructions:\nTest your self under pressure by timing your self, the timer will run untill you get 5 correct.";//timer instructions
    }
  public static String timerInstructions(String type){//timer instruction with a parameter of mode
    if (type.equals("easy")){//prints easy mode instructions
      return "\nInstructions:\nIn this mode you will have 45 seconds to get 5 correct! If you finish in 45 secs, you win!!";
    }
    else if(type.equals("medium")){//prints medium mode instructions
      return "\nInstructions:\nIn this mode you will have 30 seconds to get 5 correct!If you finish in 30 secs, you win!!";
    }
    else if(type.equals("hard")){//prints hard mode instructions
      return "\nInstructions:\nIn this mode you will have just 20 seconds to get 5 correct!If you finish in 20 secs, you win!!";
    }
    else {
      return"";//diffault statement because java needs something that it can always diffault to
    }
  }
  public static String multiInstructions(){
    return "\nInstructions:\nPlay against a friend the faster one to get 5 cards correct, wins that round, whoever wins 5 rounds first wins the game";//multiplayer instructions
  } 

  //Method to display title 
   public static String title(){
    return  "  _____              __     _ __  __\n"+
" / ___/ ____  ____  / /_   (_) /_/ /\n"+                                                            
" \\__ \\ / __ \\/ __ \\/ __/  / / __/ /\n"+ 
" ___/ / /_/ / /_/ / /_   / / /_/_/\n"+  
"/____/ .___/\\____/\\__/  /_/\\__(_)\n"+
 "    /_/\n";       
  } 
//prints goodbye message when game is over
  public static void goodBye(){ //Start goodbye method
          System.out.println("\n***************************************");
          System.out.println("****            Thanks             ****");
          System.out.println("****          For Playing          ****");
          System.out.println("***************************************"); 
  }//End goodbye method
}//end class