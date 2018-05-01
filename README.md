# Generador de Números Reales
Programa para generar números reales, a partir de la siguiente gramática:
```
La gramática G = (N, T, P, σ*), genera todos los números reales.

N={ < Digito >,< N. Real >,< N. Real c/signo >,< N. Real s/signo >,< Punto >,< Decimales > }
T={ 0,1,2,3,4,5,6,7,8,9,+,-,. }
P={ 
  < Digito > ::= 0|1|2|3|4|5|6|7|8|9 >
  < N. Real > ::= <N. Real c/signo> | < N. Real s/signo >
  < N. Real c/signo > ::= +< N. Real s/signo > | -< N. Real s/signo >
  < N. Real s/signo > ::= <Digito>< N. Real s/signo > | <Digito><Punto>
  < Punto > ::= .< Decimales >
  < Decimales > ::= <Digito> | <Digito>< Decimales >
}
σ*::= < N. Real >
```

## Instrucciones de Ejecución
Desde la carpeta raiz (NumerosReales) ejecutar el siguiente comando desde la consola o terminal:
```
// Windows:
javac -cp src -d bin src\app\App.java && java -cp bin app.App
    
// Linux ó Mac:
javac -cp src -d bin src/app/App.java && java -cp bin app.App
```
