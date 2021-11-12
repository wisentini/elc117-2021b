package br.ufsm.leagueoflanguages;

public class AppGUI {
    public static void main(String[] args) throws Exception {
        AppGUIView view = new AppGUIView();
        AppGUIController controller = new AppGUIController(view);

        controller.init();
    }
}
