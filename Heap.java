package heap;

public class Heap {
	private int[] a;//���±�1��ʼ�洢
	private int n;//heap�п��Դ洢��������ݸ���
	private int count;//heap���Ѿ��洢�����ݸ���
	public Heap(int capacity){
		a=new int[capacity+1];
		n=capacity;
		count=0;
	}
	public void insert(int data){
		if(count>=n){
			return;
		}
		a[++count]=data;
		int i=count;
		while(i/2>0&&a[i]>a[i/2]){//�������¶ѻ�			
			int temp=a[i];
			a[i]=a[count];
			a[count]=temp;
			i=i/2;
		}
	}
	public void deleteMax(){
		a[1]=a[count];
		count--;
		int i=1;
		while(true){//�������¶ѻ�
			int max = 0;
			if(i*2<=count&&a[i]<a[2*i]){
				max=i*2;
			}
			if(i*2+1<=count&&a[max]<a[2*i+1]){
				max=i*2+1;
			}
			if(max==0) break;
			int temp=a[i];
			a[i]=a[max];
			a[max]=temp;
			i=temp;
		}
	}

}
