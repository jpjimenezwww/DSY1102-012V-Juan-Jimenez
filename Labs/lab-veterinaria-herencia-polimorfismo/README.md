# DSY1102-012V-Juan-Jimenez
único repositorio para toda la asignatura.



# Lab Veterinaria — Herencia y Polimorfismo (DSY1102)

Laboratorio de Desarrollo Orientado a Objetos: modelar la atención de animales en
una veterinaria usando herencia y polimorfismo en Java.

## Jerarquía de clases
````
Animal                (estado y comportamiento común + validaciones)
├── Mascota           (agrega: dueño)
│   ├── Perro
│   └── Gato
└── Salvaje           (agrega: procedencia)
    ├── Tigre
    └── León
````

## Cómo ejecutar
````bash
cd src
javac *.java
java Main
````

## Conceptos demostrados
- **Herencia:** lo común vive en `Animal`; cada nivel especializa hacia abajo.
- **super():** cada subclase delega en su padre la construcción de la parte común.
- **Polimorfismo:** un mismo mensaje (`atender()`) y cada objeto responde según su
  tipo, sin `if` por especie.

## Documentación
- `docs/01-analisis-problema.md` — conceptos, acciones y reglas.
- `docs/02-algoritmo-atencion.md` — algoritmo inicial de atención.
- `docs/diagramas/interaccion-objetos.md` — diagrama de la interacción polimórfica.
- `evidencias/cierre.md` — comparación y aprendizajes.