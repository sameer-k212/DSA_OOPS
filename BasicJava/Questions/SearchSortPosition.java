
public class SearchSortPosition {
    int index;
    int searchSortPosition (int arr[],int target)
    {
        int last = arr.length;
        int start=0;
        while( start < last)
        {
            int mid = (start + last)/2;
            if(arr[mid] == target)
            {
                last=mid;
            }
            else if(arr[mid] < target)
            {
                start = mid+1;
                index=start;
            }
            else {
                last = mid;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        SearchSortPosition obj = new SearchSortPosition();
        int arr[]={1,3};
        int target=2;
        int index=obj.searchSortPosition(arr,target);
        System.out.println(index);
    }
}
