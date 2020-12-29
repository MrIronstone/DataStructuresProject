public class  MyArrayList <T> {

    private ListNode<T> Head;
    private ListNode<T> Tail;
    private int theSize;

    private class ListNode<T> extends Student<T>{
        private Student<T> previous;
        private Student<T> later;

        public ListNode(ListNode<T> pre, ListNode<T> late, T isim, T soyisim, T id ){
            later=late;
            previous= pre;
            name = isim;
            surname = soyisim;
            studentID = id;
        }
    }
    private void clear(){
        Head = null;
    }


}
