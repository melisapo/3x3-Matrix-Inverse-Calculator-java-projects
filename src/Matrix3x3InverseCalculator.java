import java.util.Scanner;

public class Matrix3x3InverseCalculator  {
    public static void main(String[] args) throws Exception {
        int determinante;
        double inversa[][];
        Scanner in = new Scanner(System.in);
        int matriz[][] = new int[3][3];
       
        for(int i = 0; i< 3; i++ ){
            for(int j = 0;j<3;j++){
               System.out.println("Introduzca el elemento de la fila " + (i+1) + ",  columna " + (j+1));
                matriz[i][j] = in.nextInt();    
            }
        }
        determinante = Determinante(matriz);
        if(determinante == 0){
            System.out.println("El determinante de la matriz es 0 por lo tanto no tiene inversa");
        }else{
            inversa = CalcularInversa(matriz);
            System.out.println(inversa);
        }
    }
 
     public static double[][] CalcularInversa(int[][]matriz){
        double[][]result=new double[3][3];
        int[][]adjunta=new int[3][3];
        adjunta=Adjunta(matriz);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                result[i][j]=adjunta[i][j]/Determinante(matriz);
            }
        }
        return result;
    }
    public static int[][] Adjunta(int[][]matriz){
        int[][] adjunta = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                adjunta[j][i]= CalcularCofactor(matriz,i,j);
            }
        }
        return adjunta;
    }
    public static int CalcularCofactor(int[][]matriz, int i, int j){
        int result=(int)Math.pow(-1, i+j);
        result*=CalcularMayor(matriz, i, j);
        return result;
    }
    public static int CalcularMayor(int[][]matriz, int a,int b){
        int[]submatriz=new int[4];
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;i++){
                if(i!=a && j!=b){
                    submatriz[index]=matriz[i][j];
                    index++;
                }
            }
        }
        int result=submatriz[0]*submatriz[3]-submatriz[1]*submatriz[2];
        return result;
    }
    

public static int Determinante(int matriz[][]){
    int determinante = 0;
    
    for(int j = 0; j < 3; j++){
       determinante += matriz[0][j] * CalcularCofactor(matriz, 0, j);
    }
    return determinante;
 }
}