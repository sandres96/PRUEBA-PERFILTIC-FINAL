import java.util.regex.Matcher;
import java.util.regex.Pattern;
class operacion {

    int operadorA;
    int operadorB;
    String simbolo;

    int operacion(int operadorA,int operadorB,String simbolo) {
        int resultado = 0;
        this.operadorA = operadorA;
        this.operadorB = operadorB;
        this.simbolo = simbolo;
        if (simbolo.equals("+") )
            resultado = operadorA + operadorB;
        if (simbolo.equals("-"))
            resultado = operadorA - operadorB;
        if (simbolo.equals("*"))
            resultado = operadorA * operadorB;
        if (simbolo.equals("/"))
             resultado = operadorA / operadorB;
       return resultado;
    }
}

public class Main {
    public static void main(String[] args) {
        operacion obj = new operacion();
        String[] v = {"{'99','+','8'}", "+", "{'20','+',{'8','*',{'9','+','8'}}}"};
        String[] A = {"{'2','+','9'}", "+", "{'9','+','7'}"};
        String[] cadenas;
        String ayuda;
        int num,num2,aux=0;
        int aux4[] = {0,0,0};
        int total;
        Pattern pat = Pattern.compile(".*'}$");
        for (int i = 0; i < 3; i++) {
            Matcher mat = pat.matcher(A[i]);
            if (mat.find()) {
                System.out.println("Ya se puede operar");
                cadenas = A[i].split("[,{}']");
               num = Integer.parseInt(cadenas[2]);
               num2 = Integer.parseInt(cadenas[8]);
               aux = obj.operacion(num,num2,cadenas[5]);

            } else {

                System.out.println("No se puede operar");
            }

            aux4[i] = aux;
        }
        total = obj.operacion(aux4[0],aux4[2],A[1]);
        System.out.println(total);



    }
    }










