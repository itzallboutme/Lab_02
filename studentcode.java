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
 } // digout
    
    public void solve()
    {
        int y = 1, x = 1;
        byte[] Vals = new byte[4];
       
        drawdot(y, x);
        delay(40);
        
        while ( y!=mh-2 || x!=mw-2)
        {
            drawdot(y, x);
            
            drawblock(y, x);
            
            
            if (y-1 >= 0 && M[y-1][x] != 0) Vals[0] = M[y-1][x];
            else Vals[0] = 127;
            if (x-1 >= 0 && M[y][x-1] != 0) Vals[1] = M[y][x-1];
            else Vals[1] = 127;
            if (y+1 <= 41 && M[y+1][x] != 0) Vals[2] = M[y+1][x];
            else Vals[2] = 127;
            if (x+1 <= 51 && M[y][x+1] != 0) Vals[3] = M[y][x+1];
            else Vals[3] = 127;
            
            int direction = 0;
            for (int four = 0; four < 4; four++)
            {
                if (Vals[four] < Vals[direction])
                    direction = four;
            }
            if (direction == 0 && y-1 != mh-2)
            {
                // drawblock(y, x);
                y -= 1;
                // drawdot(y, x);
                M[y][x] += 1;
            }
            
            if (direction == 1 && x-1 != mw-2)
            {
                // drawblock(y, x);
                x -= 1;
                // drawdot(y, x);
                M[y][x] += 1;
            }
            
            if (direction == 2)
            {
                // drawblock(y, x);
                y += 1;
                // drawdot(y, x);
                M[y][x] += 1;
            }
            
            if (direction == 3)
            {
                // drawblock(y, x);
                x += 1;
                // drawdot(y, x);
                M[y][x] += 1;
                
            }
            
        }
        
   
        
        
    } // solve
    
    class stackcell
    {
        int x;
        int y;
        stackcell tail;
        public stackcell(int a, int b, stackcell t) {y=a; x=b; tail=t;}
    } // stack class

    
    public void trace()
    {
        stackcell PathBackStack = new stackcell();
       
        while(x != 1 && y != 1 )
        {
            int x = PathBackStack.x;
            int y = PathBackStack.y;
            
            
            byte valueOfFieldNorthOfXY = M[x][y-1];
            byte valueOfFieldWesthOfXY = M[x-1][y];
            byte valueOfFieldEastOfXY = M[x+1][y];
            byte valueOfFieldSouthOfXY = M[x][y+1];
            
            if (stackcell.tail.x == x && stackcell.tail.y == y-1)
            {
                
                valueOfFieldNorthOfXY = 100;
            }
            if (stackcell.tail.x == x-1 && stackcell.tail.y == y)
            {
                valueOfFieldWestOfXY = 100;
            }
            
            if (stackcell.tail.x == x+1 && stackcell.tail.y == y)
            {
                valueOfFieldEastOfXY = 100;
            }
            if (stackcell.tail.x == x1 && stackcell.tail.y == y+1)
            {
                valueOfFieldSouthOfXY = 100;
            }
            
            int direction = NORTH;
            byte maxValue = 100;
            if (valueOfFieldNorthOfXY < maxValue)
            {
                maxValue = valueOfFieldNorthOfXY;
                direction = NORTH;
            }
            if (valueOfFieldWestOfXY < maxValue)
            {
                maxValue = valueOfFieldWestOfXY;
                direction = WEST;
            }
                
            if (valueOfFieldEastOfXY < maxValue)
            {
                maxValue = valueOfFieldEastOfXY;
                direction = EAST;
            }
            if (valueOfFieldSouthOfXY < maxValue)
            {
                maxValue = valueOfFieldSouthOfXY;
                direction = SOUTH;
            }
            
            int nx = x;
            int ny = y;
            if (direction == NORTH)
            {
                ny = ny - 1;
            }
            if (direction == WEST)
            {
            nx = nx - 1;
            }
            if (direction == EAST)
            {
                nx = nx + 1;
            }
            if (direction == SOUTH)
            {
                ny = ny - 1;
            }
            PathBackStack = new stackcell(nx, ny, PathBackStack);
            drawdot(PathBackStack.y,PathBackStack.x);
            
        }
    }
    
}//studentcode subclass


