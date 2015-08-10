
##Remove Duplicates from Sorted Array II 
Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

For example,
 Given sorted array nums = [1,1,1,2,2,3], 

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. 


---
##解题思想
###想法1
原本以为只要剔除数组重复后的长度就可以了，现在看来并不是这样。
还要修改传进来的数组引用，有个很奇怪的现象是一开始我直接New一个数组接受新增的值，但是显然没有什么卵用，传回去的还是源数组，所以我以为我搞清楚了Java的内存关系，然并卵。

后来转念一想，只要把元素直接赋值给前一个重复位置就可以了，因为它传进来的数组本身就是已经排好序的，如果重复直接把后面的数字填充到自己维护的count上就ok。

于是，结了。

对于函数调用的形参的问题是因为在调用一个方法把实参的引用传进去，在内部如果改变实参的引用是没有意义的。最终方法出栈内部的变量会被回收掉。


String传参没变 而StringBuffer变化 我上次说是因为string每次用'+' 都在字符常量池创建一个新的对象，而不会变的原因是因为传参数是引用时，方法体内改变形参引用，不会改变实参的引用，实参值不会变。

main(){
	Student s1 = new Student();
	s1.setAge(11);
	test(s1);
	print(s1.getAge());//还是11,说明不会改变
}

void test(Student s){
	Student s2 = new Student();
	s2.setAge(22);
	s =s2;
}




