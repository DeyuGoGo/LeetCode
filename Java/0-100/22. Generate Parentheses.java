public class Solution {
    private List<String> results = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0)return null;
        Data head = new Data("" , n , n );
        Data tail = new Data(head.s+"(",head.open-1,head.close);
        head.next =tail;
        while(head.next!=null){
            head = head.next;
            if(head.close == 0){
                results.add(head.s);
                continue;
            }
            if(head.open>0){
                tail.next = new Data(head.s+"(",head.open -1,head.close);
                tail = tail.next;
              }
              if(head.close>head.open){
                tail.next = new Data(head.s+")",head.open,head.close-1);
                tail = tail.next;
            }
        }
        return results;
    }

    class Data{
        public int open ;
        public int close ;
        public String s = "";
        public Data next = null;
        public Data(String s , int open , int close){
            this.s = s;
            this.open = open ;
            this.close = close;
        }
    }
}
