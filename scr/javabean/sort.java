package javabean;
import java.util.ArrayList;

//二分归并排序
public class sort {
     int[] arrnum;
     String [][] arrvalue;
     public ArrayList<postlist>  postlistsort(ArrayList<postlist> postlist) {
    	 arrnum=new int [postlist.size()];
    	 arrvalue=new String [postlist.size()][4];
    	 ArrayList<postlist> list=new ArrayList<postlist> ();
      for(int i=0;i<postlist.size();i++) {		 
    	  postlist post=postlist.get(i);
    	  arrnum[i]=post.getNum();
    	  arrvalue[i][0]=post.getUid();
    	  arrvalue[i][1]=post.getAid();
    	  arrvalue[i][2]=post.getTitle();
    	  arrvalue[i][3]=post.getAtime();
      }

		int[]tmpnum = new int[postlist.size()];    //新建一个临时数组存放
		String [][] tmpvalue=new String [postlist.size()][4];
		mergeSort(arrnum,arrvalue,0,arrnum.length-1,tmpnum,tmpvalue);
		for(int i=arrnum.length-1;i>=0;i--){
			postlist post1 = null;
			post1.setUid(arrvalue[i][0]);
			post1.setAid(arrvalue[i][1]);
			post1.setTitle(arrvalue[i][2]);
			post1.setAtime(arrvalue[i][3]);
			post1.setNum(arrnum[i]);
			list.add(post1);
		}
		return list;
	}
	
	public static void merge(int[] arrnum,String [][] arrvalue,int low,int mid,int high,int[] tmpnum,String [][] tmpvalue){
		int i = 0;
		int j = low,k = mid+1;  //左边序列和右边序列起始索引
		while(j <= mid && k <= high){
			if(arrnum[j] < arrnum[k]){
				tmpvalue[i][0]=arrvalue[j][0];
				tmpvalue[i][1]=arrvalue[j][1];
				tmpvalue[i][2]=arrvalue[j][2];
				tmpvalue[i][3]=arrvalue[j][3];
				tmpnum[i++] = arrnum[j++];
			}else{
				tmpvalue[i][0]=arrvalue[k][0];
				tmpvalue[i][1]=arrvalue[k][1];
				tmpvalue[i][2]=arrvalue[k][2];
				tmpvalue[i][3]=arrvalue[k][3];
				tmpnum[i++]= arrnum[k++];
			}
		}
		//若左边序列还有剩余，则将其全部拷贝进tmp[]中
		while(j <= mid){    
			tmpvalue[i][0]=arrvalue[j][0];
			tmpvalue[i][1]=arrvalue[j][1];
			tmpvalue[i][2]=arrvalue[j][2];
			tmpvalue[i][3]=arrvalue[j][3];
			tmpnum[i++] = arrnum[j++];
		}
		
		while(k <= high){
			tmpvalue[i][0]=arrvalue[k][0];
			tmpvalue[i][1]=arrvalue[k][1];
			tmpvalue[i][2]=arrvalue[k][2];
			tmpvalue[i][3]=arrvalue[k][3];
			tmpnum[i++] = arrnum[k++];
		}
		
		for(int t=0;t<i;t++){
			arrvalue[low+t][0]=tmpvalue[t][0];
			arrvalue[low+t][1]=tmpvalue[t][1];
			arrvalue[low+t][2]=tmpvalue[t][2];
			arrvalue[low+t][3]=tmpvalue[t][3];
			arrnum[low+t] = tmpnum[t];
		}
	}
 
	public static void mergeSort(int[] arrnum,String [][] arrvalue,int low,int high,int[] tmpnum,String [][] tmpvalue){
		if(low<high){
			int mid = (low+high)/2;
			mergeSort(arrnum,arrvalue,low,mid,tmpnum,tmpvalue); //对左边序列进行归并排序
			mergeSort(arrnum,arrvalue,mid+1,high,tmpnum,tmpvalue);  //对右边序列进行归并排序
			merge(arrnum,arrvalue,low,mid,high,tmpnum,tmpvalue);    //合并两个有序序列
		}
	}



}

