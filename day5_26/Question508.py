# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
        def findFrequentTreeSum(self, root):
                    ""
                            :type root: TreeNode
                                    :rtype: List[int]
                                            ""
                                                    if root is None:
                                                                    return []
                                                                
                                                                        dic = {}
                                                                                self.helper(root, dic)
                                                                                        dic = sorted(dic.items(),
                                                                                                key=lambda d: d[1],
                                                                                                reverse=True)
                                                                                                count = dic[0][1]
                                                                                                        ret = []
                                                                                                                for i in
                                                                                                                    range(len(dic)):
                                                                                                                                    co
                                                                                                                                    =
                                                                                                                                    dic[i][1]
                                                                                                                                                if
                                                                                                                                                    co
                                                                                                                                                    ==
                                                                                                                                                    count:
                                                                                                                                                                        ret.append(dic[i][0])
                                                                                                                                                                                    else:
                                                                                                                                                                                                        break
                                                                                                                                                                                                            return
                                                                                                                                                                                                        ret
                                                                                                                                                                                                        
                                                                                                                                                                                                            def
                                                                                                                                                                                                            helper(self,
                                                                                                                                                                                                                    node,
                                                                                                                                                                                                                    dictionary):
                                                                                                                                                                                                                        ret
                                                                                                                                                                                                                        =
                                                                                                                                                                                                                        0;
                                                                                                                                                                                                                                if
                                                                                                                                                                                                                                    node.left
                                                                                                                                                                                                                                    is
                                                                                                                                                                                                                                    not
                                                                                                                                                                                                                                    None:
                                                                                                                                                                                                                                                    ret
                                                                                                                                                                                                                                                    +=
                                                                                                                                                                                                                                                    self.helper(node.left,
                                                                                                                                                                                                                                                            dictionary);
                                                                                                                                                                                                                                                            if
                                                                                                                                                                                                                                                                node.right
                                                                                                                                                                                                                                                                is
                                                                                                                                                                                                                                                                not
                                                                                                                                                                                                                                                                None:
                                                                                                                                                                                                                                                                                ret
                                                                                                                                                                                                                                                                                +=
                                                                                                                                                                                                                                                                                self.helper(node.right,
                                                                                                                                                                                                                                                                                        dictionary);
                                                                                                                                                                                                                                                                                        ret
                                                                                                                                                                                                                                                                                        +=
                                                                                                                                                                                                                                                                                        node.val;
                                                                                                                                                                                                                                                                                                if
                                                                                                                                                                                                                                                                                                    ret
                                                                                                                                                                                                                                                                                                    not
                                                                                                                                                                                                                                                                                                    in
                                                                                                                                                                                                                                                                                                    dictionary.keys():
                                                                                                                                                                                                                                                                                                                    dictionary[ret]
                                                                                                                                                                                                                                                                                                                    =
                                                                                                                                                                                                                                                                                                                    1
                                                                                                                                                                                                                                                                                                                            else:
                                                                                                                                                                                                                                                                                                                                            dictionary[ret]
                                                                                                                                                                                                                                                                                                                                            +=
                                                                                                                                                                                                                                                                                                                                            1
                                                                                                                                                                                                                                                                                                                                                    return
                                                                                                                                                                                                                                                                                                                                                ret"
