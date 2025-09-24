public class Main {
    public static void main(String[] args) {
        String file1;
        String file2;
        System.out.print( "Enter file name containing Core program: ");
        file1 = System.console().readLine();
        System.out.print( "Enter file name containing input data: ");
        file2 = System.console().readLine() + "/data";
        Tokenizer.initialize(file1);
        Buffer.initialize(file2);


        Prog prog = new Prog();
        prog.parseProg();
        prog.printProg();
        prog.execProg();
        
    }
}
