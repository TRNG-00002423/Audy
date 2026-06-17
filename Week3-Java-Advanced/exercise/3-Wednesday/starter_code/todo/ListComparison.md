# ArrayList vs LinkedList — your analysis

- LinkedList is good when you're adding/removing stuff from the front of the list quite often. BUT our methods grab tasks by index, and a LinkedList has to walk through one item at a time to find that index, which is slower.
- ArrayList works well in this case, as it stores everything in order like a numbered list, so jumping straight to a specific task is instant. For instance, this is how getTask and addTask work.