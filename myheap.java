public class myheap<T extends Comparable<T>> extends Heap<T>
{
    // constructors of the subclass should be written this way:
    public myheap(int max) { super(max); }
    public myheap(T[] A, int size) {super(A, size);}
    public void drawheap() // use only with heapdisplay.java program
    {
        heapdisplay W = new heapdisplay(1024,768);
        W.drawtree(H,size);
    }
        
    public static <S extends Comparable<S>> void heapsort(S[] A)
    {
        int size = A.length;
        Heap<S> HA = new Heap<S>(size);
        for (int i = 0; i <= size-1; i++)
        {
            HA.insert(A[i]);
        }
        
        for (int j = size-1; j >= 0; j--)
        {
            A[j] = HA.deleteTop();
        }
    }
    
    public void makeheap()
    {
        Heap(T[] A, int size);
    }
    
    public void heapsort2()
    {
        int size = H.length;
        for (int i=0; i<H.length; i++)
        {
            for (int j=0; j<size-1; j++)
            {
                if (A[j].compareTo(A[j+1])>0)
                { T temp = A[j]; A[j] = A[j+1]; A[j+1] = temp;}
            }
        }
        
    }
    
    boolean heapsearch(T x, int i){return x.equals(H[i])||heapsearch(x,left(i))||heapsearch(x,right(i));}
    
   
   
    public static void main(String[] av)
    {
        int n = 100000; // sort 100K numbers
        Integer[] A = new Integer[n];
        for(int i=0;i<A.length;i++)
            A[i] = (int)(Math.random()*100*n);
        heapsort(A); // assume called from within main in myheap
        for(int i=0;i<A.length-1;i++)
            if (A[i]>A[i+1]) System.out.println("OOPS"); // shouldn't print this
    }
    
        
        
    /*public static void main(String[] av)
    {
        int n = 50;
        Heap<Integer> HI = new Heap<Integer>(n);
        HI.setComparator( (x,y)->y-x ); // what does this do?
        for(int i=0;i<n;i++) HI.insert((int)(Math.random()*n*10));
        for(int i=0;i<n;i++) System.out.print(HI.deleteTop()+"  ");
    }*/


}

