

	public class BSTException extends RuntimeException
	{
	   /******************************************************************
	     Sets up this exception with an appropriate message.
	   ******************************************************************/
	   public BSTException (String collection)
	   {
	      super ("The target element is not in this " + collection);
	   }
	} 

