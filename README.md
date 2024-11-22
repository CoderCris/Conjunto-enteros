# ConjuntoDeEnteros

Este proyecto forma parte de un ejercicio académico de la asignatura **Programación II** en el **Grado de Ingeniería Informática** en la **ULPGC**. Su propósito es implementar y manipular conjuntos de números enteros en Java, permitiendo explorar operaciones y propiedades básicas de los conjuntos bajo las restricciones definidas en el ejercicio.

## Descripción

La clase `ConjuntoDeEnteros` modela un conjunto de números enteros con un tamaño máximo de 10 elementos. Los conjuntos mantienen la unicidad de sus elementos y proporcionan métodos para realizar operaciones comunes de teoría de conjuntos.

## Funcionalidades

### Creación de Conjuntos
- **Constructor por defecto**: Crea un conjunto vacío.
- **Constructor con parámetros**: Recibe un arreglo de enteros y genera un conjunto eliminando duplicados.

### Métodos Principales
1. **Propiedades del conjunto**:
   - `cardinal()`: Retorna el número de elementos del conjunto.
   - `estáVacío()`: Comprueba si el conjunto está vacío.

2. **Operaciones sobre el conjunto**:
   - `añade(int newValue)`: Agrega un número al conjunto si no está repetido y no excede el límite de tamaño.
   - `pertenece(int value)`: Verifica si un número pertenece al conjunto.
   - `elementos()`: Devuelve un arreglo con los elementos del conjunto.

3. **Operaciones entre conjuntos**:
   - `union(ConjuntoDeEnteros compared)`: Retorna un nuevo conjunto con la unión de los elementos de ambos conjuntos.
   - `interseccion(ConjuntoDeEnteros compared)`: Devuelve un conjunto con los elementos comunes entre dos conjuntos.
   - `diferencia(ConjuntoDeEnteros compared)`: Calcula un conjunto con los elementos exclusivos del conjunto actual.

4. **Comparaciones entre conjuntos**:
   - `equals(ConjuntoDeEnteros compared)`: Compara si dos conjuntos son iguales.
   - `contenido(ConjuntoDeEnteros compared)`: Verifica si todos los elementos del conjunto actual están contenidos en otro conjunto.

### Métodos Auxiliares
- `validoAux(int[] arr, int value)`: Valida la unicidad de un elemento dentro de un arreglo auxiliar (método interno).

## Limitaciones
- **Tamaño fijo**: Cada conjunto puede contener un máximo de 10 elementos.
- **Errores potenciales**: Algunos métodos, como `añade`, pueden presentar problemas en escenarios específicos (índices fuera de rango).

## Propósito Académico

Este proyecto está diseñado para reforzar conocimientos sobre:
- Estructuras de datos (arreglos).
- Validación de datos y unicidad.
- Implementación de métodos en Java orientados a la teoría de conjuntos.
