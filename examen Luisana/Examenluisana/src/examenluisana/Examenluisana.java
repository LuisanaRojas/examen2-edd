//primer ejercicio
package examenluisana;
import java.util.Scanner;
class Suma {
    private int[] a;

    public Suma(int[] arreglo) {
        this.a = arreglo;
    }

    public int sumar() {
        return sumar(a.length - 1);
    }

    private int sumar(int indice) {
        if (indice < 0) {
            return 0;
        } else {
            return a[indice] + sumar(indice - 1);
        }
    }
}

//segundo ejercicio
class Nodo {
    String valor;
    Nodo siguiente;

    public Nodo(String valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}


class Lista {
    private Nodo cabeza;
    private Nodo cola;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregar(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza; 
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza; 
        }
    }

    public String concatenar() {
        if (cabeza == null) {
            return "";
        }
        return concatenarPalabras(cabeza, cabeza);
    }

    private String concatenarPalabras(Nodo actual, Nodo inicio) {
        if (actual.siguiente == inicio) {
            return actual.valor;
        } else {
            return actual.valor + " " + concatenarPalabras(actual.siguiente, inicio);
        }
    }

}

//tercer ejercicio
class NodoP {
    int valor;
    NodoP siguiente;

    public NodoP(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class Pila {
    NodoP cima;

    boolean isEmpty() {
        return cima == null;
    }

    void push(int val) {
        if (isEmpty()) {
            cima = new NodoP(val);
        } else {
            NodoP nuevo = new NodoP(val);
            nuevo.siguiente = cima;
            cima = nuevo;
        }
    }

    public void imprimir() {
      
         imprimirValor(cima);
        System.out.println();
    }

    private void imprimirValor(NodoP nodo) {
        
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            imprimirValor(nodo.siguiente);
        }
        
    }

    void pop() {
        if (!isEmpty()) {
            cima = cima.siguiente;
        }
    }
}

//cuarto ejercicio
class Multiplicar{
    
    public int factorial(int n) {
        if ((n == 0)||(n==1)) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public int potencia(int b, int c) {
        if (c == 0) {
            return 1;
        } else {
         return b * potencia(b, c - 1);
        }
    }
     public int multiplicar(int a, int b, int c) {
        int factorial = factorial(a);
        int potencia = potencia(b, c);
        return factorial * potencia;
    }
    
}

public class Examenluisana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        Scanner sc = new Scanner(System.in);
        int[] a =new int[6];
        int j=0; int num;
      
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número para la posición " + i + ": ");
            a[i] = sc.nextInt();
        }
  
        Suma adicion = new Suma(a);
        int resultado = adicion.sumar();
        System.out.println("La suma de los elementos del arreglo es: " + resultado);
        
        System.out.println("Ejercicio 2");
        Lista lista = new Lista();
        lista.agregar("Examen");
        lista.agregar("de");
        lista.agregar("Recursividad");
        String listaCadenas= lista.concatenar();
        System.out.println(listaCadenas);
        
         System.out.println("Ejercicio 3");
        Pila pila = new Pila();
        Scanner scanner = new Scanner(System.in);
        int i=0; int numero;
        for(i=0; i<=5;i++)
        {
            System.out.print("Ingrese un número: ");
            numero = scanner.nextInt();
            pila.push(numero);
        }
        
        System.out.println("Pila Inversa:");
       
        pila.pop();
        pila.imprimir();
        
         System.out.println("Ejercicio 4");
        Multiplicar operacion= new Multiplicar();
        int factorial; int base; int exponente;
        System.out.print("Ingrese factorial: ");
        factorial = scanner.nextInt();
        System.out.print("Ingrese base de potencia: ");
        base = scanner.nextInt();
        System.out.print("Ingrese el exponente de potencia: ");
        exponente = scanner.nextInt();
         int calculo= operacion.multiplicar(factorial, base, exponente);
        System.out.println("Multiplicacion=" + factorial + "! * " + base+ "^" + exponente + " es: " + calculo);
        
        // se hizo lo que se pudo:(
    }
    
}
