import java.util.*;
public class Main
{
    
    static void bubbleSort(int arr[],int size){
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
                if(arr[j]>arr[j+1]){
                    
                    arr[j]=arr[j]+arr[j+1];
                    arr[j+1]=arr[j]-arr[j+1];
                    arr[j]=arr[j]-arr[j+1];
                }
            }
            System.out.println("pass"+(i+1)+" : "+Arrays.toString(arr));
        }
        
    }
    
    static void selectionSortI(int arr[],int n){
        int min,temp;
        for(int i=0;i<n-1;i++){
            min=i;
            
            for(int j=i+1;j<n;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            
            temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
            
            
            
            
            System.out.println("pass "+(i+1)+" : "+Arrays.toString(arr));
        }
    }
    
    static void selectionSortII(int arr[],int size){
        int temp,max;
        
        for(int i=size-1;i>=1;i--){
            max=i;
            
            for(int j=i-1;j>=0;j--){
                if(arr[max]<arr[j]) max=j;
            }
            
            temp=arr[max];
            arr[max]=arr[i];
            arr[i]=temp;
            
            System.out.println("pass "+(size-i)+" : "+Arrays.toString(arr));
        }
    }
    
    
    static void insertionSort(int arr[],int size){
        int prev,currElement;
        for(int curr=1;curr<size;curr++){
            prev=curr-1;
            currElement = arr[curr];
            
            while(prev>=0 && arr[prev]>currElement){
                arr[prev+1]=arr[prev];
                prev--;
            }
            
            arr[prev+1]=currElement;
            
             System.out.println("pass "+(curr)+" : "+Arrays.toString(arr));
            
        }
    }
    
    static void merge(int arr[],int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        
        int lArr[]=new int[n1];
        int rArr[]=new int[n2];
        
        for(int x=0;x<n1;x++) lArr[x]=arr[x+l];
        
        for(int x=0;x<n2;x++) rArr[x]=arr[x+m+1];
        
        
        int i=0,j=0,k=l;
        
        while(i<n1&&j<n2){
            if(lArr[i]<=rArr[j]){
                arr[k]=lArr[i];
                i++;
                
            }else{
                arr[k]=rArr[j];
                j++;
            }
            k++;
        }
        
        while(i<n1){
            arr[k]=lArr[i];
            i++;k++;
        }
        
        while(j<n2){
            arr[k]=rArr[j];
            j++;k++;
        }
        
        // System.out.println("pass "+(++count)+" : "+Arrays.toString(arr));
        
        
    }
    
    //static int count=0;
    
    static void mergeSort(int arr[],int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    
	public static void main(String[] args) {
	    int arr[]={4,3,5,2,234,23,65,23,21};
	    mergeSort(arr,0,8);
	    
		System.out.println(Arrays.toString(arr));
		
	}
}