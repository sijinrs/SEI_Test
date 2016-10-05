import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeDup {
	
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
	
   
	
	public static void main(String [] args) {
		
		
		DeDup deDup = new DeDup();
		
		int [ ]  distinctIntegers = deDup.retrieveDistinctIntegers ( );
		
		System.out.println("ResultFromArrayMethod size =" + distinctIntegers.length);
		
		for ( int c : distinctIntegers  ){
			
			System.out.println(c);
		}
		
		distinctIntegers  = deDup.retrieveDistinctIntegersFromSortedArray ( );
		
		System.out.println("ResultFromArrayMethodAfterSorting size == " + distinctIntegers.length);
		
		for ( int c : distinctIntegers  ){
			
			System.out.println(c);
		}
		
		
		distinctIntegers  = deDup.retrieveDistinctIntegersUsingHashSet ( );
		
		System.out.println("ResultFromHashSetMethod size == " + distinctIntegers.length);
		
		for ( int c : distinctIntegers  ){
			
			System.out.println(c);
		}	
				
	}	
	
	/**
	 * This method maintains the order of the array checks for the distinct values by comparing the array in for loop
	 * This method retains the order of the array   
	 */
	public int[] retrieveDistinctIntegers ( )
	{
		
		int [ ] tempIntArray  = new int [ randomIntegers.length ];
		
		int recordCount = 0;
		
		for( int i= 0; i<randomIntegers.length; i++ )
		{			
			int tempInt = randomIntegers [i];				
			
			boolean isIntAlreadyPresent = false;	  
			
			for( int j= 0; j<i; j++ )
			{
				if(tempInt == randomIntegers [j] )
				{
					isIntAlreadyPresent = true;
				}
			}
			
			if (!isIntAlreadyPresent)
			{
				tempIntArray [recordCount] =  tempInt ; 
				recordCount ++;
			}
		}
		
		int [] distinctIntegers =  new int [ recordCount];
		
		for (int k = 0; k< recordCount; k ++)
		{
			distinctIntegers [k] = tempIntArray[k];				
		}
		
		return  distinctIntegers;	
	}
	
	/**
	 * This method uses HashSet which stores unique values. This use Java Collections and easy to implement.
	 * This method retains the order of the array   
	 * 
	 */
			
	public int [] retrieveDistinctIntegersUsingHashSet()
	{
		
		Set <Integer> distinctIntSet = new HashSet<>();
		
		for ( int n : randomIntegers )
		{
			distinctIntSet.add(n);
		}
		
		
		int [ ] distinctIntegers = new int [distinctIntSet.size()];
		
		int count = 0; 
		
		for ( Integer n : distinctIntSet ){
				
			distinctIntegers [count] = n.intValue();
			count++;
		}
		
		return  distinctIntegers;
		
	}
	
	
	/**
	 * This method first sorts the array then finds the distinct value, so this is better than the first method - retrieveDistinctIntegers which does not sort.  
	 * 
	 */
	
	public int[] retrieveDistinctIntegersFromSortedArray ( )
	{
		
		int [ ] tempIntArray  = new int [ randomIntegers.length ];
		
		Arrays.sort(tempIntArray);
		
		int recordCount = 0;
		
		for( int i= 0; i<randomIntegers.length; i++ )
		{			
			int tempInt = randomIntegers [i];				
			
			boolean isIntAlreadyPresent = false;	  
			
			for( int j= 0; j<i; j++ )
			{
				if(tempInt == randomIntegers [j] )
				{
					isIntAlreadyPresent = true;
				}
			}
			
			if (!isIntAlreadyPresent)
			{
				tempIntArray [recordCount] =  tempInt ; 
				recordCount ++;
			}
		}
		
		int [] distinctIntegers =  new int [ recordCount];
		
		for (int k = 0; k< recordCount; k ++)
		{
			distinctIntegers [k] = tempIntArray[k];				
		}
		
		return  distinctIntegers;	
	}

}
