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


def movsTorresHanoi(n: Int): BigInt = {return 0}

def TorresHanoi(n:Int, t1:Int, t2:Int, t3:Int): List[(Int, Int)] = {return null}