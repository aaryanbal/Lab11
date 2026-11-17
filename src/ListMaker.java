
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<String> lines = new ArrayList<>();
    private static String line = "";

    public static void main(String[] args)
    {
        String menuPrompt = "A - Add   I - Insert  D - Delete  V - View  Q - Quit";
        String cmd = ""; // A D V or Q

        boolean done = false;
        boolean confirmQuit = false;

        do {

            // display the current list
            displayList();
            //
            // get a cmd from the user display the cmd menu in the input prompt
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaIiDdVvQq]");

            cmd = cmd.toUpperCase();
            // execute it

            switch (cmd)
            {
                case "A":
                    addItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "V":
                    viewList();
                    break;
                case "Q":
                    confirmQuit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    if (confirmQuit)
                    {
                        done = true;
                    }
                    break;
            }

        }while(!done);

    }

    private static void insertItem()
    {
        int insertIndex = 0;

        // get an item number for the item to be inserted
        insertIndex = SafeInput.getRangedInt(in, "Enter the number for the insertion", 1, lines.size() + 1);
        // convert the item to an index --
        insertIndex = insertIndex - 1;

        line = SafeInput.getNonZeroLengthString(in, "Enter the new item to add to the list");
        lines.add(insertIndex, line);

    }

    private static void viewList() { displayList(); }

    private static void addItem()
    {
        line = SafeInput.getNonZeroLengthString(in, "Enter the new item to add to the list");
        lines.add(line);
    }

    private static void deleteItem()
    {
        int itemToDelete = 0;

        // get an item number for the item to delete from the user
        itemToDelete = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, lines.size());
        // convert the item to an index --
        itemToDelete = itemToDelete - 1;
        lines.remove(itemToDelete);
    }

    private static void displayList()
    {
        System.out.println("====================================================");
        if(lines.size() > 0)
        {
            int itemNum = 1;
            for(String l:lines)
            {
                System.out.println(itemNum + ". " + l);
                itemNum++;
            }
        }
        else
        {
            System.out.println("Currently, the list is empty!");
        }
        System.out.println("====================================================");
    }
}
