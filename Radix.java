public class Radix{
  public static int nth(int n, int col){
    int a = (int) Math.pow(10,col);
    int q = n/a;
    return Math.abs(q%10);
  }

  public static int length(int n){
    if (n==0) return 1;
    int l = (int) (Math.log10(n) + 1);
    return Math.abs(l);
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (int i=0; i<buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

}
