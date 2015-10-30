/**
 * 
 */
/**
 * @author ssk1391
 *
 */
//package javaapplication2;

import java.util.Random;
import java.util.Scanner;

public class ConnectFour

{

private static Scanner userinput;
private static Scanner scan2;
private static Scanner scan3;
private static Scanner userinput2;


  public static String[][] createPattern()

  {

         String[][] displaypattern = new String[13][15];

     

        for (int row =0;row<displaypattern.length;row++)

    {
    
       for (int col =0;col<displaypattern[row].length;col++)

      {

    
        if (col% 2 == 0)
        {
        	displaypattern[row][col] ="|";
        }else{
        	displaypattern[row][col] = " ";
        }
         if (row% 2 == 0)
        {
        	displaypattern[row][col] ="-";
        }
       
      }
       

  }

    return displaypattern;
  }

   

    public static void printPattern(String[][] displaypattern)

  {

    for (int row =0;row<displaypattern.length;row++)
    {
      for (int col=0;col<displaypattern[row].length;col++)
      {
        System.out.print(displaypattern[row][col]);
      }
      System.out.println();
    }

  }

   
    public static void insertXPattern(String[][] displaypattern,String name)

  {
    System.out.println(" It's your turn now !  "+name+" Please drop an X at column ranging from (0–6): ");
    userinput2 = new Scanner (System.in);
     
    int cursor = 2*userinput2.nextInt()+1;
    
    for (int row =11;row>=0;row--)
    {
      if (displaypattern[row][cursor] == " ")
      {
        displaypattern[row][cursor] = "X";
        break;

      }
       
    }
  }
   
    public static void insertOPattern(String[][] displaypattern,String name)
  {
    System.out.println( "It's your turn now ! "+name+" Please drop an O at column ranging from (0–6): ");
    userinput = new Scanner (System.in);
    int cursor = 2*userinput.nextInt()+1;
    for (int row =11;row>=0;row--)
    {
      if (displaypattern[row][cursor] == " ")
      {
        displaypattern[row][cursor] = "O";
        break;
      }
       
    }
  }
   
    public static String verifyWinner(String[][] displaypattern)
  {
  	int row=1;
   	while (row<displaypattern.length)
	{
		int col=3,count=1;
		while (col<displaypattern[row].length)
		{
			if ( displaypattern[row][col]!=" " && displaypattern[row][col-2]==displaypattern[row][col]) 
			{
				count++;
			}
			else
			{
				count=1;
			}
			if (count==4)
			{
				return displaypattern[row][col];
			}

			col+=2;

		}
		row+=2;

	}
	row=3;
   	int col=1,count=1;
   	while (col<displaypattern[row].length)
	{
		count=1;
		while (row<displaypattern.length)
		{
			if ( displaypattern[row][col]!=" " && displaypattern[row-2][col]==displaypattern[row][col]) 
			{
				count++;
			}
			else
			{
				count=1;
			}
			if (count==4)
			{
				return displaypattern[row][col];
			}

			row+=2;
		}
		row=3;
		col+=2;

	}
	
	row=9;col=11;
	while (row>=1)
	{
		int i=row;
		while (col>=1)
		{
			
			int j=col;
			count=1;
			while (i>=1 && j>=1)
			{
				if ( displaypattern[i][j]!=" " && displaypattern[i+2][j+2]==displaypattern[i][j] )
				{
					count++;
				}
				else
				{
					count=1;
				}
				if (count==4)
					return displaypattern[i][j];
				i-=2;
				j-=2;
			}
			col-=2;
		}
		row-=2;
	}
	row=displaypattern.length-4; col=3;
	while (row >=1 )
	{
		int i=row;
		while (col <displaypattern[row].length)
		{
			int j=col;
			count=1;
			while ( i >= 1 && j < displaypattern[row].length )
			{
				if ( displaypattern[i][j]!=" " && displaypattern[i+2][j-2]==displaypattern[i][j] )
					 count++;
				else
					count=1;
				if (count==4)
					return displaypattern[i][j];
				i-=2; 
				j+=2;
			}
			
			col+=2;
		}
		row-=2;
	}		
   return null;
   }
  
  
  public static void askPlayerNames(String player1,String player2){
      
      System.out.println("Please enter player1 name  ");
      scan3 = new Scanner (System.in);
      player1=scan3.next();
      while(player1.equals("")){
          System.out.println("name can not be empty, Please enter any name  ");
         player1=scan3.next(); 
      }
      
      System.out.println("Please enter player2 name  ");
      player2=scan3.next();
      
      while(player2.equals("")){
          System.out.println("name can not be empty, Please enter any name  ");
         player2=scan3.next(); 
      }
      
      
  }
   
   public static void main (String[] args)
  {
    String[][] displaypattern = createPattern();
    String player1;
    String player2;
    boolean isRandomOrder=false;
    boolean isPlayer1Turn=true;
    
      System.out.println("Player 1 Please enter your name");
      scan2 = new Scanner (System.in);
      player1=scan2.next();
      
      System.out.println("Player 2 Please enter your name");
      player2=scan2.next();
      
      System.out.println("Inputted value for player 1  is  "+player1+"   & Player 2  is "+player2 );
      
      System.out.println("Do you wish to randomize the playing order ? By default player 1 will start the game : Please enter Y/N  ");
      
      String choice=scan2.next();
      if("Y".equalsIgnoreCase(choice.trim())){
          isRandomOrder=true;
      }
      if(isRandomOrder){
      Random r=new Random();
      int a=r.nextInt(10);
      System.out.println(a);
      if(a%2!=0){
          isPlayer1Turn=false;
          System.out.println(player2+" will play first");
      }else{
         System.out.println(player1+" will play first");
      }
      }
      else{
          System.out.println("Choice is not Y so player 1 ("+player1+") will play ");
          
      }
 
      
    
    boolean loop = true;
    int count = 0;
    printPattern(displaypattern);
    while(loop)
    {
        
        if(isPlayer1Turn){
       if (count % 2 == 0){
           insertXPattern(displaypattern,player1);
       }
       else {
           insertOPattern(displaypattern,player2);
       }
        }else{
            
            if (count % 2 == 0){
           insertOPattern(displaypattern,player2);
       }
       else {
                insertXPattern(displaypattern,player1);
           
       }
            
        }
       count++;
       printPattern(displaypattern);
       if (verifyWinner(displaypattern) != null)
       {
          if (verifyWinner(displaypattern) == "X")
             System.out.println("Congratulations !!!  "+player1+" you have won this game .");
          else if (verifyWinner(displaypattern)== "O")
            System.out.println("Congratulations  !!!  "+player2+" you have won this game.");
         loop = false;
       }
	  // System.out.println(loop);
    }
  }
}
