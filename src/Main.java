import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main (String [] args ){

        BinaryTree tree = new BinaryTree ();
 
        tree.insert ( 5 );
        tree.insert ( 3 );
        tree.insert ( 7 );
        tree.insert( 4 );
        tree.insert ( 6 );
        tree.insert ( 8 );

        try (FileWriter file = new FileWriter("arvore.json")) {
            file.write(tree.toJson());
            System.out.println("Arquivo JSON gerado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}