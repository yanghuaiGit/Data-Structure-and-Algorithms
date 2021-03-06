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

<p> 树的遍历 </p>
<link href="https://www.zhihu.com/tardis/sogou/art/100059468?ab_signature=CiRBSUNtUDVhaEhRNUxCVkVrdWIybm5WWFBkX2FfREMwYUNZRT0SIGY2MmI3MGJjMjg1YWE2YzVkYmZlNzVlZDdkNTk2ZDg4GhAIARIGNi4zNC4wGgQxOTE2&utm_source=wechat_session&utm_medium=social&utm_oi=772756249275035648">
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
<p>基本条件(特性)</p>
<li>平衡二叉树</li>
<li>每个节点都必须有相同高度的左子树和右子树，如果空子树的高度定义为-1，那么只有具备了2^k-1个节点的理想平衡树满足这个条件</li>
<li>一颗AVL树的每个节点的左子树和右子树的高度最多差1的二叉查找树(空树的高度定义为-1),即左右子树都是AVL树，AVL树左右子树高度之差的绝对不超过1(-1,0,1)</li>
<li>每个节点的高度是其左右子树高度的最大值＋1</li>


<h3>为了保证AVL树在插入之后仍然是平衡的，需要进行修正，即进行旋转操作</h3>
<p>旋转右4种情况:</p>
<li>左左: 单旋转</li>
<li>左右: 双旋转</li>
<li>右左: 双旋转</li>
<li>右右: 单旋转</li>

<h4>单旋转</h4> 
<P>左左 右右使用单旋转，可使得平衡树平衡</P>
左旋转使得左边高的节点变低，右边高一个节点
<h4>双旋转</h4>
<P>左右 右左适合使用双旋转，可使得平衡树平衡</P>
<li>左右:其实是先左旋转，使得转变为左左情况，再使用右旋转</li>
<li>右左:其实是先右旋转，使得转变为右右情况，再使用左旋转</li>

<a href="https://www.jianshu.com/p/65c90aa1236d"> 比较好的一份平衡树解析博客 </a>
<p></p>
<a href="https://github.com/yanghuaiGit/Data-Structure-and-Algorithms/blob/master/src/main/resources/static/Snipaste_2020-04-09_08-33-31.jpg">双旋转过程</a>
<h2>B树</h2>
<a href="https://blog.csdn.net/qq_26222859/article/details/80631121"> 比较好的一份B+树博客 </a>

<h3>B-树</h3>
<p>B-树定义</p>
<Li>任意非叶子节点最多只有M个儿子，且M>2</Li>
<Li>根节点的儿子树为[2，M]</Li>
<Li>除根节点以外的非叶子节点的儿子数为[M/2,2]向上取整</Li>
<Li>非叶子节点的关键字个数=儿子数-1</Li>
<Li>所有叶子节点位于同一层</Li>
<Li>K个关键字把节点拆成K+1段，分别指向K+1个儿子，同时满足查找树的大小关系</Li>

<p>B-树的特性</p>
<li>关键字集合分布在整棵树中</li>
<li>任何一个关键字有且只出现在一个节点中</li>
<li>搜索可能在非叶子节点结束</li>
<li>其搜搜性能等价于在关键字全集内做一次二分查找</li>

<h3>B+树</h3>
<li>有n颗子树的非叶节点中含有n个关键字(b树是n-1个),这些关键字不保存数据，只用来索引，所有数据都保存在叶子节点(B树是每个关键字都保存数据)</li>
<li>所有的叶子节点中包含了全部关键字的信息，及指向含有这些关键字记录的指针，且叶子节点本身以关键字的大小自小而大顺序连接</li>
<li>所有的非叶子节点可以看成是索引部分,节点中仅含其子树中最大(或最小关键字</li>
<li>同一个数字会在不同节点中重复出现，根节点的最大元素就是b+树的最大元素</li>

<P>B+树说的M阶，M代表的是一个非叶子节点的最大关键字数量，也是其最大的子树个数</P>

<h3>B+树相对于B-树的查询优势</h3>
<li>B+树中间节点不保存数据，所以磁盘页能容纳更多节点元素，更加矮胖</li>
<li>B+树查询必须查询到叶子节点，B树只需要匹配到即可，不需要管元素位置，因此B+树更加稳定</li>
<li>对于范围查找来说，B+树只需要遍历叶子节点链表即可，而B树却需要进行中序遍历</li>




