private boolean contains(String s, String pattern) {
        char[] arrS = s.toCharArray();
        char[] arrPattern = pattern.toCharArray();
        int[] table = buildKMPtable(pattern);
        int i = 0; int j = 0;
        
        while (i < s.length()) {
            if (arrS[i] == arrPattern[j]) {
                i++; j++;
            } 
            if (j >= pattern.length()) {
                return true;
            }
            if (i < s.length() && arrS[i] != arrPattern[j]) {
                if (j != 0) j = table[j - 1];
                else i++;
            }
        }
        return false;
    }
    
    private int[] buildKMPtable(String pattern) {
        char[] arr = pattern.toCharArray();
        int[] table = new int[arr.length];
        
        int i = 0; int j = 1;
        
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                table[j] = i + 1;
                i++; j++;
            } else {
                if (i != 0) i = table[i - 1];
                else {
                    table[j] = i;
                    j++;
                }
            }
        }
        
        return table;
    }
}