/*
 ============================================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.01.23 (Question2)
 Link : http://www.geeksforgeeks.org/amazon-interview-experience-set-170/
 Description : http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define NULL 0

// A Binary Tree Node
struct Node {
	int data;
	struct Node *left, *right;
} typedef Node;

Node* newNode(int data) {
	Node* node = (Node*) malloc(sizeof(Node));
	if (node == NULL) {
		return NULL;
	}
	node->data = data;
	node->left = node->right = NULL;
	return node;
}

// Recursive function to find level of Node 'ptr' in a binary tree
int getNodeLevel(Node* root, Node* ptr, int level) {
	// base cases
	if (root == NULL)
		return 0;
	if (root == ptr)
		return level;

	// Return level if Node is present in left subtree
	int result = getNodeLevel(root->left, ptr, level + 1);
	if (result != 0)
		return result;

	// Else search in right subtree
	return getNodeLevel(root->right, ptr, level + 1);
}

// Recursive function to find parent node of 'ptr' in a binary tree
Node* getNodeParent(Node* root, Node* ptr, Node* parent) {
	if (root == NULL) {
		return NULL;
	}

	if (root == ptr) {
		return parent;
	}

	// Sets parent node
	parent = root;

	Node* result = getNodeParent(root->left, ptr, parent);
	if (result != NULL) {
		return result;
	}

	result = getNodeParent(root->right, ptr, parent);
	if (result != NULL) {
		return result;
	}

	return NULL;
}

// Two nodes are cousins of each other if they are at same level and have different parents.
int isCousin(Node* root, Node* a, Node* b) {
	int levelOfA = getNodeLevel(root, a, 0);
	int levelOfB = getNodeLevel(root, b, 0);

	if (levelOfA == levelOfB) {
		Node* parentOfA = getNodeParent(root, a, NULL);
		Node* parentOfB = getNodeParent(root, b, NULL);
		if (parentOfA == parentOfB) {
			return FALSE;
		} else {
			return TRUE;
		}
	} else {
		return FALSE;
	}
}

// Returns true if node exists in given binary tree
int isNodeInBinaryTree(Node* root, Node* a) {
	if (root) {
		if (root == a) {
			return TRUE;
		} else {
			return isNodeInBinaryTree(root->left, a)
					|| isNodeInBinaryTree(root->right, a);
		}
	}
	return FALSE;
}

// Driver Program to test above functions
int main() {

/*
 * Below is sample binary tree.
		  1
	  2      3
	4  5  6   7
		15  8
 */

	Node *root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->left->right->right = newNode(15);
	root->right->left = newNode(6);
	root->right->right = newNode(7);
	root->right->left->right = newNode(8);

	Node *Node1, *Node2;
	Node1 = root->left->left;
	Node2 = root->right->left->right;

	if(isCousin(root, Node1, Node2)) {
		printf("Yes\n");
	} else {
		printf("No\n");
	}

	return 0;
}
