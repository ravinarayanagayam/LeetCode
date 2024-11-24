class Solution {

    public static HashMap<Integer, Character[]> keyPad = new HashMap<Integer, Character[]>();
    public List<String> result = new ArrayList<String>();
    static {
        keyPad.put(2, new Character[] { 'a', 'b', 'c' });
        keyPad.put(3, new Character[] { 'd', 'e', 'f' });
        keyPad.put(4, new Character[] { 'g', 'h', 'i' });
        keyPad.put(5, new Character[] { 'j', 'k', 'l' });
        keyPad.put(6, new Character[] { 'm', 'n', 'o' });
        keyPad.put(7, new Character[] { 'p', 'q', 'r', 's' });
        keyPad.put(8, new Character[] { 't', 'u', 'v' });
        keyPad.put(9, new Character[] { 'w', 'x', 'y', 'z' });
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        if (null == digits || digits.length() == 0)
            return result;
        generate(0, digits, new StringBuilder());
        return result;
    }

    private void generate(int startPos, String digits, StringBuilder soFar) {
        if (startPos == digits.length()) {
            result.add(soFar.toString());
            return;
        }

        for (Character c : keyPad.get(Integer.parseInt(digits.charAt(startPos) + ""))) {
            soFar.append(c);
            generate(startPos + 1, digits, soFar);
            soFar.deleteCharAt(soFar.length() - 1);
        }

    }
}