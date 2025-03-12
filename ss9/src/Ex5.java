public class Ex5 {
    public static class Vector2D{
        private  double x;
        private double y;
        public Vector2D(double x, double y){
            this.x = x;
            this.y = y;
        }
        public double calculateMagnitude(){
            return Math.sqrt(x*x+y*y);
        }
        public Vector2D add(Vector2D v) {
            return new Vector2D(this.x + v.x, this.y + v.y);
        }
        public Vector2D subtract(Vector2D v) {
            return new Vector2D(this.x - v.x, this.y - v.y);
        }
        public double dotProduct(Vector2D v) {
            return this.x * v.x + this.y * v.y;
        }
        public void displayVector(){
            System.out.println("("+this.x + "," + this.y+")");
        }
    }
    public static void main(String[] args) {
        Vector2D vt1 = new Vector2D(2,2);
        Vector2D vt2 = new Vector2D(3,3);
        vt1.displayVector();
        vt2.displayVector();
        Vector2D vt3=vt1.add(vt2);
        System.out.println("Tổng 2 vector là:  "+vt3.calculateMagnitude());
        Vector2D vt4=vt1.subtract(vt2);
        System.out.println("Hiệu của 2 vector là: "+vt4.calculateMagnitude());
        System.out.println("Tích vô hương của 2 vector là: "+vt1.dotProduct(vt2));
    }
}