package Practice1;

public class Validate {
    public boolean validateId(String newId){

        if(!newId.matches("^B.{3}$")){
            System.err.println("Id không hợp lệ");
            return false;
        }
        if(!Main.listBook.contains(newId)){
            return true;
        }
        System.err.println("Không được trùng lặp id");
        return false;
    }
    public  boolean validateName(String newName){

        if(!Main.listBook.contains(newName)){
            return true;
        }
        System.err.println("Không được trùng lặp tên sách");
        return false;
    }
    public  boolean validateAuthor(String newAuthor){
        if(newAuthor.length()>6 &&  newAuthor.length()<50){
            return true;
        }
        return false;
    }
    public  boolean validateYear(double newYear){
        return newYear>2000;
    }
}