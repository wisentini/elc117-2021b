import java.io.*;

class ExceptionExample1 {
    public static void main(String[] args) {
        Integer i = null;
        float f = i.floatValue();
        System.out.println(f);
        System.out.println("End");
    }
}

class ExceptionExample2 {
    public static void main(String[] args) {
        try {
            Integer i = null;
            float f = i.floatValue();
            System.out.println(f);
        } catch (NullPointerException e) {
            System.out.print("Caught! ");
        }
        System.out.println("End");
    }
}

class ExceptionExample3 {
    public static void main(String[] args) {
        try {
            Integer i = null;
            float f = i.floatValue();
            System.out.println(f);
        } catch (NullPointerException e) {
            System.out.print("Caught! ");
            return;
        }
        System.out.println("End");
    }
}

class ExceptionExample4 {
    public static void main(String[] args) {
        try {
            Integer i = null;
            float f = i.floatValue();
            System.out.println(f);
        } catch (NullPointerException e) {
            System.out.print("Caught! ");
            return;
        } finally {
            System.out.println("Finally");
        }
        System.out.println("End");
    }
}

class ExceptionExample5 {
    public static void main(String[] args) {
        Integer.parseInt("a");
        System.out.println("End");
    }
}

class ExceptionExample6 {
    public static void main(String[] args) {
        try {
            Integer.parseInt("a");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
        }
        System.out.println("End");
    }
}

// class CheckedExceptionError {
// public static void main(String args[]) {
// FileInputStream is = null;
// is = new FileInputStream("notfound.txt");
// int i;
// while ((i = is.read()) != -1) {
// System.out.print((char) i);
// }
// is.close();
// }
// }

class CheckedExceptionTryCatch {
    public static void main(String args[]) {
        FileInputStream is = null;
        
        try {
            is = new FileInputStream("notfound.txt");
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            // e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        } finally {
            System.out.println("Finally!");
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                }
            }
        }
    }
}

class CheckedExceptionThrows {
    public static void main(String args[]) throws IOException {
        FileInputStream is = null;
        is = new FileInputStream("notfound.txt");
        int i;

        while ((i = is.read()) != -1) {
            System.out.print((char) i);
        }
        
        is.close();
    }
}
