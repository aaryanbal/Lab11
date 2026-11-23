
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
        String cmd = "";

        boolean done = false;
        boolean confirmQuit = false;

        do {

            displayList();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaIiDdVvQq]");

            cmd = cmd.toUpperCase();

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

        insertIndex = SafeInput.getRangedInt(in, "Enter the number for the insertion", 1, lines.size() + 1);
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

        itemToDelete = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, lines.size());
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
