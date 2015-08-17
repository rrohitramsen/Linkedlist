# Linkedlist
Algorithms problems based on linked list

1. Deep Copy : Clone a linked list with next and random pointer. 
Solution 1 : By using Map, In first traversing of list clone the entire list into map. 
And now in second traverse of list update the next and random pointers of the clone list. 
Solution 2 : While traversing the list insert the clone node after its original node, by this we have a behavior of map.

Note : But this approach is not recommended in real, because in run time we are not suppose to modify the original list.
Now we have something like this..

Original List : a–>b–>c–>d–>#
While Cloning : a–>a’–>b–>b’–>c–>c’–>d–>d’–#

Again traverse the list, now link a’–>b’–>c’–>d’–># and also update the random pointer,
Suppose a–random is-c->
Then in above cloning step, a–random–>c and its clone node will be a–random–>c–>c’.

2. Find Nth node from the end of the linked list.

3. Find Mid point of the linked list.

4. Reverse the linked list in pairs, k-pairs and complete.

5. Find the loop in the linked list and the loop node.
