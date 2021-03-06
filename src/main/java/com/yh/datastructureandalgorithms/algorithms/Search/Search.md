<h2>如何用最省内存的方式实现快速查找功能？</h2>
<p>针对有序数据集合的查找算法：二分查找(Binary Search)算法，也叫折半查找算法。</p>
<p>二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半
，直到找到要查找的元素，或者区间被缩小为0</p>
<h2>O(logn)惊人的查找速度</h2>
分析时间复杂度
<p>假设数据大小是 n，每次查找后数据都会缩小为原来的一半，也就是会除以 2。最坏情况下，直到查找区间被缩小为空，才停止。</p>
<img src="https://static001.geekbang.org/resource/image/d1/94/d1e4fa1542e187184c87c545c2fe4794.jpg"/>
可以看出来，这是一个等比数列。其中 n/2<sup>k</sup>=1 时，k 的值就是总共缩小的次数。而每一次缩小操作只涉及两个数据的大小比较，所以，经过了 k 次区间缩小操作，
时间复杂度就是 O(k)。通过 n/2<sup>k</sup>=1，我们可以求得 k=log2<sup>n</sup>，所以时间复杂度就是 O(logn)。
<p>二分查找的局限性</p>
<li>首先，二分查找依赖的是顺序表结构，简单点说就是数组。</li>
那二分查找能否依赖其他数据结构呢？比如链表。答案是不可以的，主要原因是二分查找算法需要按照下标随机访问元素。我们在数组和链表那两节讲过，数组按照下标随机访问数据的时间复杂度是 O(1)，而链表随机访问的时间复杂度是 O(n)。所以，如果数据使用链表存储，二分查找的时间复杂就会变得很高。
二分查找只能用在数据是通过顺序表来存储的数据结构上。如果你的数据是通过其他数据结构存储的，则无法应用二分查找。
<li>其次，二分查找针对的是有序数据。</li>
二分查找对这一点的要求比较苛刻，数据必须是有序的。如果数据没有序，我们需要先排序。前面章节里我们讲到，排序的时间复杂度最低是 O(nlogn)。所以，如果我们针对的是一组静态的数据，没有频繁地插入、删除，我们可以进行一次排序，多次二分查找。这样排序的成本可被均摊，二分查找的边际成本就会比较低。
但是，如果我们的数据集合有频繁的插入和删除操作，要想用二分查找，要么每次插入、删除操作之后保证数据仍然有序，要么在每次二分查找之前都先进行排序。针对这种动态数据集合，无论哪种方法，维护有序的成本都是很高的。
所以，二分查找只能用在插入、删除操作不频繁，一次排序多次查找的场景中。针对动态变化的数据集合，二分查找将不再适用。那针对动态数据集合，如何在其中快速查找某个数据呢？别急，等到二叉树那一节我会详细讲。
<li>再次，数据量太小不适合二分查找。</li>
如果要处理的数据量很小，完全没有必要用二分查找，顺序遍历就足够了。比如我们在一个大小为 10 的数组中查找一个元素，不管用二分查找还是顺序遍历，查找速度都差不多。只有数据量比较大的时候，二分查找的优势才会比较明显。
不过，这里有一个例外。如果数据之间的比较操作非常耗时，不管数据量大小，我都推荐使用二分查找。比如，数组中存储的都是长度超过 300 的字符串，如此长的两个字符串之间比对大小，就会非常耗时。我们需要尽可能地减少比较次数，而比较次数的减少会大大提高性能，这个时候二分查找就比顺序遍历更有优势。
<li>最后，数据量太大也不适合二分查找。</li>
二分查找的底层需要依赖数组这种数据结构，而数组为了支持随机访问的特性，要求内存空间连续，对内存的要求比较苛刻。比如，我们有 1GB 大小的数据，如果希望用数组来存储，那就需要 1GB 的连续内存空间。
注意这里的“连续”二字，也就是说，即便有 2GB 的内存空间剩余，但是如果这剩余的 2GB 内存空间都是零散的，没有连续的 1GB 大小的内存空间，那照样无法申请一个 1GB 大小的数组。而我们的二分查找是作用在数组这种数据结构之上的，所以太大的数据用数组存储就比较吃力了，也就不能用二分查找了。
<p>二分查找的核心思想理解起来非常简单，有点类似分治思想。即每次都通过跟区间中的中间元素对比，将待查找的区间缩小为一半，直到找到要查找的元素，或者区间被缩小为 0。但是二分查找的代码实现比较容易写错。你需要着重掌握它的三个容易出错的地方：循环退出条件、mid 的取值，low 和 high 的更新。</p>

<h2>如果数据结构使用链表而不是数组，那么时间复杂度是多少？</h2>
假设链表长度为n，二分查找每次都要找到中间点(计算中忽略奇偶数差异):
 <li>第一次查找中间点，需要移动指针n/2次；</li>
  <li>第二次，需要移动指针n/4次；</li>
 <li>第三次需要移动指针n/8次；</li>
  <li>以此类推，一直到1次为值</li>
<p>总共指针移动次数(查找次数) = n/2 + n/4 + n/8  + ...+ 1，这显然是个等比数列，根据等比数列求和公式：Sum = n - 1.  </p>
最后算法时间复杂度是：O(n-1)，忽略常数，记为O(n)，时间复杂度和顺序查找时间复杂度相同
但是稍微思考下，在二分查找的时候，由于要进行多余的运算，严格来说，会比顺序查找时间慢

<h2>几种常见的二分查找变形问题</h2>
<img src="https://static001.geekbang.org/resource/image/42/36/4221d02a2e88e9053085920f13f9ce36.jpg"/>
 


<h3>二分查找的一些条件</h3>
<li>查找的数据是有序的数据</li>
<li>二分查找依赖的是顺序表结构
如果数据集合有频繁的插入和删除操作，使用二分查找要么每次插入 删除操作之后保持有序，要么查找前进行排序，针对动态的数据集合一般使用二叉树会比较好¶
数据量太大也不好，因为二分查找需要依赖数据这种数据结构要求内存空间连续
</li>
<li>数据量太小不适合二分查找</li>