package P284窥探迭代器;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Integer peek;
    Iterator<Integer> parent;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.peek = null;
        this.parent = iterator;
    }

    public Integer peek() {
        if(peek == null){
            getNext();
        }
        return peek;
    }

    @Override
    public Integer next() {
        if(peek == null){
            getNext();
            if(peek != null){
                int peek = this.peek;
                this.peek = null;
                return peek;
            }else{
                return null;
            }
        }else{
            int peek = this.peek;
            this.peek = null;
            return peek;
        }
    }

    @Override
    public boolean hasNext() {
        if(peek == null){
            getNext();
            return peek != null;
        }else{
            return true;
        }
    }
    private void getNext(){
        if(parent.hasNext()){
            this.peek = parent.next();
        }else{
            this.peek = null;
        }
    }
}