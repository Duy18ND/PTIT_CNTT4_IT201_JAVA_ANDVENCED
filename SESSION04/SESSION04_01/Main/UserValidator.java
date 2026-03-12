public class UserValidator {
    public boolean isValidUsername(String username){
        //Check nếu null
        if(username == null){
            return false;
        }
        //Kiểm tra ký tự 6-20
        int length = username.length();
        boolean isCorrectLength = length >= 6 && length <= 20;

        //Kiểm tra không chứa khoảng trắng
        boolean noSpace = username.contains("");

        return isCorrectLength && noSpace;
    }
}
