
class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {

        // If node is NULL or value is found
        if (root == NULL || root->val == val) {
            return root;
        }

        // Search in left subtree
        if (val < root->val) {
            return searchBST(root->left, val);
        }

        // Search in right subtree
        return searchBST(root->right, val);
    }
};
