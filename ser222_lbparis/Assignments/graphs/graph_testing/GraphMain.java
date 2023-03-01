package graph_testing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Program for generating kanji component dependency order via topological sort.
 *
 * @author paris, Acuna
 * @version 1.0
 */
public class GraphMain {

    private static final String DATA_KANJI = "data-kanji.txt";
    private static final String DATA_COMPONENTS = "data-components.txt";
    private BetterDiGraph loadedGraph;

    /**
     * Entry point for testing.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GraphMain().run();
    }

    private void run() {
        //TODO: implement this
        loadedGraph = new BetterDiGraph();

        //Freebie: this is one way to load the UTF8 formated character data.
        try {
            BufferedReader indexReader = getBufferedReader(DATA_KANJI);
            HashMap<Integer, Integer> kanjiMap = loadKanji(indexReader);
            indexReader.close();

            System.out.println("Original:");
            for (Integer i : loadedGraph.vertices()) {
                printFormatted(kanjiMap, i);
            }

            indexReader = getBufferedReader(DATA_COMPONENTS);
            loadComponents(indexReader);
            indexReader.close();

            TopologicalSort topologicalSort = new IntuitiveTopological(loadedGraph);

            System.out.println("\nSorted:");
            for (Integer i : topologicalSort.order()) {
                printFormatted(kanjiMap, i);
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private HashMap<Integer, Integer> loadKanji(BufferedReader reader) throws IOException {
        HashMap<Integer, Integer> table = new HashMap<>();

//        String currentLine;
    	// Read first line
        reader.readLine(); 		
        // Set currentLine null
        String currentLine = null;		
        
        
        while ((currentLine = reader.readLine()) != null) {
            if (!currentLine.substring(0, 1).equals("#")) {
                String[] splitString = currentLine.split("\t");

                int id = Integer.parseInt(splitString[0]);
                int kanjiId = Character.codePointAt(splitString[1], 0);
                table.put(id, kanjiId);
                loadedGraph.addVertex(id);
            }
        }

        return table;
    }

    private void loadComponents(BufferedReader reader) throws IOException {
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            if (!currentLine.substring(0, 1).equals("#")) {
                String[] splitString = currentLine.split("\t");

                int v = Integer.parseInt(splitString[0]);
                int w = Integer.parseInt(splitString[1]);

                loadedGraph.addEdge(v, w);
            }
        }
    }

    private BufferedReader getBufferedReader(String filename) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)), StandardCharsets.UTF_8));
    }


    private void printFormatted(HashMap<Integer, Integer> map, int i) {
        System.out.print(String.valueOf(Character.toChars(map.get(i))));
    }
}