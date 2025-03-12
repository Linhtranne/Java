public class Ex3 {
    public static class Rectangle {
        private int width;
        private int height;
        public Rectangle(int width, int height) {
            this.width = width ;
            this.height = height ;
        }

        public Rectangle() {
            this.height=1;
            this.width=1;
        }

        public int  Area(){
            return width * height;
        }
        public int Perimeter(){
            return  (width + height)*2;
        }
        public void display(){
            System.out.println("Chiều dài: "+ width);
            System.out.println("Chiều rộng: "+ height);
            System.out.println("Diện tích: "+ Area());
            System.out.println("Chu vi: "+ Perimeter());
        }
    }
    public static void main(String[] args) {
        Rectangle a = new Rectangle(10,10);
        Rectangle b= new Rectangle();
        b.display();
        a.display();
    }
}