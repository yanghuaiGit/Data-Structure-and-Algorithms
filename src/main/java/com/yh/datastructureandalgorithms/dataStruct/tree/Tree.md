<h1>树</h1>

数组是一种线性表数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据

<h3>基本概念</h3>
    <li>高度：节点到叶子节点的最长路径</li>
    <li>深度: 根节点到这个节点所经历的边的个数</li>
    <li>层数: 节点的深度+1</li>
    树的高度等于根节点的高度
<p></p>  
<h2>树的分类</h2>                                                                                           
    <h3>满二叉树</h3>
        <p>除了叶子节点之外，每个节点都有左右2个子节点，这种二叉树叫做满二叉树</p>
    <h3>完全二叉树</h3>
        <p>叶子节点都在最底下两层，最后一层的叶子节点都靠左排列，并且除了最后一层，其他层的节点个数都要达到最大，这种二叉树叫作完全二叉树</p>
     <h3>顺序存储法</h3>
     <p> 基于数组的顺序存储法:如果节点X存储在数组中下标为i的位置，下标为2*i的位置存储的就是左子节点，下标为2*i+1的位置存储的右子节点，反过来下标为i/2的位置存储的就是它的父节点</p>
    如果是一颗完全二叉树，那用数组存储无疑是最节省内存的一种方式，因为数组的存储方式并不需要像链式一样存储额外的左右子节点指针
<p></p>
<h3>二叉树的遍历</h3>
<ul>
    <li>前序遍历</li>
    <li>中序遍历</li>
    <li>后序遍历</li>
</ul>

<h3>递推公式<h3>
````
  <p>前序遍历: 对于树中的任意节点，先遍历这个节点，再遍历左子树最后打印右子树</p>
  <P>中序遍历: 对于树中的任意节点，先遍历左子树，再打印节点，最后打印右子树</P>
  <P>后序遍历: 对于树中的任意节点,先遍历左子树，再遍历右子树，最后遍历中间节点</p>
````
<h3>代码</h3>
````

void preOrder(Node* root) {
  if (root == null) return;
  print root // 此处为伪代码，表示打印root节点
  preOrder(root->left);
  preOrder(root->right);
}

void inOrder(Node* root) {
  if (root == null) return;
  inOrder(root->left);
  print root // 此处为伪代码，表示打印root节点
  inOrder(root->right);
}

void postOrder(Node* root) {
  if (root == null) return;
  postOrder(root->left);
  postOrder(root->right);
  print root // 此处为伪代码，表示打印root节点
}

````
<h2>二叉查找树</h2>
二叉查找树要求在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
<p></p>
<h3>AVL 带有平衡条件的二叉查找树</h3>
<p>基本条件</p>
<li>平衡二叉树</li>
<li>每个节点都必须有相同高度的左子树和右子树，如果空子树的高度定义为-1，那么只有具备了2^k-1个节点的理想平衡树满足这个条件</li>
<li>一颗AVL树的每个节点的左子树和右子树的高度最多差1的二叉查找树(空树的高度定义为-1),即左右子树都是AVL树，AVL树左右子树高度之差的绝对不超过1(-1,0,1)</li>

<h3>为了保证AVL树在插入之后仍然是平衡的，需要进行修正，即进行旋转操作</h3>
<p>旋转右4种情况:</p>
<li>左左: 单旋转</li>
<li>左右: 双旋转</li>
<li>右左: 双旋转</li>
<li>右右: 单旋转</li>

<h4>单旋转</h4> 
<P></P>
<p>每个节点的高度是其左右子树高度的最大值＋1</p>



<h2>B树</h2>







