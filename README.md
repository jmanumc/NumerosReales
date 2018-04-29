# Generador de Numeros Reales
Programa de para generar números reales, a partir de la siguiente gramatica:

La gramática __G = (N, T, P, σ*)__, genera todos los números reales.

**N={**<Digito>,<N. Real>,<N. Real c/signo>,< N. Real s/signo >,<Punto>,<Decimales>**}**

**T={** 0,1,2,3,4,5,6,7,8,9,+,-,. __}__

**P={**

< Digito > ::= 0|1|2|3|4|5|6|7|8|9

< N. Real > ::= <N. Real c/signo> | < N. Real s/signo >

< N. Real c/signo > ::= +< N. Real s/signo > | -< N. Real s/signo >

< N. Real s/signo > ::= <Digito>< N. Real s/signo > | <Digito><Punto>

< Punto > ::= .< Decimales >

< Decimales > ::= <Digito> | <Digito>< Decimales >

**}**

__σ*__ ::= < N. Real >
