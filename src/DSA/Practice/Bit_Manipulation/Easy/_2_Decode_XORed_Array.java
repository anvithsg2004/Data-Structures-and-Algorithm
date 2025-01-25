package DSA.Practice.Bit_Manipulation.Easy;

public class _2_Decode_XORed_Array {

    //x=i⊕j
    //x⊕i=(i⊕j)⊕i
    //x⊕i=j
    //j=x⊕i

    public int[] decode(int[] encoded, int first) {

        int n = encoded.length;

        int[] result = new int[n + 1];

        result[0] = first;

        for (int i = 0; i < result.length; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }

        return result;

    }
}
