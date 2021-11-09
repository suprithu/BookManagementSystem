package com.cruds.book;

import java.util.InputMismatchException;
//import java.util.InputMismatchException;
import java.util.Scanner;

import com.cruds.db.BookDAO;
import com.cruds.exception.BookException;

public class TestBook 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		BookDAO dao = new BookDAO();
		
		String choice = "";
		
		//boolean test = false;
		
		
		do
		{
			System.out.println("1: Add Book");
			System.out.println("2. Search Book Based on Book Title");
			System.out.println("3. Search Book Based on Book Category");
			System.out.println("4. Search Book Based on Author ");
			System.out.println("5. Lis All Books ");
			System.out.println("6. ");
			System.out.println("9. exit");
			
			choice = sc.nextLine();
			
			switch(choice)
			{
			case "1":
				
				int isbn = 0;
			
							System.out.println("Please Enter the Book ISBN");
							GetISBN();
							isbn = sc.nextInt();
							sc.nextLine();
						
						System.out.println("Please Enter Book Title");
						String title = sc.nextLine();
						
						System.out.println("Please Enter the Category of Book");
						String category = sc.nextLine();
						
						System.out.println("Please Enter Total number of Available books");
						GetBook();
						//int no_of_books = sc.nextInt();
						sc.nextLine();
		
						int no_of_books = 0;
						//int isbn = 0;
						Book book = new Book(isbn, title, category, no_of_books);
						
						System.out.println("Please Enter the Author Name");
						String authorname = sc.nextLine();
						
						System.out.println("Please Enter the Author EmailId");
						String authormailid = sc.nextLine();
						
						Author author = new Author(authorname, authormailid);
						
						
						
						book.setAuthor(author);
						dao.create(book);
					
						System.out.println("Book Entered Successfully");
						
				 
				break;
				
			case "2" :
				System.out.println("Please Enter the Title of the Book to search");
				String searchTitle = sc.nextLine();
		
				dao.search(searchTitle);
		
				break;
				
			case "3" :
				System.out.println("Please Enter the Category to Search Books ");
				String searchCategory = sc.nextLine();
				
				dao.searchCat(searchCategory);
				
				break;
				
			case "4":
				System.out.println("Please Enter the Author Name to Search Books ");
				String searchAuthor = sc.nextLine();
				
				dao.searchAuth(searchAuthor);
				
				break;
				
			case "5":
				String listAllBooks = null;
				dao.list(listAllBooks);
				
				break;
				
			case "9" :
				System.out.println("Exiting Application");
				break;
					
					
				
			default:
				System.out.println("Invalid" + "\n");
				
				
		}
		}while(!choice.equals("9"));
		
		sc.close();
	}




private static int GetBook()
{
	//@SuppressWarnings("resource")
	Scanner sc1 = new Scanner(System.in);
	while(true)
	{
		try
		{
			return sc1.nextInt();
		}
		catch (InputMismatchException e)
		{
			//sc1.nextLine();
			System.out.println("Invalid Type!! Please Enter Again");
		}
	}
	
}


private static int GetISBN()
{
	//@SuppressWarnings("resource")
	Scanner sc1 = new Scanner(System.in);
	while(true)
	{
		try
		{
			return sc1.nextInt();
		}
		catch (InputMismatchException e)
		{
			sc1.next();
			System.out.println("Invalid Type!! Please Enter Again ");
		}
	}
	
}
}

