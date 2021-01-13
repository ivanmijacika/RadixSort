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

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int maxLength = 0;
    for (int i=0; i<10; i++){
      buckets[i] = new SortableLinkedList(); //boxes
    }
    while (data.size()>0){
      if (length(data.get(0)) > maxLength){
	maxLength = length(data.get(0));
      }
      buckets[nth(data.get(0), 1)].add(data.get(0));
      data.remove(0);
    }
    merge(data, buckets);
    for (int i=1; i<maxLength; i++){
      while(data.size()>0){
	buckets[nth(data.get(0), i)].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    SortableLinkedList[] posneg = new SortableLinkedList[2]; //+ or - distnguisher
    int maxLength = 0;
    for (int i=0; i<10; i++){
      buckets[i] = new SortableLinkedList();
    }
    for (int i=0; i<2; i++){
      posneg[i] = new SortableLinkedList();
    }
    while(data.size()>0){
      if(length(data.get(0)) > maxLength){
        maxLength = length(data.get(0));
      }
      buckets[nth(data.get(0), 0)].add(data.get(0));
      data.remove(0);
    }
    merge(data, buckets);
    for (int i=1; i<maxLength; i++){
      while(data.size()>0){
        buckets[nth(data.get(0), i)].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
    //???? Something to do with signs???
  }

}
