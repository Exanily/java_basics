public class Arithmetic {
    int a;
    int b;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int multiplication() {
        return a * b;
    }

    public int max() {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public int min() {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
}
