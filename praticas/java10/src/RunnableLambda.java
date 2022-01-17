class RunnableLambda {
    public static void main(String args[]) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Wow, I'm running!");
            }
        }).start();*/

        new Thread(() -> {
            System.out.println("Wow, I'm running!");
        }).start();
    }
}
