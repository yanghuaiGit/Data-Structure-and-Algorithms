<h1>堆</h1>

堆是一种特殊的完全二叉树

<h3>基本概念</h3>
<h4>结构性质</h4>
<Li>是一颗完全二叉树</Li>    
<h4>堆序性质</h4>
    <li>堆中的每一个节点的值都必须大于或(小于等于)其子树中的每个节点的值</li>
    如果每个节点的值大于等于子树的每个节点值的堆，称作 "大顶堆"<br/>
    如果每个节点的值小于等于子树的每个节点值的堆，称作 "小顶堆"
<p></p>  
<h2>堆的基本操作</h2> 
完全二叉树比较适合用数组来存储，用数组来存储完全二叉树是非常节省空间的，
因为不需要存储左右子节点的指针，单纯地通过数组的下标，就可以找到一个节点的左右子节点和父节点。                                                                                          
<p></p>
为了保证插入和删除能继续保证堆得特性，需要进行堆化，分为2种
<li>从下往上(上滤): 顺着节点所在的路径，向上对比进行交换</li>
<li>从上往下(下滤): 顺着节点所在的路径，向下对比进行交换</li>
<h4>添加操作</h4>
添加操作会涉及到上面的上滤逻辑，将插入的节点作为堆得下一个可用的位置，然后进行上滤
   <p></p>
<h3>删除堆顶元素</h3>
涉及到下滤: 将最后一个节点放到堆顶，利用父子节点对比，下沉到正确位置即可

<h3>时间复杂度</h3>
一个包含n个节点的完全二叉树，树的高度不会超过Log n。堆化的过程是顺着节点所在路径比较交换的，
所以堆化的时间复杂度和树的高度成正比，也就是O(long n)。
</br>
借助堆进行排序，叫做堆排序，这种排序方法的时间复杂度非常稳定，是O(nlog n),并且还是原地排序算法
堆排序的过程大致分解为
<li>建堆</li>
<li>排序</li>
<p></p>
<h4>建堆</h4>
<li>n个数据就进行n次的插入，从前往后进行插入，进行上滤操作</li>
<li>从后向前处理数组，每个数据都是从上往下堆化</li>
<p></p>
一般采用第二种方式，因为从上往下进行堆化，只需要对非叶子节点进行操作就行，叶子节点是不会进行堆化处理的，
和第一种从下往上堆化相比至少节约了一般的操作，第一种n个数据就需要对n个数据进行堆化处理
<br/>
时间复杂度: 因为叶子节点不需要堆化，所以需要堆化的节点从倒数第二层开始，每个节点堆化的过程中，
需要比较和交换的节点个数，跟这个节点的高度成正比，最终计算时间复杂度为O(n)
<img src="https://static001.geekbang.org/resource/image/89/d5/899b9f1b40302c9bd5a7f77f042542d5.jpg">
<h4>排序</h4>
建堆结束之后，数组中的数据已经是按照大顶堆的特性来组织。数组中的第一个元素就是堆顶，也就是最大的元素。
将这个元素和最后一个元素进行交换，那最大的元素放到了下标为n的位置
<br/>
这个过程有点类似 删除堆顶元素 的操作，当堆顶元素移出之后，我们把下标为n的元素放到堆顶，然后再通过堆化的方式，
将剩下的n-1个元素重新构建成堆。堆化完成之后，我们再取堆顶的元素放入n-1的位置，一直重复即可
<br/>
时间复杂度:堆排序的过程,只需要极个别临时存储空间，所以堆排序是原地排序算法。堆排序包括建堆和排序两个操作，
建堆过程的时间复杂度是O(n)，排序过程的时间复杂度是O(nlog n)所以堆排序的时间复杂度为O(nlog n)
 <br/>堆排序不是未定的排序算法，因为在排序的过程中，存在将堆的最后一个节点跟堆顶节点互换的操作，所以就有可能改变值相同数据的原始相对位置


<h4>堆排序的应用</h4>
<li>优先级队列:PriorityQueue</li>
<li>top k</li>
<li>流里面的中值</li>
<li>流里面的中位数</li>