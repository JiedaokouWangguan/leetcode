import java.util.ArrayDeque;

public class Question449{

    // 8.44
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {          
        StringBuilder sb = new StringBuilder();       
        genString(root, sb);                          
        String result = sb.toString();                
        return result.substring(0, result.length()-1);
    }                                                 

    private void genString(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("#,");
            return;
        }           
        sb.append(root.val+",");                      
        genString(root.left, sb);                     
        genString(root.right, sb);                    
    }                                                 

    // Decodes your encoded data to tree.             
    public TreeNode deserialize(String data) {        
        String[] tokens = data.split(",");            
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(String token : tokens) queue.offer(token);
        return restoreTree(queue);                    
    }                                                 

    private TreeNode restoreTree(ArrayDeque<String> queue){                                                                
        String s = queue.poll();                      
        if(s.equals("#")) return null;                
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = restoreTree(queue);               
        node.right = restoreTree(queue);              
        return node;                                  
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
