import java.util.*;

// Clase para representar una arista
class Edge {
    int source, dest, weight;

    Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFord {

    // Función para ejecutar el algoritmo de Bellman-Ford
    public void bellmanFord(List<Edge> edges, int V, int source, Map<Integer, Character> indexToVertex) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relajación de todas las aristas V-1 veces
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.source] + edge.weight;
                }
            }
        }

        // **Relajar las aristas una vez más** para detectar ciclos negativos
        boolean negativeCycle = false;
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.dest]) {
                distance[edge.dest] = distance[edge.source] + edge.weight;
                negativeCycle = true;
            }
        }

        // Imprimir las distancias (considerando los ciclos negativos)
        System.out.println("Distancias desde el nodo fuente:");
        for (int i = 0; i < V; i++) {
            System.out.println("Distancia al vertice " + indexToVertex.get(i) + ": " + distance[i]);
        }

        // Verificar si algún valor final es negativo y notificar si ocurre
        for (int i = 0; i < V; i++) {
            if (distance[i] < 0) {
                System.out.println("El resultado final tiene un valor negativo en el vertice " + indexToVertex.get(i)
                        + ": " + distance[i]);
                return; // Detener el programa
            }
        }

        // Notificar si se detectó un ciclo negativo pero no afecta al final
        if (negativeCycle) {
            System.out.println("Se detecto un ciclo negativo, pero el resultado final no tiene valores negativos.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada del usuario para el número de vértices y aristas
        System.out.println("Introduce el numero de vertices: ");
        int V = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        Map<Character, Integer> vertexToIndex = new HashMap<>();
        Map<Integer, Character> indexToVertex = new HashMap<>();

        // Entrada del usuario para los vértices (letras)
        System.out.println("Introduce los vertices (letras, uno por uno): ");
        for (int i = 0; i < V; i++) {
            char vertex = scanner.next().charAt(0);
            vertexToIndex.put(vertex, i);
            indexToVertex.put(i, vertex);
        }

        // Entrada del usuario para las aristas
        System.out.println("Introduce el numero de aristas: ");
        int E = scanner.nextInt();

        System.out.println("Introduce las aristas (formato: origen destino peso, usando letras para los vertices): ");
        for (int i = 0; i < E; i++) {
            char sourceVertex = scanner.next().charAt(0);
            char destVertex = scanner.next().charAt(0);
            int weight = scanner.nextInt();
            edges.add(new Edge(vertexToIndex.get(sourceVertex), vertexToIndex.get(destVertex), weight));
        }

        // Entrada del usuario para el nodo fuente
        System.out.println("Introduce el nodo fuente (letra): ");
        char sourceVertex = scanner.next().charAt(0);
        int source = vertexToIndex.get(sourceVertex);

        /// Ejecución del algoritmo de Bellman-Ford
        BellmanFord bf = new BellmanFord();
        bf.bellmanFord(edges, V, source, indexToVertex);

        // Representar el grafo gráficamente usando letras
        GraphPlotter.plotGraph(edges, V, indexToVertex);

    }
}