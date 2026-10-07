package Lab2.ex4;

public class Validator {
    Validator(){}

    private static final String approvedStarters_ = "1256";
    private static final int[] controlNumber_ = new int[]{2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};

    public static boolean validateCnp(String cnp)
    {
        if(cnp.length() !=13) {
            System.out.println("Lungime necorespunzatoare!");
            return false;
        }
        if(approvedStarters_.indexOf(cnp.toCharArray()[0]) == -1) {
            System.out.println("Cifra de inceput "+cnp.toCharArray()[0]+" e necoresnpunzatoare!");
            return false;
        }
        for(var cifra : cnp.toCharArray()){
            if(!Character.isDigit(cifra)) {
                System.out.println("CNP-ul trebuie sa contina doar cifre");
                return false;
            }
        }
        return validateControlDigit(cnp);
    }

    private static boolean validateControlDigit(String cnp){
        var cifra = cnp.toCharArray()[cnp.length()-1];
        cnp = cnp.substring(0,cnp.length()-1);
        var sum =0;
        int index = 0;
        for (var digit : cnp.toCharArray()) {
            sum+= (digit-'0') * controlNumber_[index];
            index++;
        }
        var result = sum%11;
        if (result == 10 ) result =1;
        return cifra -'0' == result;
    }
}
