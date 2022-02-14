package assemblyline;

/**
* Lab4 Programming. Based on the description
* you can find in text.docx file in the parent folder.
*
* @author  Dimitri Sukhankin
* @since   2022-02-14 
*/
public class Main {
    public static void main(String[] args) {
        try {
            FileManager.loadSave("default.json");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}