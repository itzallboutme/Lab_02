# Lab_02
// Kyle Hover
// Lab_02
// 


public class CList<T> extends Comparable<T>> extends LinkedList<T>
{
    public CList() { super(); } // subclass constructor

    // sample method to insert a value in sorted order
    public void orderInsert(T x)
    {
	size++;
	if (size==1) {first=last = new node(x); return; }
	if (x.compareTo(first.item)<0) // push in front
	    { first = new node(x,first); return; }
	node current = first;
	// find node before insertion point:
	while (current!=last && x.compareTo(current.item)>=0) 
	    current=current.next;
	current.next = new node(x,current.next);
	if (current==last) last = current.next;
    }
	
	public int count(T x) // 1 returns the number of time x is 
						  // found as an item in the list
	{
		int number = 0;
		if (x==null) return 0;
		{
			node current=first;
			int i = 0;
			for (i = current; i <= size; i++)
			{
				if (x.equals(current.item));
				{
					number ++;
				}
			}
		return number;
	}
	
	public void cut() // 2 Removes the items between the first number of a list
					 // and the last occurrence of the same number	
	{
		node current = first;
		firstnum = first.item;
		tempSize = this.size;
		for (current = current.last; tempSize <= this.size; current.prev)
		{
			if current.equals(firstnum)
			{
				first.next = current.next
			}
		}
	}
	
	public CList<T> clone() 	// 3 Should return a full clone of the list being
								// invoked on    		
		{							
		cloneList = new.list;
		current = current.first;
		cloneSize = 0;
		for (int i = 0; i < size(); i++)
			{
				node i = new node(current);				
				current = current.next;
				cloneSize++;
			}
		}
	
	public CList<T> weakclone() // 4 should return another instance of the list  
									 // with the same size and elements but without 
									 // duplicating cells
		{							
			if (L == null) 
				return null;
			CList<T> weakCloneList = new.list<T>();
			weakCloneList.size = L.size;
			weakCloneList.first = L.first;
			weakCloneList.last = L.last;
			return weakCloneList;
		}				

	public CList<T> reverse()    // 5 Should return a reversed version of the list
		{
			CList<T> MList = new.list<T>();
			temp = L.size;
			
       		for (current = current.last; temp <= L.size(); current.prev;)
			{
					MList.add(current);
			}
    		return MList;
        }
	   
	   public T min() 		// 6 Finds the smallest item in the list
		{
			temp = this.size();
			CList<T> L.current = first;
			T min = first;
			while (temp != null)
			{
				if (CList.compareTo(min) < current)
				{
					min = current;
				}
				current = current.next;
				temp --;
			}
			return min;
		}
		
		public CList<T> sort() // 7 Creates a new sorted list while leaving the original 
		{
			CList<T> S = new CList<T>();
			for (T x;this) S.orderInsert(x);
			return S;
		}


	
	public static void main(String argv)
	{
		
	}
