import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class TeamStanding 
{

	static ArrayList<Team> teams = new ArrayList<Team>();
	public static void main(String[] args) 
	{
		Scanner scan = null;
		try 
		{
			scan = new Scanner(new File("competitionData.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Cannot Find Input File");
		}
		
		int numCases = scan.nextInt();
		
		for(int i = 0; i < numCases; i ++)
		{
			String teamA = scan.next();
			int scoreA = scan.nextInt();
			String teamB = scan.next();
			int scoreB = scan.nextInt();
			
			Team tempA = null;
			Team tempB = null;
			
			if(teams.isEmpty())
			{
				tempA = new Team(teamA);
				tempB = new Team(teamB);
				teams.add(tempA);
				teams.add(tempB);				
			}
			else
			{		
				tempA = null;
				tempB = null;
				for(Team team : teams)
				{
					if(team.getName().equals(teamA))
						tempA = team;
					if(team.getName().equals(teamB))
						tempB = team;
				}
				
				if(tempA == null)
				{
					tempA = new Team(teamA);
					teams.add(tempA);
				}
				if(tempB == null)
				{
					tempB = new Team(teamB);
					teams.add(tempB);
				}							
			}
			if(scoreA > scoreB)
				teams.get(teams.indexOf(tempA)).addDefeated(teamB);
			else
				teams.get(teams.indexOf(tempB)).addDefeated(teamA);	
			
				
			
		}
		/*//print the list of defeated
		for(Team team : teams)
		{
				System.out.print("\n" + team.getName() + " - ");
				ArrayList<String> defeated = team.getDefeated();
				if(defeated.isEmpty())
					System.out.print("none");
				else
					for(String def : defeated)
						System.out.print(def + ", ");
				
		}*/
		
		numCases = scan.nextInt();
		
		for(int i = 0; i < numCases; i ++)
		{
			String teamA = scan.next();
			String teamB = scan.next();
			
			int indexA = getIndex(teamA);
			int indexB = getIndex(teamB);
			
			//defeated directly
			if(teams.get(indexA).getDefeated().contains(teamB))
				System.out.println(teamA + " defeated " + teamB);
			else
				if(teams.get(indexB).getDefeated().contains(teamA))
					System.out.println(teamB + " defeated " + teamA);
				else
				{
					//defeated indirectly
					boolean indirA = checkIndirect(indexA, indexB);
					boolean indirB = checkIndirect(indexB, indexA);
					if(indirA && indirB)
						System.out.println(teamA + " and " + teamB + " defeated each other indirectly");
					else
						if(indirA)
							System.out.println(teamA + " defeated " + teamB + " indirectly");
						else
							if(indirB)
								System.out.println(teamB + " defeated " + teamA + " indirectly");
							else
								System.out.println(teamA + " and " + teamB + " are not comparable");
				}				
		}
	}
	
	public static boolean checkIndirect(int indexA, int indexB)
	{
		Team teamA = teams.get(indexA);
		Team teamB = teams.get(indexB);
		if(teamA.getDefeated().contains(teamB.getName()))
			return true;
		else
			for(String def : teamA.getDefeated())
			{
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(indexA);
				if(checkIndirect(getIndex(def), indexB, arr))
					return true;
			}
		return false;
	}
	
	public static boolean checkIndirect(int indexA, int indexB, ArrayList<Integer> arr)
	{
		Team teamA = teams.get(indexA);
		Team teamB = teams.get(indexB);
		if(teamA.getDefeated().contains(teamB.getName()))
			return true;
		else
			for(String def : teamA.getDefeated())
				if(!arr.contains(getIndex(def)))
				{
					arr.add(getIndex(def));
					if(checkIndirect(getIndex(def), indexB, arr))
						return true;
				}
		return false;
	}
	
	
	public static int getIndex(String name)
	{
		for(Team team : teams)
			if(team.getName().equals(name))
				return teams.indexOf(team);
		return -1;
	}
}

class Team
{
	private ArrayList<String> defeated = new ArrayList<String>();
	private String name;

	public Team(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addDefeated(String defeated)
	{
		this.defeated.add(defeated);
	}
	
	public ArrayList<String> getDefeated()
	{
		return defeated;
	}
}
