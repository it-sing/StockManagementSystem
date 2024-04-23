package view;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MenuImpl implements Menu  {
    @Override
    public void displayStyle(){
        String text = """
                ┏┓┏┓┏┳┓┏┓┳┓  ┏┓┳┳┓┏┓
                ┃ ┗┓ ┃ ┣┫┃┃  ┗┓┃┃┃┗┓
                ┗┛┗┛ ┻ ┛┗┻┛  ┗┛┛ ┗┗┛                 \s
                """ ;
        System.out.print(text);
    }
    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println("#".repeat(25));
        System.out.println("# Application Menu");
        Table table = new Table(7, BorderStyle.UNICODE_DOUBLE_BOX_WIDE, ShownBorders.SURROUND);
        table.setColumnWidth(0,15,25);
        table.setColumnWidth(1, 15,25);
        table.setColumnWidth(2,15,25);
        table.setColumnWidth(3,15,25);
        table.setColumnWidth(4,15,25);
        table.setColumnWidth(5,15,25);
        table.setColumnWidth(6,15,25);
        table.setColumnWidth(0,15,25);
        table.setColumnWidth(1,15,25);
        table.setColumnWidth(2, 15,25);
        table.setColumnWidth(3,15,25);
        table.setColumnWidth(4,15,25);
        table.setColumnWidth(5,15,25);
        table.setColumnWidth(6,15,25);
        table.addCell("Disp(l)ay");
        table.addCell("| Rando(m)");
        table.addCell("| W)rite");
        table.addCell("| R)ead");
        table.addCell("| (E)dit");
        table.addCell("| D)elete");
        table.addCell("| S)earch");
        table.addCell("Set r(o)w");
        table.addCell("| (C)ommit");
        table.addCell("| Bac(k) up");
        table.addCell("| Res(t)ore");
        table.addCell("| (H)elp");
        table.addCell("| E(x)it");
        System.out.println(table.render());
    }

    @Override
    public void displayExitTable(){
        Table tableExit = new Table(9, BorderStyle.DESIGN_CAFE);
        tableExit.addCell("               GOOD BYE!         ");
        System.out.println(tableExit.render());
    }
    @Override
    public void displayHelpTable(){
        Table tableHelp = new Table(1, BorderStyle.CLASSIC_LIGHT_WIDE,ShownBorders.SURROUND);
        tableHelp.addCell("1.      Press       l : Display product as table");
        tableHelp.addCell("2.      Press       w : Create a new product");
        tableHelp.addCell("3.      Press       r : View product details by code");
        tableHelp.addCell("4       Press       e : Edit an existing product by code");
        tableHelp.addCell("5.      Press       d : Delete an existing product by code");
        tableHelp.addCell("6.      Press       s : Search an existing product by name");
        tableHelp.addCell("6.      Press       o : Set row of data");
        tableHelp.addCell("7.      Press       c : Commit transaction data");
        tableHelp.addCell("8.      Press       k : Backup data");
        tableHelp.addCell("9.      Press       t : Restore data");
        tableHelp.addCell("10.     Press       f : Navigate pagination to the first page");
        tableHelp.addCell("11.     Press       p : Navigate pagination to the previous page");
        tableHelp.addCell("12.     Press       n : Navigate pagination to the next page");
        tableHelp.addCell("13.     Press       l : Navigate pagination to the last page");
        tableHelp.addCell("14.     Press       h : Help");
        tableHelp.addCell("15.     Press       b : Step Back of the Application");
        tableHelp.addCell("16.     Press       x : Exit the Application");
        System.out.println(tableHelp.render());

    }
}
