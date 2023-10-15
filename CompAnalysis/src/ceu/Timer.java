package ceu;

public class Timer 
{
  public static void run( int rerunCount, int seconds )
  {
    Thread timerThread = new Thread( new Runnable() 
    {
        @Override
        public void run() 
        {
            for ( int i = seconds; i > 0; i-- ) 
            {
              try 
              {
                  Thread.sleep( 1000 );
                  System.out.print( i + "..." );
              } catch ( InterruptedException e ) 
              {
                  e.printStackTrace();
              }
          }
            }
    } );

    timerThread.start();
    
    try 
    {
      timerThread.join();
    } 
    catch ( InterruptedException e ) 
    {
        e.printStackTrace();
    }
  }
}
