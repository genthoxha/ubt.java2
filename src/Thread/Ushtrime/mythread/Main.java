package Thread.Ushtrime.mythread;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        ThreadIm threadIm = new ThreadIm("Threadi im");
        threadIm.start();

        String inputValue = null;

        do {
            inputValue = JOptionPane.showInputDialog("Shtyp exit per te mundesuar perfundimin e aplikacionit");
        }
        while (!inputValue.toUpperCase().equals("EXIT"));
        System.out.println("Threadi (" + threadIm.getName() + ") eshte gjalle? : " + threadIm.isAlive());
        threadIm.nok();

        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("TANI a eshte threadi (" + threadIm.getName() + ") gjalle? : " + threadIm.isAlive());
    }
}
