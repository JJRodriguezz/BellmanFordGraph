import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import javax.swing.*;
import java.util.List;
import java.util.Map;

public class GraphPlotter {

    // Método para graficar el grafo con los vértices etiquetados por letras
    public static void plotGraph(List<Edge> edges, int V, Map<Integer, Character> indexToVertex) {
        // Crear el grafo
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        // Crear un array para los vértices
        Object[] vertices = new Object[V];

        // Insertar los vértices en el grafo usando las letras en lugar de V0, V1, etc.
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i < V; i++) {
                // Usa la letra correspondiente al índice del vértice
                vertices[i] = graph.insertVertex(parent, null, indexToVertex.get(i), 100 + (i * 50), 100, 30, 30);
            }

            // Insertar las aristas en el grafo
            for (Edge edge : edges) {
                graph.insertEdge(parent, null, edge.weight, vertices[edge.source], vertices[edge.dest]);
            }
        } finally {
            graph.getModel().endUpdate();
        }

        // Crear un componente para mostrar el grafo
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        JFrame frame = new JFrame();
        frame.getContentPane().add(graphComponent);
        frame.setTitle("Representacion del grafo");
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}