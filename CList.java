public class CList<T extends Comparable<T>> extends LinkedList<T>
{
    public CList() { super(); } // subclass constructor
    
    // sample method to insert a value in sorted order
    public void orderInsert(T x)
    {
        size++;
        if (size == 1) {first = last = new node(x); return; }
        if (x.compareTo(first.item)<0) // push in front
        { first = new node(x,first); return; }
        node current = first;
        // find node before insertion point:
        while (current!=last && x.compareTo(current.item)>=0)
            current = current.next;
        current.next = new node(x,current.next);
        if (current == last) last = current.next;
    }
    
    public int count(T x) // returns the number of times x is found as an item in the list
    {
        int count = 0;
        
        if (x==null) return 0;
    
        node current = first;
        
        while(current != last)
        {
            if (x.equals(current.item))
            {
                number += 1;
                current = current.next;
            }
        }
        return count;
    }
    
    public void cut() // removes specified number of elements from the front of a list
    {
        node current = first;
        firstnum = first.item;
        tempsize = this.size;
        for (current = current.last; tempsize <= this.size; current.prev)
        {
            if current.equals(firstnum)
            {
                first.next = current.next;
            }
        }
    }

    
    public LinkedList<T> clone() // return a full clone of the list being invoked on.
    {
        LinkedList<T> CloneList = new LinkedList<T>();
        current = current.first;
        cloneSize = 0;
        
        for (int i = 0; i < size; i++)
        {
            node i = new node (current);
            current = current.next;
            cloneSize++;
        }
        return cloneSize;
        
    }

    public LinkedList<T> weakclone() //list with the same size without duplicating cells
    {
        if (L == null)
        {
            return null;
            CList<T> WeakClone = new WeakClone<T>();
            WeakClone.size = L.size;
            WeakClone.first = L.first;
            WeakClone.last = L.last;
        }
        return WeakClone;
    }
    
    
    
    public CList<T> reverse() //Function to reverse list
    {
        CList<T> ReversedList = new.list<T>();
        temp = L.size;
        
        for (current = current.last; temp <= L.size(); current.prev;)
        {
            MList.add(current);
        }
        return MList;
    }
    
    
    
    public T min() // find the smallest item in the list
    {
        LinkedList<T> temp = first.next();
        T min = first.get();
        while(temp != null)
        {
            T current = temp.get();
            if (current.compareTo(min) < 0)
            {
                min = current;
            }
            temp = temp.next();
        }
        return min;
    }
    
    public CList<T> sort()		// Creates sorted list
    {
        CList <T> S = new CList<T>();
        for (T x; this;)
            S.orderInsert(x);
            return S;
        
    }		

}