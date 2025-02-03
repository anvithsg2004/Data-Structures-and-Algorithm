package DSA.Strings;

public class _10_Integer_to_Roman {

    public String RoMaN(int c) {
        switch (c) {
            case 1000:
                return "M";
            case 2000:
                return "MM";
            case 3000:
                return "MMM";
            case 900:
                return "CM";
            case 800:
                return "DCCC";
            case 700:
                return "DCC";
            case 600:
                return "DC";
            case 500:
                return "D";
            case 400:
                return "CD";
            case 300:
                return "CCC";
            case 200:
                return "CC";
            case 100:
                return "C";
            case 90:
                return "XC";
            case 80:
                return "LXXX";
            case 70:
                return "LXX";
            case 60:
                return "LX";
            case 50:
                return "L";
            case 40:
                return "XL";
            case 30:
                return "XXX";
            case 20:
                return "XX";
            case 10:
                return "X";
            case 9:
                return "IX";
            case 8:
                return "VIII";
            case 7:
                return "VII";
            case 6:
                return "VI";
            case 5:
                return "V";
            case 4:
                return "IV";
            case 3:
                return "III";
            case 2:
                return "II";
            case 1:
                return "I";
            default:
                return "";
        }
    }

    // Method to convert integer to a Roman numeral
    public String intToRoman(int num) {
        String roman = "";

        int thousands = (num / 1000) * 1000;
        num %= 1000;
        int hundreds = (num / 100) * 100;
        num %= 100;
        int tens = (num / 10) * 10;
        num %= 10;
        int single = num;

        roman += RoMaN(thousands);
        roman += RoMaN(hundreds);
        roman += RoMaN(tens);
        roman += RoMaN(single);
        return roman;
    }
}
