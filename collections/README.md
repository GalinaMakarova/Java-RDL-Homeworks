# Java Collections

## Getting started

1. Open `io.humb1t.Main.java` and compare different approaches in iterations. Write down your thoughts,
what is your favourite option? Which one is easier to read and which one is easier to write? Why?
1. 1. Results: I prefer to use stream and foreach options. Foreach is more clearly and much easier than other ways, this is a good option for special cases when we should do something with different collection's parts at the same time. Streams are shorter and more elegant, this is the best way for workign with the whole collection as with the one object.
1. Add numeric field to `Order` class, use it to filter collection of orders by some criteria 
(more than 50 order items for example).
1. 1. Results: see Main.java, task#2 parts
1. Imagine the situation - you need to implement [queue](https://en.wikipedia.org/wiki/Queue_(abstract_data_type))
of incoming requests, to process incoming requests we have 3 independent "processors".
How can we design our application in such a case and what pros and cons we would face in different approaches?
Write down your thoughts and implement one possible solution.
1. 1. Results: see Main.java, task#3 parts
in this task, we must take into account that the work with streams/"processors" is parallel and all the processors must be independent of each other plus their data should be thread-safe.
1. Imagine the situation when you have a `Collection` and should remove all duplicates in it. 
How would you do it? Implement your solution using only Java SE.
1. 1. Results: see Main.java, task#4 parts
1. There is an old war between `ArrayList` and `Linked List` - choose new fighters and implement your
own benchmark (`Vector` vs `Queue` for example). Write down your thoughts.
1. 1. Results: see Task5.java
task#5
1. 1. 1. Vector: add 40.000.000 elements - time 2,001 sec.
1. 1. 1. Vector: get element#15.648.792 - time 0 sec.
1. 1. 1. Vector: remove 1.000 elements - time 71,785 sec.
1. 1. 1. Queue: add 40.000.000 elements - time 3,27 sec.
1. 1. 1. Queue: get element#15.648.792 - time 0,009 sec.
1. 1. 1. Queue: remove 1.000 elements - time 0,001 sec.
1. 1. As you can see, vector is slow for adding and removing operations, but that's a good object type for get operation.
Queue is good in removing, but that's not the perfect object type for getting and adding operations.
1. `Map` is very good in implementation of simple [caches](https://en.wikipedia.org/wiki/Cache_(computing)).
Implement your own cache using `Map`.
1. 1. Results: see Task6.java
I've implemented a unique number counter. myCache gets all unique values and counts how many times the number appears.

