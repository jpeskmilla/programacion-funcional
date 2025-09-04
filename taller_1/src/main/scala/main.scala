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
  return l.head //Se retorna el mayor elemento
}

/* ===MÁXIMO USANDO RECURSIÓN LINEAL===
*/
def maxIter(l: List[Int]): Int = {

}