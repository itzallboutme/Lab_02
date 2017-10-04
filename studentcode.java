class studentcode extends mazedfs
{
    public studentcode(int bh0, int mh0, int mw0) // don't change constructor
    { 
	super(bh0,mh0,mw0); 
    } 

/* class Coord
{
	int y;
	int x;
	public Coord(int a, int b)
	{
		y = a;
		x = b;
	}
	public boolean .equals(Object x)
	{
		Coord c = (Coord) x;
	*/
class stackcell 
{
    int x;
    int y;
    stackcell tail;
    public stackcell(int a, int b, stackcell t) {y=a; x=b; tail=t;}
	
	/* public void cut()
	{
		int first = (a);
		for (int loop = 0; loop < stacksize; loop++)
		{
			// if a == j
		}
	} */
} // stack class

public void digout(int y, int x)   // modify this function
{
     // solution

     M[y][x] = 1;  // digout maze at coordinate y,x
     drawblock(y,x);  // change graphical display to reflect space dug out
     //     delay(40); // slows animation

     // order directions in terms of North, East, South, West
     int[] DX = {0,1,0,-1};
     int[] DY = {-1,0,1,0};
     // randomly scramble DX, DY:
     for(int i=0;i<DX.length-1;i++)
	 {
	     int r = i+(int)(Math.random()*(DX.length-i));
	     int tmp = DX[i];  DX[i]=DX[r];  DX[r]=tmp;
	     tmp = DY[i]; DY[i] = DY[r]; DY[r]=tmp;
	 }
     
     for (int dir = 0;dir<DX.length;dir++)
	 {
	     int dx = DX[dir], dy = DY[dir];
	     // look two spaces ahead
	     int nx = x + 2*dx, ny = y+ 2*dy;
	     if (nx>=0 && nx<mw && ny>=0 && ny<mh && M[ny][nx]==0)
		 {
		     // digout itermediate square:
		     M[y+dy][x+dx] = 1;
		     drawblock(y+dy,x+dx);
		     // recursively dig out two spots ahead in chosen dir:
		     digout(ny,nx);
		 }
	 }// for each dir
 }//digout

 public void solve()
 {
	
	int x=1, y=1;
	byte[] Vals = new byte[4];
	stackcell yourStack = new stackcell(y,x, null);

	drawdot(y, x);
	delay(40);
	while( y != mh-2 || x != mw-2)
	{
		drawdot(y, x);
		int mazesize = 0;
	 
		// drawblock(y, x);
		
		
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
			
			drawblock(y, x);
			y -= 1;
			// drawdot(y, x);
			M[y][x] += 1;
		}
		
		if (direction == 1 && x-1 != mw-2)
		{
			drawblock(y, x);
			x -= 1;
			// drawdot(y, x);
			M[y][x] += 1;
		}

		if (direction == 2)
		{
			drawblock(y, x);
			y += 1;
			// drawdot(y, x);
			M[y][x] += 1;
		}

		if (direction == 3)
		{
			drawblock(y, x);
			x += 1;
			// drawdot(y, x);
			M[y][x] += 1;		
		}
		
		yourStack = new stackcell(y,x, yourStack);


		
	} 
 }
 
     public void trace()
    {
		
    
}//studentcode subclass


