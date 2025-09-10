package FuncionesRecursivas

/*
  @author Juan Pablo Escamilla
  @author Paul Weiss
*/

/* ===MÁXIMO USANDO RECURSIÓN LINEAL===
  Para este caso, nos conviene ordenar la lista de mayor a menor para poder retornar el mayor elemento usando l.head
*/
def maxLin(l: List[Int]): Int = {
  if (l.tail.isEmpty) l.head // Si la lista tiene un solo elemento, se retorna el elemento
  else {
    val maximoResto = maxLin(l.tail)  // Se llama a la función recursivamente con la lista sin el primer elemento
    if (l.head > maximoResto) l.head // Si el primer elemento es mayor que el mayor elemento del resto de la lista, se retorna el primer elemento
    else maximoResto // Si el primer elemento es menor que el mayor elemento del resto de la lista, se retorna el mayor elemento del resto de la lista
  }
}

/* ===MÁXIMO USANDO RECURSIÓN LINEAL===
  Para este caso, se define una función recursiva que toma la lista restante y el mayor elemento actual.
  Se calcula el nuevo mayor elemento y se llama a la función recursivamente con la lista restante y el nuevo mayor elemento.
  Se retorna el mayor elemento.
*/
def maxIt(l: List[Int]): Int = {
    def loop(resto: List[Int], maximoActual: Int): Int = { // Se define una función recursiva que toma la lista restante y el mayor elemento actual
    if (resto.isEmpty) maximoActual // Si la lista está vacía, se retorna el mayor elemento actual
    else {
      val nuevoMaximo = if (resto.head > maximoActual) resto.head else maximoActual // Se calcula el nuevo mayor elemento
      loop(resto.tail, nuevoMaximo) // Se llama a la función recursivamente con la lista restante y el nuevo mayor elemento
    }
  }
  loop(l.tail, l.head) // Se llama a la función recursivamente con la lista y el primer elemento como mayor elemento inicial
}

/*
  ===MOVIMIENTOS TORRES DE HANOI===
  Para calcular los movimientos usamos la siguiente lógica, donde T1 es el poste de origen, T2 es el poste 
  auxiliar y T3 es el poste destino:
  - Si hay un solo disco, se mueve directamente de T1 a T3 (1 movimiento = 2^1-1).
  - Si hay dos dicos, se mueve el disco pequeño de T1 a T2, luego el disco grande de T1 a T3, 
  y finalmente el disco pequeño de T2 a T3 (3 movimientos = 2^2-1).
  - Si seguimos ese patron, tendremos la "ecuacion" 2^n-1, donde n es el numero de discos.
  */
def movsTorresHanoi(n: Int): BigInt = {
  if (n == 1) 1 // Caso base: si hay un solo disco, se necesita un solo movimiento
  else 2 * movsTorresHanoi(n - 1) + 1 // Se mueven n-1 discos al poste auxiliar, se mueve el disco más grande al poste destino, y se mueven los n-1 discos del poste auxiliar al poste destino
}

/* ===TORRES DE HANOI===
  La función retorna una lista de tuplas, donde cada tupla representa un movimiento de un disco 
  desde un poste origen a un poste destino.
*/
def torresHanoi(n: Int, t1: Int, t2: Int, t3: Int): List[(Int, Int)] = {
  if (n == 1) List((t1, t3)) // Caso base: si hay un solo disco, se mueve directamente de T1 a T3
  else {
    val parte1 = torresHanoi(n - 1, t1, t3, t2) // Se mueven n-1 discos del poste origen al poste auxiliar
    val moverGrande = List((t1, t3)) // Se mueve el disco más grande del poste origen al poste destino
    val parte2 = torresHanoi(n - 1, t2, t1, t3) // Se mueven n-1 discos del poste auxiliar al poste destino
    parte1 ++ moverGrande ++ parte2 // Se concatenan las listas de movimientos y se retorna la lista completa
  }
}