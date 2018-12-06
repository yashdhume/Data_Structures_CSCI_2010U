// @author Yash Dhume (100653618)
package Assignment3;

public class MajorityElement {
    private static Integer majorityElement(int[] arr){
        int count =0;
        Integer element = null;//used object Integer for null
        for (int i : arr){//iterate through array it adds and subtracts count by 1 if the element is same
            if(count==0){//add 1 to have  a num
                element = i;
                count++;
                continue;
            }
            else{//keep adding until different value
                if (element  == i)count++;
                else count--;
            }
        }
        if(count==0)return null;
        count=0;
        for(int  i : arr){//double  check if the the  total amount is greater  than  n/2
            if(element==i)  count++;
        }
        if(count>arr.length/2) return element;
        else return null;
    }
    public  static void main(String[] args){
        int[] arr = {1};
        System.out.println("Majoirty Element: " + majorityElement(arr));
    }
}
