class studentcode extends mazedfs
{
    public studentcode(int bh0, int mh0, int mw0) // don't change constructor
    {
        super(bh0,mh0,mw0);
    } 

public void digout(int y, int x)   // modify this function
 {
     // The following is a skeleton program that demonstrates the mechanics
     // needed for the completion of the program.

     // We always dig out two spaces at a time: we look two spaces ahead
     // in the direction we're trying to dig out, and if that space has
     // not already been dug out, we dig out that space as well as the
     // intermediate space.  This makes sure that there's always a wall
     // separating adjacent corridors.
     
     M[y][x] = 1;  // digout maze at coordinate y,x
     drawblock(y,x);  // change graphical display to reflect space dug out
     //delay(40); // slows animation
     
   
     // order directions in terms of North, East, South, West
     int[] DX = {0,1,0,-1};
     int[] DY = {-1,0,1,0};
   
     for(int i=0;i<DX.length-1;i++)
     {
         int r = i+(int)(Math.random()*(DX.length-i));
         int tmp = DX[i]; DX[i]=DX[r]; DX[r]=tmp;
         tmp = DY[i]; DY[i] = DY[r]; DY[r]=tmp;
     }
     
     for (int dir = 0;dir<DX.length;dir++)
     {
         int dx = DX[dir], dy = DY[dir];
         int nx = x + 2*dx, ny = y+ 2*dy;
         if (nx>=0 && nx<mw && ny>=0 && ny<mh && M[ny][nx]==0)
         {
             M[y+dy][x+dx] = 1;
             drawblock(y+dy,x+dx);
             digout(ny,nx);
         }
     }
 }
    
    public void solve()
    {
        int y = 1, x = 1;
        drawdot(y, x);
        
        
        while ( y!=mh-2 || x!=mw-2)
        {
            //int n = M[y-1][x];
            y++;
            x++;
            drawdot(y,x);
            drawblock(y-1,x-1);
            delay(40);
            
        }
        
       
        /*while (y != mh - 2 || x != mw - 2)
        {
            if (y-1 >0 && M[y-1][x] != 0)
            {
                n = M[y-1][x];
            }
            else
            {
                n = 127;
                
            }
            drawdot(y,x);
        } */
        
        
    }

}//studentcode subclass


