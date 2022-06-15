public class BruteForceAttacker extends Thief {
    
    /**
     * Function for searching password with brute forse
     * 
     * @param sizeOfPassword This is the size of password that needs to be guessed
     * @return Nothing
     */
    @Override
    public void breakPassword(int sizeOfPassword) {
        char[] arr = getCharacters();  // array of symbols password is made of
        char[] pass = new char[sizeOfPassword];  // password we try to find

        if (sizeOfPassword == 0) {
            tryOpen(pass);
        } else {
            for (int i = 0; i < arr.length; i++) {
                pass[0] = arr[i];
                if (bruteForceTry(1, pass, arr)) {
                    return;
                }
            }
        }
    }

    /**
     * Recursive function for searching and trying password variotions with first given character
     * 
     * @param index This is the index of place the function starts to guess with
     * @param pass This is the password that needs to be guessed
     * @param arr This is the array with symbols in passwords 
     * @return true if password is guessed false otherwise
     */
        public boolean bruteForceTry(int index, char[] pass, char[] arr) {
        if (index == pass.length) {
            return tryOpen(pass);
        }
        for (int i = 0; i < arr.length; i++) {
            pass[index] = arr[i];
            if (bruteForceTry(index+1, pass, arr)) {
                return true;
            }
        }
        return false;
    }
}
