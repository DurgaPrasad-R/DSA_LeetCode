class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0,high = s.length() - 1;
        while (low<=high){
            if ((Character.toLowerCase(chars[low]) == 'a' || Character.toLowerCase(chars[low]) == 'e' || Character.toLowerCase(chars[low]) == 'i' || Character.toLowerCase(chars[low]) == 'o' || Character.toLowerCase(chars[low]) == 'u') && (Character.toLowerCase(chars[high]) == 'a' || Character.toLowerCase(chars[high]) == 'e' || Character.toLowerCase(chars[high]) == 'i' || Character.toLowerCase(chars[high]) == 'o' || Character.toLowerCase(chars[high]) == 'u')){
                char temp = chars[low];
                chars[low] = chars[high];
                chars[high] = temp;
                low++;
                high--;
            }
            else if ((Character.toLowerCase(chars[low]) != 'a' && Character.toLowerCase(chars[low]) != 'e' && Character.toLowerCase(chars[low]) != 'i' && Character.toLowerCase(chars[low]) != 'o' && Character.toLowerCase(chars[low]) != 'u') && (Character.toLowerCase(chars[high]) != 'a' && Character.toLowerCase(chars[high]) != 'e' && Character.toLowerCase(chars[high]) != 'i' && Character.toLowerCase(chars[high]) != 'o' && Character.toLowerCase(chars[high]) != 'u')){
                low++;
                high--;
            } else if (Character.toLowerCase(chars[low]) != 'a' && Character.toLowerCase(chars[low]) != 'e' && Character.toLowerCase(chars[low]) != 'i' && Character.toLowerCase(chars[low]) != 'o' && Character.toLowerCase(chars[low]) != 'u') {
                low++;
            } else {
                high--;
            }
        }
        return String.valueOf(chars);
    }
}