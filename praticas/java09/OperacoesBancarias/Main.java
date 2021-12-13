class Conta {
    private float saldo;

    public Conta() {
        saldo = 0f;
    }

    public Conta(float inicial) {
        saldo = inicial;
    }

    public float saldo() {
        return saldo;
    }

    // public synchronized void deposita(float valor) {
    public void deposita(float valor) { // errado
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        saldo = saldo + valor;
    }

    // public synchronized void retira(float valor) {
    public void retira(float valor) { // errado
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        saldo = saldo - valor;
    }
}

class ThreadDeposita extends Thread {
    private Conta c;

    ThreadDeposita(Conta c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {// faz 10 depositos de 100
            c.deposita(100f);
        }
    }
}

class ThreadRetira extends Thread {
    private Conta c;

    ThreadRetira(Conta c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {// faz 5 retiradas de 50
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.retira(50f);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Conta c = new Conta(100f);

        ThreadDeposita td = new ThreadDeposita(c);
        ThreadRetira tr = new ThreadRetira(c);

        td.start();
        tr.start();
        try {
            td.join();
            tr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Saldo da conta: " + c.saldo());
    }
}
