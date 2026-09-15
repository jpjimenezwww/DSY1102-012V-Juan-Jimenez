# Interacción polimórfica: la veterinaria atendiendo animales

La veterinaria recibe animales de distintas especies, pero **no los trata caso
por caso**: los guarda a todos como `Animal` y a cada uno le envía el mismo
mensaje, `atender()`. Cada objeto concreto decide en tiempo de ejecución cómo se
atiende, según lo que corresponde a su tipo. Así, agregar una especie nueva no
obliga a reescribir el proceso de atención.

SECUENCIA

    participant V as Veterinaria
    participant P as perro : Perro
    participant G as gato : Gato
    participant T as tigre : Tigre
    participant L as leon : Leon

    Note over V,L: La veterinaria recorre su lista sin preguntar la especie:<br/>for (Animal a : animales) a.atender();

    V->>P: atender()
    activate P
    P-->>V: atención estándar (consulta y aviso al dueño)
    deactivate P

    V->>G: atender()
    activate G
    G-->>V: atención estándar (consulta y aviso al dueño)
    deactivate G

    V->>T: atender()
    activate T
    T-->>V: atención con protocolo de seguridad (salvaje peligroso)
    deactivate T

    V->>L: atender()
    activate L
    L-->>V: atención con protocolo de seguridad (salvaje peligroso)
    deactivate L
```

## Por qué esto es polimorfismo
- **Un solo mensaje:** la veterinaria llama `atender()` igual para los cuatro.
- **Sin preguntar el tipo:** no hay `if (es mascota) ... else if (es salvaje)`;
  el objeto real resuelve su comportamiento.
- **La diferencia nace de la jerarquía:** `Perro` y `Gato` heredan la atención de
  `Mascota`; `Tigre` y `León`, la de `Salvaje`. Por eso mascotas y salvajes
  responden distinto aunque la llamada sea la misma.
- **Extensible:** sumar un `Conejo` o un `Puma` no cambia ni una línea del
  proceso de la veterinaria.