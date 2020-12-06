<p>给定一个数组 <code>A[0,1,&hellip;,n-1]</code>，请构建一个数组 <code>B[0,1,&hellip;,n-1]</code>，其中 <code>B</code> 中的元素 <code>B[i]=A[0]&times;A[1]&times;&hellip;&times;A[i-1]&times;A[i+1]&times;&hellip;&times;A[n-1]</code>。不能使用除法。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> [120,60,40,30,24]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>所有元素乘积之和不会溢出 32 位整数</li>
	<li><code>a.length &lt;= 100000</code></li>
</ul>
<div><li>👍 26</li><li>👎 0</li></div>