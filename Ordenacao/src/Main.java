import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] vetor = {5,33,14,2,6,45,12,44,64};
        BubbleSort(vetor);
    }
    public static void selectionSort(int[] v){
        int comparacao = 0;
        for(int i=0;i<v.length-1;i++){
            for(int j=i+1;j<v.length;j++){
                if (v[j]<v[i]){
                    int aux=v[i];
                    v[i]=v[j];
                    v[j]=aux;
                    comparacao+=1;
                }
            }
        }
        System.out.println(Arrays.toString(v));
        System.out.println(comparacao);
    }

    public static void selectionSortOtimizado(int[] v){
        int comparacao = 0;
        int indicemenor=0;
        for(int i=0;i<v.length-1;i++){
            indicemenor=i;
            for(int j=i+1;j<v.length;j++){
                if (v[j]<v[indicemenor]){
                     indicemenor=j;
                     comparacao+=1;
                }
            }
            if (i!=indicemenor){

                int aux=v[i];
                v[i]=v[indicemenor];
                v[indicemenor]=aux;
            }
        }
        System.out.println(Arrays.toString(v));
        System.out.println(comparacao);
    }


    public static void BubbleSort(int [] v){
        int comparacao = 0;
        for(int i=0;i<v.length-1;i++){
            for(int j=1;j<v.length-i;j++){
                if (v[j-1]>v[j]){
                    int aux=v[j-1];
                    v[j-1]=v[j];
                    v[j]=aux;
                    comparacao+=1;
                }
            }
        }
        System.out.println(Arrays.toString(v));
        System.out.println(comparacao);
    }

}