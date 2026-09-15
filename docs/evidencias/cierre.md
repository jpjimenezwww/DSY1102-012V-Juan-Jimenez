# Cierre: cómo cambió mi forma de resolver el problema

## Algoritmo inicial vs. solución final
Al principio pensé la atención como una lista de pasos, uno tras otro. Ahí habría
tenido que preguntar el tipo de animal con `if (mascota) … else if (salvaje) …` cada
vez que el trato cambiaba. Con objetos fue distinto: el tipo de animal **es la clase**,
y cada animal sabe cómo atenderse. La veterinaria manda un solo mensaje y cada uno
responde solo, sin preguntar "¿qué tipo eres?".

## Herencia
Puse lo común en `Animal` (nombre, especie, edad, peso, estado, validaciones).
`Mascota` y `Salvaje` agregan su dato propio (dueño / procedencia), y las especies
agregan su sonido. Cada clase escribe solo lo nuevo, así no repito código.

## super()
Cada subclase llama a `super(...)` para que `Animal` inicialice y valide la parte
común. Gracias a eso las validaciones (nombre no vacío, peso > 0…) las escribí una
sola vez.

## Polimorfismo
Trato a todos como `Animal` y les mando el mismo mensaje `atender()`. Java mira el
objeto real y ejecuta la versión que corresponde, por eso el `main` no tiene ningún
`if` de tipo.

## Qué mejoraría
- Hacer `Animal` abstracta, para no poder crear un animal genérico.
- Sacar el `String tipo`, que es redundante porque la clase ya dice el tipo.
- Crear una clase `Veterinaria` con la lista de animales, para no dejar eso en el `main`.