import java.util.Scanner;

public class Matrix3x3InverseCalculator  {
    public static void main(String[] args) throws Exception {
        double determinante;
        double inversa[][] = new double[3][3];
        Scanner in = new Scanner(System.in);
        double matriz[][] = new double[3][3];
        for(int i = 0; i < 3; i++ ){
            for(int j = 0; j < 3; j++){
               System.out.println("Introduzca el elemento de la fila " + (i+1) + ",  columna " + (j+1));
                matriz[i][j] = in.nextInt();    
            }
        }
        in.close();
        determinante = calcularDeterminante(matriz);
        if(determinante == 0){
            System.out.println("El determinante de la matriz es 0 por lo tanto no tiene inversa");
        }else{
            inversa = calcularInversa(matriz);
            System.out.println("La inversa de la matriz es: ");
            for(int i = 0; i <3;i++){
                for(int j = 0; j <3;j++){
                    System.out.print(inversa[i][j]+" ");
                }
                System.out.println(" ");
            }
        }
    }
    public static double[][] calcularInversa(double[][]matriz){
        double[][]result=new double[3][3];
        double[][]adjunta=new double[3][3];
        adjunta=calcularAdjunta(matriz);
        double determinante = calcularDeterminante(matriz);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                result[i][j]=adjunta[i][j]/determinante;
            }
        }
        return result;
    }
    public static double[][] calcularAdjunta(double[][]matriz){
        double[][] adjunta = new double[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                adjunta[j][i]= calcularCofactor(matriz,i,j);
            }
        }
        return adjunta;
    }
    public static double calcularCofactor(double[][]matriz, int i, int j){
        double result=Math.pow(-1, i+j);
        result*=calcularMayor(matriz, i, j);
        return result;
    }
    public static double calcularMayor(double[][]matriz, int a,int b){
        double[]submatriz=new double[4];
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i!=a && j!=b){
                    submatriz[index]=matriz[i][j];
                    index++;
                }
            }
        }
        double result=submatriz[0]*submatriz[3]-submatriz[1]*submatriz[2];
        return result;
    }
    public static double calcularDeterminante(double matriz[][]){
        double determinante = 0;
        for(int j = 0; j < 3; j++){
            determinante += matriz[0][j] * calcularCofactor(matriz, 0, j);
        }
        return determinante;
    }
}