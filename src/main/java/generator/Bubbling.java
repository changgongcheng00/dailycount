package generator;

/**
 * @ClassName Bubbling
 * @Description TODO
 * @Author cheng
 * @Date 2019/4/30 13:39
 **/
public class Bubbling {

    public static void main(String[] args) {
        int [] no = {3,5,9,8,5,4,7,6};
        for(int i=0;i<no.length-1;i++){
            for(int j=0;j<no.length-1-i;j++){
                if(no[j]>no[j+1]){
                    int temp = no[j];
                    no[j] = no[j+1];
                    no[j+1]=temp;
                }
            }
        }
        for (int i = 0; i <no.length ; i++) {
            System.out.println(no[i]);
        }

    }
}
