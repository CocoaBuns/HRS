package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RoomVisualiserBoundary extends Boundary
{
	private Scanner scan;

	protected int scheduleMenu()
	{
		printMainTitle("Schedule Overview");
		String[] menuList =
				{
						"Display Current Schedule (Today)",
						"Display Future Schedule",
				};
		printMenuList(menuList, "Back to Main Application");
		System.out.println();
		return getInput(0, 2);
	}

	protected LocalDate selectDate()
	{
		scan = new Scanner(System.in);
		LocalDate startDate = null;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String tempString;

		System.out.println("Please type the start date(dd/mm/yyyy):");
		while (startDate == null)
		{
			try
			{
				tempString = scan.next();
				startDate = LocalDate.parse(tempString, dateFormat);
				if (startDate.isBefore(LocalDate.now()))
				{
					System.out.println("Please key in a date after today");
					startDate = null;
				}
			} catch (Exception e)
			{
				//e.printStackTrace();
				System.out.println("Please use the format dd/mm/yyyy");
			}
		}
		return startDate;
	}


	@Override
	protected void printMenu()
	{
	}
}
