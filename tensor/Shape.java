package tensor;

public class Shape {
    private int[] dims;
    /*dimension array */

    public Shape(int[] dims) {
        this.dims = dims;
    }

    public int[] getDims() {
        return dims;
    }

    public int rows() {
        return dims[0];
    }

    public int cols() {
        return dims[1];
    }

    public int size() {
        int size = 1;
        for (int dim : dims) {
            size *= dim;
        }
        return size;
    }

    
}
