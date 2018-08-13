public class Question722{
    public List<String> removeComments(String[] source) {
        String[] s = String.join("\n",source).replaceAll("//.*|/\\*(.|\n)*?\\*/", "").split("\n");
        List<String> ans = new ArrayList<>();
        for(String str : s) if(!str.equals("")) ans.add(str);
        return ans;
    }
}
